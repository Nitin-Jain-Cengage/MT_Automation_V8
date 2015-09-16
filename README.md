<<<<<<< HEAD
HMMv12 selenium-automation
===================

### HBP UAT - Automated Functional Test Demo
---
#### Summary:

Automated Test Suite. This is a demo of Selenium Testing Tool used for automated testing 

#### System Requirement:

* JDK 1.8 or above
* Maven 3.1
* Eclipse or IDE of choice in case there is need to update the script. (optional)

#### Test Execution:

All the test suites can be configured and kept in ./src/test/resources/testxml folder

##### Executing the default tests as mentioned in the TestNG.xml

    mvn clean integration-test

##### Executing custom suite of tests (e.g. as defined in NewTestNG.xml)

    mvn clean integration-test -Dtestxml=NewTestNG.xml

##### Executing a single test (e.g. Admin_Login_Layout_Test)

    mvn clean integration-test -Dtest=Admin_Login_Layout_Test


#### Result Files:	
The Test Execution Results will be stored in the following directory once the test has completed

##### TestNG Surefire reports
    ./target/surefire-reports/emailable-report.html (for single test suite)
	
##### Galen Layout reports
    ./target/galen-reports/report.html
=======
# MT_Automation_V8
MT Automation using V8 frame work
>>>>>>> 210cbcc0df3d76263faf8d5d780082fad8618853
