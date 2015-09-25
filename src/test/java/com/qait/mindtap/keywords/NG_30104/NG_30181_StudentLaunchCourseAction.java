package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_StudentLaunchCourseAction extends GetPage{
	public NG_30181_StudentLaunchCourseAction(WebDriver driver) {
        super(driver, "NG-30181-SsoDashboard");
        
    }
	
	public void verify_User_Is_On_SSO_dashboard() {
		    verifyPageTitleContains();
	               
	    }
	
	public void student_Registers_Course_With_CourseKey() {
		isElementDisplayed("inputCourseKey");
		element("inputCourseKey").sendKeys(data.readProperty("courseKey"));
		element("btnRegister").click();
		
	}

	public void student_Open_Course() {
		element("btnOpenCourse" , data.readProperty("courseKey").replaceAll("-","")).click();
				
	}
}
