package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_InstructorCreatesEditCoursePageActions extends GetPage {
	public NG_30181_InstructorCreatesEditCoursePageActions(WebDriver driver) {
        super(driver, "NG-30181-InstructorCreatesEditCourse");
       
 
    }
	
	public void verify_User_Is_On_InstructorPage() {
		    verifyPageTitleContains();
	               
	    }

	public void create_Course(String courseName) {
		isElementDisplayed("inputCourseName");
		element("inputCourseName").clear();
		element("inputCourseName").sendKeys(courseName);
		element("inputBeginDate").clear();
		element("inputBeginDate").sendKeys(date.getDesiredDateInSpecificFormat("MM/dd/yyyy", -1));
		element("inputEndDate").clear();
		element("inputEndDate").sendKeys(date.getDesiredYearDateFromCurrentYearInSpecificFormat("MM/dd/yyyy" , 1));
		element("btnCreateCourse").click();	
	}

	public void clean_Data_File() {
        data.clearProperty();		
	}

	public void addInstrutorTA(String TA_mailID) {
       element("btnAddInstructorTA").click();
       element("inputEmailId").sendKeys(TA_mailID);
       element("btnAdd").click();
       element("btnSaveChanges").click();
		
	}

	
	
}
