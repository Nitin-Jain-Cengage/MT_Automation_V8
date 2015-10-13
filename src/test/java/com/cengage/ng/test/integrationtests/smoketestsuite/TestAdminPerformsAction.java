//package com.cengage.ng.test.integrationtests.smoketestsuite;
//
//import static com.qait.mindtap.automation.utils.YamlReader.getData;
//
//import org.testng.annotations.*;
//
//import com.qait.mindtap.automation.TestSessionInitiator;
//import org.testng.ITestResult;
//
//
//public class TestAdminPerformsAction {
//	TestSessionInitiator test;
//
//    String[] browserSizes = {"720x360"};
//    String[] layoutTags = {"all"};
//    String lu2 = "neXtBooks.neXtBook2.learningPaths.learningPath1.learningUnits.learningUnit1";
//    String lu = "neXtBooks.neXtBook1.learningPaths.learningPath1.learningUnits.learningUnit1";
//    String nb = "neXtBooks.neXtBook1";
//    String la = "neXtBooks.learningActivities";
//        
//
//    @BeforeClass
//    @Parameters("browser")
//    public void start_test_session(@Optional String browser) {
//        test = new TestSessionInitiator("TestAdminPerformsAction", browser);
//        test.launchApplication(getData("environment")+getData("launchUrlPath"));
//    }
//    
//    @Test
//    public void Step_01_Admin_Logs_in_to_the_Application() {
//        test.loginpage.login_to_the_application_as_admin(getData(("users.superadmin.username")), getData(("users.superadmin.password")));
//        test.adminDashboard.verify_User_LoggedIn();
//    }
//    
//    @Test(dependsOnMethods = "Step_01_Admin_Logs_in_to_the_Application")
//    public void Step_02_Admin_Logs_in_to_the_Application() {
//    	test.adminDashboard.clickCreateMaster();
//        test.adminDashboard.enterMasterNameAndDescription(getData(nb+".name"), getData(nb+".learningPaths.learningPath1.name"),getData(nb+".description"));
//        test.adminDashboard.enterCoreTextISBN(getData(nb+".isbn"));
//        test.adminDashboard.createMasterNeXtBookInCourseMode();
//        test.adminDashboard.createUnpublishedMaster(getData(nb+".name"));
//    }
//    
//    @Test(dependsOnMethods = "Step_02_Admin_Logs_in_to_the_Application")
//    public void adminRefreshMasterNeXtBook(){
//        test.adminDashboard.openMaster();
//        test.adminDashboard.searchBookOnMastersPage(getData("neXtBooks.neXtBook1.name"));
//        test.adminDashboard.clickOnModeValueIcon(getData("neXtBooks.neXtBook1.mode2"));
//        test.adminDashboard.clickBookModifyOption(getData("neXtBooks.neXtBook1.name"), "refresh");
//        test.adminDashboard.refreshMasterNextBook(getData("Book Info"));
//    }
//    
//   
//    @Test(dependsOnMethods = "adminRefreshMasterNeXtBook")
//    void adminCreatesUser(){
//        test.adminDashboard.openOrg();
//        test.userpage.navigateToOrganisationAndCreateUser(getData("users.editUser.organisation"), getData("Nameusers.editUser.ssoUser"), getData("users.editUser.role"));
//      }  
//    
//    @Test(dependsOnMethods = "adminCreatesUser")
//    void adminChangesRoleForCreatedUser(){
//        test.adminDashboard.openOrg();
//        test.userpage.navigateToManageUsersTab();
//        test.userpage.findUserInTheOrgListandPerform(getData("users.editUser.ssoUser"), "editUser");
//        test.userpage.editUserUpdateRole( getData("users.editUser.role"));
//    }  
//    
//    @Test(dependsOnMethods = "adminChangesRoleForCreatedUser")
//    void adminDeletesCreatedUser(){
//        test.adminDashboard.openOrg();
//        test.userpage.searchUserandClickDelete(getData("users.editUser.organisationName"),getData("users.editUser.ssoUserName"));
//    }  
//                                                                               
//    @Test(dependsOnMethods = "adminDeletesCreatedUser")
//    void  adminCreatesLearningUnit(){
//        test.adminDashboard.openMaster();
//        test.adminDashboard.searchBookOnMastersPage(getData("neXtBooks.neXtBook1.name"));
//        test.adminDashboard.clickOnModeValueIcon(getData("neXtBooks.neXtBook1.mode2"));
//        test.adminDashboard.verifyBookPresent(getData("neXtBooks.neXtBook1.name"));
//        test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(getData("classTitle"));
//        test.lpn.createLearningUnit(getData(lu+".newUnit"),getData(lu+".newUnit"));
//    }   
//        
//    @Test(dependsOnMethods = "adminCreatesLearningUnit")
//     void verifySearchOperation(){
//        test.adminDashboard.openMaster(); 
//        test.adminDashboard.searchBookOnMastersPage(getData("neXtBooks.neXtBook1.master"));
//        test.adminDashboard.clickOnModeValueIcon(getData("neXtBooks.neXtBook1.mode2"));
//        test.adminDashboard.verifyBookPresent(getData("neXtBooks.neXtBook1.master"));
//        test.adminDashboard.verifyLearningUnitsPresentInMasterNeXtBook(getData("classTitle"));
//        test.search.verifySearchApp();
//        test.search.performSearchOperationUsingSubmit(lu+".name");
//    }
//
//     @Test(dependsOnMethods = "verifySearchOperation")
//    void adminLogout(){
//        test.dsl.clickOnAutomationAdminLink();
//        test.dsl.verifyLogOut();
//       
//    }
//     @AfterClass(alwaysRun = true)
//    void stopBrowser() {        
//        test.closeTestSession(); 
//    }
//    
//    
//    @AfterMethod
//    public void captureScreenShotOnFailure(ITestResult result) {
//              test.takescreenshot.takeScreenShotOnException(result);
//
//     }
//}
