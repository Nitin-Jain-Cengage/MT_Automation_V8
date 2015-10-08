package com.cengage.ng.test.integrationtests.smoketestsuite;

import static com.qait.mindtap.automation.utils.YamlReader.getData;

import org.testng.annotations.*;

import com.qait.mindtap.automation.TestSessionInitiator;


public class TestAdminPerformsAction {
	TestSessionInitiator test;

    String[] browserSizes = {"720x360"};
    String[] layoutTags = {"all"};
    String lu2 = "neXtBooks.neXtBook2.learningPaths.learningPath1.learningUnits.learningUnit1";
    String lu = "neXtBooks.neXtBook1.learningPaths.learningPath1.learningUnits.learningUnit1";
    String nb = "neXtBooks.neXtBook1";
    String la = "neXtBooks.learningActivities";
        

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
        test.userpage.navigateToOrganisationAndCreateUser(getData("users.editUser.organisation"), getData("Nameusers.editUser.ssoUser"), getData("users.editUser.role"));
      }  
    
    @Test(dependsOnMethods = "adminCreatesUser")
    void adminChangesRoleForCreatedUser(){
        test.adminDashboard.openOrg();
        test.userpage.navigateToManageUsersTab();
        test.userpage.findUserInTheOrgListandPerform(getData("users.editUser.ssoUser"), "editUser");
        test.userpage.editUserUpdateRole( getData("users.editUser.role"));
    }  
    
    @Test(dependsOnMethods = "adminChangesRoleForCreatedUser")
    void adminDeletesCreatedUser(){
        test.adminDashboard.openOrg();
        test.userpage.searchUserandClickDelete(getData("users.editUser.organisationName"),getData("users.editUser.ssoUserName"));
    }  
                                                                               
    @Test(dependsOnMethods = "adminDeletesCreatedUser")
    void  adminCreatesLearningUnit(){
        test.adminDashboard.openMaster();
        test.adminDashboard.searchBookOnMastersPage(getData("neXtBooks.neXtBook1.name"));
        test.adminDashboard.clickOnModeValueIcon(getData("neXtBooks.neXtBook1.mode2"));
        test.adminDashboard.verifyBookPresent(getData("neXtBooks.neXtBook1.name"));
        test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(getData("classTitle"));
        test.lpn.createLearningUnit(getData(lu+".newUnit"),getData(lu+".newUnit"));
        Reporter.log ("Completed Admin Creates Learning Unit",true)
    }   
        
    @Test(dependsOnMethods = "adminCreatesLearningUnit")
    void verifySearchOperation(){
        test.adminDashboard.openNeXtBookAdminDashboard();
        Assert.assertTrue(test.adminDashboard.launchMasterNextBook(dsl.testdata.neXtBooks.neXtBook1.master,dsl.testdata.neXtBooks.neXtBook1.mode2));        
        Assert.assertTrue(test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(getData("classTitle"));
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
   */
}
