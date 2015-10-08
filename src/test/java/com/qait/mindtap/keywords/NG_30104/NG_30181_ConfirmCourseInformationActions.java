package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_ConfirmCourseInformationActions extends GetPage{

	public NG_30181_ConfirmCourseInformationActions(WebDriver driver) {
            super(driver, "NG-30181-ConfirmCourseInformation");
	}

	public void verify_User_Is_On_CourseConfirmInfoPage() {
	    verifyPageTitleContains();
        }

	public void student_Click_Continue_Button(){
            isElementDisplayed("btnContinue");
            element("btnContinue").click();
	}
	
}
