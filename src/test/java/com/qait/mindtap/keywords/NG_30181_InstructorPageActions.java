package com.qait.mindtap.keywords;
import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_InstructorPageActions extends GetPage {
	

	
	public NG_30181_InstructorPageActions(WebDriver driver) {
           super(driver, "NG-30181-InstructorPage");
       
 
    }
	
	public void verify_User_Is_On_InstructorPage() {
		    verifyPageTitleContains();
	               
	    }

	public void verify_User_LoggedIn_As_Instructor(String replacement) {
		isElementDisplayed("pageTitle", replacement);
		
	}

	public void search_Course_Using_ISBN(String ISBN) {
		element("input_book_search").clear();
		element("input_book_search").sendKeys(ISBN);
		isElementDisplayed("icon_search");
		element("icon_search").click();
		
	}

	public void check_Course_CheckBox() {
		isElementDisplayed("checkbox_course");
		element("checkbox_course").click();
		element("btn_add").click();
	}

	public void instructor_Course_Option(String option) {
		isElementDisplayed("courseOperation" , option);
		element("courseOperation" , option).click();
		
	}

	public void instructor_Open_Course() {
		isElementDisplayed("courseLink", data.readProperty("courseKey"));
		launchCourse(configReader.getProperty("./Config.properties" , "tier") , element("courseLink",yml.getData("courseKey")).getAttribute("href"));

	}

	
}

