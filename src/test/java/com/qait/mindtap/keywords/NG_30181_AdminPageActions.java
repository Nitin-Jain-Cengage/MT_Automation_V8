/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.mindtap.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.mindtap.automation.getpageobjects.GetPage;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.SeleniumWait;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class NG_30181_AdminPageActions extends GetPage {

    public NG_30181_AdminPageActions(WebDriver driver) {
        super(driver, "NG-30181-AdminPage");

    }

    public void verifyuserIsOnAdminPage() {
        verifyPageTitleContains();
        ReportMsg.pass("Verified User is on Admin Page");
    }

    public void verify_User_LoggedIn_As_Admin(String replacement) {
        this.isElementDisplayed("mindtap_toolbar");
        this.isElementDisplayed("admin_dashboard", replacement);
    }

    public void search_Course_Using_ISBN(String courseKey) {
        element("input_search_ISBN").click();
        element("input_search_ISBN").sendKeys(courseKey);

    }

    public void open_Course_In_Edit_Mode(String replacement) {
        wait.waitForElementToDisappear(element("nextPageArrow"));
        hover(element("courseClass"));
        waitTOSync();
        isElementDisplayed("icon_course_edit");
        element("icon_course_edit").click();
    }

    public void course_Andesite_Mode_Is_Checked(String replacement) {
        this.isElementDisplayed("checkbox_Andesite_mode");
        element("btn_save_Edit_Working_copy").click();
    }

    public void search_Course_Using_CourseKey() {
        isElementDisplayed("inputOrganizationSearch");
        element("inputOrganizationSearch").click();
        System.out.println(data.readProperty("courseKey"));
        element("inputOrganizationSearch").sendKeys(data.readProperty("courseKey"));
        waitTOSync();
        isElementDisplayed("courseOrganization");
        element("courseOrganization").click();
        waitTOSync();
        isElementDisplayed("courseProvisioned");
        element("courseProvisioned").click();
        isElementDisplayed("courseCollege", yml.getYamlValue("course1.courseName"));
    }

    public void clickOnProvisionApps() {
        clickOnCourseProvisionAppIcon(yml.getYamlValue("course1.courseName"));
    }

    public void selectCengageNoMT_Activity() {
        wait.waitForElementToBeVisible(element("appRegistryHeading"));
        isElementDisplayed(("appRegistryHeading"));
        addRegistry("Cengage.non-mt-activity");
        }

    public void openOrganizationPage() {
        isElementDisplayed("orgaizationTab");
        element("orgaizationTab").click();
    }

    public void addRegistry(String appRegistryOption) {
        List<WebElement> appsProvisionList = elements("ProvisionList");
        int limit = 0;
        for (WebElement appProvision : appsProvisionList) {
             String str = appProvision.getText();
             System.out.println("activity"+str);
            if (str.contains(appRegistryOption)) {
                String classname = appProvision.getAttribute("class").toString();
                executeJavascript("document.getElementsByClassName('" + classname + "')[0].getElementsByTagName('a')[0].click();");
                waitTOSync();
                break;
            } 
        }
    }

    void clickOnCourseProvisionAppIcon(String snapshotName) {
        isElementDisplayed("snapshotList");
        List<WebElement> snapshotList = elements("snapshotList");
        int i = 0;
        for (WebElement ele : snapshotList) {
            if (ele.getText().contains(snapshotName)) {
                String bookClassName = ele.getAttribute("class").toString();
                wait.resetImplicitTimeout(5);
                for (int optionCount = 0; optionCount <= 4; optionCount++) {
                    if (optionCount != 2) {
                        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[" + optionCount + "].style.display = 'none';");
                    } else {
                        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[" + optionCount + "].style.display = 'block';");
                    }
                }
                clickOnElementUsingActionBuilder(element("provisionAppsIcon"));
                break;
            }
            i++;
        }
    }

}
