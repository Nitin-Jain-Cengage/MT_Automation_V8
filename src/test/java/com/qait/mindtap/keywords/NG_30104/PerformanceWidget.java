/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords.NG_30104;

/**
 *
 * @author ayushgaur
 */

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebElement;

public class PerformanceWidget extends GetPage{

	public PerformanceWidget(WebDriver driver) {
		super(driver, "PerformanceWidget");
		
	}

    public void dropsStudent() {
        element("performanceIcon").click();
        switchToFrame(element("performanceWidgetFrame"));
        System.out.println("Switched to frame");
        try{
        for(WebElement ele:elements("courseEnrolledUser")){
            ele.click();
            element("dropStudent").click();
            element("yesToDrop").click();
        }}
        catch(NullPointerException e){
              switchToDefaultContent();
        }
    }
    
}
