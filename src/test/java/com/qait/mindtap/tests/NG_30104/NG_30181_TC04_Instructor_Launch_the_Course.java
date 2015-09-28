package com.qait.mindtap.tests.NG_30104;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;

public class NG_30181_TC04_Instructor_Launch_the_Course {

		TestSessionInitiator test;

	    String[] browserSizes = {"720x360"};
	    String[] layoutTags = {"all"};

	    @BeforeClass
	    @Parameters("browser")
	    public void start_test_session(@Optional String browser) {
	        test = new TestSessionInitiator("NG_30181_TC03_Instructor_Creates_Course", browser);
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
	    public void Step_02_Instructor_Manages_Course_From_SSO() {
	       test.instructor.verify_User_LoggedIn_As_Instructor("Instructor Resource Center");
	       test.instructor.instructor_Course_Option("Manage Course");
	       test.courseEdit.courseOperations(getData("coretext.NAME"),"Edit Course");
	      
	      }
	     
	    @Test(dependsOnMethods = {"Step_02_Instructor_Manages_Course_From_SSO"})
	    public void Step_03_Instructor_Enrols_TA_IN_Course() {
	       test.instructor.instructor_Course_Option("Manage Course");
	       test.courseEdit.courseOperations(getData("coretext.NAME"),"Edit Course");
	       test.courseCreateEdit.addInstrutorTA(getData("TA"));
	       test.instructor.instructor_Open_Course();
	      }

	   
	    @Test(dependsOnMethods = {"Step_03_Instructor_Enrols_TA_IN_Course"})
	    public void Step_04_Verify_Rolling_Week_UI () {
	    	test.header.MindTapIcononTopleft();
	    	test.header.helloUserFirstNameOnRight(getData("users.instructor.name"));
	    	test.weekwidget.couresNameInBlueHeader();
	    	test.weekwidget.verifyRWV_TV_andJUMP_TO_WEEK_Buttons();
	    	
	    }
	    
	    @Test(dependsOnMethods = {"Step_05_Verify_Rolling_Week_UI"})
	    public void Step_06_Verify_Weeks_Displays_Along_Month_and_Date () {
	    	test.weekwidget.verifyMonthDate();
	    }
	    
	    @Test(dependsOnMethods = {"Step_05_Verify_Rolling_Week_UI"})
	    public void Step_06_Verify_Expand_Collapse_Functionality() {
	    	test.weekwidget.functionalityExpandCollapse();
	    }

	    
	    @Test(dependsOnMethods = {"Step_02_Instructor_Launch_Course_From_SSO"})
	    public void Step_03_verify_Splash_Page() {
	    	test.la.verifyBookCover(getData("neXtBooks.neXtBook2.splashPage.bookCoverText"));
	        test.la.verifyAuthors(getData("neXtBooks.neXtBook2.splashPage.aboutAuthorText"));
	        test.la.verifyAboutCengageLearning(getData("neXtBooks.neXtBook2.splashPage.cengageLearningText"));
	        test.la.verifyAboutMindTap(getData("neXtBooks.neXtBook2.splashPage.mindTapText"));
	        test.la.verifyCopyrightStatement(getData("neXtBooks.neXtBook2.splashPage.copyrightText"));
	        test.la.verifyMindTapServiceAgreement(getData("neXtBooks.neXtBook2.splashPage.mindTapAgreementText"));
	        test.la.verifySupportInformation(getData("neXtBooks.neXtBook2.splashPage.supportInf"));
       
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