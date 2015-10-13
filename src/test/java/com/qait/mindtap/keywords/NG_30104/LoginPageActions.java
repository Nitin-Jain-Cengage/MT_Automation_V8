/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords.NG_30104;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;

/**
 *
 * @author ayushgaur
 */
public class LoginPageActions extends GetPage{

    public LoginPageActions(WebDriver driver) {
        super(driver, "LoginPage");
    }
    
    
    public void clickOnAutomationAdminLink(){
        try{
           switchToDefaultContent();
            wait.resetImplicitTimeout(2);
            //To avoid stale element exception
            element("LogoutTab");
            executeJavascript("document.getElementsByClassName('user-menu')[0].style.display = 'block';");
        }catch(NullPointerException e ){
            Reporter.fail("Logout dropdown list not displayed");
            e.printStackTrace();
        }
        catch(NoSuchElementException e ){
            Reporter.fail("Logout dropdown list not displayed");
            e.printStackTrace();
        }
        catch(StaleElementReferenceException e ){
            Reporter.fail("Logout dropdown list not displayed");
            e.printStackTrace();
        }
        catch(Exception e ){
            Reporter.fail("Logout dropdown list not displayed");
            e.printStackTrace();
        }
    }

    public void verifyLogOut() {
        isElementDisplayed("loginForm");
        isElementDisplayed("logoutMessage");
        Reporter.pass("Completed admin Logout");
    }

}
