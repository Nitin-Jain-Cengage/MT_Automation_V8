package com.qait.mindtap.keywords.NG_30104;

import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;

import org.openqa.selenium.WebDriver;



import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_InstructorDeletesCourse extends GetPage {
	public NG_30181_InstructorDeletesCourse(WebDriver driver) {
        super(driver, "NG-30181-InstructorManageCourses");
       
 
    }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
		 verifyPageTitleContains();
	}

	public void course_Delete(String courseName) {
	//	isElementDisplayed("deleteCourse", courseName);
		//element("deleteCourse", courseName).click();
	//	handleAlert();
		Assert.assertTrue(checkIfElementIsNotThere("deleteCourse", courseName), ReportMsg.failForAssert("Course '"+courseName+"'is not deleted"));		
		ReportMsg.pass("Course is already deleted");
	}
}
