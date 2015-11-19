/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30371_Topic_View;

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
public class TC02_TA_Adds_OR_Cancel_Topic_Activity {

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
    public void Step_01_TA_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_sso(getData(("users.studentTA.username")), getData(("users.studentTA.password")));
        }

    @Test(dependsOnMethods = {"Step_01_TA_Logs_in_to_the_Application"})
    public void Step_02_TA_Launch_Course() {
        test.sso.student_Click_Open(getData("course2.ISBN"));
       

    }
 @Test(dependsOnMethods = {"Step_02_TA_Launch_Course"})
    public void Step_03_Verify_RollingWeekUI_And_Select_TopicView() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyInstructorExpandsWeek();
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsTopicView();
       
    }

     @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI_And_Select_TopicView"})
    public void Step_04_TA_Edit_Course_Details_To_Add() {
        test.topicView.instructorSelectsTopic("14.3 Binomial Probability","Reading: Binomial Probability");
        test.topicView.instructorOpenTopicInEditMode("14.3 Binomial Probability","Reading: Binomial Probability");
        test.topicView.instructorEntersTitle();
        test.topicView.instructorEntersDescription("add");
        test.topicView.instructorEntersStartDate();
        test.topicView.instructorEntersEndDate();
        test.topicView.instructorClickOnSave();
        test.weekwidget.clickRWV();
    }
    

    @Test(dependsOnMethods = {"Step_04_TA_Edit_Course_Details_To_Add"})
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
    public void Step_07_Verify_RollingWeekUI_And_Select_TopicView() {
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsTopicView();
       
    }

     @Test(dependsOnMethods = {"Step_07_Verify_RollingWeekUI_And_Select_TopicView"})
    public void Step_08_TA_Edit_Course_Details_To_Cancel() {
        test.topicView.instructorSelectsTopic("14.3 Binomial Probability","Reading: Binomial Probability");
        test.topicView.instructorOpenTopicInEditMode("14.3 Binomial Probability","Reading: Binomial Probability");
        test.topicView.instructorEntersTitle();
        test.topicView.instructorEntersDescription("cancel");
        test.topicView.instructorEntersStartDate();
        test.topicView.instructorEntersEndDate();
        test.topicView.instructorClickOnCancel();
        test.weekwidget.clickRWV();
    }
    

    @Test(dependsOnMethods = {"Step_08_TA_Edit_Course_Details_To_Cancel"})
    public void Step_09_Verify_Rolling_Week_UI() {
        test.weekwidget.verifyCurrentWeekIcon();
        test.weekwidget.verifyWeeks();
        test.weekwidget.verifyMonthDate();
    }

    @Test(dependsOnMethods = {"Step_09_Verify_Rolling_Week_UI"})
    public void Step_10_Verify_Activity_Gets_Canceled() {
       test.weekwidget.verifyDescriptionNotShown();
    }

    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
    //    test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}
