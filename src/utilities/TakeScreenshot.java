package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 3/17/2018.
 */
public class TakeScreenshot {
    public static String takeScreenshot(WebDriver driver) throws IOException
    {
        String imageName = null;

            try
            {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
                imageName = "screenshot" + DateStr + ".png";
                String imagePath = "screenshots/" + imageName;
                FileUtils.copyFile(scrFile, new File(imagePath));
            } catch (Exception e)
            {
                System.out.println("not able to take screenshot " + e);
            }
            return imageName;
    }

}
