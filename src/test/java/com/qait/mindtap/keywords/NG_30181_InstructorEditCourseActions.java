package com.qait.mindtap.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;

public class NG_30181_InstructorEditCourseActions extends GetPage {
	public NG_30181_InstructorEditCourseActions(WebDriver driver) {
            super(driver, "NG-30181-InstructorManageCourses");
        }
	
	public void verify_User_Is_On_Course_Confirmation_Page() {
             verifyPageTitleContains();
	}

	public void courseDelete(String courseName) {
            if(checkIfElementIsNotThere("courseLink", data.readProperty(courseName)))	{
		ReportMsg.pass("Course is already deleted"); 
		}
            else{
		element("deleteCourse", data.readProperty("courseName")).click();
		handleAlert();
		courseDelete(data.readProperty(courseName));
                }
        }
	
        public void courseEdit() {
            if(checkIfElementIsNotThere("courseLink", data.readProperty("courseName")))	{
		ReportMsg.pass("Course is already deleted"); 
		}
            else{
		element("editCourse", data.readProperty("courseName")).click();
		}
        }

	
	public void instructor_Open_Course(String courseName) {
		isElementDisplayed("courseLink", courseName);
		launchCourse(configReader.getProperty("./Config.properties" , "tier") , element("courseLink",courseName).getAttribute("href"));

	}
        
        public void instructor_Open_Course() {
		isElementDisplayed("courseLink",data.readProperty("courseName"));
		launchCourse(configReader.getProperty("./Config.properties" , "tier") , element("courseLink",data.readProperty("courseName")).getAttribute("href"));

	}

        public void instructor_Select_PreviousCourses() {
		isElementDisplayed("courseLink", yml.getData("coretext.NAME"));
		launchCourse(configReader.getProperty("./Config.properties" , "tier") , element("courseLink",yml.getData("coretext.NAME")).getAttribute("href"));

	}
        
        
}  

