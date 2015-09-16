/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords.admin;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class AdminPageActions extends GetPage{

    public ManageMastersPageActions managemasters;
    
    public AdminPageActions(WebDriver driver) {
        super(driver, "AdminPage");
        managemasters = new ManageMastersPageActions(driver, "AdminPages_");
    }

    public void verifyuserIsOnAdminPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void openManageMasters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
