package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class AdminPerformActionPage extends GetPage{

    String OrgURL = configReader.getProperty("environment") + "/static/nb/ui/admin/orgs/orgs.html" ;
    String MasterURL = configReader.getProperty("environment") + "/static/nb/ui/admin/masters/masters.html";

	
	
	public AdminPerformActionPage(WebDriver driver) {
       super(driver, "AdminPerformActionPage");
	}

	public void verify_User_LoggedIn() {
		 Reporter.log ("Completed LoginAsAdmin");
		 verifyPageTitleContains(yml.getData("neXtBooks.neXtBook1.pageTitle"));
	     isElementDisplayed("logo");
	     isElementDisplayed("loggedID");
	     Reporter.log ("Completed verifyPageTitle");
	}

	public void createMasterNeXtBookInCourseMode() {
		
	}

	public void openMaster() {
		launchSpecificUrl("MasterURL");       
        isElementDisplayed("masters_link");
        element("masters_link").getAttribute("class").contains("active");
        Reporter.log ("Completed Admin Creates Master NeXtBook In Course Mode");
        
	}

	public void clickCreateMaster() {
		// TODO Auto-generated method stub
		
	}

	public void enterMasterNameAndDescription(String data, String data2,
			String data3) {
		// TODO Auto-generated method stub
		
	}

	public void enterCoreTextISBN(String data) {
		// TODO Auto-generated method stub
		
	}

	public void createUnpublishedMaster(String data) {
		// TODO Auto-generated method stub
		
	}

	public void searchBookOnMastersPage(String data) {
		// TODO Auto-generated method stub
		
	}

	public void clickOnModeValueIcon(String data) {
		// TODO Auto-generated method stub
		
	}

	public void clickBookModifyOption(String data, String string) {
		// TODO Auto-generated method stub
		
	}

	public void refreshMasterNextBook(String data) {
		// TODO Auto-generated method stub
        Reporter.log ("Completed Admin Refresh Master NeXtBook");

	}

	public void openOrg() {
		getURL(OrgURL);
		isElementDisplayed("orgs_link");
		element("orgs_link").getAttribute("class").contains("active");
		
				
	}

	
	
}
