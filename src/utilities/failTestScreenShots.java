package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class failTestScreenShots
{
    String imageName = null;
    public String failscreenshot(WebDriver  driver,ITestResult result)
    {
        if (ITestResult.FAILURE == result.getStatus())
        {
            try
            {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
                imageName = result.getName() + DateStr + ".png";
                String imagePath = "screenshots/" + imageName;
                FileUtils.copyFile(scrFile, new File(imagePath));

            } catch (Exception e)
            {
                System.out.println("Unable to catch the screenshots");
            }
        }
        return imageName;
    }
}
