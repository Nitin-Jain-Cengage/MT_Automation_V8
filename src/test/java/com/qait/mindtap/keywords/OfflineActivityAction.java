/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author ayushgaur
 */
public class OfflineActivityAction extends GetPage{

    public OfflineActivityAction(WebDriver driver) {
       super(driver,"OfflineActivityPage");
    }

    public void instructorEnterScore() {
        isElementDisplayed("offline_assignmentScore");
        String score = "50";
        data.writeProperty("offline_assignmentScore", score);
        element("offline_assignmentScore").sendKeys(score);
    }

    public void instructorEntersTitle() {
        isElementDisplayed("offline_assignmentTitle");
        String title = "Assignment_Offline_1";
        data.writeProperty("offline_assignmentTitle", title);
        element("offline_assignmentTitle").sendKeys(title);
      }

    public void instructorEntersDescription() {
        isElementDisplayed("offline_assignmentDescription");
        String description = "It is an offline assignment";
        data.writeProperty("offline_assignmentDescription", description);
        element("offline_assignmentDescription").sendKeys(description);
      }

    public void instructorClickOnAdd() {
        element("addOfflineAssignment_Btn").click();
    }
    
     public void instructorClickOnCancel() {
        element("addOfflineAssignment_Cancel").click();
    }
    
}
