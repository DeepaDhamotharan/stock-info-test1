Project Title: Verify Stock Information Display
Description:
This project launches the NSE India URL, searches for the Tata Motors stock, and displays its 52-week high and low values.

Getting Started/Installation
Prerequisites
Java version 21.0.6

Installation Steps
(If applicable) Clone the repository:

git clone <repository_url>

Build the project using Maven:

mvn clean install

Framework Structure
The framework is organized into the following main packages:

com.example.base: Contains base classes for test setup and teardown.

com.example.tests: Holds the actual test classes.

com.example.utils: Utility classes for reporting.

log4j2.xml: Configuration file for logging information.

Running Tests
To execute the tests, run the following Maven command:

mvn test

Test Reports and Logs
Test reports will be generated in the target/extent-reports directory.

Logs will be generated in the test-automation.log file in the root path.