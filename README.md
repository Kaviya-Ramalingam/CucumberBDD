# Cucumber BDD Java Automation Project

This repository provides a Behavior-Driven Development (BDD) automation framework using **Cucumber**, **Java**, and **TestNG**. It is designed to make test scenarios easy to read, maintain, and extend for everyone involved in the software development lifecycle.

## Features

- **Cucumber BDD**: Write tests in Gherkin syntax for clear, human-readable scenarios.
- **Java**: Robust, scalable step definitions and utilities.
- **TestNG Runner**: Easily execute scenarios via TestNG.
- **Parallel Test Execution**: Achieved using TestNG. Run tests concurrently to save time.
- **Cross-Browser Testing**: Easily switch and run tests on different browsers (Chrome, Firefox, etc.) by configuring parameters in `testng.xml`.
- **PicoContainer**: Dependency injection is implemented using PicoContainer, enabling clean sharing of objects and context between step definitions.
- **Page Object Model **: For scalable UI automation.
- **Reusable steps and hooks** for setup and teardown.
- **Detailed reports**: Integrate with plugins for HTML/JSON reporting.

## Project Structure

```
src/
  test/
    java/
      stepDefinitions/      # Cucumber step definition classes
      runners/              # TestNG runners for Cucumber features
      pages/                # Page objects (for UI projects)
      utilities/            # Utilities and helper classes
    resources/
      features/             # .feature files for scenarios
      testdata/             # Test data files (CSV, Excel, JSON, etc.)
testng.xml                  # TestNG configuration for parallel and cross-browser runs
```

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven or Gradle
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Setup

1. **Clone the repository**
    ```bash
    git clone https://github.com/Kaviya-Ramalingam/CucumberBDD.git
    cd CucumberBDD
    ```

2. **Install dependencies**
    ```bash
    mvn clean install
    ```

3. **Configure your test data and environment settings** as needed.

## Running Tests

- **Run via Maven:**
    ```bash
    mvn test
    ```

- **From your IDE:**  
  Right-click the TestNG runner class or the `testng.xml` file and select "Run".

## Writing Scenarios

- Add `.feature` files under `src/test/resources/features/`.
- Write Given/When/Then steps in Gherkin syntax.
- Implement step definitions in `src/test/java/stepDefinitions/`.
- Share state and objects cleanly between steps using PicoContainer dependency injection.

## Reporting

- Cucumber can generate HTML, JSON, and other reports.  
  Configure plugins in the runner class or `pom.xml` as needed.


## License

[MIT](LICENSE)  
(C) Kaviya Ramalingam

---

*Happy BDD Testing!*
