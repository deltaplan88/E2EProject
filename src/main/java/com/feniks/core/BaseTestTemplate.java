package com.feniks.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@org.testng.annotations.Listeners(com.feniks.core.Listeners.class)
public class BaseTestTemplate {

    protected static WebDriver driver = null;
    public static Logger log = LogManager.getLogger(BaseTestTemplate.class.getName());


    @BeforeTest
    public WebDriver initializeLocalDriver() throws IOException {

        String browserName = null,  browserNameFromConfig = null, browserNameFromMVN = null;

        Properties props = new Properties();

        props.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\feniks\\data.properties"));

        browserNameFromConfig = props.getProperty("browser");
        browserNameFromMVN = System.getProperty("browser");  //taking from maven command line parameter


        log.info("***BrowserName from Maven was = " +browserNameFromMVN);

        if (StringUtils.isNotEmpty(browserNameFromMVN)) {
            browserName  = browserNameFromMVN;
        } else {
            browserName =  browserNameFromConfig;
        }

        log.info("Browser was selected " +browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\webdrivers\\chrome\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\webdrivers\\firefox\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("You can only select  chrome or firefox for now");
        }
        //String timeout = props.getProperty("implicitlyWaitTimeout");
        //driver.manage().timeouts().implicitlyWait(Integer.valueOf(timeout), TimeUnit.SECONDS);
         return driver;

    }



    @AfterTest
    public void after () {
      /*  if (driver!=null)
            driver.quit();*/
    }

}
