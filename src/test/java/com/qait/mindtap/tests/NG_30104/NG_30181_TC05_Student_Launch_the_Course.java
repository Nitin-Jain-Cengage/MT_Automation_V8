package com.qait.mindtap.tests.NG_30104;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;


public class NG_30181_TC05_Student_Launch_the_Course {

    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("NG_30181_TC06_Student_Launch_the_Course", browser);
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void Step_01_Student_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.student.ssousername")), getData(("users.student.ssopassword")));
        test.sso.verify_User_Is_On_SSO_dashboard();
    }

    @Test(dependsOnMethods = {"Step_01_Student_Logs_in_to_the_Application"})
    public void Step_02_Student_Registers_Course() {
       test.sso.student_Registers_Course_With_CourseKey();
       test.confirmCourseInfo.verify_User_Is_On_CourseConfirmInfoPage();
       test.confirmCourseInfo.student_Click_Continue_Button();
      }
     
    @Test(dependsOnMethods = {"Step_01_Student_Logs_in_to_the_Application"})
    public void Step_03_Student_Launch_Course() {
        test.sso.student_Open_Course();
        test.coursePayment.verify_User_Is_On_CoursePayment_Page();
        test.coursePayment.take_Me_To_Course();

      }
    
    @Test(dependsOnMethods = {"Step_02_Instructor_Launch_Course_From_SSO"})
    public void Step_03_verify_Spalsh_Page_Dispalys_Automatically() {
       
       
    }
    
    @Test(dependsOnMethods = {"Step_03_verify_Spalsh_Page_Dispalys_Automatically"})
    public void Step_04_verify_Clicking_Enter_TakesTO_MTQ_Rolling_Week_View() {
       
    }

    @Test(dependsOnMethods = {"Step_04_verify_Clicking_Enter_TakesTO_MTQ_Rolling_Week_View"})
    public void Step_05_Verify_Rolling_Week_UI () {
    	
    }
    
    @Test(dependsOnMethods = {"Step_05_Verify_Rolling_Week_UI"})
    public void Step_06_Verify_Weeks_Displays_Along_Month_and_Date () {
    	
    }

    
    //@Test(dependsOnMethods = {"Step_03_Confirm_Course_Details"})
    void Step_07_Instructor_SignOut() {
        test.loginpage.signout();
    }

    //@AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    //@AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}
