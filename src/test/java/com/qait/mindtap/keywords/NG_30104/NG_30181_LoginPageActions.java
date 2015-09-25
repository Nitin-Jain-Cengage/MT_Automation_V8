package com.qait.mindtap.keywords.NG_30104;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;


/**
 *
 * @author prashantshukla
 */
public class NG_30181_LoginPageActions extends GetPage {

	public NG_30181_LoginPageActions(WebDriver driver) {
		super(driver, "NG-30181-LoginPage");
	}

	public void verify_User_Is_On_Login_Page() {
		verifyPageTitleContains();
	}

	public void login_to_the_application_as(String user){
		String _username = getData("users." + user + ".username");
		String _password = getData("users." + user + ".password");
		ReportMsg.info("log into application as '" + user + "'");
		login_to_the_application_sso(_username, _password);
	}

	public void login_to_the_application_as_admin(String username, String password) {
		element("inp_username").clear();
		element("inp_username").sendKeys(username);
		element("inp_password").clear();
		element("inp_password").sendKeys(password);
		element("btn_signin").click();
		ReportMsg.info("log into the application using credentials '" + username + " / " + password + "'");
	}
	
	public void login_to_the_application_sso(String username, String password) {
		element("sso_username").clear();
		element("sso_username").sendKeys(username);
		element("sso_password").clear();
		element("sso_password").sendKeys(password);
		element("sso_signin").click();
		ReportMsg.info("log into the application using credentials '" + username + " / " + password + "'");
	}

	public void logout(){
		element("icon_logout").click();
	}
	
	public void verify_Login_Error_Message_Is_Displayed(String errormsgtxt) {
		verifyElementTextContains("txt_errormsg", errormsgtxt);
	}

	public void signout() {
		element("icon_signout").click();
		
	}

	
}
