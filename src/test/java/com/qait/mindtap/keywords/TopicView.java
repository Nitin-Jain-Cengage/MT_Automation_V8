/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ayushgaur
 */
public class TopicView extends GetPage {

    public TopicView(WebDriver driver) {
        super(driver, "TopicView");
    }

    public void instructorSelectsTopic(String topic, String subTopic) {
        List<WebElement> topicList = elements("topicList");
        for (WebElement topicTitle : topicList) {
            scrollDown(topicTitle);
            if (topicTitle.getText().equals(topic)) {
                data.writeProperty("title", topic);
                break;
            }
        }
        isElementDisplayed("subTopic", subTopic);
        hover(element("subTopic", subTopic));

    }

    public void instructorOpenTopicInEditMode(String topic, String subTopic) {
        isElementDisplayed("topicEditBtn", subTopic);
        element("topicEditBtn", subTopic).click();
    }

    public void instructorEntersDescription(String operation) {
        isElementDisplayed("descriptionTopic");
        String description = "It is an offline assignment for " + operation + date.getCurrentDateTime();
        data.writeProperty("description", description);
        element("descriptionTopic").click();
        element("descriptionTopic").clear();
        element("descriptionTopic").sendKeys(description);
    }

    public void instructorEntersStartDate() {
        element("startDateInput").click();
     //   if(!(element("calendarDate", date.getCurrentDateInitial(0)).getAttribute("class").contains("ui-state-active"))){
        element("clearBtn").click();
        waitTOSync();
        element("startDateInput").click();
        element("calendarDate", date.getCurrentDateInitial(1)).click();
        waitTOSync();
        element("doneBtn").click();
    }

    public void instructorEntersEndDate() {
        element("endDateInput").click();
   //     if(!element("calendarDate", date.getCurrentDateInitial(1)).getAttribute("class").contains("ui-state-active")){
        element("clearBtn").click();
        waitTOSync();
        element("endDateInput").click();
        int flag=0;
        flag = nextMonthCalendar(flag);
        if(flag==0){
            element("calendarDate", date.getCurrentDateInitial(2)).click();
        }
  //     }
        waitTOSync();
        isElementDisplayed("doneBtn");
        element("doneBtn").click();
        
    }

    public void instructorClickOnSave() {
        element("saveScheduleBtn").click();
    }

    public void instructorEntersTitle() {
        isElementDisplayed("title");
        data.writeProperty("title", element("title").getText());
    }

    public void instructorClickOnCancel() {
       
        element("cancelScheduleBtn").click();
    }

    public int nextMonthCalendar(int flag){
        for (WebElement dates : elements("calendarDates")) {
            if (dates.getText().equals(date.getCurrentDateInitial(2))) {
                element("calendarDate", date.getCurrentDateInitial(2)).click();
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        if (flag == 0) {
            element("endDateInput").click();
            element("calendarMonthNext").click();
        }
    return flag;
    }
    
}
