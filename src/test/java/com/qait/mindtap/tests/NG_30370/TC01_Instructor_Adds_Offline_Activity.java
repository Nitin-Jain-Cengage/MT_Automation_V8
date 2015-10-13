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
public class TC01_Instructor_Adds_Offline_Activity {
        	TestSessionInitiator test;

	    String[] browserSizes = {"720x360"};
	    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("TC01_Admin_login_and_search_the_isbn_under_master_Tab", browser);
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void Step_01_Admin_Logs_in_to_the_Application() {
        test.loginpage.login_to_the_application_as_admin(getData(("users.admin.username")), getData(("users.admin.password")));
        test.adminpage.verifyuserIsOnAdminPage();
    }

    @Test(dependsOnMethods = {"Step_01_Admin_Logs_in_to_the_Application"})
    public void Step_02_Admin_Search_Course_using_ISBN() {
       test.adminpage.verify_User_LoggedIn_As_Admin("Admin Dashboard");
       test.adminpage.search_Course_Using_ISBN(getData("course1.ISBN"));
      }
            
    @Test(dependsOnMethods = {"Step_02_Admin_Search_Course_using_ISBN"})
     public void step_03_test_session(@Optional String browser) {
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
	    public void Step_03_Instructor_Open_Course() {
	       test.courseEdit.instructor_Open_Course();
	     }

	    @Test(dependsOnMethods = {"Step_03_Instructor_Enrols_TA_IN_Course"})
	    public void Step_04_verify_Spalsh_Page_Dispalys_Automatically() {
              test.la.verifyCourseName();	       
  	      test.la.clickEnterOnSplashPage();
  	    }
            
            
}
	  