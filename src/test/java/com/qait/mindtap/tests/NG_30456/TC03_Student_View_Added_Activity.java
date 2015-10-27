/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30456;

import com.qait.mindtap.automation.TestSessionInitiator;
import static com.qait.mindtap.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author ayushgaur
 */
public class TC03_Student_View_Added_Activity {
    
    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("TC03_Student_View_Added_Activity");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void Step_01_Student_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.student.ssousername")), getData(("users.student.ssopassword")));
        test.sso.verify_User_Is_On_SSO_dashboard();
    }

    @Test(dependsOnMethods = {"Step_01_Student_Logs_in_to_the_Application"})
    public void Step_02_Student_Launch_Course() {
        test.sso.student_Open_Course();
        test.coursePayment.verify_User_Is_On_CoursePayment_Page();
        test.coursePayment.take_Me_To_Course();

    }
    
    @Test(dependsOnMethods = {"Step_02_Student_Launch_Course"})
    public void Step_03_Verify_Weeks_CurrentWeekIcon_Displays_Along_Month_and_Date() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyWeeks();
        test.weekwidget.verifyMonthDate();

    }

    @Test(dependsOnMethods = {"Step_03_Verify_Weeks_CurrentWeekIcon_Displays_Along_Month_and_Date"})
    public void Step_04_Verify_Activity_Gets_Added() {
        test.weekwidget.verifyAssignment();
        test.weekwidget.verifyScore();
        test.weekwidget.verifyTitle();
        test.weekwidget.verifyDescription();
    }

    @Test(dependsOnMethods = {"Step_04_Verify_Activity_Gets_Added"})
    void Step_07_student_LogOut() {
        test.loginpage.logOut(test.header.accessor("helloUser"));// for accessing locators of different actions class
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

