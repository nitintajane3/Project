package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Admin on 3/17/2018.
 */
public class Driver {
    private  static WebDriver MyDriver;

    public enum   drivertype
    {
        Chromedriver, Firefoxdriver, IEbrowser
    }

    public static WebDriver getDriver(drivertype d)
    {

        switch (d)
        {
            case Chromedriver:
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\Project\\Browsers\\chromedriver.exe");
                MyDriver = new ChromeDriver();
                MyDriver.manage().window().maximize();
                break;

            case Firefoxdriver:
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\IdeaProjects\\Project\\Browsers\\geckodriver.exe");
                MyDriver =  new FirefoxDriver();
                //MyDriver.manage().window().maximize();

                break;

            case IEbrowser:
                System.setProperty("webdriver.ie.driver","browsers/IEDriverServer.exe");
                MyDriver = new InternetExplorerDriver();
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                break;
        }
        return MyDriver;
    }
}
