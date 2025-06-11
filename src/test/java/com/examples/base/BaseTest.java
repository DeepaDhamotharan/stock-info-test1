package com.examples.base;

import com.examples.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(ExtentReportManager.class)
public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(this.getClass());
    protected ExtentTest extentTest;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser, ITestContext context) {
        logger.info("Setting up WebDriver and browser: " + browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                logger.warn("Browser not specified or invalid. Defaulting to Chrome.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        logger.info("Browser launched and maximized.");
    }

    @AfterClass
    public void tearDown(ITestContext context) {
        logger.info("Tearing down WebDriver and browser.");
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        } else {
            logger.warn("WebDriver instance was null, nothing to quit.");
        }
    }
}
