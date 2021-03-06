package com.qait.mindtap.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class NG_30181_CoursePaymentActionPageActions extends GetPage{

	
            public NG_30181_CoursePaymentActionPageActions(WebDriver driver) {
                    super(driver, "NG-30181-CoursePaymentPage");
	        
	    }
		
            public void verify_User_Is_On_CoursePayment_Page() {
		    verifyPageTitleContains();
	    }
				
            public void take_Me_To_Course() {
                   launchCourse(configReader.getProperty("./Config.properties" , "tier") , (String)executeJavascriptWithReturn("document.getElementById('"+elementByJscript("courseUrl")+"').getAttribute('value')"));
		}
	}


