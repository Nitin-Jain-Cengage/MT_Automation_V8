package com.qait.mindtap.keywords;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import java.util.List;
import org.openqa.selenium.WebElement;


public class WeekWidgetActions extends GetPage{

	public WeekWidgetActions(WebDriver driver) {
		super(driver,"weekwidget");	}

	public void couresNameInBlueHeader() {
            Assert.assertTrue(element("courseBookTitle").getCssValue("background-color").toString().equals("rgba(47, 156, 212, 1)"), Reporter.failForAssert("color of coursename is not blue"));
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
		Assert.assertTrue(checkIfElementIsNotThere("Today"),Reporter.failForAssert("Expand/Collapse Functionality does not work properly"));
		Reporter.pass("Expand/Collapse Functionality work properly");
	}

	public void verifyCurrentWeekIcon() {
                waitTOSync();
                while(checkIfElementIsNotThere("currentWeekIcon")){
                    refreshPage();
                }
                isElementDisplayed("currentWeekIcon");
                Reporter.pass("Current Week icon is displayed");
	}

	public void verifyWeeks() {
		isElementDisplayed("textWeek");
		Assert.assertTrue(element("textWeek").getText().contains("WEEK"),Reporter.failForAssert("WEEK is not Displayed"));
		Reporter.pass("Week is Displayed along with count"+element("textWeek").getText());
	}

        public void verifyInstructorExpandsWeek(){
                isElementDisplayed("expand_collapse");
		element("expand_collapse").click();
                element("expand_collapse").click();
                isElementDisplayed("addToWeek");
                Reporter.pass("Instructor is able to expand week");
        }        
        
        public void instructorClickOnAddToWeek(){
            element("addToWeek").click();
         }
        public void instructorSelectsDay(){
          String day = date.getDayCurentDay();
          element("dayToAdd",day).click();
        }

    public void instructorSelectsOfflineActivity() {
        isElementDisplayed("offlineActivity");
        element("offlineActivity").click();   
    }

    public void verifyAssignment() {
        Assert.assertTrue(isElementDisplayed("offlineAssignment"),Reporter.failForAssert("Assignment is not added or displayed"));
        Reporter.pass("Assignment is displayed");
    }

    public void verifyScore() {
        Assert.assertTrue(isElementDisplayed("offline_assignmentScore"),Reporter.failForAssert("Assignment Score is not added or displayed"));
        Reporter.pass("Assignment Score is displayed");
        if(element("offline_assignmentScore").getText().contains(data.readProperty("offline_assignmentScore"))){
            Reporter.pass("Correct Score is displayed"+element("offline_assignmentScore").getText());
        }
        else{
            Reporter.fail("Correct Score is displayed");
        }

    }

    public void verifyTitle() {
        Assert.assertTrue(isElementDisplayed("offline_assignmentTitle"),Reporter.failForAssert("Assignment is not added or displayed"));
        Reporter.pass("Assignment is not added or displayed");
         if(element("offline_assignmentTitle").getText().contains(data.readProperty("offline_assignmentTitle"))){
            Reporter.pass("Correct Title is displayed");
        }
         else{
             Reporter.fail("Correct Title is displayed");
         }

    }

    public void verifyDescription() {
        Assert.assertTrue(checkIfElementIsNotThere("assignmentDescription",data.readProperty("offline_assignmentDescription")),Reporter.failForAssert("Assignment is not added or displayed"));
       }
    public void verifyAssignmentNotAdded() {
        Assert.assertFalse(isElementDisplayed("offlineAssignment"),Reporter.failForAssert("Assignment is not added or displayed"));
        Reporter.fail("Assignment is displayed");
    }

    public void verifyScoreNotShown() {
        Assert.assertFalse(isElementDisplayed("offline_assignmentScore"),Reporter.failForAssert("Assignment Score is displayed"));
        Reporter.pass("Assignment Score is not added or displayed");
        if(element("offline_assignmentScore").getText().contains(data.readProperty("offline_assignmentScore"))){
            Reporter.fail("Correct Score is displayed");
        }
        else{
            Reporter.pass("Correct Score is displayed");
        }

    }

    public void verifyTitleNotShown() {
        Assert.assertFalse(isElementDisplayed("offline_assignmentTitle"),Reporter.failForAssert("Assignment is displayed"));
        Reporter.pass("Assignment is not added or displayed");
         if(element("offline_assignmentTitle").getText().contains(data.readProperty("offline_assignmentTitle"))){
            Reporter.fail("Correct Title is displayed");
        }
         else{
             Reporter.pass("Correct Title is not displayed");
         }

    }

    public void verifyDescriptionNotShown() {
         if(checkIfElementIsNotThere("assignmentDescription","It is an offline assignment for cancel"+date.getCurrentDateTime())){
             Reporter.pass("Assignment is not added or displayed");
                 }

    }

    public void instructorSelectsTopic(String InstructorTopic) {
    List<WebElement> Topics = elements("");
    for(WebElement topic:Topics){
        String topicname=topic.getText();
        if(topicname.contains(InstructorTopic)){
            topic.click();
           }
         }
    }
}
