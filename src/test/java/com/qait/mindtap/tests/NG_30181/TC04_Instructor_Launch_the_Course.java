package com.qait.mindtap.tests.NG_30181;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;

public class TC04_Instructor_Launch_the_Course {

		TestSessionInitiator test;

	    String[] browserSizes = {"720x360"};
	    String[] layoutTags = {"all"};

	    @BeforeClass
	    @Parameters("browser")
	    public void start_test_session(@Optional String browser) {
	        test = new TestSessionInitiator("TC04_Instructor_Launch_the_Course", browser);
	        test.launchApplication(getData("sso_url"));
	        
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
	       test.courseEdit.courseEdit();
	      
	      }
	     
	    @Test(dependsOnMethods = {"Step_02_Instructor_Manages_Course_From_SSO"})
	    public void Step_03_Instructor_Enrols_TA_IN_Course() {
	       test.courseCreateEdit.addInstrutorTA(getData("users.studentTA.username"));
	       test.courseEdit.instructor_Open_Course();
	     }

	    @Test(dependsOnMethods = {"Step_03_Instructor_Enrols_TA_IN_Course"})
	    public void Step_04_verify_Spalsh_Page_Dispalys_Automatically() {
            //  test.la.verifyCourseName();	       
  	   //   test.la.clickEnterOnSplashPage();
  
	    }

	   	    
	    @Test(dependsOnMethods = {"Step_04_verify_Spalsh_Page_Dispalys_Automatically"})
	    public void Step_05_Verify_Weeks_CurrentWeekIcon_Displays_Along_Month_and_Date () {
	    	test.weekwidget.verifyCurrentWeekIcon();
	    	test.weekwidget.verifyWeeks();
	    	test.weekwidget.verifyMonthDate();
	    }
	    
	    @Test(dependsOnMethods = {"Step_05_Verify_Weeks_CurrentWeekIcon_Displays_Along_Month_and_Date"})
	    public void Step_06_Verify_Expand_Collapse_Functionality() {
	    	test.weekwidget.functionalityExpandCollapse();
	    }

	    
	    @Test(dependsOnMethods = {"Step_06_Verify_Expand_Collapse_Functionality"})
	    public void Step_07_verify_Splash_Page() {
	        test.header.MindTapIconClick();
	    	test.la.verifyBookCover();
	        test.header.MindTapIconClick();

	    }
	    
	    @Test(dependsOnMethods = {"Step_07_verify_Splash_Page"})
	    public void Step_08_Verify_Rolling_Week_UI () {
	    	test.header.MindTapIconOnTopleft();
	    	test.header.helloUserFirstNameOnRight(getData("users.instructor.name"));
	    	test.weekwidget.couresNameInBlueHeader();
	    	
	    }

	    @Test(dependsOnMethods = {"Step_08_Verify_Rolling_Week_UI"})
	     void Step_07_user_LogOut() {
                test.loginpage.logOut(test.header.accessor("helloUser"));
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