package com.qait.mindtap.automation;

import static com.qait.mindtap.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.mindtap.automation.utils.YamlReader.getYamlValue;
//import static com.qait.mindtap.automation.utils.YamlReader.setYamlFilePath;







import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qait.mindtap.automation.pojo.TopicNamePojo;
import com.qait.mindtap.automation.utils.ReportMsg;
import com.qait.mindtap.automation.utils.TakeScreenshot;
import com.qait.mindtap.automation.utils.YamlReader;
import com.qait.mindtap.keywords.AdminPerformActions;
import com.qait.mindtap.keywords.HeaderActions;
import com.qait.mindtap.keywords.LearningActivityActions;
import com.qait.mindtap.keywords.LearningPathNavigatorPageActions;
import com.qait.mindtap.keywords.LoginPageActions;
import com.qait.mindtap.keywords.NG_30181_AdminPageActions;
import com.qait.mindtap.keywords.NG_30181_ConfirmCourseInformationActions;
import com.qait.mindtap.keywords.NG_30181_CoursePaymentActionPageActions;
import com.qait.mindtap.keywords.NG_30181_InstructorCreatesCourseConfirmationActions;
import com.qait.mindtap.keywords.NG_30181_InstructorCreatesCourseOptionPageActions;
import com.qait.mindtap.keywords.NG_30181_InstructorCreatesEditCoursePageActions;
import com.qait.mindtap.keywords.NG_30181_InstructorEditCourseActions;
import com.qait.mindtap.keywords.NG_30181_InstructorPageActions;
import com.qait.mindtap.keywords.NG_30181_LoginPageActions;
import com.qait.mindtap.keywords.NG_30181_StudentLaunchCourseActions;
import com.qait.mindtap.keywords.OrganizationActions;
import com.qait.mindtap.keywords.ProgressWidgetActions;
import com.qait.mindtap.keywords.UserPageActions;
import com.qait.mindtap.keywords.WeekWidgetActions;

public class TestSessionInitiator {

    protected WebDriver driver;
    private final WebDriverFactory wdfactory;
    String browser;
    String seleniumserver;
    String seleniumserverhost;
    String appbaseurl;
    String applicationpath;
    String chromedriverpath;
    String datafileloc = "";
    static int timeout;
    Map<String, Object> chromeOptions = null;
    DesiredCapabilities capabilities;

    /**
     * Initiating the page objects
     */
    public NG_30181_LoginPageActions loginpage;
    public NG_30181_AdminPageActions adminpage;
    public NG_30181_InstructorPageActions instructor;
    public NG_30181_InstructorCreatesCourseConfirmationActions courseConfirmation;
    public NG_30181_InstructorCreatesCourseOptionPageActions courseOptions;
    public NG_30181_InstructorCreatesEditCoursePageActions courseCreateEdit;
    public NG_30181_InstructorEditCourseActions courseEdit;
    public NG_30181_StudentLaunchCourseActions sso;
    public NG_30181_CoursePaymentActionPageActions coursePayment;
    public NG_30181_ConfirmCourseInformationActions confirmCourseInfo;
    public UserPageActions userpage;
  //  public AdminPerformActions adminDashboard;
    public OrganizationActions org;
    public LearningActivityActions la;
    public HeaderActions header;
    public WeekWidgetActions weekwidget;
    public ProgressWidgetActions progress;
    public LearningPathNavigatorPageActions lpn;
  //  public SearchAppPageActions search;
    public LoginPageActions dsl;
    
    public TakeScreenshot takescreenshot;
    public TopicNamePojo topicNameValue;
    private final String testname;

    public Random randomGenerator;
	

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        loginpage = new NG_30181_LoginPageActions(driver);
        adminpage = new NG_30181_AdminPageActions(driver);
        instructor = new NG_30181_InstructorPageActions(driver);
        topicNameValue = new TopicNamePojo();
        courseConfirmation = new NG_30181_InstructorCreatesCourseConfirmationActions(driver);
        courseOptions = new NG_30181_InstructorCreatesCourseOptionPageActions(driver);
        courseCreateEdit = new NG_30181_InstructorCreatesEditCoursePageActions(driver);
        courseEdit = new NG_30181_InstructorEditCourseActions(driver);
        sso = new NG_30181_StudentLaunchCourseActions(driver);
        confirmCourseInfo = new NG_30181_ConfirmCourseInformationActions(driver);
        coursePayment = new NG_30181_CoursePaymentActionPageActions(driver);
     //   adminDashboard = new AdminPerformActions(driver);
        userpage = new UserPageActions(driver);
        org = new OrganizationActions(driver);
        la = new LearningActivityActions(driver);
        header = new HeaderActions(driver);
        weekwidget = new WeekWidgetActions(driver);
        progress = new ProgressWidgetActions(driver);
        lpn = new LearningPathNavigatorPageActions(driver);
    //    search = new SearchAppPageActions(driver);
        org = new OrganizationActions(driver);
    }

    /**
     * Page object Initiation done
     *
     * @param testname
     */
    public TestSessionInitiator(String testname) {
        wdfactory = new WebDriverFactory();
        testInitiator(testname);
        this.testname = testname;
    }

    public TestSessionInitiator(String testname, String browserName) {
        wdfactory = new WebDriverFactory(browserName);
        testInitiator(testname);
        this.testname = testname;

        
    }

    private void testInitiator(String testname) {
        YamlReader.setYamlFilePath();
        _configureBrowser();
        _initPage();
        takescreenshot = new TakeScreenshot(testname, this.driver);
    }

    private void _configureBrowser() {
        driver = wdfactory.getDriver(_getSessionConfig());
        if (!_getSessionConfig().get("browser").toLowerCase().trim().equalsIgnoreCase("mobile")) {
            driver.manage().window().maximize();
        }
        driver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(getProperty("timeout")),
                        TimeUnit.SECONDS);
    }

    private Map<String, String> _getSessionConfig() {
        String[] configKeys = {"tier", "browser", "seleniumserver",
            "seleniumserverhost", "timeout", "driverpath", "appiumServer",
            "mobileDevice"};
        Map<String, String> config = new HashMap<>();
        for (String string : configKeys) {
            config.put(string, getProperty("./Config.properties", string));
        }
        return config;
    }

    public void launchApplication() {
        launchApplication(getYamlValue("base_url"));
    }

    public void launchApplication(String base_url) {
        ReportMsg.info(" The application url is :- " + base_url);
        driver.manage().deleteAllCookies();
        driver.get(base_url);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowserSession() {
        ReportMsg.info("The Test: " + this.testname.toUpperCase() + " COMPLETED!" + "\n");
        try {
        	driver.quit();
        } catch (Exception b) {
            b.getMessage();
        }
    }

    public void closeTestSession() {
        closeBrowserSession();
    }
}
