package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;

public class NG_30181_InstructorEditCourse extends GetPage {
	public NG_30181_InstructorEditCourse(WebDriver driver) {
        super(driver, "NG-30181-InstructorManageCourses");
       
 
    }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
		 verifyPageTitleContains();
	}

	public void courseDelete(String courseName) {
		
		if(checkIfElementIsNotThere("courseLink", courseName))	{
			ReportMsg.pass("Course is already deleted"); 
		}
		
		else{
			element("deleteCourse", courseName).click();
			handleAlert();
			courseDelete(courseName);
			
		}
 }
	
public void courseEdit(String courseName) {
		
		if(checkIfElementIsNotThere("courseLink", courseName))	{
			ReportMsg.pass("Course is already deleted"); 
		}
		
		else{
			element("editCourse", courseName).click();
					
		}
 }

	
	public void instructor_Open_Course() {
		isElementDisplayed("courseLink", data.readProperty("courseName"));
		mt.launchCourse(configReader.getProperty("./Config.properties" , "tier") , element("courseLink",data.readProperty("courseName")).getAttribute("href"));

	}

}
