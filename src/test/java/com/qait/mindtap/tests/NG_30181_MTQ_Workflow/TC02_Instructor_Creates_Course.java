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

public class TC02_Instructor_Creates_Course {

    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("TC02_Instructor_Creates_Course");
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
    public void Step_02_Instructor_Search_Course_using_ISBN() {
        test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
        test.instructor.search_Course_Using_ISBN(getData("course1.ISBN"));
    }

    @Test(dependsOnMethods = {"Step_02_Instructor_Search_Course_using_ISBN"})
    public void Step_03_Instructor_check_Course_Checkbox() {
        test.instructor.check_Course_CheckBox();
    }

    @Test(dependsOnMethods = {"Step_03_Instructor_check_Course_Checkbox"})
    public void Step_04_Instructor_Creates_Course() {
        test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
        test.instructor.instructor_Course_Option("Create Course");
    }

    @Test(dependsOnMethods = {"Step_04_Instructor_Creates_Course"})
    public void Step_05_Instructor_Enters_Course_Details() {
        test.courseOptions.creates_New_Course();
        test.courseCreateEdit.create_Course(getData("coretext.NAME"));
    }

    @Test(dependsOnMethods = {"Step_05_Instructor_Enters_Course_Details"})
    public void Step_06_Confirm_Course_Details() {
        test.courseConfirmation.verify_User_Is_On_Course_Confirmation_Page();
        test.courseConfirmation.get_Created_Course_Key(getData("course1.ISBN"));
    }

    @Test(dependsOnMethods = {"Step_06_Confirm_Course_Details"})
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
