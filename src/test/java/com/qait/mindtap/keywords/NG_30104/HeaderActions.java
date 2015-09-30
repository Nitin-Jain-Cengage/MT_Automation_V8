package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class HeaderActions extends GetPage{

	public HeaderActions(WebDriver driver) {
		super(driver,"Header");
		
	}

	public void MindTapIconOnTopleft() {
	 refreshPage();
	 wait.waitForPageToLoadCompletely();
	 Assert.assertTrue(isElementDisplayed("headerBody") , "Page not loaded");
	 Assert.assertTrue( isElementDisplayed("mindtapLogo"),Reporter.failForAssert("Mindtap icon is not displayed "));
 }

	
	public void helloUserFirstNameOnRight(String user) {
		String[] leftCorner = element("helloUser").getText().split(" ");
		if(leftCorner[0].equalsIgnoreCase("Hello,")){
			Assert.assertTrue(leftCorner[1].equalsIgnoreCase(user),Reporter.failForAssert("User is not valid"));
			Reporter.pass("Hello User is shown ");
		}
		
	}

	public void MindTapIconClick() {
		isElementEnabled("mindtapLogo",true);
		element("mindtapLogo").click();		
	}

	

}
