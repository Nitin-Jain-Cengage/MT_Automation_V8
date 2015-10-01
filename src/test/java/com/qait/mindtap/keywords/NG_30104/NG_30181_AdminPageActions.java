/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class NG_30181_AdminPageActions extends GetPage{

	SeleniumWait sel_wait;
    
    public NG_30181_AdminPageActions(WebDriver driver) {
        super(driver, "NG-30181-AdminPage");
        sel_wait = new SeleniumWait(driver,30);
 
    }

    public void verifyuserIsOnAdminPage() {
       	verifyPageTitleContains();
        ReportMsg.pass("Verified User is on Admin Page"); 
    }

   	public void verify_User_LoggedIn_As_Admin(String replacement) {
	    this.isElementDisplayed("mindtap_toolbar");
	    this.isElementDisplayed("admin_dashboard", replacement);
	}
	
    public void search_Course_Using_ISBN(String courseKey) {
		element("input_search_ISBN").sendKeys(courseKey);
                                
	}

	public void open_Course_In_Edit_Mode(String replacement){
		wait.waitForElementToDisappear(element("nextPageArrow"));
                isElementDisplayed("Btn_show_copy");
		element("Btn_show_copy").click();
		isElementDisplayed("icon_course_edit");
		element("icon_course_edit").click();
		
	}
	
	public void course_Andesite_Mode_Is_Checked(String replacement){
		this.isElementDisplayed("Edit_Working_copy",replacement);
		this.isElementDisplayed("checkbox_Andesite_mode");
	    element("btn_save_Edit_Working_copy").click();

	}
	
   	
}
