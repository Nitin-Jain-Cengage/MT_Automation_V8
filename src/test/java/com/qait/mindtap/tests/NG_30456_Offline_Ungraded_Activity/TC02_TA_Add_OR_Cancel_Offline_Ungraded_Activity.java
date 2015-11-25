/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30456_Offline_Ungraded_Activity;
import static com.qait.mindtap.automation.utils.YamlReader.getData;

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
public class TC02_TA_Add_OR_Cancel_Offline_Ungraded_Activity {
    
 
    TestSessionInitiator test;
    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass

    public void start_test_session() {
        test = new TestSessionInitiator("TC02_TA_Add_OR_Cancel_Offline_Ungraded_Activity");
        test.launchApplication(getData("sso_url"));

    }

   @Test
    public void Step_01_TA_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.studentTA.username")), getData(("users.studentTA.password")));
        }

    @Test(dependsOnMethods = {"Step_01_TA_Logs_in_to_the_Application"})
    public void Step_02_TA_Launch_Course() {
        test.sso.student_Click_Open(getData("course2.ISBN"));
       

    }

                   
    @Test(dependsOnMethods = {"Step_02_TA_Launch_Course"})
    public void Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyInstructorExpandsWeek();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();

    }

    @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity"})
    public void Step_04_Instructor_Enters_Detail_In_OfflineActivity() {
        test.offline_activity.instructorEnterScore();
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
        test.weekwidget.verifyCurrentWeekIcon();
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
