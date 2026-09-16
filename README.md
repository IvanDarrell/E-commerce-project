# Ecommerce Sample Project

A Java-based web automation project built with **Selenium WebDriver, TestNG, and the Page Object Model design pattern**.

The project automates key e-commerce customer workflows, including login, product interaction, shopping-cart management, and checkout-price validation. It also includes reusable utilities, external test-data management, reporting, logging, cross-browser execution, and CI/CD integration.

## 🚀 Functional Coverage

* Application navigation
* Customer login
* Adding products to the shopping cart
* Editing cart items
* Removing cart items
* Shopping-cart total-price validation
* Checkout workflow validation
* Hard and soft assertions
* Exception handling

## 🔧 Technical Features

* Java and Selenium WebDriver
* TestNG test automation framework
* Page Object Model architecture
* Reusable action and utility classes
* Hard and soft assertions
* Exception handling
* ExtentReports integration
* Thread-safe ExtentReports test logging
* JSON test-data reading
* MySQL database connectivity
* Cross-browser testing:

  * Google Chrome
  * Microsoft Edge
  * Mozilla Firefox
* Parallel execution using Selenium Grid
* Docker Compose-based Selenium Grid infrastructure
* Logging and screenshots on test failure
* GitHub Actions CI/CD integration

## 🛠️ Technology Stack

| Technology         | Purpose                                    |
| ------------------ | ------------------------------------------ |
| Java               | Automation development                     |
| Selenium WebDriver | Browser automation                         |
| TestNG             | Test execution and assertions              |
| Maven              | Dependency and build management            |
| Selenium Grid      | Distributed and parallel browser execution |
| Docker Compose     | Browser infrastructure                     |
| MySQL              | Test-data management                       |
| JSON               | External test data                         |
| ExtentReports      | Test reporting                             |
| GitHub Actions     | CI/CD automation                           |

## 📦 Installation and Execution

### Prerequisites

Install the following:

* Java 11
* Maven
* Docker Desktop
* Git
* Google Chrome, Microsoft Edge, or Mozilla Firefox
* MySQL, if running database-dependent tests locally

### Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd <YOUR_PROJECT_DIRECTORY>
```

### Run using JSON test data

If you do not want to use the database, configure the framework to use the JSON data reader and update the URL used by the `navigate()` method.

Then execute:

```text
testng.xml
```

Alternatively, run the Maven test command:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

### Run using MySQL

1. Configure the database connection in the framework.
2. Ensure the required database and tables are available.
3. Update the database URL, username, and password.
4. Confirm that the required test data exists.
5. Run the TestNG suite.

> **Important:** Database-dependent tests may fail if the database connection, credentials, schema, or test data are not configured for the local environment. Use environment-specific configuration rather than committing credentials to the repository.

## 🌐 Selenium Grid and Docker

The project supports distributed browser execution through Selenium Grid and Docker Compose.

Supported browsers:

* Chrome
* Edge
* Firefox

Start Selenium Grid with:

```bash
docker compose up -d
```

Check the running containers:

```bash
docker compose ps
```

The Selenium Grid Hub is available at:

```text
http://localhost:4444
```

Stop the Grid after execution:

```bash
docker compose down
```

## 📊 Reports and Diagnostics

Test execution generates reports and diagnostic information, including:

* ExtentReports
* TestNG reports
* Execution logs
* Screenshots on failure
* Test failure details

Typical report locations:

```text
target/report/
target/surefire-reports/
```

## 🔄 GitHub Actions CI/CD

The project includes a GitHub Actions workflow that can:

1. Set up Java and Maven
2. Start the MySQL service
3. Import the required database
4. Start Selenium Grid using Docker Compose
5. Execute the TestNG suite
6. Upload ExtentReports and TestNG reports as build artifacts
7. Stop the Selenium Grid containers

## 📝 Project Notes

The framework supports both database-driven and JSON-driven test-data execution.

For local execution, configure the appropriate data source:

* **Database mode:** Configure the local MySQL connection and required test data.
* **JSON mode:** Enable the JSON reader and configure the required user information and application URL.

The database connection and credentials should be configured through environment-specific settings. Do not commit private credentials or production database information to the repository.

## 👤 Author

**Ivan Darrell V. Colina**
