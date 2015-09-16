package com.qait.mindtap.keywords;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author prashantshukla
 */
public class LoginPageActions extends GetPage {

	public LoginPageActions(WebDriver driver) {
		super(driver, "LoginPage");
	}

	public void verify_User_Is_On_Login_Page() {
		verifyPageTitleContains();
                ReportMsg.pass("Verified User is on Login Page");
	}

	public void login_to_the_application_as(String user){
		String _username = getData("users." + user + ".username");
		String _password = getData("users." + user + ".password");
		ReportMsg.info("log into application as '" + user + "'");
		login_to_the_application_as(_username, _password);
	}

	public void login_to_the_application_as(String username, String password) {
		element("inp_username").clear();
		element("inp_username").sendKeys(username);
		element("inp_password").clear();
		element("inp_password").sendKeys(password);
		element("btn_signin").click();
		ReportMsg.info("log into the application using credentials '" + username + " / " + password + "'");
	}

	public void verify_Login_Error_Message_Is_Displayed(String errormsgtxt) {
		verifyElementTextContains("txt_errormsg", errormsgtxt);
	}
}
