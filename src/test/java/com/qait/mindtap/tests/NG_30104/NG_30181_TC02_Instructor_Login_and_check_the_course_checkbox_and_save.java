package com.qait.mindtap.tests.NG_30104;
import org.testng.annotations.*;
import org.testng.ITestResult;
import com.qait.mindtap.automation.TestSessionInitiator;
import static com.qait.mindtap.automation.utils.YamlReader.getData;

public class NG_30181_TC02_Instructor_Login_and_check_the_course_checkbox_and_save {
    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("NG_30181_TC01_Admin_login_and_search_the_isbn_under_master_Tab", browser);
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void Step_01_Instructor_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_01_Instructor_Logs_in_to_the_Application"})
    public void Step_02_Instructor_Search_Course_using_ISBN() {
       test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
       test.instructor.search_Course_Using_ISBN(getData("course1.ISBN"));
      }
     
    @Test(dependsOnMethods = {"Step_02_Instructor_Search_Course_using_ISBN"})
    public void Step_03_Instructor_check_Course_Checkbox() {
       test.instructor.check_Course_CheckBox();
      }
    
    @Test(dependsOnMethods = {"Step_03_Instructor_check_Course_Checkbox"})
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
