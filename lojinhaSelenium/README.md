# My Project

This project contains automated tests for the QA Store using Selenium and Cucumber.

## Features

The project includes the following features:

### Home Screen

This feature tests the functionality of the Home screen, including product selection, cart validation, address details validation, payment screen navigation, and card details entry.

### Login Screen

This feature tests the login functionality, including successful login with valid credentials.

### Registration

This feature tests the registration process for new users, including filling out the signup form and completing the registration.

## Running the Tests

To run the automated tests, follow these steps:

1. Clone the project repository.
2. Make sure you have the necessary dependencies and libraries installed.
3. Open the project in your preferred IDE.
4. Configure the test environment, such as the browser and URL, in the test configuration file.
5. Run the RunCucumberTest class as a JUnit test.

## Dependencies

The project uses the following dependencies:

- Selenium Java (version 4.1.2)
- JavaFaker (version 1.0.2)
- JUnit Jupiter (version 5.8.2)
- Hamcrest (version 1.3)
- WebDriverManager (version 5.4.0)
- Cucumber Java (version 7.2.3)
- Cucumber JUnit Platform Engine (version 7.2.3)
- JUnit Platform Suite (version 1.8.2)

Make sure to have these dependencies properly configured in your project's `pom.xml` file.

## Execution

### Running the "Home Screen" Feature
```shell
mvn test -Dcucumber.filter.tags="@home,@regression"
```
### Running the "Login Screen" Feature
```shell
mvn test -Dcucumber.filter.tags="@login,@regression"
```
### Running the "Registration Screen" Feature
```shell
mvn test -Dcucumber.filter.tags="@registration,@regression"
```

## Contributors
Jheymisson


# Português - IMPORTANTE!
```
Obs: Eu modifiquei a lógica do iframe para gerar uma nova url, estava tomando tempo e com o o projeto é apenas fins de conhecimento técnico, então optei por não demorar nessa lógica.
```