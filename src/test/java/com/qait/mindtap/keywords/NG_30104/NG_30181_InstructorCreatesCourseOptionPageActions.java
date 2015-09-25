package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;


public class NG_30181_InstructorCreatesCourseOptionPageActions extends GetPage {
	public NG_30181_InstructorCreatesCourseOptionPageActions(WebDriver driver) {
        super(driver, "NG-30181-InstructorCreatesCourseOptionPage");
       
 
    }
	
	public void verify_User_Is_On_() {
		    verifyPageTitleContains();
	               
	    }

	public void creates_New_Course() {
		element("createNewCourse").click();
		element("btnContinue").click();
		
	}

		
}
