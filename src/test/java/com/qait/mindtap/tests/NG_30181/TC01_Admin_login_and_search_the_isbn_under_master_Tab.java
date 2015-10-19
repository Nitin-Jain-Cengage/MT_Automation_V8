package com.qait.mindtap.tests.NG_30181;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.mindtap.automation.TestSessionInitiator;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class TC01_Admin_login_and_search_the_isbn_under_master_Tab {

    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass

    public void start_test_session() {
        test = new TestSessionInitiator("TC01_Admin_login_and_search_the_isbn_under_master_Tab");
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void Step_01_Admin_Logs_in_to_the_Application() {
        test.loginpage.login_to_the_application_as_admin(getData(("users.admin.username")), getData(("users.admin.password")));
        test.adminpage.verifyuserIsOnAdminPage();
    }

    @Test(dependsOnMethods = {"Step_01_Admin_Logs_in_to_the_Application"})
    public void Step_02_Admin_Search_Course_using_ISBN() {
        test.adminpage.verify_User_LoggedIn_As_Admin("Admin Dashboard");
        test.adminpage.search_Course_Using_ISBN(getData("course1.ISBN"));
    }

    @Test(dependsOnMethods = {"Step_02_Admin_Search_Course_using_ISBN"})
    public void Step_03_Admin_Verify_Course_Andesite_mode_checked() {
        test.adminpage.open_Course_In_Edit_Mode(getData("course1.courseName"));
        test.adminpage.course_Andesite_Mode_Is_Checked("Edit Working Copy");

    }

    @Test(dependsOnMethods = {"Step_03_Admin_Verify_Course_Andesite_mode_checked"})
    void Step_04_Admin_Logs_Out() {
        test.loginpage.logout();
    }

    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}
