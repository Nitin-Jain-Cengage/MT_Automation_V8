package com.qait.mindtap.automation.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mindtapUtilityMethods {

	
	WebDriver driver;
	
	 
	 public mindtapUtilityMethods(WebDriver driver) {
     this.driver=driver;
	 }


	public void clickOnCourseName(String CourseName, String env, List<WebElement> lnk_course) {
	    for (WebElement ele : lnk_course) {
	            if (ele.getText().equalsIgnoreCase(CourseName)) {
	                String attribute = ele.getAttribute("href");
	                String[] url = attribute.split("http.*.ng.cengage.com");
	                System.out.println(url[1]);
	                if (env.equalsIgnoreCase("qad")) {
	                    System.out.println("Navigated To QAD Env.");
	                    System.out.println("http://qad-ng.cengage.com" + url[1]);
	                    driver.navigate().to("http://qad-ng.cengage.com" + url[1]);
	                }
	                if (env.equalsIgnoreCase("qaf")) {
	                    System.out.println("Navigated To QAF Env.");
	                    driver.navigate().to("http://qaf.ng.cengage.com" + url[1]);
	                }
	                if (env.equalsIgnoreCase("prod")) {
	                    System.out.println("navigated to prod..");
	                    driver.navigate().to("http://ng.cengage.com" + url[1]);
	                }
	                break;
	            }
	        }
}
	 
	 
	 public void launchCourse(String environment , String url) {
	         
	        System.out.println(url);
	        System.out.println("Navigated to URL:-"+url);
	        if (environment.toLowerCase().endsWith("qad")) {
	            url = url.replaceAll("qaf.", "qad-");
	        }
	        if (environment.toLowerCase().endsWith("prod")) {
	            url = url.replaceAll("qaf.", "");
	        }
	        if (environment.toLowerCase().endsWith("qaf")) {
	            url = url;
	        }
	        if (environment.toLowerCase().endsWith("qap")) {
	            url = url.replaceAll("qaf.", "qap.");
	        }

	        if (environment.toLowerCase().endsWith("mtprod")) {
	            url = url.replaceAll("cloud-qap-ng", "mtprod");
	        }
	        System.out.println(url);
	        driver.navigate().to(url);
	        
	        
	    }

	

	
}