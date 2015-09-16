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

import com.qait.mindtap.keywords.LoginPageActions;
import com.qait.mindtap.keywords.admin.AdminPageActions;

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
    public LoginPageActions loginpage;
    public AdminPageActions adminpage;

    public TakeScreenshot takescreenshot;
    public TopicNamePojo topicNameValue;
    private final String testname;

    public Random randomGenerator;

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        loginpage = new LoginPageActions(driver);
        adminpage = new AdminPageActions(driver);
        topicNameValue = new TopicNamePojo();
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
