///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.qait.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import com.qait.mindtap.automation.getpageobjects.*;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ayushgaur
 */
// TODO: Auto-generated Javadoc
/**
 * The Class LearningPathNavigator.
 * @author Mayank Gupta
 */
public class LearningPathNavigatorPageActions extends GetPage {

   // adminservice;
    
    /** The nbservice. */
    //def nbservice;
    
    /** The size after reorder. */
    int sizeAfterReorder;
    
    /** The size before reorder. */
    int sizeBeforeReorder;
    
    /** The get browser. */
    //String getBrowser = getProperty("browser");
    
    /** The assignmentactivity. */
    //AssignmentActivity assignmentactivity;
    
    /** The media activity. */
   // MediaActivityPage mediaActivity;
    
    /** The reading activity. */
    //ReadingActivity readingActivity;
     
    /**
     * Instantiates a new learning path navigator.
     *
     * @param driver the driver
     * @param testdata the testdata
     * @param service the service
     */
    public LearningPathNavigatorPageActions(WebDriver driver) {
        super(driver, "LearningPathNavigator");
        //this.driver = driver;
        //this.testdata = testdata;
        //this.adminservice = service[0];
        //this.nbservice = service [1];
        //assignmentactivity = new AssignmentActivity(driver, testdata, service);
        //mediaActivity = new MediaActivityPage(driver, testdata, service);
        //readingActivity=new ReadingActivity(driver, testdata, service);
    }
//    
//    /**
//     * Open.
//     */
//    void open() {
//        isElementDisplayed("lpn_icon");
//        //try{
//            wait.resetImplicitTimeout(5);
//          //  if(lpn_icon.getAttribute("class").contains("closed")){
//          //      lpn_icon.click()
//            }          
//        }
//        //catch(all){          
//      //  }
//   //     resetImplicitTimeout(AJAX_WAIT)
//    }
//
//    /*
//     * createLearningUnit Navigates to add distinct activity page
//     * action: Blocks the add icon and adds distinct unit
//    @param name refers to the title of learning unit     
//    @param description description of unit added
//     */
//
//        
//    /**
//     * Creates the learning unit.
//     *
//     * @param name the name
//     * @param description the description
//     * @return true, if successful
//     */
    public void  createLearningUnit(String name, String description){
        isElementDisplayed("add_link");
        if(configReader.getProperty("Browser").equalsIgnoreCase("firefox")){
          element("add_link").click();
        }
        else{
          clickOnElementUsingActionBuilder(element("add_link"));
        }   
        isElementDisplayed("menu");
        executeJavascript("document.getElementsByClassName('menu')[0].style.display = 'block';");
        clickOnElementUsingActionBuilder(element("addUnit"));
        isElementDisplayed("unitName");
        element("unitName").sendKeys(description);
        element("save_btn").click();
        wait.hardWait(2);
        List<WebElement> units_list = elements("lpn_name");
        for(WebElement unit: units_list){
            if(unit.getText().contains(name)){
                clickOnElementUsingActionBuilder(unit);
                break;
            }
        }
        Reporter.pass("Learning unit is created");
    }
// 
//    /**
//     * Creates the learning unit for reader mode.
//     *
//     * @param name the name
//     * @param description the description
//     * @return true, if successful
//     */
//    boolean createLearningUnitForReaderMode(String name, String description){
//        isElementDisplayed("addLinkReaderBook)
//        if(getBrowser == "firefox"){
//            addLinkReaderBook.click()
//        }
//        else{
//            clickOnElementUsingActionBuilder(addLinkReaderBook)
//        }
//        isElementDisplayed("By.className("lpn_readerHeading"))
//        driver.executeScript("document.getElementsByClassName('lpn_readerHeading')[0].getElementsByClassName('lpn_create')[0].getElementsByClassName('menu')[0].style.display='block';")
//        clickOnElementUsingActionBuilder(addUnit)       
//        isElementDisplayed("unitName)
//        unitName.sendKeys(description)  
//        selectOrder()
//        save_btn.click()        
//        waitToSync()        
//        for(WebElement unit: units_list){
//            if(unit.getText().contains(name)){
//                unit.click()
//                break
//            }
//        }
//        return true
//    }
//    
//    /**
//     *  selectLearningUnit navigate to learning activity.
//     *
//     * @param name refers to the learning unit
//     * @return true, if successful
//     */
//
//    boolean selectLearningUnit(String name){
//        waitToSync()
//        isElementDisplayed("By.xpath("//div[contains(@class,'lpn_unit')]//h3[@class='lpn_name' and contains(.,'${name}')]"))
//        driver.findElement(By.xpath("//div[contains(@class,'lpn_unit')]//h3[@class='lpn_name' and contains(.,'${name}')]")).click();
//        waitToSync()
//        WebElement activityLink = driver.findElement(By.xpath("//div[contains(@class,'lpn_activity')]//h3[@class='lpn_name' and contains(.,'${name}')]"))
//        return isElementDisplayed("activityLink)       
//    }
//
//    
//
//    /**
//     * Navigate to lpn.
//     */
//    void navigateToLPN(){
//        isElementDisplayed("By.className("navLink"))
//        clickOnElementUsingActionBuilder(lpnback_link)
//        isElementDisplayed("By.xpath("//img[@class='lpn_thumbImage']"))
//    }
//
//    /**
//     * Select frame.
//     */
//    void selectFrame() {
//        driver.switchTo().frame(addInlineActivityFrame.getAttribute("id"))
//    }
//
//    /**
//     * Rename learning path for admin.
//     *
//     * @param title the title
//     */
//    void renameLearningPathForAdmin(title){ 
//        driver.executeScript("document.getElementsByClassName('lpn_navigation')[0].childNodes[1].childNodes[5].childNodes[1].click()")
//        assert driver.findElement(By.className("mxui_layout_modal-overlay")).getAttribute("style").contains("block")
//        pathName_txtField.clear()
//        pathName_txtField.sendKeys title
//        save_btn.click()
//    }
//    void renameLearningPathForInstructor(title){ 
//        driver.executeScript("document.getElementsByClassName('lpn_navigation')[0].childNodes[1].childNodes[7].childNodes[1].click()")
//        assert driver.findElement(By.className("mxui_layout_modal-overlay")).getAttribute("style").contains("block")
//        pathName_txtField.clear()
//        pathName_txtField.sendKeys title
//        save_btn.click()
//    }
//    /**
//     * Navigate to learning unit and check assignment status.
//     *
//     * @param name the name
//     */
//    void navigateToLearningUnitAndCheckAssignmentStatus(String name){    /*TODO: Seems there is no CheckAssignmentStatus here. Right ?*/
//        waitToSync()
//        String selectLearningUnit = "//div[@class='lpn_thumbTitle' and contains(.,'${name}')]"
//        driver.findElement(By.xpath(selectLearningUnit)).click()
//        waitToSync()
//        waitToSync()
//    }
//
//    /**
//     * Reorder learning unit.
//     *
//     * @param title the title
//     */
//    void reorderLearningUnit(String title){
//        int firstPos=1
//        int secondPos=2
//        //reorderLunit(title,secondPos)   
//        editDistinctActivity(title)
//        isElementDisplayed("ddl_orderButton)
//        ddl_orderButton.click()
//        driver.findElement(By.xpath("//ul[@id='order-menu']/li[${secondPos}]")).click()
//        save_btn.click()
//        //sleep 5000        
//        //reorderLunit(title,firstPos)
//        editDistinctActivity(title)
//        //sleep 1000
//        isElementDisplayed("ddl_orderButton)
//        ddl_orderButton.click()
//        driver.findElement(By.xpath("//ul[@id='order-menu']/li[${firstPos}]")).click()
//        //waitToSync()
//        save_btn.click()        
//        //sleep 5000
//        waitToSync()
//    }
//       
//    //    void reorderLunit(String title,int pos){
//    //        int i = 0
//    //        while(nb_list[i]){
//    //            if(nb_list[i].getText().contains(title)){
//    //                String bookClassName = nb_list[i].getAttribute("class").toString()
//    //                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//    //                sleep 500
//    //                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].getElementsByTagName('img')[0].click();")
//    //                break
//    //            }
//    //            i++
//    //        }
//    //    } 
//    
//    //    void reorderLU(String title){
//    //        waitToSync()
//    //        List<WebElement> nb_list = driver.findElements(By.xpath("//li[contains(@class, 'item switchPath node lpn_node_')] | //li[contains(@class, 'item switchPath lpn_item_active node lpn_node_')]"))
//    //        int i = 0
//    //        while(nb_list[i]){
//    //            if(nb_list[i].getText().contains(title)){
//    //                String bookClassName = nb_list[i].getAttribute("class").toString()
//    //                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//    //                sleep 500
//    //                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].getElementsByTagName('img')[0].click();")
//    //                break
//    //            }
//    //            i++
//    //        }
//    //    }
//      
//    /**
//     * Edits the inst learning unit.
//     *
//     * @param name the name
//     */
//    void editInstLearningUnit(String name){     
//        editDistinctActivity(name)
//        isElementDisplayed("unitTitle)
//        unitTitle.click()
//        unitTitle.clear()
//        unitTitle.sendKeys("Chapter 16: Reconstruction: An Unfinished Revolution, 1865-1877")
//        sleep 1000
//        save_btn.click()
//        waitToSync()
//    }
//        
//    /**
//     * Perform click on new folder icon.
//     */
//    void performClickOnNewFolderIcon(){
//        clickOnElementUsingActionBuilder(add_link)
//        isElementDisplayed("By.className("menu"))
//        driver.executeScript("document.getElementsByClassName('menu')[0].style.display = 'block';")
//        isElementDisplayed("newFolder_link)
//        newFolder_link.click()
//    }
//    
//    /**
//     * Adds the new folder to master next book.
//     *
//     * @param testfolder the testfolder
//     * @return true, if successful
//     */
//    boolean addNewFolderToMasterNextBook(String testfolder){
//        boolean flag = false
//        performClickOnNewFolderIcon()
//        try{
//            isElementDisplayed("adminForm)
//        }
//        catch(all){}
//        if(adminForm.isDisplayed()){
//            folderTitle.sendKeys(testfolder)
//            isElementDisplayed("save_btn)
//            save_btn.click()
//            flag = true
//        }
//        else{
//            flag = false
//            takeScreenShotMethod("AdminForm is not visible")
//        }
//        return flag
//    }
//    
//    /*
//     * @param activity Name of the Assignable activity
//     * @return boolean true if 'Try Again or Continue' button is displayed
//     */
//    
//    /**
//     * Click assignable activity and check score details displayed.
//     *
//     * @param activity the activity
//     * @return true, if successful
//     */
//    boolean clickAssignableActivityAndCheckScoreDetailsDisplayed(String activity){  /*TODO: Discuss moving this to AssignmentActivity.*/
//        driver.findElement(By.xpath("//div[@class='lpn_thumbTitle' and contains(., '"+activity+"')]")).click()
//        assert waitForElementPresent(By.xpath("//*[@class='attempt_number' and contains(.,'Recorded score')]"))
//        return true
//    }
//    
//    /**
//     * Reorder folder.
//     *
//     * @param title the title
//     * @param position the position
//     * @return true, if successful
//     */
//    boolean reorderFolder(String title,String position){
//        int i = 0
//        while(nb_list[i]){
//            if(nb_list[i].getText().contains(title)){
//                String bookClassName = nb_list[i].getAttribute("class").toString()
//                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//                sleep 4000
//                if(getBrowser == "firefox"){
//                    driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'${title}')]/../..//img[@alt='Edit']")).click()
//                }
//                else {
//                    println("bookClassName = " + bookClassName)
//                    driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].childNodes[1].click();")
//                }  
//                isElementDisplayed("titleField)
//                selectMenu.click()
//                waitToSync() 
//                order_list(position)             
//                waitToSync()
//                isElementDisplayed("save_btn)
//                save_btn.click()
//                return true
//            }
//            i++
//        }
//        return false
//    }
//         
//    /**
//     * Order_list.
//     *
//     * @param position the position
//     */
//    void order_list(position){
//        for(WebElement order : order_list){
//            if(order.getText().contains(position))
//            { 
//                order.click()
//                waitToSync()
//                break;
//            } 
//        }
//    }
//
//    /**
//     * Expand folder.
//     *
//     * @param title the title
//     */
//    void expandFolder(title){
//        waitToSync()
//        if(getBrowser == "firefox"){
//            driver.findElement(By.xpath("//div[contains(@class,'lpn_thumbTitle') and contains(.,'${title}')]")).click()
//        }
//        else {
//            clickOnElementUsingActionBuilder(driver.findElement(By.xpath("//div[contains(@class,'lpn_thumbTitle') and contains(.,'${title}')]")))
//        }         
//    }
//    
//    /**
//     * Close.
//     */
//    void close() {  /*TODO: How is this different from closeActivity ? Add comments.*/
//        isElementDisplayed("lpn_icon)
//        lpn_icon.click()
//        sleep 500
//    }
//
//    /**
//     * Close activity.
//     */
//    void closeActivity(){
//        waitToSync()
//        waitToSync()
//        deselectFrame()
//        if(getBrowser == "firefox"){
//            //To avoid stale element exception
//            driver.findElement(By.xpath("//div[@class='nb_activityBar']/../..[contains(@style,'block')]//a[@class='closeActivity']")).click()
//        }
//        else {
//            clickOnElementUsingActionBuilder(driver.findElement(By.xpath("//div[@class='nb_activityBar']/parent::*/parent::*[contains(@style,'block')]//a[@class='closeActivity']")))
//        }  
//        
//    }
//    
//    /**
//     * Verify presence of distinct activity.
//     *
//     * @param title the title
//     * @return true, if successful
//     */
//    boolean verifyPresenceOfDistinctActivity(String title){ /*TODO: Discuss moving this to AssignmentActivity.*/
//        waitToSync()
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//div[@class='lpn_thumbTitle']/h3"))
//        for(WebElement unit: nb_list){
//            String unitName=unit.getText()
//            if(unitName.contains(title)){
//                return true
//            }
//        }
//        return false
//    }
//
//    /**
//     * Check assignable activity submission status.
//     *
//     * @param title the title
//     * @param submissionState the submission state
//     * @return true, if successful
//     */
//    boolean checkAssignableActivitySubmissionStatus(String title, submissionState){  /*TODO: Discuss moving this to AssignmentActivity.*/
//        int i = 0
//        while(nb_list[i]){
//            if(nb_list[i].getText().contains(title) && nb_list[i].getText().contains(submissionState)){
//                return true
//            }
//            i++
//        }
//        return false
//    }
//    
//    /**
//     * Verify presence of inline activity.
//     *
//     * @param title the title
//     * @return true, if successful
//     */
//    boolean verifyPresenceOfInlineActivity(String title){
//        switchToMainIFrame()
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//div[contains(@class,'nb_thumbTitle')]"))
//        for(WebElement unit: nb_list){
//            String unitName=unit.getText()
//            if(unitName.contains(title)){
//                return true
//            }
//        }
//        return false
//    }
//
//    /**
//     * Validate cancel button on flash activity screen.
//     *
//     * @return true, if successful
//     */
//    boolean validateCancelButtonOnFlashActivityScreen(){
//        editOption_btn.click()
//        driver.switchTo().frame(editFrame)
//        boolean flag = true
//
//        List<WebElement> editButtonList = driver.findElements(By.xpath("//div[@id='addactivitydiv']//div[contains(@class,'buttons')]//input"))
//
//        for(WebElement button: editButtonList){
//            if(button.getAttribute("value").contains("Cancel"))
//            flag = false
//        }
//        flashCardsActivityContinue_btn.click()
//        deselectFrame()
//        //to navigate to lpn back
//        driver.findElement(By.xpath("//div[@class='buttons']/a[contains(@class,'cancel')]")).click();
//        return flag
//    }
//
//    /**
//     * Verify lp ndisplays.
//     *
//     * @param unit the unit
//     * @return true, if successful
//     */
//    boolean verifyLPNdisplays(unit){
//        waitToSync()
//        waitToSync()
//        String selectLearningUnit = "//h3[contains(@class,'lpn_name') and contains(.,'${unit}')]"
//        try{
//            driver.findElement(By.xpath(selectLearningUnit))
//            return true
//        }
//        catch(all){
//            return false
//        }
//    }
//
//    /**
//     * Verify activity present after reorder.
//     *
//     * @param title the title
//     * @return true, if successful
//     */
//    boolean verifyActivityPresentAfterReorder(title){
//        waitForElementToBeNotDisplayed(By.id("order-menu"))
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//div[contains(@class,'lpn_thumbTitle') and contains(.,'${title}')]/parent::*//div[@class='expandable']/ul/li"))
//        sizeAfterReorder = nb_list.size()
//        if(sizeAfterReorder == sizeBeforeReorder){
//            return true
//        }
//        else {
//            return false
//        }
//    }
//
//    /**
//     * Verify activity present before reorder.
//     *
//     * @param title the title
//     * @return true, if successful
//     */
//    boolean verifyActivityPresentBeforeReorder(title){
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//div[contains(@class,'lpn_thumbTitle') and contains(.,'${title}')]/..//div[@class='expandable']/ul/li"))
//        sizeBeforeReorder = nb_list.size()
//    }
//    
//    /**
//     * Verify working copy activities.
//     *
//     * @param assignableActivity the assignable activity
//     * @param videoActivity the video activity
//     */
//    void verifyWorkingCopyActivities(assignableActivity, videoActivity){
//        String errMsg = "Msg: "
//        boolean videoAct = verifyActivity(videoActivity)
//
//        if(videoAct == false){
//            errMsg = errMsg + " ** Media Activity Not Present ** "
//        }
//        
//        Assert.assertTrue(videoAct, errMsg)
//    }
//
//    /**
//     * Verify activity.
//     *
//     * @param title the title
//     * @return true, if successful
//     */
//    boolean verifyActivity(String title){
//        int i = 0, count = 0
//        while(nb_list[i]){
//            if(nb_list[i].getText().contains(title)){
//                println " " + title + "Present"
//                count++
//            }
//            i++
//        }
//        if(count>0){
//            return true
//        }
//        else{
//            return false
//        }
//    }
//
//
//    /**
//     * Validate activity deleted from master.
//     *
//     * @return true, if successful
//     */
//    boolean validateActivityDeletedFromMaster(){
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//li[contains(@class, 'item switchPath node lpn_node_')]"))
//        int i = 0
//        while(nb_list[i]){
//            if(nb_list[i].getText().contains("Activity")){
//                return false
//            }
//            i++
//        }
//        return true
//    }
//
//    /**
//     * Verify add button is present.
//     */
//    void verifyAddButtonIsPresent(){
//        try{
//            resetImplicitTimeout(7)
//            Assert.assertFalse(driver.findElement(By.cssSelector(".navLink.menu_trigger.pseudofocus.active-lpn")).isDisplayed())
//            resetImplicitTimeout(AJAX_WAIT)
//        }
//        catch(all){
//            resetImplicitTimeout(AJAX_WAIT)
//        }
//    }
//
//   
//    /**
//     * Verify edit button is present.
//     */
//    void verifyEditButtonIsPresent(){
//        int i = 0
//        while(nbActivity_list[i]){
//            String bookClassName = nbActivity_list[i].getAttribute("class").toString()
//            try{
//                resetImplicitTimeout(7)
//                driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//                Assert.assertFalse(driver.findElement(By.cssSelector(".clui-button.clui-edit")).isDisplayed())
//            }
//            catch(all){
//                break;
//            }
//        }
//        i++
//    }
//
//    /**
//     * Verify delete button is present.
//     */
//    void verifyDeleteButtonIsPresent(){
//        int i = 0
//        while(nbActivity_list[i]){
//            String bookClassName = nbActivity_list[i].getAttribute("class").toString()
//            driver.executeScript("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//            try{
//                resetImplicitTimeout(7)
//                Assert.assertFalse(driver.findElement(By.cssSelector(".clui-button.clui-delete")).isDisplayed())
//            }
//            catch(all){
//                break;
//            }
//        }
//        i++
//    }
//
//    /**
//     * Verify edit inline button is present.
//     */
//    void verifyEditInlineButtonIsPresent(){
//        isElementDisplayed("By.xpath("//iframe[contains(@id,'_NB_Main_IFrame')]"))
//        driver.switchTo().frame(frameName)
//        try{
//            resetImplicitTimeout(7)
//            Assert.assertFalse(driver.findElement(By.cssSelector(".editDoc.pseudofocus.active-pageToolBar")).isDisplayed())
//            resetImplicitTimeout(AJAX_WAIT)
//        }
//        catch(all){
//            resetImplicitTimeout(AJAX_WAIT)
//        }
//        deselectFrame()
//    }
//
//    /**
//     * Verify view attempt button displayed.
//     *
//     * @return true, if successful
//     */
//    boolean verifyViewAttemptButtonDisplayed(){ /*TODO: Discuss moving this to AssignmentActivity.*/
//        return verifyElementIsDisplayed(viewAttempt_btn)
//    }
//
//    /**
//     * Verify view attempt button not displayed.
//     *
//     * @return true, if successful
//     */
//    boolean verifyViewAttemptButtonNotDisplayed(){ /*TODO: Discuss moving this to AssignmentActivity.*/
//        switchToMainIFrame()
//        String button=driver.findElement(By.xpath("//a[@class='inline_button']")).getText()
//        return verifyTextEqualsIgnoreCase(button,"View")
//    }
//    
//    /**
//     * Click on lpn launcher.
//     */
//    void clickOnLPNLauncher() {
//        waitToSync()
//        isElementDisplayed("lpn_icon)
//        try{
//            resetImplicitTimeout(5)
//            if(lpn_icon.getAttribute("class").contains("closed")){
//                lpn_icon.click()
//            }          
//        }
//        catch(all){          
//        }
//        resetImplicitTimeout(AJAX_WAIT)
//        sleep 1000
//    }
//    
//    /**
//     * Edits the description of distinct activity.
//     *
//     * @param description the description
//     */
//    void editDescriptionOfDistinctActivity(description){
//        waitToSync()
//        description_inputField.click()
//        description_inputField.clear()
//        description_inputField.sendKeys(description)  
//    }
//    
//    /**
//     * Save distinct activity.
//     */
//    void saveDistinctActivity(){
//        save_btn.click()
//        waitToSync()
//    }
//    
//    ///////////////////////////////////////////////////////////
//    
//    /**
//     * Click on add distinct activity icon and select activity.
//     *
//     * @param activity the activity
//     */
//    void clickOnAddDistinctActivityIconAndSelectActivity(String activity){
//        isElementDisplayed("add_link)
//        performClickOnAddActivityIcon()
//        selectActivityToAdd(activity)
//    }
//    
//    /**
//     * Input distinct activity title and description.
//     *
//     * @param title the title
//     * @param description the description
//     */
//    void inputDistinctActivityTitleAndDescription(String title,String description){
//        try{
//            waitToSync()
//            waitToSync()
//            isElementDisplayed("title_inputField)
//            title_inputField.click()
//            title_inputField.clear()
//            title_inputField.sendKeys title
//            description_inputField.clear()
//            description_inputField.sendKeys(description)
//        }catch(all){
//            //To avoid stale element exception
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).click()
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).clear()
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).sendKeys title
//        } 
//        selectOrder()
//        isElementDisplayed("save_btn)
//        save_btn.click()
//        waitToSync()
//        closeAnnouncement()
//        waitToSync()
//        isElementDisplayed("driver.findElement(By.xpath("//div[contains(@class,'lpn_activity')]//h3[@class='lpn_name' and contains(.,'"+title+"')]")))
//    }
//    
//    void inputTitleAndDescription(String title,String description){
//        try{
//            waitToSync()
//            waitToSync()
//            isElementDisplayed("title_inputField)
//            title_inputField.click()
//            title_inputField.clear()
//            title_inputField.sendKeys title
//            description_inputField.clear()
//            description_inputField.sendKeys(description)
//        }catch(all){
//            //To avoid stale element exception
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).click()
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).clear()
//            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).sendKeys title
//        } 
//        isElementDisplayed("save_btn)
//        save_btn.click()
//        waitToSync()
//        waitToSync()
//    }
//    
//    /**
//     * Edits the distinct activity.
//     *
//     * @param title the title
//     */
//    void editDistinctActivity(String title){
//        waitToSync()
//        String bookClassName = driver.findElement (By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*")).getAttribute ("class").toString ()
//        driver.executeScript ("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//        waitToSync()
//        driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*//a[@title='Edit']")).click ()
//        waitToSync()
//    }
//    
//    /**
//     * Delete distinct activity.
//     *
//     * @param title the title
//     */
//    void deleteDistinctActivity(String title){
//        waitToSync()
//        List<WebElement> nb_list = driver.findElements(By.xpath("//div[@id='lpn_workspace' and contains(@style,'block')]//div[contains(@class,'lpn_node lpn_activity')]//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]")) 
//        int len=nb_list.size()
//        while(len){
//            isElementDisplayed("By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*"))
//            waitToSync()    
//            String bookClassName = driver.findElement (By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*")).getAttribute ("class").toString ()
//            driver.executeScript ("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//            isElementDisplayed("By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]/parent::*/parent::*/parent::*//a[@title='Delete']"))
//            driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]/parent::*/parent::*/parent::*//a[@title='Delete']")).click()
//            waitForAlert()
//            acceptAlertWindow()
//            len--
//        }
//    }
//    
//    /**
//     * Launch distinct activity.
//     *
//     * @param title the title
//     */
//    void launchDistinctActivity(String title){
//         WebElement activity
//        waitForElementToAppear(By.xpath("//a[contains(.,'" + title + "')]"),15)
//        waitToSync()
//        
//        waitToSync()
//        activity = driver.findElement (By.xpath ("//a[contains(.,'" + title + "')]"))
//        activity.click()
//        waitToSync()
//        waitToSync()
//    }
//        
//    /**
//     * Click on lpn launcher icon.
//     */
//    void clickOnLPNLauncherIcon(){
//        isElementDisplayed("lpn_icon)
//        lpn_icon.click()
//    }
//    
//    /**
//     * Click on lpn back icon.
//     */
//    void clickOnLPNBackIcon(){
//        isElementDisplayed("lpnback_link)
//        clickOnElementUsingActionBuilder(lpnback_link)
//    }
//    
//    /**
//     * Verify bookmark displayed.
//     */
//    void verifyBookmarkDisplayed(){
//        Assert.assertTrue(verifyBookmark("Effective"),"BookMark Not Displayed")
//    }
//    
//    /**
//     * Verify bookmark.
//     *
//     * @param name the name
//     * @return true, if successful
//     */
//    boolean verifyBookmark(String name){
//        try{
//            resetImplicitTimeout(5)
//            driver.findElement(By.xpath("//h3[contains(.,'"+name+"')]/../div[contains(@class,'lpn_bookmark')]"))
//            resetImplicitTimeout(AJAX_WAIT)
//            return true
//        }catch(all){
//            resetImplicitTimeout(AJAX_WAIT)
//            return false
//        }
//    }
//    
//    /**
//     * Click on add link and add unit.
//     */
//    void clickOnAddLinkAndAddUnit(){
//        isElementDisplayed("add_link)
//        if(getBrowser == "firefox"){
//            add_link.click()
//        }
//        else{
//            clickOnElementUsingActionBuilder(add_link)
//        }   
//        isElementDisplayed("By.className("menu"))
//        driver.executeScript("document.getElementsByClassName('menu')[0].style.display = 'block';")
//        //addUnit.click()
//        //clickOnElementUsingActionBuilder(addUnit)
//        driver.executeScript("document.getElementsByClassName('menu')[0].childNodes[3].childNodes[0].click()")
//    }
//    
//    /**
//     * Input name of custom unit.
//     *
//     * @param name the name
//     */
//    void inputNameOfCustomUnit(name){
//        isElementDisplayed("unitName)
//        unitName.click()
//        unitName.clear()
//        unitName.sendKeys(name)   
//    }
//        
//    /**
//     * Input description of custom unit.
//     *
//     * @param description the description
//     */
//    void inputDescriptionOfCustomUnit(description){
//        isElementDisplayed("description_textField)
//        description_textField.sendKeys(description)  
//        selectOrder()
//        isElementDisplayed("save_btn)
//        save_btn.click()
//        isElementDisplayed("driver.findElement(By.xpath("//span[@class='lpn_description' and contains(.,'"+ description +"')]")))
//    
//    }
//    
//    /**
//     * Click on edit icon for custom unit.
//     *
//     * @param name the name
//     */
//    void clickOnEditIconForCustomUnit(name){
//        waitToSync()
//        String bookClassName = driver.findElement (By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + name + "')]/parent::*/parent::*/parent::*")).getAttribute ("class").toString ()
//        driver.executeScript ("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//        waitToSync()
//        driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'" + name + "')]/parent::*/parent::*/parent::*//a[@title='Edit']")).click ()
//        waitToSync()
//    }
//    
//    /**
//     * Edits the name and description of custom unit.
//     *
//     * @param editedName the edited name
//     * @param editedDescription the edited description
//     */
//    void editNameAndDescriptionOfCustomUnit(editedName, editedDescription){     
//        isElementDisplayed("unitTitle)
//        unitTitle.click()
//        unitTitle.clear()
//        unitTitle.sendKeys(editedName)
//        description_textField.click()
//        description_textField.clear()
//        description_textField.sendKeys(editedDescription)
//        sleep 1000
//        save_btn.click()
//        waitToSync()
//    }
//    
//       
//    /**
//     * Delete custom unit.
//     *
//     * @param name the name
//     */
//    void deleteCustomUnit(name){
//        isElementDisplayed("By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + name + "')]/parent::*/parent::*/parent::*"))
//        waitToSync()
//        String bookClassName = driver.findElement (By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + name + "')]/parent::*/parent::*/parent::*")).getAttribute ("class").toString ()
//        driver.executeScript ("document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';")
//        isElementDisplayed("By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+name+"')]/parent::*/parent::*/parent::*//a[@title='Delete']"))
//        driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+name+"')]/parent::*/parent::*/parent::*//a[@title='Delete']")).click()
//        waitForAlert()
//        acceptAlertWindow()
//    }
//    
//     
//    /** 
//     *Verify Due Date Status of All Activities
//     *
//     * @param 
//     */  
//    boolean verifyDueDateStatus(String title){
//        WebElement status1 = driver.findElement(By.xpath("//div[contains(.,'"+title+"')]//img[@title='Overdue' or contains(@title,'Due Soon')]"))
//        WebElement status2 = driver.findElement(By.xpath("//div[contains(.,'"+title+"')]//div[(contains(@class,'overdue')) or (contains(@class,'duesoon'))]"))
//        boolean flag =  verifyElementIsDisplayed(status1) && verifyElementIsDisplayed(status2)
//        return flag
//    }
//    
//    void  clickOnAddLinkAndAddFolder(){
//        performClickOnAddFolder()
//        
//    }
//    
//    void inputFolderInformationAndSave(title){
//        waitToSync()
//        pathName_txtField.clear()
//        pathName_txtField.sendKeys title
//        selectOrder()
//        save_btn.click()
//    }
//    
//    boolean verifyScoringStrategyOfActivity(String title){
//        boolean flag = false
//        List<WebElement> dialog = driver.findElements(By.xpath("//div[contains(.,'"+title+"')]/div[@class='lpn_thumbTitle']/ul[@class='lpn_submissionInfo']/li"))
//        for(WebElement textbox:dialog){
//            String testline = textbox.getText()
//            if((testline.contains("Score"))||(testline.contains("strategy"))){
//                flag = true
//                return flag
//            }
//        }
//        return flag
//        
//    }
//    
//    void cancelAddActivity() {
//        waitToSync()
//        isElementDisplayed("cancelAddActivity)
//        clickOnElement(cancelAddActivity)
//        waitToSync()
//    }
//    void closeAddActivityList() {
//        waitToSync()
//        isElementDisplayed("cancelbtnId)
//        clickOnElement(cancelbtnId)
//        waitToSync()
//    }
//    
////    void addDistinctLearningLabActivity(String title, String description){
////        waitToSync()
////        WebElement select =driver.findElement(By.xpath("(//div[@class='button']/input[contains(@class,'selectButton')])[1]"))
////        isElementDisplayed("select)
////        select.click()
////        //       //clean text and add
////        isElementDisplayed("activityNametitle)
////        activityNametitle.click()
////        activityNametitle.clear()
////        activityNametitle.sendKeys(title)
////        
////        isElementDisplayed("discription)
////        discription.click()
////        discription.clear()
////        discription.sendKeys(description) 
////        
////        isElementDisplayed("create)
////        create.click()
////        waitToSync()
////        deselectFrame()
////        waitToSync()
////        selectOrder()
////        save_btn.click()   
////        waitToSync()
////    }
////   
//    void addDistinctLearningLabActivity(String title, String description){
//        waitToSync()
//        WebElement select =driver.findElement(By.xpath("(//div[@class='button']/input[contains(@class,'selectButton')])[1]"))
//        isElementDisplayed("select)
//        select.click()
//        //       //clean text and add
//        isElementDisplayed("activityNametitle)
//        activityNametitle.click()
//        activityNametitle.clear()
//        activityNametitle.sendKeys(title)
//        
//        isElementDisplayed("discription)
//        discription.click()
//        discription.clear()
//        discription.sendKeys(description) 
//        
//        isElementDisplayed("create)
//        create.click()
//        waitToSync()
//        deselectFrame()
//        waitToSync()
//        selectOrder()
//        save_btn.click()   
//        waitToSync()
//    }
//   
//    void addDistinctLearningLabActivity(String title, String description){
//        waitToSync()
//        WebElement select =driver.findElement(By.xpath("(//div[@class='button']/input[contains(@class,'selectButton')])[1]"))
//        isElementDisplayed("select)
//        select.click()
//        //       //clean text and add
//        isElementDisplayed("activityNametitle)
//        activityNametitle.click()
//        activityNametitle.clear()
//        activityNametitle.sendKeys(title)
//        
//        isElementDisplayed("discription)
//        discription.click()
//        discription.clear()
//        discription.sendKeys(description) 
//        
//        isElementDisplayed("create)
//        create.click()
//        waitToSync()
//        deselectFrame()
//        waitToSync()
//        selectOrder()
//        save_btn.click()   
//        waitToSync()
    }
//   
//}
//
//    
