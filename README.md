# Selenium Cucumber BDD Framework with TestNG and Rest Assured

This project demonstrates automated testing using Selenium, Cucumber BDD, TestNG, Rest Assured, and AssertJ. The
framework is designed for both UI and API testing and supports parallel test execution through Docker Selenium Grid.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Application Under Test](#application-under-test)
4. [Project Setup](#project-setup)
5. [Docker Selenium Grid Setup](#docker-selenium-grid-setup)
6. [Running Tests](#running-tests)
7. [Contact](#contact)

## Project Overview

This framework integrates multiple tools to provide a seamless testing solution for web applications and RESTful APIs.
It supports:

- UI testing using Selenium and Cucumber BDD.
- API testing using Rest Assured.
- Test execution parallelism with TestNG.
- Browser interaction across multiple environments via Docker Selenium Grid.

### Application Under Test

The application used for testing in this project is [Sauce Demo](https://www.saucedemo.com).

## Technologies Used

- **Selenium**: For browser automation.
- **Cucumber BDD**: To write human-readable test scenarios.
- **TestNG**: To manage and execute tests.
- **Rest Assured**: For API testing.
- **AssertJ**: For fluent assertion API.
- **Docker**: To containerize and manage testing infrastructure.
- **Maven**: For project build and dependency management.

## Project Setup

### docker-selenium-grid-setup

1. docker network create grid
2. docker pull selenium/hub:latest
3. docker pull selenium/node-firefox:latest
4. docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest
5. docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g"
   -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 -e SE_NODE_MAX_SESSIONS=5 -e
   SE_NODE_OVERRIDE_MAX_SESSIONS=true selenium/node-firefox:latest

### Prerequisites

1. **Java JDK 8+** installed.
2. **Maven** for build automation.
3. **Docker** to set up Selenium Grid and manage nodes.

### Cloning the Repository

To get started, clone this repository:

```bash
git clone https://github.com/yourusername/selenium_cucumber_pom.git
cd selenium_cucumber_pom
```

## running-tests

mvn test -Dcucumber.filter.tags="@selenium" -Dbrowser.env=local

### optionals

-DthreadCount=2
-Dbrowser=chrome

### selenium grid

-Dbrowser.env=grid
-Dgrid.url=gridurl

## contact

If you have any questions or need support, feel free to reach out.

* Author: Partheeban Subramanian
* Email: partheeban_subramanian@outlook.com
* GitHub: https://github.com/partheebanMani

