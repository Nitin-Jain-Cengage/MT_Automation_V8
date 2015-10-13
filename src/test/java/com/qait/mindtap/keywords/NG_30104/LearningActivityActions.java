 package com.qait.mindtap.keywords.NG_30104;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class LearningActivityActions extends GetPage{

	public LearningActivityActions(WebDriver driver) {
            super(driver, "LearningActivity");
	}

	public void verifyBookCover() {
		isElementDisplayed("courseNameAfterEnter");
	        Assert.assertTrue(element("courseNameAfterEnter").getText().equalsIgnoreCase(data.readProperty("courseName")),	Reporter.failForAssert("Failed to Verify Book Cover Test"));
	        Reporter.pass ("Completed Verify Book Cover Test");

	}

	public void verifyAuthors(String title) {
		element("authors_link").click();
	        wait.hardWait(2);
	        isElementDisplayed("author_header");
	        String text = element("author_header").getText();
	        Assert.assertTrue(text.contains(title),	Reporter.failForAssert( "Failed to Verify Authors Test") );
	        Reporter.pass( "Completed Verify Authors Test");

	}

	public void verifyAboutCengageLearning(String title) {
		element("cengageLearning_link").click();
	        wait.hardWait(2);
	        isElementDisplayed("title_header");
	        String text = element("title_header").getText();
	        wait.hardWait(2);
	        Assert.assertTrue(text.contains(title), Reporter.failForAssert( "Failed to Verify About Cengage Learning Test"));
	        Reporter.pass( "Completed Verify About Cengage Learning Test");

	}

	public void verifyAboutMindTap(String title) {
	        element("mindTap_link").click();
	        wait.hardWait(2);
	        isElementDisplayed("title_header");
	        String text = element("title_header").getText();
	        Assert.assertTrue(text.contains(title),Reporter.failForAssert( "Failed to Verify About MindTap Test"));
	        Reporter.pass( "Completed Verify About MindTap Test");

	}

	public void verifyCopyrightStatement(String title) {
		element("copyrightStatement_link").click();
	        wait.hardWait(2);
	        isElementDisplayed("copyright_header");
	        String text = element("copyright_header").getText();
	        Assert.assertTrue(text.contains(title),	Reporter.failForAssert("Failed to Verify Copyright Statement Test"));
	        Reporter.pass ("Completed Verify Copyright Statement Test");

	}

	public void verifyMindTapServiceAgreement(String title) {
	    element("mindTapServiceAgreement_link").click();
             wait.hardWait(2);
             isElementDisplayed("title_header");
             String text = element("title_header").getText();
             Assert.assertTrue(text.contains(title),Reporter.failForAssert("Failed to Verify MindTap Service Agreement Test"));
             wait.hardWait(2);
              Reporter.pass ("Completed Verify MindTap Service Agreement Test");

	}

	public void verifySupportInformation(String title) {
	    	element("supportInf_link").click();
	        isElementDisplayed("support_header");
	        String text = element("support_header").getText();
	        Assert.assertTrue(text.contains(title), Reporter.failForAssert( "Failed Verify Support Information Test"));
	       	Reporter.pass( "Completed Verify Support Information Test");
           
	}

	public void clickEnterOnSplashPage() {
                isElementDisplayed("enter");
                element("enter").click();
		element("close_btn").click();
                
	}

	public void verifyCourseName() {
		isElementDisplayed("courseName");
		if(!element("courseName").getText().equalsIgnoreCase(data.readProperty("courseName"))){
			Reporter.fail("Splash Page is not displayed");
		}
	    Reporter.pass("Splash Page is displayed");
	}
	

}
