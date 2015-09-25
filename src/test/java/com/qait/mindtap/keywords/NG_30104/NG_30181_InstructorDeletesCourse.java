package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;

public class NG_30181_InstructorDeletesCourse extends GetPage {
	public NG_30181_InstructorDeletesCourse(WebDriver driver) {
        super(driver, "NG-30181-InstructorManageCourses");
       
 
    }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
		 verifyPageTitleContains();
	}

	public void course_Delete(String courseName) {
		
		if(checkIfElementIsNotThere("deleteCourse", courseName))	{
			ReportMsg.pass("Course is already deleted"); 
		}
		
		else{
			element("deleteCourse", courseName).click();
			handleAlert();
			course_Delete(courseName);
			}
		 }
}
