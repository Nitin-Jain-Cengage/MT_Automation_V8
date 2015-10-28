package com.qait.mindtap.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_StudentLaunchCourseActions extends GetPage{
	public NG_30181_StudentLaunchCourseActions(WebDriver driver) {
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
        
        public void student_Click_Open(String courseKey) {
		String[] value = element("openbtn" , courseKey).getAttribute("onclick").split("\'");
                for(String url:value){
                    if(url.startsWith("http")){
                        url=url.replaceFirst("'","");
                        launchCourse(configReader.getProperty("./Config.properties" , "tier"), url);
                    }
                }
                
				
	}
}
