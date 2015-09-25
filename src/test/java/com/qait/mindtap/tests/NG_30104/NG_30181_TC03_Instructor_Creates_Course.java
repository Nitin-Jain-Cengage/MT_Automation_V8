package com.qait.mindtap.tests.NG_30104;
import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;


public class NG_30181_TC03_Instructor_Creates_Course {

   TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("NG_30181_TC03_Instructor_Creates_Course", browser);
        test.launchApplication(getData("sso_url"));
        test.courseCreateEdit.clean_Data_File();
    }

    @Test
    public void Step_01_Instructor_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_01_Instructor_Logs_in_to_the_Application"})
    public void Step_02_Instructor_Creates_Course() {
       test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
       test.instructor.instructor_Course_Option("Create Course");
      }
     
    @Test(dependsOnMethods = {"Step_02_Instructor_Creates_Course"})
    public void Step_03_Instructor_Enters_Course_Details() {
       test.courseOptions.creates_New_Course();
       test.courseCreateEdit.create_Course(getData("coretext.NAME"));
      }
    
    @Test(dependsOnMethods = {"Step_03_Instructor_Enters_Course_Details"})
    public void Step_03_Confirm_Course_Details() {
       test.courseConfirmation.verify_User_Is_On_Course_Confirmation_Page();
       test.courseConfirmation.get_Created_Course_Key();
    }
    
    @Test(dependsOnMethods = {"Step_03_Confirm_Course_Details"})
    void Step_04_Instructor_SignOut() {
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
