# 🚗 Namma Yatri QA Automation Framework

[![Selenium](https://img.shields.io/badge/Selenium-4.26.0-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-red.svg)](https://testng.org/)
[![Java](https://img.shields.io/badge/Java-24-orange.svg)](https://www.oracle.com/java/)
[![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange.svg)](https://www.postman.com/)

> **Comprehensive test automation framework** demonstrating Selenium WebDriver, API testing with Postman, SQL data validation, and TestNG framework capabilities for ride-sharing platform quality assurance.

---

## 📋 Table of Contents

- [Project Overview](#-project-overview)
- [Tech Stack](#-tech-stack)
- [Framework Architecture](#-framework-architecture)
- [Test Coverage](#-test-coverage)
- [Project Structure](#-project-structure)
- [Setup & Installation](#-setup--installation)
- [Execution](#-execution)
- [Test Results](#-test-results)
- [Key Features](#-key-features)
- [Skills Demonstrated](#-skills-demonstrated)
- [Future Enhancements](#-future-enhancements)
- [Contact](#-contact)

---

## 🎯 Project Overview

This automation framework was built specifically to demonstrate QA engineering skills aligned with **Namma Yatri's** requirements for testing India's first open-mobility platform. The project showcases comprehensive testing capabilities across:

- **UI Automation** using Selenium WebDriver
- **API Testing** using Postman with JavaScript assertions
- **Database Validation** using SQL queries
- **Test Framework** design using TestNG with grouping and parallel execution

**Purpose:** To validate critical user journeys, API endpoints, and data integrity in a ride-sharing platform context.

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | JDK 24 | Programming language for test scripts |
| **Selenium WebDriver** | 4.26.0 | Browser automation |
| **TestNG** | 7.10.2 | Test execution framework |
| **Maven** | 3.x | Dependency management & build tool |
| **Postman** | Latest | API testing & validation |
| **SQL** | MySQL/PostgreSQL | Database validation queries |
| **Git/GitHub** | - | Version control |

---

## 🏗️ Framework Architecture
```
┌─────────────────────────────────────────────────────────────┐
│                    TEST AUTOMATION FRAMEWORK                 │
├─────────────────────────────────────────────────────────────┤
│                                                               │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   UI TESTS   │  │  API TESTS   │  │  SQL TESTS   │      │
│  │   Selenium   │  │   Postman    │  │  Data Layer  │      │
│  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘      │
│         │                  │                  │               │
│         └──────────────────┴──────────────────┘              │
│                            │                                  │
│                   ┌────────▼────────┐                        │
│                   │  TestNG Runner  │                        │
│                   │  (Orchestrator) │                        │
│                   └────────┬────────┘                        │
│                            │                                  │
│                   ┌────────▼────────┐                        │
│                   │  HTML Reports   │                        │
│                   │   Screenshots   │                        │
│                   └─────────────────┘                        │
│                                                               │
└─────────────────────────────────────────────────────────────┘
```

---

## ✅ Test Coverage

### **1. Selenium UI Automation Tests**

| Test Case | Description | Status |
|-----------|-------------|--------|
| Valid Login | Verifies successful user authentication | ✅ Pass |
| Invalid Password | Tests error handling for wrong credentials | ✅ Pass |
| Empty Credentials | Validates field-level validation | ✅ Pass |
| Locked Out User | Tests security for blocked accounts | ✅ Pass |
| Product Catalog | Verifies product page loads correctly | ✅ Pass |
| Add to Cart | Tests shopping cart functionality | ✅ Pass |
| Logout | Validates session termination | ⚠️ Known Issue |

**Total:** 6/7 tests passing (85.7% pass rate)

---

### **2. Postman API Tests**

| Test Suite | Test Cases | Assertions | Status |
|------------|------------|------------|--------|
| GET Requests | Fetch all posts, single post, filtered results | 11 | ✅ Pass |
| POST Requests | Create new resource, create with missing fields | 5 | ✅ Pass |
| PUT/PATCH | Update full resource, partial update | 5 | ✅ Pass |
| DELETE | Remove resource | 2 | ✅ Pass |
| Negative Tests | Invalid IDs, error handling | 2 | ✅ Pass |
| Response Validation | Headers, response time, data structure | 3 | ⚠️ 1 Minor |

**Total:** 27/28 assertions passing (96.4% pass rate)

---

### **3. SQL Data Validation Tests**

| Category | Test Count | Purpose |
|----------|------------|---------|
| Data Integrity | 3 | Orphaned records, duplicates, calculations |
| Business Rules | 3 | Negative values, status consistency, timestamps |
| Data Quality | 3 | NULL checks, format validation, date logic |
| Performance | 3 | Volume analysis, completion rates, payments |

**Total:** 12 comprehensive SQL validation queries

---

## 📁 Project Structure
```
namma-yatri-qa-automation/
│
├── selenium-tests/
│   ├── src/
│   │   ├── main/java/           # Page Object Models (future)
│   │   └── test/java/
│   │       └── tests/
│   │           └── SauceDemoTests.java  # Main test suite
│   ├── pom.xml                  # Maven dependencies
│   └── testng.xml               # TestNG configuration
│
├── postman-collection/
│   └── Namma_Yatri_API_Tests.json  # 10 API test scenarios
│
├── sql-tests/
│   ├── data_validation_tests.sql   # 12 SQL test queries
│   └── README.md                    # SQL test documentation
│
├── screenshots/
│   ├── selenium_results.png
│   ├── postman_results.png
│   └── project_structure.png
│
├── docs/
│   └── test_strategy.md         # Testing approach document
│
└── README.md                     # This file
```

---

## 🚀 Setup & Installation

### **Prerequisites**

- Java JDK 17+ installed
- Maven 3.6+ installed
- Chrome browser (latest version)
- ChromeDriver (matching Chrome version)
- Postman (for API tests)
- Git

### **Installation Steps**

1. **Clone the repository**
```bash
   git clone https://github.com/YOUR_USERNAME/namma-yatri-qa-automation.git
   cd namma-yatri-qa-automation
```

2. **Install Selenium dependencies**
```bash
   cd selenium-tests
   mvn clean install
```

3. **Configure ChromeDriver path**
   - Open `src/test/java/tests/SauceDemoTests.java`
   - Update line 23 with your ChromeDriver location:
```java
   System.setProperty("webdriver.chrome.driver", "YOUR_PATH/chromedriver.exe");
```

4. **Import Postman collection**
   - Open Postman
   - Click Import → Choose Files
   - Select `postman-collection/Namma_Yatri_API_Tests.json`

---

## ▶️ Execution

### **Run Selenium Tests**

**Option 1: Via Maven**
```bash
cd selenium-tests
mvn clean test
```

**Option 2: Via TestNG XML**
```bash
mvn test -DsuiteXmlFile=testng.xml
```

**Option 3: Run specific test groups**
```bash
# Run only smoke tests
mvn test -Dgroups=smoke

# Run regression suite
mvn test -Dgroups=regression

# Run negative tests only
mvn test -Dgroups=negative
```

**Option 4: Via IntelliJ IDEA**
- Right-click on `testng.xml` → Run

---

### **Run Postman API Tests**

1. Open Postman
2. Navigate to Collections → "Namma Yatri API Test Suite"
3. Click the three dots (...) → Run collection
4. Click "Run Namma Yatri API..." button
5. View results in Collection Runner

**Via Newman (Command Line):**
```bash
newman run postman-collection/Namma_Yatri_API_Tests.json
```

---

### **Run SQL Tests**

1. Connect to your test database using MySQL Workbench or similar tool
2. Open `sql-tests/data_validation_tests.sql`
3. Execute each test section individually
4. Expected result for most tests: **0 rows** (no issues found)

---

## 📊 Test Results

### **Selenium Test Execution**

![Selenium Results](screenshots/selenium_results.png)
```
===============================================
Test Suite: Namma Yatri Complete Test Suite
Total tests run: 7
Passes: 6
Failures: 1
Skips: 0
Pass Rate: 85.7%
===============================================
```

---

### **Postman API Test Execution**

![Postman Results](screenshots/postman_results.png)
```
===============================================
Collection: Namma Yatri API Test Suite
Total Requests: 10
Total Assertions: 28
Passed: 27
Failed: 1 (CORS header - API limitation)
Pass Rate: 96.4%
Duration: 5.4 seconds
===============================================
```

---

## 🌟 Key Features

### **1. Test Organization**
- ✅ Test grouping (Smoke, Regression, Negative)
- ✅ Priority-based execution
- ✅ Configurable test suites via TestNG XML

### **2. Reporting**
- ✅ Console output with emojis for readability
- ✅ TestNG HTML reports
- ✅ Detailed test descriptions
- ✅ Screenshots on failure (future enhancement)

### **3. Best Practices**
- ✅ Clear naming conventions
- ✅ Helper methods to avoid code duplication
- ✅ Explicit waits for stability
- ✅ Proper assertions with meaningful messages
- ✅ Test data separation

### **4. Maintainability**
- ✅ Maven for dependency management
- ✅ Modular structure
- ✅ Configuration externalization
- ✅ Version control with Git

---

## 💡 Skills Demonstrated

| Skill Area | Technologies/Concepts |
|------------|----------------------|
| **Test Automation** | Selenium WebDriver, TestNG Framework |
| **Programming** | Java, Object-Oriented Design |
| **API Testing** | REST APIs, Postman, JavaScript Assertions |
| **Database Testing** | SQL, Data Validation, Integrity Checks |
| **Test Design** | Test Planning, Test Case Design, Negative Testing |
| **Tools** | Maven, Git, Chrome DevTools |
| **Best Practices** | Page Object Model (foundation), DRY Principle, Test Grouping |
| **CI/CD Ready** | Maven build system, Command-line execution |

---

## 🔮 Future Enhancements

### **Phase 1: Framework Improvements**
- [ ] Implement complete Page Object Model (POM)
- [ ] Add ExtentReports for better HTML reporting
- [ ] Integrate screenshot capture on test failure
- [ ] Add logging framework (Log4j)
- [ ] Data-driven testing using Excel/CSV

### **Phase 2: Expanded Coverage**
- [ ] Mobile testing with Appium (Android/iOS)
- [ ] Cross-browser testing (Firefox, Edge, Safari)
- [ ] Performance testing basics
- [ ] Accessibility testing (ADA compliance)

### **Phase 3: CI/CD Integration**
- [ ] Jenkins pipeline setup
- [ ] GitHub Actions workflow
- [ ] Automated test execution on commit
- [ ] Slack/Email notifications

### **Phase 4: Advanced Features**
- [ ] Parallel test execution
- [ ] Docker containerization
- [ ] BDD with Cucumber
- [ ] Visual regression testing

---

## 📈 Known Issues & Resolutions

### **Issue 1: Logout Test Timeout**
- **Status:** Known Issue
- **Description:** Test fails due to page load timing after logout
- **Root Cause:** Logout redirect takes longer than expected wait time
- **Workaround:** Increase wait time or add Thread.sleep()
- **Priority:** Low (non-critical path)

### **Issue 2: CORS Header Assertion**
- **Status:** API Limitation
- **Description:** JSONPlaceholder API doesn't return expected CORS header in all responses
- **Impact:** 1 API test assertion fails
- **Note:** Not a framework issue; would not occur with real Namma Yatri APIs

---

## 🎓 Learning Resources

This project was built by studying:
- [Selenium Official Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Postman Learning Center](https://learning.postman.com/)
- [API Testing Best Practices](https://www.ministryoftesting.com/)

---

## 📞 Contact

**Your Name**  
📧 Email: your.email@example.com  
💼 LinkedIn: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)  
🐙 GitHub: [github.com/yourusername](https://github.com/yourusername)  
📍 Location: Kolkata, West Bengal, India

---

## 🙏 Acknowledgments

- **Namma Yatri** - For inspiring this automation framework aligned with real-world QA requirements
- **SauceDemo** - Test application used for UI automation practice
- **JSONPlaceholder** - Free fake API for testing and prototyping

---

## 📝 License

This project is created for educational and portfolio purposes.

---

<div align="center">

### ⭐ If you found this project helpful, please consider giving it a star!

**Built with dedication for Namma Yatri QA Engineer Application - November 2025**

</div>
