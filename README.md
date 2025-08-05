
# RestAssured_API_Framework

This is a Java-based End-to-End (E2E) API testing framework designed using Cucumber, Maven, and REST-assured. It supports BDD-style feature files and uses a modular approach to build test data and perform validations.

## 📁 Project Structure

```
E2E_API_Framework/
├── src/
│   ├── main/java/org/e2e/api/         # Core API test classes
│   └── test/java/
│       ├── cucumber/Options/          # Test runner class
│       ├── features/                  # Cucumber feature files
│       ├── resources/                 # Test data, API resources, utilities
│       └── stepDefinitions/           # Step definition classes
├── pom.xml                            # Maven configuration file
├── logging.txt                        # Log file
└── .gitignore                         # Git ignore rules ```

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- IDE (e.g., IntelliJ IDEA or Eclipse)

### Installation

1. Clone the repository or extract the ZIP.
2. Navigate to the project root.

### Running Tests

mvn test

Or use your IDE to run `TestRunner.java`.

## ✅ Features

- BDD with Cucumber
- API testing with REST-assured (assumed)
- Utility classes for common operations
- Test data builder pattern
- Property-driven configuration

## 📄 Author & License

- Author: *Sheethal Holenarasipura Maheswara*
- License: MIT
