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
import com.qait.mindtap.keywords.NG_30104.AdminPerformActionPage;
import com.qait.mindtap.keywords.NG_30104.HeaderActions;
import com.qait.mindtap.keywords.NG_30104.LearningActivity;
import com.qait.mindtap.keywords.NG_30104.NG_30181_AdminPageActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_ConfirmCourseInformationActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_CoursePaymentActionPage;
import com.qait.mindtap.keywords.NG_30104.NG_30181_InstructorCreatesCourseConfirmation;
import com.qait.mindtap.keywords.NG_30104.NG_30181_InstructorCreatesCourseOptionPageActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_InstructorCreatesEditCoursePageActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_InstructorEditCourse;
import com.qait.mindtap.keywords.NG_30104.NG_30181_InstructorPageActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_LoginPageActions;
import com.qait.mindtap.keywords.NG_30104.NG_30181_StudentLaunchCourseAction;
import com.qait.mindtap.keywords.NG_30104.Organization;
import com.qait.mindtap.keywords.NG_30104.ProgressWidget;
import com.qait.mindtap.keywords.NG_30104.UserPage;
import com.qait.mindtap.keywords.NG_30104.WeekWidgetActions;

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
    public NG_30181_InstructorCreatesCourseConfirmation courseConfirmation;
    public NG_30181_InstructorCreatesCourseOptionPageActions courseOptions;
    public NG_30181_InstructorCreatesEditCoursePageActions courseCreateEdit;
    public NG_30181_InstructorEditCourse courseEdit;
    public NG_30181_StudentLaunchCourseAction sso;
    public NG_30181_CoursePaymentActionPage coursePayment;
    public NG_30181_ConfirmCourseInformationActions confirmCourseInfo;
    public UserPage userpage;
    public AdminPerformActionPage adminDashboard;
    public Organization org;
    public LearningActivity la;
    public HeaderActions header;
    public WeekWidgetActions weekwidget;
    public ProgressWidget progress;
    public LearningActivity lpn;
    
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
        courseConfirmation = new NG_30181_InstructorCreatesCourseConfirmation(driver);
        courseOptions = new NG_30181_InstructorCreatesCourseOptionPageActions(driver);
        courseCreateEdit = new NG_30181_InstructorCreatesEditCoursePageActions(driver);
        courseEdit = new NG_30181_InstructorEditCourse(driver);
        sso = new NG_30181_StudentLaunchCourseAction(driver);
        confirmCourseInfo = new NG_30181_ConfirmCourseInformationActions(driver);
        coursePayment = new NG_30181_CoursePaymentActionPage(driver);
        adminDashboard = new AdminPerformActionPage(driver);
        userpage = new UserPage(driver);
        org = new Organization(driver);
        la = new LearningActivity(driver);
        header = new HeaderActions(driver);
        weekwidget = new WeekWidgetActions(driver);
        progress = new ProgressWidget(driver);
        lpn = new LearningActivity(driver);
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
