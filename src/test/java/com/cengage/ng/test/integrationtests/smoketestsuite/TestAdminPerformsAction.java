package com.cengage.ng.test.integrationtests.smoketestsuite;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.annotations.*;

import com.qait.mindtap.automation.TestSessionInitiator;


public class TestAdminPerformsAction {
	TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};

    @BeforeClass
    @Parameters("browser")
    public void start_test_session(@Optional String browser) {
        test = new TestSessionInitiator("NG_30181_TC01_Admin_login_and_search_the_isbn_under_master_Tab", browser);
        test.launchApplication(getData("stagingSsoUrl"));
    }
    
    @Test
    public void Step_01_Admin_Logs_in_to_the_Application() {
        test.loginpage.verify_User_Is_On_Login_Page();
        test.loginpage.login_to_the_application_as_admin(getData(("users.superadmin.username")), getData(("users.superadmin.password")));
        test.adminDashboard.verify_User_LoggedIn();
    }
    
    @Test
    public void Step_02_Admin_Logs_in_to_the_Application() {
    	test.adminDashboard.clickCreateMaster();
        test.adminDashboard.enterMasterNameAndDescription(getData("neXtBooks.neXtBook1.name"), getData("neXtBooks.neXtBook1.learningPaths.learningPath1.Name"),getData(" neXtBooks.neXtBook1.description"));
        test.adminDashboard.enterCoreTextISBN(getData("coreisbn"));
        test.adminDashboard.enterCoreTextISBN(getData("ssoisbn"));
        test.adminDashboard.createMasterNeXtBookInCourseMode();
        test.adminDashboard.createUnpublishedMaster(getData("name"));
    	test.adminDashboard.openMaster();
    }
    
    @Test(dependsOnMethods = "adminCreatesMasterNeXtBookInCourseMode")
    void adminRefreshMasterNeXtBook(){
        test.adminDashboard.openMaster();
        test.adminDashboard.searchBookOnMastersPage(getData("neXtBooks.neXtBook1.name"));
        test.adminDashboard.clickOnModeValueIcon(getData("neXtBooks.neXtBook1.mode2"));
        test.adminDashboard.clickBookModifyOption(getData("neXtBooks.neXtBook1.name"), "refresh");
        test.adminDashboard.refreshMasterNextBook(getData("Book Info"));
    }
    
   
    @Test(dependsOnMethods = "adminRefreshMasterNeXtBook")
    void adminCreatesUser(){
        test.adminDashboard.openOrg();
        test.org.navigateToOrganisationAndCreateUserName(dsl.testdata.users.editUser.organisationName, dsl.testdata.users.editUser.ssoUser, dsl.testdata.users.editUser.role));
        Reporter.log "Completed Find org and create user with role:- " + dsl.testdata.users.editUser.role,true
    }  
    
    @Test(dependsOnMethods = "adminCreatesUser")
    void adminChangesRoleForCreatedUser(){
        test.adminDashboard.openOrgDashBoard();
        orgDsl.searchUserOnManageOrganisationsPageAndEdit(dsl.testdata.users.editUser.organisationName,dsl.testdata.users.editUser.ssoUserName,dsl.testdata.users.editUser.changeRole);
        Reporter.log "Completed Admin Changes Role For Created User",true
    }  
    
    @Test(dependsOnMethods = "adminChangesRoleForCreatedUser")
    void adminDeletesCreatedUser(){
        test.adminDashboard.openOrgDashBoard();
        Assert.assertTrue(orgDsl.searchUserOnManageOrganisationsPageAndDelete(dsl.testdata.users.editUser.organisationName,dsl.testdata.users.editUser.ssoUserName));
        Reporter.log "Completed Admin Deletes Created User",true
    }  
     
    @Test(dependsOnMethods = "adminDeletesCreatedUser")
    void  adminCreatesLearningUnit(){
        test.adminDashboard.openNeXtBookAdminDashboard();
        Assert.assertTrue(test.adminDashboard.launchMasterNextBook(dsl.testdata.neXtBooks.neXtBook1.name,dsl.testdata.neXtBooks.neXtBook1.mode2));
        Assert.assertTrue(test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(classTitle), "Learning Units Not Displayed");
        Assert.assertTrue(lpnDsl.createLearningUnit(lu.newUnit,lu.newUnit));
        Reporter.log ("Completed Admin Creates Learning Unit",true)
    }   
        
    @Test(dependsOnMethods = "adminCreatesLearningUnit")
    void verifySearchOperation(){
        test.adminDashboard.openNeXtBookAdminDashboard();
        Assert.assertTrue(test.adminDashboard.launchMasterNextBook(dsl.testdata.neXtBooks.neXtBook1.master,dsl.testdata.neXtBooks.neXtBook1.mode2));        
        Assert.assertTrue(test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(classTitle), "Learning Units Not Displayed");
        searchDsl.verifySearchApp();
        searchDsl.performSearchOperationUsingSubmit(lu.name);
        Reporter.log "Completed verify Search Operation",true
    }

    //@Test(dependsOnMethods="verifySearchOperation")
    void navigateToSnapshotAndOpenLamsFromDockApp(){
        test.adminDashboard.openOrgDashBoard();
        orgDsl.navigateToSnapshot(lu2.learningActivities.learningActivity2.organisationName,dsl.testdata.neXtBooks.neXtBook2.CourseName,
            lu2.learningActivities.learningActivity2.snapshotName,dsl.testdata.neXtBooks.neXtBook2.CourseKey);
        Assert.assertTrue(lamsDsl.validateAdminCannotViewActivityFromTheAppDock());
        Reporter.log "Completed Navigate to Snapshot and Open Lams From Dock App",true
    }
    
    @Test(dependsOnMethods = "verifySearchOperation")
    void adminLogout(){
        dsl.logOut();
        dsl.verifyLogOut();
        Reporter.log ("Completed admin Logout",true)
    }
   
}
