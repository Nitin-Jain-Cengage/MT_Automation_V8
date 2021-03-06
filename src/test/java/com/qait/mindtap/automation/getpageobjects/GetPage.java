package com.qait.mindtap.automation.getpageobjects;

import static com.qait.mindtap.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static com.qait.mindtap.automation.utils.ConfigPropertyReader.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;

import com.qait.mindtap.automation.utils.LayoutValidation;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;

public class GetPage extends BaseUi {

    protected final int AJAX_WAIT = 30;
    protected WebDriver webdriver;
    String pageName;
    LayoutValidation layouttest;
    SeleniumWait sel_wait;

    void selectChapter(String name) {
        int index = 0;
        List<WebElement> unitLinks = driver.findElements(By.xpath("//div[@class='list-area']/ul[contains(@class,'nb_stacklist slate list nb_nothumb clui_list')]/li[contains(@class,'item switchPath nb_unit nb_unit')]"));
        for (WebElement link : unitLinks) {
            index++;
            if (link.getText().contains(name)) {
                String i = Integer.toString(index);
                fireOnClickJsEvent("nb_thumbTitle", i);
            }
        }
    }

    /**
     * Perform click on more link.
     */
    public void performClickOnMoreLink(WebElement more_link) {
        try {
            wait.hardWait(2);
            wait.resetImplicitTimeout(10);
            //To avoid stale element exception
            wait.waitForElementToBeVisible(driver.findElement(By.cssSelector("img[alt='Expand Dock']")));
            wait.hardWait(2);
            more_link.click();
            wait.hardWait(2);
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException e) {
            e.printStackTrace();
        }
        wait.resetImplicitTimeout(AJAX_WAIT);
    }

    protected void waitForSpinnerToDisappear() {
        int i = 0;
        wait.resetImplicitTimeout(2);
        try {
            List<WebElement> spinnerGifs = driver.findElements(By.xpath("//img[contains(@src, '/nb/ui/images/savingAnimation_')]"));
            if (spinnerGifs.size() > 0) {
                for (WebElement spinnerGif : spinnerGifs) {
                    while (spinnerGif.isDisplayed() && i <= AJAX_WAIT) {
                        wait.hardWait(2);
                        i++;
                    }
                }
            }
        } catch (Exception e) {
        }
        wait.resetImplicitTimeout(AJAX_WAIT);
    }

    public GetPage(WebDriver driver, String pageName) {
        super(driver, pageName);
        this.webdriver = driver;
        this.pageName = pageName.replace("_", File.separator);
        layouttest = new LayoutValidation(driver, pageName);
    }

    public void testPageLayout(List<String> tagsToBeTested) {
        layouttest.checklayout(tagsToBeTested);
    }

    public void testPageLayout(List<String> browserSizes,
            List<String> tagsToBeTested) {
        layouttest.checklayout(browserSizes, tagsToBeTested);
    }

    public void testPageLayout(String[] browserSizes, String[] tagToBeTested) {
        testPageLayout(Arrays.asList(browserSizes),
                Arrays.asList(tagToBeTested));
    }

    public void testPageLayout(String... tagToBeTested) {
        testPageLayout(Arrays.asList(tagToBeTested));
    }

    public void testPageLayout() {
        testPageLayout(Arrays.asList(getProperty("./Config.properties",
                "browser")));
    }

    public WebElement accessor(String element) {
        return element(element);
    }

    // TODO: put this in right place, create dedicated class for frame and
    // window handlers
    protected void switchToNestedFrames(String frameNames) {
        switchToDefaultContent();
        String[] frameIdentifiers = frameNames.split(":");
        for (String frameId : frameIdentifiers) {
            wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId
                    .trim()));
        }
    }

    protected WebElement element(String elementToken) {
        return element(elementToken, "");
    }

    protected WebElement elementWithoutWait(String elementToken, String replacement) {
        WebElement elem = null;
        try {
            elem = webdriver.findElement(getLocator(elementToken, replacement));
        } catch (NoSuchElementException excp) {
            ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
        } catch (NullPointerException npe) {
            ReportMsg.scripterror(npe.getLocalizedMessage());
        }
        return elem;
    }

    protected WebElement element(String elementToken, String replacement) {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(webdriver
                    .findElement(getLocator(elementToken, replacement)));
        } catch (NoSuchElementException excp) {
            ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
        } catch (NullPointerException npe) {
            ReportMsg.scripterror(npe.getLocalizedMessage());
        }
        return elem;
    }

    protected WebElement element(String elementToken, String replacement1, String replacement2) {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(webdriver
                    .findElement(getLocator(elementToken, replacement1, replacement2)));
        } catch (NoSuchElementException excp) {
            ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
        } catch (NullPointerException npe) {
            ReportMsg.scripterror(npe.getLocalizedMessage());
        }
        return elem;
    }

    protected WebElement childOfElement(WebElement el, String elementToken, String replacement) {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(el
                    .findElement(getLocator(elementToken, replacement)));
        } catch (NoSuchElementException excp) {
            ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
        } catch (NullPointerException npe) {
            ReportMsg.scripterror(npe.getLocalizedMessage());
        }
        return elem;
    }

    protected WebElement childOfElement(WebElement el, String elementToken) {
        return childOfElement(el, elementToken, "");
    }

    protected List<WebElement> elements(String elementToken, String replacement) {
        // return wait.waitForElementsToBeVisible(webdriver.findElements(getLocator(elementToken, replacement)));
        return webdriver.findElements(getLocator(elementToken, replacement));
    }

    protected List<WebElement> elementsFromElement(WebElement el, String elementToken, String replacement) {
        return wait.waitForElementsToBeVisible(el
                .findElements(getLocator(elementToken, replacement)));
    }

    protected List<WebElement> elements(String elementToken) {
        return elements(elementToken, "");
    }

    protected List<WebElement> elementsFromElement(WebElement el, String elementToken) {
        return elementsFromElement(el, elementToken, "");
    }

    protected boolean isElementDisplayed(String elementName,
            String elementTextReplace) {
        wait.waitForElementToBeVisible(element(elementName, elementTextReplace));
        boolean result = element(elementName, elementTextReplace).isDisplayed();

        if (result) {
            ReportMsg.pass("element " + elementName + " with text "
                    + elementTextReplace + " is displayed.");
        } else {
            ReportMsg.fail("element " + elementName
                    + "with text " + elementTextReplace + " is not displayed.");
            fail();
        }
        return result;
    }

    protected boolean checkIfElementIsNotThere(String elementToken) {
        boolean flag = false;
        try {
            wait.hardWait(10);

            if (webdriver.findElement(getLocator(elementToken)).isDisplayed()) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (NoSuchElementException ex) {
            flag = true;
        }
        return flag;
    }

    protected boolean checkIfElementIsNotThere(String elementToken, String replacement) {
        boolean flag = false;
        try {
            wait.hardWait(10);
            if (webdriver.findElement(getLocator(elementToken, replacement)).isDisplayed()) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (NoSuchElementException ex) {
            flag = true;
        }
        return flag;
    }

    protected boolean checkIfElementIsNotThere(String elementToken, String replacement1, String replacement2) {
        boolean flag = false;
        try {
            if (webdriver.findElement(getLocator(elementToken, replacement1, replacement2)).isDisplayed()) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (NoSuchElementException ex) {
            flag = true;
        }
        return flag;
    }

    protected void verifyElementText(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertEquals(element(elementName).getText().trim(), expectedText,
                ReportMsg.failForAssert("Text of the page element '"
                        + elementName + "' is not as expected: "));
        ReportMsg.pass("element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected void verifyElementTextContains(String elementName,
            String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertThat(ReportMsg.failForAssert("Text of the page element '"
                + elementName + "' is not as expected: "), element(elementName)
                .getText().trim(), containsString(expectedText));
        ReportMsg.pass("element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected boolean isElementDisplayed(String elementName) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = element(elementName).isDisplayed();

        assertTrue(result, ReportMsg.failForAssert(" element '" + elementName
                + "' is not displayed."));
        ReportMsg.pass("element " + elementName + " is displayed.");
        return result;
    }

    protected boolean isElementEnabled(String elementName, boolean expected) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = expected && element(elementName).isEnabled();
        assertTrue(result, ReportMsg.failForAssert(" element '" + elementName
                + "' is  ENABLED :- " + !expected));
        ReportMsg.pass("element " + elementName + " is enabled :- "
                + expected);
        return result;
    }

    protected By getLocator(String elementToken) {
        return getLocator(elementToken, "");
    }

    protected String getJsLocator(String elementToken) {
        return getJsLocator(elementToken, "");
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected String getJsLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return locator[2].trim();
    }

    protected By getLocator(String elementToken, String replacement1,
            String replacement2) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement1);
        locator[2] = locator[2].replaceAll("\\%\\{.+\\}", replacement2);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected void clickOnElementUsingActionBuilder(WebElement element) {
        Actions builder = new Actions(driver);
        Actions MenuItems = builder.moveToElement(element);
        waitTOSync();
        MenuItems.click().build().perform();
        waitTOSync();
    }

    protected void waitTOSync() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected String elementByJscript(String element) {
        return getJsLocator(element);

    }

    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    protected void waitForElementPresent(String ele) {
        for (int second = 0;; second++) {
            if (second >= AJAX_WAIT) {
                Reporter.fail("element not present");
            } else {
                wait.resetImplicitTimeout(3);
                try {
                    element(ele);
                    wait.resetImplicitTimeout(AJAX_WAIT);
                    Reporter.pass(ele + "is present");
                } catch (Exception ee) {
                    wait.hardWait(2);
                }
            }
        }
    }

    public void clickOnHideApp() {
        switchToDefaultContent();
        if (isElementDisplayed("hideFrame")) {
            element("hideFrame").click();
        }
    }
}
