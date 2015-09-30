package com.qait.mindtap.keywords.NG_30104;

import java.util.List;





import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.TakeScreenshot;

public class AdminPerformActionPage extends GetPage{

    String OrgURL = configReader.getProperty("environment") + "/static/nb/ui/admin/orgs/orgs.html" ;
    String MasterURL = configReader.getProperty("environment") + "/static/nb/ui/admin/masters/masters.html";
    int AJAX_WAIT = 30;
    TakeScreenshot takescreenshot;
	
	
	public AdminPerformActionPage(WebDriver driver) {
       super(driver, "AdminPerformActionPage");
	}

	public void verify_User_LoggedIn() {
		 Reporter.log ("Completed LoginAsAdmin");
		 verifyPageTitleContains(yml.getData("neXtBooks.neXtBook1.pageTitle"));
	     isElementDisplayed("logo");
	     isElementDisplayed("loggedID");
	     Reporter.log ("Completed verifyPageTitle");
	}

	public void createMasterNeXtBookInCourseMode() {
		
	}

	public void openMaster() {
		getURL("MasterURL");       
        isElementDisplayed("masters_link");
        element("masters_link").getAttribute("class").contains("active");
        Reporter.log ("Completed Admin Creates Master NeXtBook In Course Mode");
        
	}

	public void clickCreateMaster() {
		// TODO Auto-generated method stub
		
	}

	public void enterMasterNameAndDescription(String data, String data2,
			String data3) {
		// TODO Auto-generated method stub
		
	}

	public void enterCoreTextISBN(String data) {
		// TODO Auto-generated method stub
		
	}

	public void createUnpublishedMaster(String data) {
		// TODO Auto-generated method stub
		
	}

	public void searchBookOnMastersPage(String searchTerm) {
		isElementDisplayed("masterBookList|");
        //To avoid stale element exception
		element("masterBookList");
        element("neXtBookSearch_inputBox").click();
        element("neXtBookSearchInputBoxActivated_txtField").click();  
        isElementDisplayed("neXtBookSearchInputBoxActivated_txtField");
        element("neXtBookSearchInputBoxActivated_txtField").clear();
        element("neXtBookSearchInputBoxActivated_txtField").sendKeys( searchTerm);
        wait.hardWait(2);
        isElementDisplayed("notPublished_btn");
        element("notPublished_btn").click();
        wait.hardWait(2);
        try{
            wait.resetImplicitTimeout(2);
            waitForSpinnerToDisappear();    
            wait.resetImplicitTimeout(AJAX_WAIT);
        }
        catch(NoSuchElementException e){
         e.printStackTrace();
        }
		
	}

	public void clickOnModeValueIcon(String data) {
			        element("modeValue").click();
			        wait.hardWait(2);
			        isElementDisplayed("modeValue");
			 		
	}

	public void clickBookModifyOption(String title, String option) {
		 int optionNumber = 0;
		 int optionsCount = 4;
			        int i = 0;
			        switch (option){
			        case "Refresh": case "refresh":
			            optionNumber = 0;
			            option = "Refresh";
			            break;
			        case "Publish":case "publish":
			            optionNumber = 1;
			            option = "Publish Master";
			            break;
			        case "Edit":case "edit":
			            optionNumber = 2;
			            option = "Edit";
			            break;
			        case "Delete":case "delete":
			            optionNumber = 3;
			            option = "Delete";
			            break;
			        case "Provision Apps":case "provision apps":
			            optionNumber = 4;
			            option = "Provision Apps";
			            break;
			        default:  
			            optionNumber = 0;
			        }
			        isElementDisplayed("admin_models_master");
			        List<WebElement> nblist = elements("admin_models_master");
			        List<WebElement> nbNameList = elements("admin_models_master");    
			        while(nblist.get(i)!=null) {
			        if(nbNameList.get(i).getText().equals(title)) {
			                isElementDisplayed(("options"));
			                String bookClassName = nblist.get(i).getAttribute("class").toString();
			                List<WebElement> optionlist = elements("options");
			                for (int optionCount = 0; optionCount <= optionsCount; optionCount++){
			                    if ( optionCount != optionNumber){
			                    	executeJavascript("document.getElementsByClassName('${bookClassName}')[0].getElementsByTagName('a')[${optionCount}].style.display = 'none';");
			                        }    else{
			                        executeJavascript("document.getElementsByClassName('${bookClassName}')[0].getElementsByTagName('a')[${optionCount}].style.display = 'block';");
			                    }
			                }
			                for (WebElement option1:optionlist){
			                    try{
			                        if (option1.isDisplayed() && option1.getAttribute("alt").equals(option)){
			                            element("option1").click();
			                            break;
			                        }
			                   
			                    }
			                    catch(NoSuchElementException e){
			                    	e.printStackTrace();
			                    }
			                }
			                if (option.equals("Delete")){
			                    handleAlert();
			                    }
			                break;
			            }
			            i++;
			        }
		
	}

	public void refreshMasterNextBook(String data) {
		// TODO Auto-generated method stub
        Reporter.log ("Completed Admin Refresh Master NeXtBook");

	}

	public void openOrg() {
		getURL(OrgURL);
		isElementDisplayed("orgs_link");
		element("orgs_link").getAttribute("class").contains("active");
		
				
	}

	public void verifyBookPresent(String data) {

		
	}

	public void verifyLearningUnitsPresentInMasterNeXtBook(String classTitle) {
				 boolean flag = false;        
			     Assert.assertTrue( verifyLearningUnitsPresent(),Reporter.failForAssert("Learning Units are not present in master nextbook"));       
			     refreshPage();
			            //To avoid stale element exception
			     isElementDisplayed("logoBox");
			     Assert.assertTrue(verifyLearningUnitsPresent(),Reporter.failForAssert("Learning Units are not present in master nextbook"));
			     takescreenshot.takeScreenshot();
		     	}

	private boolean verifyLearningUnitsPresent() {
		 try{
	            wait.resetImplicitTimeout(10);
	            //To avoid stale element exception
	           element("thumbtitle");
	           Assert.assertTrue(isElementDisplayed("thumbtitle"),"Stale Element on Learning Units In MasterNextBook");
	            wait.resetImplicitTimeout(AJAX_WAIT);
	            return true;
	        } 
	        catch(NoSuchElementException e){
	            wait.resetImplicitTimeout(AJAX_WAIT);
	            return false;
	        }	
	}

	
	
}
