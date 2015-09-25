package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class UserPage extends GetPage{

  
	public UserPage(WebDriver driver) {
       super(driver, "UserPage");
	}

	

	public void navigateToOrganisationAndCreateUser(String organisationName, String ssoUser, String role){
	        navigateToManageUsersTab();
	        wait.waitForElementToBeVisible(element("createUser"));       
	        fireOnClickJsEvent("adminCreate showSSOSearch", "0");
	        wait.waitForElementToBeVisible(element("userId"));
	        element("userId").sendKeys (ssoUser);
	        element("verifySsoAccount_btn").click();
	        wait.waitForElementToBeVisible(element("required"));
	        selectProvidedText(element("required"), role);
	        wait.waitForElementToBeVisible(element("adminSave_btn"));
	        element("adminSave_btn").click(); 
	        wait.waitForElementToBeVisible(element("users"));       
	        isElementDisplayed("users");       
	    }
	 
	 public void navigateToManageUsersTab(){
		 wait.waitForElementToBeVisible(element("manageUsers_link"));
	     element("manageUsers_link").click();
	    }



}
