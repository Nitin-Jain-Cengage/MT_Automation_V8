package com.qait.mindtap.keywords.NG_30104;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class UserPage extends GetPage{

  
	public UserPage(WebDriver driver) {
       super(driver, "UserPage");
	}

	

	public void navigateToOrganisationAndCreateUser(String organisationName, String ssoUser, String role){
	        navigateToManageUsersTab();
	        isElementDisplayed(("createUser"));       
	        fireOnClickJsEvent("adminCreate showSSOSearch", "0");
	        isElementDisplayed(("userId"));
	        element("userId").sendKeys (ssoUser);
	        element("verifySsoAccount_btn").click();
	        isElementDisplayed(("required"));
	        selectProvidedText(element("required"), role);
	        isElementDisplayed(("adminSave_btn"));
	        element("adminSave_btn").click(); 
	        isElementDisplayed(("users"));       
	        isElementDisplayed("users");    
	        Reporter.log ("Completed Admin Changes Role For Created User");
	    }
	 
	 public void navigateToManageUsersTab(){
		 wait.waitForElementToBeVisible(element("manageUsers_link"));
	     element("manageUsers_link").click();
	    }



	public void findUserInTheOrgListandPerform(String userIdValue, String action) {
		wait.resetImplicitTimeout(2); 
	        isElementDisplayed("nextPage_icon");
	        while(!element("nextPage_icon").getAttribute("class").contains("inactive")){
	            wait.hardWait(2);
	            isElementDisplayed(("users"));
	            List<WebElement> userList = elements(("users"));    
	            for(WebElement userNameValue : userList){                 
	                String userNameText = element("userNameValue").getText();
	                isElementDisplayed("userNameValue");
	                if(userNameText.contains(userIdValue)){
	                    isElementDisplayed("userNameValue");
	                    userNameValue.findElement(By.className(action)).click();
	                }
	            }
	            element("nextPage_icon").click();
	        }            
	        		
	}



	public void editUserUpdateRole(String roleUpdate) {
		selectProvidedText(element("roleNameSelector"),roleUpdate);
        element("update_btn").click();
		
	}



	public void searchUserandClickDelete(String organisationName, String ssoUserName) {
		    navigateToManageUsersTab();
	        isElementDisplayed("totalCount");
	        String countBeforeDelete = element("totalCount").getText();
	        int countBeforeDeleteNum = Integer.parseInt(countBeforeDelete);
	        findUserInTheOrgListandPerform(ssoUserName, "deleteUser");  
	        wait.hardWait(2);
	        String countAfterDelete = element("totalCount").getText();
	        int countAfterDeleteNum = Integer.parseInt(countAfterDelete);
	        int countAfterDeleteNumValue = countAfterDeleteNum + 1;
	        Assert.assertTrue(countBeforeDeleteNum==countAfterDeleteNumValue , Reporter.failForAssert("All the users are not deleted")); 
	        Reporter.log( "Completed Admin Deletes Created User");

       }
}
