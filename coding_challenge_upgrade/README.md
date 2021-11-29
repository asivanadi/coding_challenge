# Upgrade Coding Challenge

## API Tests
- These tests hit the credify api and tests their functionality

## UI Tests
- These tests hit the credify ui via browser

##Pre-Requisites
- Java 8
- Apache Maven 3.5.4

### To execute api tests
- `cd coding_challenge_upgrade/api`
- `mvn clean test`
- To generate report
- `mvn allure:serve`

### To execute ui tests
-  Firefox and Chrome are supported.
- By default tests are executed in chrome. 
  To change the browser, change the environment variable `BROWSER` in `build.sh` 
  script to `FIREFOX`
- To execute the test cases:
- `cd coding_challenge_upgrade/uitests`
- `mvn clean test`
- To generate report
- `mvn allure:serve`

### To execute all tests and generate combined report
- `chmod 777 build.sh`
- `./build.sh`
