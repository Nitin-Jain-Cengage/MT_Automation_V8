package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.YamlReader;


public class NG_30181_InstructorCreatesCourseConfirmation extends GetPage {
	
	public NG_30181_InstructorCreatesCourseConfirmation(WebDriver driver) {
        super(driver, "NG-30181-InstructorCreatesCourseConfirmation");
       
 
    }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
		 verifyPageTitleContains();
	}

	public void get_Created_Course_Key() {
       data.writeProperty("courseName", YamlReader.getData("coretext.NAME"));
       data.writeProperty("courseKey", parseUrl(element("instructorCourseUrl"))[parseUrl(element("instructorCourseUrl")).length-1]);
	   
	}
	
	
}
