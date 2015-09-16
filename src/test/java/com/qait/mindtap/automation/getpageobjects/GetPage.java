package com.qait.mindtap.automation.getpageobjects;

import static com.qait.mindtap.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static com.qait.mindtap.automation.utils.ConfigPropertyReader.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qait.mindtap.automation.utils.LayoutValidation;
import com.qait.mindtap.automation.utils.ReportMsg;
import java.io.File;

public class GetPage extends BaseUi {

    protected WebDriver webdriver;
    String pageName;
    LayoutValidation layouttest;

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
        return wait.waitForElementsToBeVisible(webdriver
                .findElements(getLocator(elementToken, replacement)));
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

    protected void verifyElementText(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertEquals(element(elementName).getText().trim(), expectedText,
                ReportMsg.fail("Text of the page element '"
                        + elementName + "' is not as expected: "));
        ReportMsg.pass("element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected void verifyElementTextContains(String elementName,
            String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertThat(ReportMsg.fail("Text of the page element '"
                + elementName + "' is not as expected: "), element(elementName)
                .getText().trim(), containsString(expectedText));
        ReportMsg.pass("element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected boolean isElementDisplayed(String elementName) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = element(elementName).isDisplayed();
        assertTrue(result, ReportMsg.fail(" element '" + elementName
                + "' is not displayed."));
        ReportMsg.pass("element " + elementName + " is displayed.");
        return result;
    }

    protected boolean isElementEnabled(String elementName, boolean expected) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = expected && element(elementName).isEnabled();
        assertTrue(result, ReportMsg.fail(" element '" + elementName
                + "' is  ENABLED :- " + !expected));
        ReportMsg.pass("element " + elementName + " is enabled :- "
                + expected);
        return result;
    }

    protected By getLocator(String elementToken) {
        return getLocator(elementToken, "");
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected By getLocator(String elementToken, String replacement1,
            String replacement2) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = StringUtils.replace(locator[2], "$", replacement1);
        locator[2] = StringUtils.replace(locator[2], "%", replacement2);
        return getBy(locator[1].trim(), locator[2].trim());
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
}
