package com.qait.mindtap.keywords.NG_30104;

import java.awt.Color;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;

public class WeekWidgetActions extends GetPage{

	public WeekWidgetActions(WebDriver driver) {
		super(driver,"weekwidget");	}

	public void couresNameInBlueHeader() {
		Assert.assertTrue(element("courseBookTitle").getCssValue("background-color").toString().equals("rgba(2, 159, 214, 1)"), Reporter.failForAssert("color of coursename is not blue"));
	    Reporter.pass("color of course is blue");
	    
	}

	public void verifyRWV_TV_andJUMP_TO_WEEK_Buttons() {
		isElementDisplayed("btnTV");
		element("btnTV").click();
		elements("chapters");
		Reporter.pass("buton TV works fine");
		isElementDisplayed("btnRWV");
		element("btnRWV").click();
		verifyCurrentWeekIcon();
		Reporter.pass("button RWV works fine");
		functionalityExpandCollapse();
		isElementDisplayed("btnjumpToWeek");
	    element("btnjumpToWeek").click();
		Reporter.pass("button JUMP TO WEEK works fine");

	}

	public void verifyMonthDate() {
		isElementDisplayed("monthDate");
		String[] monthDate = element("monthDate").getText().split(" ");
		switch(monthDate[0].toLowerCase())
		{
		case "jan": Reporter.pass(monthDate[0]+" Month is displayed"); break  ;
		case "feb": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "mar": Reporter.pass(monthDate[0]+" Month is displayed"); break  ;
		case "apr": Reporter.pass(monthDate[0]+" Month is displayed"); break  ;
		case "may": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "jun": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "jul": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "aug": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "sep": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "oct": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "nov": Reporter.pass(monthDate[0]+" Month is displayed"); break ;
		case "dec": Reporter.pass(monthDate[0]+" Month is displayed"); break;
		default : Reporter.fail(monthDate[0]+" Month is not displayed");
		}
		int Date = Integer.parseInt(monthDate[1]);
		if(Date>0 && Date<32){
		Reporter.pass("along with date "+monthDate[1]);
		}
	}

	public void functionalityExpandCollapse() {
		isElementDisplayed("expand_collapse");
		element("expand_collapse").click();
		Assert.assertTrue(checkIfElementIsNotThere("Today"),Reporter.failForAssert("Expand/Collapse Functionality doesnot work properly"));
		Reporter.pass("Expand/Collapse Functionality work properly");
	}

	public void verifyCurrentWeekIcon() {
		isElementDisplayed("currentWeekIcon");
		Reporter.pass("Current Week icon is displayed");
	}

	public void verifyWeeks() {
		isElementDisplayed("textWeek");
		Assert.assertTrue(element("textWeek").getText().contains("WEEK"),Reporter.failForAssert("WEEK is not Displayed"));
		Reporter.pass("Week is Displayed along with count"+element("textWeek").getText());
	}

}
