package com.qait.mindtap.keywords;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.qait.mindtap.keywords.NG_30104;
//
//import com.qait.mindtap.automation.getpageobjects.GetPage;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
///**
// *
// * @author ayushgaur
// */
//public class SearchAppPageActions extends GetPage{
//
//    public SearchAppPageActions(WebDriver driver) {
//        super(driver, "SearchAppPage");
//    }
//
//    public void verifySearchApp() {
//         if(element("search").isDisplayed()){
//            wait.hardWait(1);
//            executeJavascript("document.getElementById('app_Search').click()");
//            isElementDisplayed("panelName");
//            Assert.assertTrue(element("panelName").getText().equalsIgnoreCase("Search"), "Actual Value = " + element("panelName").getText() + "  Expected Value = Search");
//            element("inputSearch").isDisplayed();
//            element("hide").isDisplayed();
//        }    }
//
//    public void performSearchOperationUsingSubmit(String string) {
//        performSearchOperationAndClickOnSearchButton("name");
//        isElementDisplayed("suggestion_box");
//        element("suggestion_boxItem").click();
//        if(configReader.getProperty("Browser").equalsIgnoreCase("firefox")){
//            element("clearResult").click();
//        }
//        else{ if(configReader.getProperty("Browser").equalsIgnoreCase("chrome")){
//            fireOnClickJsEvent("closeBut");
//        }
//        mt.clickOnHideApp();    
//        }
//        Reporter.log("Completed verify Search Operation");
//
//     }
//
//    void performSearchOperationAndClickOnSearchButton(String name){
//        name = "\"" +name+ "\"";
//        isElementDisplayed("search");
//        element("inputSearch").clear();
//        element("inputSearch").sendKeys(name);
//        element("search_btn").click();
//    }
//    
//    void performSearchOperationAndClickOnSearchButtonForPageNo(String name){
//        isElementDisplayed("search");
//        element("inputSearch").clear();
//        element("inputSearch").sendKeys(name);
//        wait.hardWait(2);
//        isElementDisplayed("search_btn");
//        element("search_btn").click();
//        wait.hardWait(2);
//    }
//
//    
//}
