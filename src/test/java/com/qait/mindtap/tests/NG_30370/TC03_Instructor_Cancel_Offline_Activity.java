/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30370;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;

/**
 *
 * @author ayushgaur
 */
public class TC03_Instructor_Cancel_Offline_Activity {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    /**
     *
     * @author ayushgaur
     */
    TestSessionInitiator test;
    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("TC01_Instructor_Adds_Offline_Activity");
        test.launchApplication(getData("sso_url"));

    }

    @Test
    public void Step_01_Instructor_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_01_Instructor_Logs_in_to_the_Application"})
    void Step_02_Instructor_Manages_Course_From_SSO() {
        test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
        test.instructor.instructor_Course_Option("Manage Course");
        test.courseEdit.instructor_Open_Course();

    }

    @Test(dependsOnMethods = {"Step_02_Instructor_Manages_Course_From_SSO"})
    void Step_03_verify_Spalsh_Page_Dispalys_Automatically() {
        test.la.verifyCourseName();
        test.la.clickEnterOnSplashPage();
        test.weekwidget.verifyCurrentWeekIcon();
        test.loginpage.logOut(test.header.accessor("helloUser"));
    }

    @Test(dependsOnMethods = {"Step_03_verify_Spalsh_Page_Dispalys_Automatically"})
    void Step_04_start_admin_test_session() {
        test.launchApplication(getData("base_url"));
    }

    @Test(dependsOnMethods = {"Step_04_start_admin_test_session"})
    public void Step_05_Admin_Logs_in_to_the_Application() {
        test.loginpage.login_to_the_application_as_admin(getData(("users.admin.username")), getData(("users.admin.password")));
        test.adminpage.verifyuserIsOnAdminPage();
        test.adminpage.openOrganizationPage();

    }

    @Test(dependsOnMethods = {"Step_05_Admin_Logs_in_to_the_Application"})
    public void Step_06_Admin_Search_Course() {
        test.adminpage.verify_User_LoggedIn_As_Admin("Admin Dashboard");
        test.adminpage.search_Course_Using_CourseKey();
        test.adminpage.clickOnProvisionApps();
        test.adminpage.selectCengageNoMT_Activity();
    }

    @Test(dependsOnMethods = {"Step_06_Admin_Search_Course"})
    public void Step_07_start_instructor_test_session() {
        test.launchApplication(getData("sso_url"));
    }

    @Test(dependsOnMethods = {"Step_07_start_instructor_test_session"})
    public void Step_08_Instructor_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.instructor.username")), getData(("users.instructor.password")));
        test.instructor.verify_User_Is_On_InstructorPage();
    }

    @Test(dependsOnMethods = {"Step_08_Instructor_Logs_in_to_the_Application"})
    public void Step_09_Instructor_Manages_Course_From_SSO() {
        test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
        test.instructor.instructor_Course_Option("Manage Course");
        test.courseEdit.instructor_Open_Course();
    }

    @Test(dependsOnMethods = {"Step_09_Instructor_Manages_Course_From_SSO"})
    public void Step_10_Verify_RollingWeekUI_And_Select_OfflineActivity() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyInstructorExpandsWeek();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();

    }

    @Test(dependsOnMethods = {"Step_10_Verify_RollingWeekUI_And_Select_OfflineActivity"})
    public void Step_11_Instructor_Enters_Detail_In_OfflineActivity() {
        test.offline_activity.instructorEnterScore();
        test.offline_activity.instructorEntersTitle();
        test.offline_activity.instructorEntersDescription();
        test.offline_activity.instructorClickOnCancel();
    }

    @Test(dependsOnMethods = {"Step_11_Instructor_Enters_Detail_In_OfflineActivity"})
    public void Step_12_Verify_Rolling_Week_UI() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyWeeks();
        test.weekwidget.verifyMonthDate();
    }

    @Test(dependsOnMethods = {"Step_12_Verify_Rolling_Week_UI"})
    public void Step_13_Verify_Activity_Not_Gets_Added() {
        test.weekwidget.verifyAssignmentNotAdded();
        test.weekwidget.verifyScoreNotShown();
        test.weekwidget.verifyTitleNotShown();
        test.weekwidget.verifyDescriptionNotShown();
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
