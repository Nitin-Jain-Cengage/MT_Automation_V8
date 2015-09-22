package com.qait.mindtap.keywords.NG_30104;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;
import org.openqa.selenium.WebDriver;


public class NG_30181_InstructorCreatesCourseConfirmation extends GetPage {
	
	public NG_30181_InstructorCreatesCourseConfirmation(WebDriver driver) {
        super(driver, "NG-30181-InstructorCreatesCourseConfirmation");
       
 
    }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
		 verifyPageTitleContains();
	}
	
	
}
