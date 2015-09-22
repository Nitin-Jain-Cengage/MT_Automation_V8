package com.qait.mindtap.keywords.NG_30104;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;

import org.openqa.selenium.WebDriver;

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
		element("inputBeginDate").sendKeys(date.getDateInSpecificFormat("MM/dd/yyyy"));
		element("inputEndDate").clear();
		element("inputEndDate").sendKeys(date.getDesiredYearDateFromCurrentYearInSpecificFormat("MM/dd/yyyy" , 1));
		element("btnCreateCourse").click();	
	}

	
	
}
