/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords.NG_30104;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 *
 * @author ayushgaur
 */
public class FlashCardApp extends GetPage{
    /** The window handle. */
    public String windowHandle;
    
    /** The current chapter. */
    public String currentChapter;
    
    /** The card count before hide. */
    public String cardCountBeforeHide;
    
    /** The card count before restore. */
    public String cardCountBeforeRestore;

    public FlashCardApp(WebDriver driver, String pageName) {
        super(driver, "FlashCardAppPage");
    }
    
    /**
     * Instantiates a new flash card app page.
     *
     * @param driver the driver
     * @param testdata the testdata
     */
      
      /**
     * Click on flash card app.
     */
    void clickOnFlashCardApp(){
        isElementDisplayed("flashApp_btn");
        element("flashApp_btn").click();
        wait.hardWait(2);
    }
        
    /**
     * Click on drop down list to select chapter.
     */
    void clickOnDropDownListToSelectChapter(){
        switchToDefaultContent();
        switchToFrame(element("dockFrame"));
        waitForElementPresent("select_chapter");
        element("chaptermenu_ddl").click();//To avoid stale element exception
        
       element("selectChapterMenu-1").click();
        wait.hardWait(1);
        currentChapter=element("chapter_link").getText();
        System.out.println("currentChapter = "+currentChapter);
        wait.hardWait(2);
        element("chaptermenu_ddl").click();
        wait.hardWait(.5); 
        //To avoid stale element exception
        element("selectChapterMenu-4").click();
        wait.hardWait(2);    }
    
    /**
     * Select definition option from setting.
     *
     * @return true, if successful
     */
    void  selectDefinitionOptionFromSetting(){
        isElementDisplayed("settings_img");
        element("settings_img").click();
        isElementDisplayed("definitionOption");
        element("definitionOption").click();
        wait.hardWait(2);
        isElementDisplayed("settingWindow");
        
    }
    
    /**
     * Select key term option from setting.
     *
     * @return true, if successful
     */
    void selectKeyTermOptionFromSetting(){
        isElementDisplayed("settings_img");
        element("settings_img").click();
        isElementDisplayed("keyTermOption");
        element("keyTermOption").click();
        wait.hardWait(2);
    }
    
    /**
     * Click on hide card option.
     */
    void clickOnHideCardOption(){
        wait.hardWait(2);
        cardCountBeforeHide = element("currentFlashCard_text").getText();
        isElementDisplayed("hideCard");
        element("hideCard").click();
        wait.hardWait(2);
    }
    
    /**
     * Click on restore card option.
     */
    void clickOnRestoreCardOption(){
        cardCountBeforeRestore=element("currentFlashCard_text").getText();
        isElementDisplayed("settings_img");
        element("settings_img").click();
        isElementDisplayed("restoreCard");
        element("restoreCard{").click();
        isElementDisplayed("restoreDeck");
        element("restoreDeck").click();
        wait.hardWait(2);
    }
    
    /**
     * Click on card to flip.
     */
    void clickOnCardToFlip(){
        switchToDefaultContent();
        switchToFrame("dockFrame");
        isElementDisplayed("flashCard");
        element("flashCard").click();
        wait.hardWait(2);
    }
    
    /**
     * Click on print option.
     */
    void clickOnPrintOption(){
        isElementDisplayed("settings_img");
        element("settings_img").click();
        isElementDisplayed("print");
        element("print").click();
    }
    
    void clickOnSettingsImage(){
        isElementDisplayed("settings_img");
        element("settings_img").click();
    }
    
    void clickOnUploadFromCSVOption(){
        isElementDisplayed("uploadFromCSV");
        element("uploadFromCSV").click();
    }
    
    void uploadCSVFile(String fileName){
        uploadDocumentViaBrowseOption(Browse_Btn,fileName);
        isElementDisplayed("uploadButton");
        element("uploadButton").click();
        wait.hardWait(2);
        handleAlert();
    }
    /**
     * Close print dialog box.
     */
    void closePrintDialogBox(){
        isElementDisplayed("printClose");
        element("printClose").click();
        wait.hardWait(2);
    }
        
    /**
     * Click on create card button.
     */
    void clickOnCreateCardButton(){
        isElementDisplayed("createCard");
        element("createCard").click();
    }
   
    /**
     * Save flash card.
     *
     * @param keyTerm the key term
     * @param definition the definition
     */
    void saveFlashCard(String keyTerm,String definition){
        isElementDisplayed("createCardTerm");
        element("createCardTerm").sendKeys(keyTerm);
        isElementDisplayed("createCardDef");
        element("createCardDef").sendKeys(definition);
        isElementDisplayed("createCardSave");
        element("createCardSave").click();
        wait.hardWait(2);
    }
    
    /**
     * Click on edit card link.
     */
    void clickOnEditCardLink(){
        fireOnClickJsEvent("editcustomcard");
    }
    
    /**
     * Edits the flash card.
     *
     * @param keyTerm the key term
     * @return true, if successful
     */
    void editFlashCard(String keyTerm){
        isElementDisplayed("createCardTerm");
        element("createCardTerm").clear();
        element("createCardTerm").sendKeys(keyTerm);
        isElementDisplayed("createCardSave");
        elemnt("createCardSave").click();
        wait.hardWait(2);
        switchToDefaultContent();
     }
    
    /**
     * Student view flash card.
     *
     * @param keyTerm the key term
     * @return true, if successful
     */
    void  studentViewFlashCard(String keyTerm){
        String displayKey = element("addedCardKey").getText();
        verifyTextEqualsIgnoreCase(displayKey,keyTerm);
    }
    
    /**
     * Creates the flash card.
     *
     * @param key the key
     * @param value the value
     */
    void createFlashCard(key,value){
        switchToFrame("dockFrame");
        clickOnCreateCardButton();
        saveFlashCard(key,value);
        switchToFrame("windowHandle");
    }

    /**
     * Removes the flash card.
     *
     * @param key the key
     */
    void removeFlashCard(String key){
        switchToDefaultContent();
        switchToFrame("dockFrame");
        removeCard(key);
        switchToDefaultContent();
        clickOnHideApp();
        wait.hardWait(5);
    }

    /**
     * Removes the card.
     *
     * @param key the key
     */
    void removeCard(key){
        boolean flag = true
        while(flag){
            shuffledeck.click()
            String keyItem = keyterm.getText()
            if(keyItem.contains(key)){
                //To avoid stale element exception
                driver.findElement(By.xpath("//div[@class='viewer-card' and contains(@style,'left: 0%')]//a[@class='editcustomcard']")).click()
                wait.hardWait(2)()
                //To avoid stale element exception
                driver.findElement(By.id("card-form-delete")).click()
                wait.hardWait(2)()
                acceptAlertWindow()
                flag = false
            }
        }
    }

    /**
     * View flash card item.
     *
     * @param name the name
     * @param flashKeyId the flash key id
     * @param flashKeyValue the flash key value
     */
    void viewFlashCardItem(name, flashKeyId, flashKeyValue){
        String value
        wait.hardWait(2)()
        List <WebElement> unitLinks = driver.findElements(By.xpath("//h3[contains(@class,'lpn_name')]"))//className("lpn_name"))
        for(WebElement unitLink: unitLinks){
            if(unitLink.getText().contains(name)){
                isElementDisplayed(unitLink)
                try{
                    unitLink.click()
                }
                catch(all){}
                break
            }
        }
        waitForSpinnerToDisappear()
        switchToMainIFrame()
        value = shuffleCard(flashKeyId)
        String selectChapterStyle = driver.findElement(By.id("select_chapter")).getAttribute("style")
        println("selectChapterStyle = " + selectChapterStyle)
        Assert.assertTrue(selectChapterStyle.contains("none"),"Flashcard-Blank Chapter Drop Down list is shown for Distinct activity via LPN.")      
        driver.switchTo().defaultContent()
        Assert.assertTrue(value.contains(flashKeyValue),"Actual : " + value + " Expected : " + flashKeyValue)
    }

    /**
     * Adds the flash card.
     *
     * @param key the key
     * @param value the value
     */
    void addFlashCard(key,value){
        switchToMainIFrame()
        clickOnCreateCardButton()
        saveFlashCard(key,value)
        deselectFrame()
    }

    /**
     * Removes the added flash card.
     *
     * @param key the key
     */
    void removeAddedFlashCard(key){
        switchToMainIFrame()
        removeCard(key)
        deselectFrame()
        toggle_icon.click()
        wait.hardWait(2)()
    }    
    
    /**
     * Shuffle card.
     *
     * @param flashKeyId the flash key id
     * @return the string
     */
    String shuffleCard(flashKeyId){
        String value
        boolean flag = true
        while(flag){
            shuffledeck.click()
            String keyItem = keyterm.getText()
            if(keyItem.contains(flashKeyId)){
                String getKeyId = driver.findElement(By.xpath("//div[@class='ahead card-term']/span/span[contains(.,'${flashKeyId}')]")).getAttribute("id")
                driver.findElement(By.id(getKeyId)).click()
                wait.hardWait(2)()
                value = keydef.getText()
                flag = false
            }
        }
        return value
    }
    
    /**
     * Validate select chapter option in flash app.
     *
     * @param chapterTitle the chapter title
     * @return true, if successful
     */
    boolean validateSelectChapterOptionInFlashApp(chapterTitle){
        isElementDisplayed(flashApp_btn)
        flashApp_btn.click()
        driver.switchTo().defaultContent()        
        driver.switchTo().frame(dockFrame) 
        isElementDisplayed(chaptermenu_ddl)
        boolean flag = true
        for(WebElement chapterValue : chapter_ddl ){
            if(chapterValue.getText().contains(chapterTitle)){
                flag = false
            }
        }      
        deselectFrame()
        clickOnHideApp()        
        return flag
    }
    
    /**
     * Verify flash card app opened.
     *
     * @return true, if successful
     */
    boolean verifyFlashCardAppOpened(){
        return verifyElementIsDisplayed(flashCardApp)
    }
    
    /**
     * Verify chapter switched.
     *
     * @return true, if successful
     */
    boolean verifyChapterSwitched(){
        String displayChapter=chapter_link.getText()
        println("displayChapter = " + displayChapter)
        return verifyTextEqualsIgnoreCase(displayChapter,currentChapter)
    }
    
    /**
     * Verify flash card show definition.
     *
     * @return true, if successful
     */
    boolean verifyFlashCardShowDefinition(){
        return verifyElementIsDisplayed(definition)
    }
    
    /**
     * Verify flash card show key term.
     *
     * @return true, if successful
     */
    boolean verifyFlashCardShowKeyTerm(){
        return verifyElementIsDisplayed(keyTerm)
    }
    
    /**
     * Verify card is hid.
     *
     * @return true, if successful
     */
    boolean verifyCardIsHid(){
        String cardCountAfterHide=currentFlashCard_text.getText()
        Assert.assertFalse(cardCountBeforeHide.equalsIgnoreCase(cardCountAfterHide))
    }
    
    /**
     * Verify card restored.
     *
     * @return true, if successful
     */
    boolean verifyCardRestored(){
        String cardCountAfterRestore=currentFlashCard_text.getText()
        Assert.assertFalse(cardCountBeforeRestore.equalsIgnoreCase(cardCountAfterRestore))
    }
    
    /**
     * Verify restore card option disabled in setting menu.
     *
     * @return true, if successful
     */
    boolean verifyRestoreCardOptionDisabledInSettingMenu(){
        isElementDisplayed(settings_img)
        settings_img.click()
        return restoreCard_btn.isEnabled()    
    }
    
    /**
     * Verify next previous and shuffle card.
     *
     * @return true, if successful
     */
    boolean verifyNextPreviousAndShuffleCard(){
        nextcard_btn.click()
        isElementDisplayed(previouscard)
        previouscard.click()
        isElementDisplayed(shuffledeck)
        shuffledeck.click()
        return true
    }
    
    /**
     * Verify print dialog box opened.
     *
     * @return true, if successful
     */
    boolean verifyPrintDialogBoxOpened(){
        return verifyElementIsDisplayed(print_dialogBox)
    }
    
    /**
     * Verify consistency of flash card between lpn and app dock.
     *
     * @param unit the unit
     * @return true, if successful
     */
    boolean verifyConsistencyOfFlashCardBetweenLPNAndAppDock(String unit){
        deselectFrame()
        isElementDisplayed(flashCardApp_btn)
        flashCardApp_btn.click()
        driver.switchTo().frame(dockFrame) 
        waitForElementPresent(By.id("select_chapter"))
        String chapterOpen=chapter_link.getText()
        if(chapterOpen.contains(unit)){
            deselectFrame()
            return true
        }
        else{
            deselectFrame()
            return false
        }
    }
    
    /**
     * Verify create card dialog box opened.
     *
     * @return true, if successful
     */
    boolean verifyCreateCardDialogBoxOpened(){
        return verifyElementIsDisplayed(createCard_dialogBox)
    }
    
    /**
     * Verify edit card dialog box opened.
     *
     * @return true, if successful
     */
    boolean verifyEditCardDialogBoxOpened(){
        return verifyElementIsDisplayed(editCard_dialogBox)
    }
    
    /**
     * Verify dialog box title.
     *
     * @return true, if successful
     */
    boolean verifyDialogBoxTitle(){
        String displayTitle=createCard_dialogBoxTitle.getText()
        return verifyTextEqualsIgnoreCase(displayTitle,"Create a Flashcard")
    }
    
    /**
     * Verify key term text box title.
     *
     * @return true, if successful
     */
    boolean verifyKeyTermTextBoxTitle(){
        String displayTitle=keyTermTextBoxTitle.getText()
        return verifyTextEqualsIgnoreCase(displayTitle,"Key Term")
    }
    
    /**
     * Verify definition text box title.
     *
     * @return true, if successful
     */
    boolean verifyDefinitionTextBoxTitle(){
        String displayTitle=definitionBoxTitle.getText()
        return verifyTextEqualsIgnoreCase(displayTitle,"Definition")
    }
    
    /**
     * Verify cancel button displayed.
     *
     * @return true, if successful
     */
    boolean verifyCancelButtonDisplayed(){
        return verifyElementIsDisplayed(CancelCard_btn)
    }
    
    /**
     * Verify save button displayed.
     *
     * @return true, if successful
     */
    boolean verifySaveButtonDisplayed(){
        return verifyElementIsDisplayed(createCardSave)
    }
    
    /**
     * Verify delete button displayed.
     *
     * @return true, if successful
     */
    boolean verifyDeleteButtonDisplayed(){
        return verifyElementIsDisplayed(deleteCard)
    }
    
    /**
     * Verify flash card item.
     *
     * @param flashKeyId the flash key id
     * @param flashKeyValue the flash key value
     */
    void verifyFlashCardItem(flashKeyId, flashKeyValue){
        String value
        isElementDisplayed(flashApp_btn)
        flashApp_btn.click()
        driver.switchTo().defaultContent()        
        driver.switchTo().frame(dockFrame) 
        wait.hardWait() 1500
        isElementDisplayed(chaptermenu_ddl)
        chaptermenu_ddl.click()
        //To avoid stale element exception
        driver.findElement(By.xpath("//ul[@id='select_chapter-menu']/li[1]")).click()    
        value = shuffleCard(flashKeyId)
        driver.switchTo().defaultContent()
        Assert.assertTrue(value.contains(flashKeyValue),"Actual value: " + value + "  Expected value: " + flashKeyValue)
    }
    
    /**
     * Adds the flash cards activity.
     */
    void addFlashCardsActivity(){
        waitForSpinnerToDisappear()
        driver.switchTo().frame(driver.findElement(By.id("distinct_activity_create_frame")).getAttribute("name"))
        isElementDisplayed(radioButton)
        radioButton.click()
        isElementDisplayed(flashCardsActivityContinue_btn)
        flashCardsActivityContinue_btn.click()
        deselectFrame()   
        
    }
}

