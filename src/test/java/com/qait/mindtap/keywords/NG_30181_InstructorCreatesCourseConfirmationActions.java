package com.qait.mindtap.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.YamlReader;


public class NG_30181_InstructorCreatesCourseConfirmationActions extends GetPage {
	
	public NG_30181_InstructorCreatesCourseConfirmationActions(WebDriver driver) {
             super(driver, "Ng-30181-InstructorCreatesCourseConfirmation");
        }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
	     verifyPageTitleContains();
	}

	public void get_Created_Course_Key(String ISBN) {
            data.writeProperty("courseName", element("instructorCourseName", ISBN).getText());
            data.writeProperty("courseKey", parseUrl(element("instructorCourseUrl"))[parseUrl(element("instructorCourseUrl")).length-1]);
        }
}
