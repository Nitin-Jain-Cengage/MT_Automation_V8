/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30457_Week_View_functionality;

import com.qait.mindtap.automation.TestSessionInitiator;
import static com.qait.mindtap.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author ayushgaur
 */
public class TC02_TA_Verify_Week_View_Functionality {

    TestSessionInitiator test;
    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass

    public void start_test_session() {
        test = new TestSessionInitiator("TC02_TA_Add_OR_Cancel_Offline_Ungraded_Activity");
        test.launchApplication(getData("sso_url"));
        test.courseCreateEdit.clean_Data_File();

    }

    @Test
    public void Step_01_TA_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.studentTA.username")), getData(("users.studentTA.password")));
        Reporter.log("Completed log in as TA", true);
    }

    @Test(dependsOnMethods = {"Step_01_TA_Logs_in_to_the_Application"})
    public void Step_02_TA_Launch_Course() {
        test.sso.student_Click_Open(getData("coretext.ISBN"));
        Reporter.log("Completed TA launch course", true);
    }

    @Test(dependsOnMethods = {"Step_02_TA_Launch_Course"})
    public void Step_03_Verify_RollingWeekUI() {
        test.weekwidget.verifyCurrentWeekIcon();
        Reporter.log("Completed TA verify Rolling Week UI", true);
    }

    @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI"})
    public void Step_04_Verify_Add_OfflineGraded_Activities_Displays() {
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();
        test.offline_activity.instrutorselectsPracticeOption();
        test.offline_activity.instructorEntersTitle();
        test.offline_activity.instructorEntersDescription(getData("addLong"));
        test.offline_activity.instructorEntersAssociatedTopic("2900960");
        test.offline_activity.instructorClickOnAdd();
        Reporter.log("Completed TA Adds Offline Activity", true);
    }

    @Test(dependsOnMethods = {"Step_04_Verify_Add_OfflineGraded_Activities_Displays"})
    public void Step_05_Verify_RollingWeekUI_And_Select_TopicView() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsTopicView();
        Reporter.log("Completed TA Selects Topic View", true);
    }

    @Test(dependsOnMethods = {"Step_05_Verify_RollingWeekUI_And_Select_TopicView"})
    public void Step_06_verify_Hide_Edit_And_DeleteOptionsInSubTopics() {
        test.topicView.verifyHideDisplayedTopicView("14.3 Binomial Probability", "Binomial Probability");
        test.topicView.verifyEditDisplayedTopicView("14.3 Binomial Probability", "Binomial Probability");
        test.weekwidget.clickRWV();
        Reporter.log("Completed TA Verify Hide Edit and Delete Options in SubTopics", true);
    }

    @Test(dependsOnMethods = {"Step_06_verify_Hide_Edit_And_DeleteOptionsInSubTopics"})
    public void Step_07_Verify_ShowMore_OR_LessButtonInAddedOfflineActivity() {
        test.weekwidget.verifyShowMoreOrLessDisplayed();
        test.weekwidget.verifyShowMoreOrLessWorksProperly();
        Reporter.log("Completed TA verify Show More or Less Button in added offline Activity", true);
    }

    @Test(dependsOnMethods = {"Step_07_Verify_ShowMore_OR_LessButtonInAddedOfflineActivity"})
    public void Step_08_verify_Flag_And_PointsBesidesOfflineGradedActivity() {
        test.weekwidget.clickTopicView();
        test.weekwidget.verifyFlagDisplayed();
        test.weekwidget.verifyPointsDisplayed();
        Reporter.log("Completed TA Verify Flag and Points Besides Offline Graded Activity", true);
    }

    @Test(dependsOnMethods = {"Step_08_verify_Flag_And_PointsBesidesOfflineGradedActivity"})
    public void Step_09_verify_Hide_Edit_And_DeleteOptionsInAddedOfflineActivity() {
        test.weekwidget.clickRWV();
        test.weekwidget.refreshPage();
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyHideDisplayedRWV();
        test.weekwidget.verifyEditDisplayedRWV();
        test.weekwidget.verifyDeleteDisplayedRWV();
        Reporter.log("Completed TA Verify Hide Edit and Delete Options in added Offline Activity", true);
    }

    @Test(dependsOnMethods = {"Step_09_verify_Hide_Edit_And_DeleteOptionsInAddedOfflineActivity"})
    public void Step_11_verify_Hide_Action() {
        test.weekwidget.clickOnHideButton();
        test.weekwidget.verifyHideFunctionality();
        Reporter.log("Completed TA Verify Hide Action on Offline Activity", true);
    }

    @Test(dependsOnMethods = {"Step_11_verify_Hide_Action"})
    public void Step_12_verify_Toogle_Button_state_Action() {
        test.weekwidget.verifyToogleButtonDefaultState();
        test.weekwidget.verifyToogleFunctionality();
        Reporter.log("Completed TA Verify Toggle Button State and Action", true);
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
