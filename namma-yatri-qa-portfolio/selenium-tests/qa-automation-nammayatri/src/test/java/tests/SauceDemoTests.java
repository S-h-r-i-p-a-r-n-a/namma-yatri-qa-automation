package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class SauceDemoTests {

    WebDriver driver;
    WebDriverWait wait;

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String baseUrl = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);

        System.out.println("✅ Browser opened successfully");
    }

    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin() {
        System.out.println("\n🧪 TEST 1: Valid Login Test");

        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        System.out.println("📝 Entered username: " + validUsername);

        driver.findElement(By.id("password")).sendKeys(validPassword);
        System.out.println("📝 Entered password");

        driver.findElement(By.id("login-button")).click();
        System.out.println("🖱️ Clicked login button");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Failed to navigate to products page");

        WebElement productsTitle = driver.findElement(By.className("title"));
        Assert.assertEquals(productsTitle.getText(), "Products", "Products page title mismatch");

        System.out.println("✅ TEST PASSED: Successfully logged in and reached products page");
    }

    @Test(priority = 2, description = "Verify error message for invalid password")
    public void testInvalidPassword() {
        System.out.println("\n🧪 TEST 2: Invalid Password Test");

        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys("wrong_password123");
        driver.findElement(By.id("login-button")).click();

        System.out.println("🖱️ Attempted login with invalid password");

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");

        String errorText = errorMessage.getText();
        Assert.assertTrue(errorText.contains("Username and password do not match"),
                "Unexpected error message: " + errorText);

        System.out.println("✅ TEST PASSED: Error message displayed correctly");
    }

    @Test(priority = 3, description = "Verify error message for empty credentials")
    public void testEmptyCredentials() {
        System.out.println("\n🧪 TEST 3: Empty Credentials Test");

        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMessage.getText().contains("Username is required"),
                "Incorrect error message for empty username");

        System.out.println("✅ TEST PASSED: Validation working for empty credentials");
    }

    @Test(priority = 4, description = "Verify locked out user cannot login")
    public void testLockedOutUser() {
        System.out.println("\n🧪 TEST 4: Locked Out User Test");

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMessage.getText().contains("locked out"),
                "Incorrect error message for locked user");

        System.out.println("✅ TEST PASSED: Locked user prevented from login");
    }

    @Test(priority = 5, description = "Verify product catalog loads correctly")
    public void testProductCatalog() {
        System.out.println("\n🧪 TEST 5: Product Catalog Test");

        performLogin();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));

        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertTrue(products.size() > 0, "No products found on page");
        System.out.println("📦 Found " + products.size() + " products");

        WebElement firstProduct = products.get(0);
        WebElement productName = firstProduct.findElement(By.className("inventory_item_name"));
        WebElement productPrice = firstProduct.findElement(By.className("inventory_item_price"));

        Assert.assertTrue(!productName.getText().isEmpty(), "Product name is empty");
        Assert.assertTrue(!productPrice.getText().isEmpty(), "Product price is empty");

        System.out.println("📦 Sample product: " + productName.getText() + " - " + productPrice.getText());
        System.out.println("✅ TEST PASSED: Product catalog loaded successfully");
    }

    @Test(priority = 6, description = "Verify add to cart functionality")
    public void testAddToCart() {
        System.out.println("\n🧪 TEST 6: Add to Cart Test");

        performLogin();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));

        WebElement cartBadgeElement = driver.findElements(By.className("shopping_cart_badge")).isEmpty()
                ? null : driver.findElement(By.className("shopping_cart_badge"));
        int initialCount = (cartBadgeElement == null) ? 0 : Integer.parseInt(cartBadgeElement.getText());

        WebElement addToCartButton = driver.findElement(By.className("btn_inventory"));
        String buttonText = addToCartButton.getText();
        Assert.assertEquals(buttonText, "Add to cart", "Button text mismatch");

        addToCartButton.click();
        System.out.println("🛒 Added item to cart");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_badge")));
        WebElement updatedCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int newCount = Integer.parseInt(updatedCartBadge.getText());

        Assert.assertEquals(newCount, initialCount + 1, "Cart count did not increase");

        WebElement removeButton = driver.findElement(By.className("btn_inventory"));
        Assert.assertEquals(removeButton.getText(), "Remove", "Button did not change to Remove");

        System.out.println("✅ TEST PASSED: Item added to cart successfully");
    }

    @Test(priority = 7, description = "Verify logout functionality")
    public void testLogout() {
        System.out.println("\n🧪 TEST 7: Logout Test");

        performLogin();

        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        System.out.println("🍔 Opened menu");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();
        System.out.println("🚪 Clicked logout");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, baseUrl, "Did not return to login page");

        System.out.println("✅ TEST PASSED: Logout successful");
    }

    private void performLogin() {
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🔒 Browser closed\n");
        }
    }
}
