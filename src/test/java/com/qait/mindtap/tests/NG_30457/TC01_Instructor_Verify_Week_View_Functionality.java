/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.tests.NG_30457;
import com.qait.mindtap.automation.TestSessionInitiator;
import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author ayushgaur
 */
public class TC01_Instructor_Verify_Week_View_Functionality {
    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};
 
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
        test.courseEdit.instructor_Open_Course(getData("coretext.NAME"));

    }

    @Test(dependsOnMethods = {"Step_02_Instructor_Manages_Course_From_SSO"})
    public void Step_03_Verify_RollingWeekUI() {
        test.weekwidget.verifyCurrentWeekIcon();
    }

    @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity"})
    public void Step_04_Verify_OfflineGraded_Activities_Displays(){
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsOfflineActivity();
        test.offline_activity.instrutorselectsPracticeOption();
        test.offline_activity.instructorEntersTitle();
        test.offline_activity.instructorEntersDescription("addLong");
        test.offline_activity.instructorEntersAssociatedTopic("- 1.1 Real Numbers");
        
    }
    
    @Test(dependsOnMethods = {"Step_03_Verify_RollingWeekUI_And_Select_OfflineActivity"})
    public void Step_05_Verify_ShowMore_OR_Less(){
        test.weekwidget.verifyShowMoreOrLessDisplayed();
        test.weekwidget.verifyShowMoreOrLessWorksProperly();

    }
    
    @Test(dependsOnMethods = {"Step_05_Verify_ShowMore_OR_Less"})
    public void Step_06_verify_Flag_And_Points(){
        test.weekwidget.verifyFlagDisplayed();
        test.weekwidget.verifyPointsDisplayed();
    }
    
    @Test(dependsOnMethods = {"Step_06_verify_Flag_And_Points"})
    public void Step_07_verify_Hide_Edit_And_Delete(){
            test.weekwidget.verifyHideDisplayed();
            test.weekwidget.verifyEditDisplayed();
            test.weekwidget.verifyDeleteDisplayed();
    }
    
    @Test(dependsOnMethods = {"Step_07_verify_Hide_Edit_And_Delete"})
    public void Step_08_verify_Hide_Edit_In_TopicVIew(){
        test.weekwidget.instructorClickOnAddToWeek();
        test.weekwidget.instructorSelectsDay();
        test.weekwidget.instructorSelectsTopicView();
        test.topicView.verifyHide();
        test.topicView.verifyDelete();  
        test.weekwidget.clickRwv();
    }
    
    @Test(dependsOnMethods = {"Step_08_verify_Hide_Edit_In_TopicVIew"})
    public void Step_09_verify_Hide_Action(){
        test.weekwidget.clickOnHideButton();
        test.weekwidget.verifyHideFunctionality();
    }
    
    @Test(dependsOnMethods = {"Step_09_verify_Hide_Action"})
    public void Step_10_verify_Toogle_Button_state_Action(){
        test.weekwidget.verifyToogleButtonDefaultState();
        test.weekwidget.verifyToogleFunctionality();
    }
   
    
    
}
