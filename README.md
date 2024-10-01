# selenium_cucumber_pom

Selenium testing with cucumber BDD and Rest Assured.

This project has used selenium, cucumber, TestNG , RestAssured, json and Maven.
For assertion assertJ is used.

Application under test: https://www.saucedemo.com

Docker Selenium GRID setup

1. docker network create grid
2. docker pull selenium/hub:latest
3. docker pull selenium/node-firefox:latest
4. docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest
5. root@Partheebans-MacBook-Air baseImage # docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g"
   -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 -e SE_NODE_MAX_SESSIONS=5 -e
   SE_NODE_OVERRIDE_MAX_SESSIONS=true selenium/node-firefox:latest

