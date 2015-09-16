package com.qait.mindtap.tests;

import org.testng.annotations.*;
import org.testng.ITestResult;

import com.qait.mindtap.automation.TestSessionInitiator;
import static com.qait.mindtap.automation.utils.YamlReader.getData;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class Admin_Create_Master_and_Edit_Provision_Apps_Test {

    TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("Admin_Create_Master_and_Edit_Provision_Apps_Test", browser);
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void Step_01_Admin_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_as(getData(("users.admin.username")), getData(("users.admin.password")));
        test.adminpage.verifyuserIsOnAdminPage();
    }

    @Test
    public void Step_02_Admin_Creates_MasterNextBook_in_Course_Mode() {
        test.adminpage.managemasters.createMasterNeXtBookInCourseMode();
        test.adminpage.openManageMasters();
        test.adminpage.managemasters.verifyMasterNeXtBookIsCreated();
    }

    //@Test
    void Step_03_Admin_Logs_Out() {
        test.adminpage.logout();
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
