package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class HeaderActions extends GetPage{

	public HeaderActions(WebDriver driver) {
		super(driver,"Header");
		
	}

	public void MindTapIconOnTopleft(String user) {
	 isElementDisplayed("mindtapLogo");
	 Assert.assertTrue(element(""),Reporter.failForAssert("Mindtap icon is not displayed "));
	}

	
	public void helloUserFirstNameOnRight(String data) {
		String[] leftCorner = element("helloUser").getText().split(" ");
		if(leftCorner[0].equalsIgnoreCase("Hello")){
			Assert.assertTrue(leftCorner[1].equalsIgnoreCase(user),Reporter.failForAssert("User is not valid"));
			Reporter.pass("Hello User is shown ");
				
		}
		
	}

	

}
