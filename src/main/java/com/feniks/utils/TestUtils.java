package com.feniks.utils;

import com.feniks.core.BaseTestTemplate;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtils extends BaseTestTemplate {

    public static String takeAndSaveScreenShot(String testCaseName, WebDriver driver) throws IOException {

    //test
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFileName = System.getProperty("user.dir")+"\\reports\\"+ DateTime.now().getMillis()+"_"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFileName));
        return destinationFileName;
    }


}
