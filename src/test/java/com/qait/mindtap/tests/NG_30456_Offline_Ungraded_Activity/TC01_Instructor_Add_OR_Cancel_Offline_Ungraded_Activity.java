/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30456_Offline_Ungraded_Activity;

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
public class TC01_Instructor_Add_OR_Cancel_Offline_Ungraded_Activity {

    TestSessionInitiator test;
    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass

    public void start_test_session() {
        test = new TestSessionInitiator("TC01_Instructor_Add_OR_Cancel_Offline_Ungraded_Activity");
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
        test.courseEdit.instructor_Open_Course(getData("course2.NAME"));

    }

    @Test(dependsOnMethods = {"Step_02_Instructor_Manages_Course_From_SSO"})
    public void Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyInstructorExpandsWeek();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();

    }

    @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity"})
    public void Step_04_Instructor_Enters_Detail_In_OfflineActivity() {
        test.offline_activity.instrutorselectsPracticeOption();
        test.offline_activity.instructorEntersTitle();
        test.offline_activity.instructorEntersDescription("add");
        test.offline_activity.instructorClickOnAdd();
    }

    @Test(dependsOnMethods = {"Step_04_Instructor_Enters_Detail_In_OfflineActivity"})
    public void Step_05_Verify_Rolling_Week_UI() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyWeeks();
        test.weekwidget.verifyMonthDate();
    }

    @Test(dependsOnMethods = {"Step_05_Verify_Rolling_Week_UI"})
    public void Step_06_Verify_Activity_Gets_Added() {
        test.weekwidget.verifyDescription();
    }

    @Test(dependsOnMethods = {"Step_06_Verify_Activity_Gets_Added"})
    public void Step_07_Verify_Rolling_Week_UI() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();
    }

    @Test(dependsOnMethods = {"Step_07_Verify_Rolling_Week_UI"})
    public void Step_08_Instructor_Enters_Detail_In_OfflineActivity() {
        test.offline_activity.instrutorselectsPracticeOption();
        test.offline_activity.instructorEntersTitle();
        test.offline_activity.instructorEntersDescription("Cancel");
        test.offline_activity.instructorClickOnCancel();
    }

    @Test(dependsOnMethods = {"Step_08_Instructor_Enters_Detail_In_OfflineActivity"})
    public void Step_09_Verify_Activity_Gets_Added_OR_Not() {
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
