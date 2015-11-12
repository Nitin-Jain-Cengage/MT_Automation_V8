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
public class OfflineActivityAction extends GetPage {

    public OfflineActivityAction(WebDriver driver) {
        super(driver, "OfflineActivityPage");
    }

    public void instructorEnterScore() {
        isElementDisplayed("offline_assignmentScore");
        String score = "50";
        data.writeProperty("offline_assignmentScore", score);
        element("offline_assignmentScore").clear();
        element("offline_assignmentScore").sendKeys(score);
    }

    public void instructorEntersTitle() {
        isElementDisplayed("offline_assignmentTitle");
        String title = "Assignment_Offline_1";
        data.writeProperty("offline_assignmentTitle", title);
        element("offline_assignmentTitle").click();
        element("offline_assignmentTitle").sendKeys(title);
    }

    public void instructorEntersDescription(String operation) {
        isElementDisplayed("offline_assignmentDescription");
        String description = yml.getData(operation) + operation + date.getCurrentDateTime();
        data.writeProperty("offline_assignmentDescription", description);
        element("offline_assignmentDescription").click();
        element("offline_assignmentDescription").sendKeys(description);
        waitTOSync();
    }

    public void instructorClickOnAdd() {
        isElementDisplayed(("addOfflineAssignment_Btn"));
        element("addOfflineAssignment_Btn").click();
        String addBtnClass = element("addOfflineAssignment_Btn").getAttribute("class");
        System.out.println("Add Button Class:"+ addBtnClass);
        fireOnClickJsEvent(addBtnClass,"1");
        //hoverClick(element("addOfflineAssignment_Btn"));
    }

    public void instructorClickOnCancel() {
        isElementDisplayed(("addOfflineAssignment_Cancel"));
        element("addOfflineAssignment_Cancel").click();
    }

    public void instrutorselectsPracticeOption() {
        isElementDisplayed("practiceBtn");
        element("practiceBtn").click();
    }

    public void instructorEntersAssociatedTopic(String string) {
        isElementDisplayed("AssociatedTopic");
        element("AssociatedTopic").click();
//        isElementDisplayed("topic",string);
//        element("topic",string);
        selectProvidedValue(element("AssociatedTopic"), string);
    }

}
