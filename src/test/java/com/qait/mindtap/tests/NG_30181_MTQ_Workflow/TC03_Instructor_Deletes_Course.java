package com.qait.mindtap.tests.NG_30181_MTQ_Workflow;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;


public class TC03_Instructor_Deletes_Course {

   TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("TC03_Instructor_Deletes_Course");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void Step_01_Instructor_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_01_Instructor_Logs_in_to_the_Application"})
    public void Step_02_Instructor_Manage_Course() {
       test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
       test.instructor.instructor_Course_Option("Manage Course");
       test.courseEdit.instructor_Select_PreviousCourses();
  
    }
    
    @Test(dependsOnMethods = {"Step_02_Instructor_Manage_Course"})
    public void Step_03_Instructor_Drops_Student() {
        test.progress.dropsStudent();
    }    
     
    @Test(dependsOnMethods = {"Step_03_Instructor_Drops_Student"})
    void Step_04_Instructor_LogOut() {
        test.loginpage.logOut(test.header.accessor("helloUser"));
    }
    
    @Test(dependsOnMethods = {"Step_04_user_LogOut"})
    public void Step_05_Instructor_Logs_in_to_the_Application_Again() {
        test.launchApplication(getData("sso_url"));
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_05_Instructor_Logs_in_to_the_Application_Again"})
    public void Step_06_Instructor_Manage_Course() {
       test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
       test.instructor.instructor_Course_Option("Manage Course");
      }
     
    @Test(dependsOnMethods = {"Step_06_Instructor_Manage_Course"})
    public void Step_07_Instructor_Delete_Course() {
       test.courseEdit.courseDelete(getData("coretext.NAME"));
    }
           
    @Test(dependsOnMethods = {"Step_07_Instructor_Delete_Course"})
    void Step_07_Instructor_SignOut() {
        test.loginpage.signout();
    }

    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);

    }
}
