package pages.dayplanpage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class RemoveDayPlanActionsElement
{
    WebDriver driver;
    ResourceBundle propertiesfile = ResourceBundle.getBundle("tamplo5");
    public RemoveDayPlanActionsElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void editBtnTest(int importancenumber, ExtentTest logervariblename, String expectedactiontitle) throws InterruptedException  // we pass critical 1 and important 2, less important 3 when we accessing this method
    {
        List<WebElement> btnlistofremove = driver.findElements(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div["+importancenumber+"]/div[2]/ul/li/div[5]/button[2][@class='btnIcon icon icon-ic-remove']"));
        int btnsremove =  btnlistofremove.size();
        int sumofremovebtn = Integer.sum(btnsremove , 1); //if list contains only one action and that action does not match
        // with expected action name to logg the catch condition like  not found

        if(btnsremove!=0)
            {
                try
                {
                    for(int i=1;i<=sumofremovebtn;i++)
                    {
                        WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div["+importancenumber+"]/div[2]/ul["+i+"]/li/div[3]/div[1]/a/span"));
                        String getactiontitle = actiontitle.getText();
                        if(getactiontitle.equals(expectedactiontitle))
                        {
                            Thread.sleep(500);
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div["+importancenumber+"]/div[2]/ul["+i+"]/li/div[5]/button[2]")).click();
                            logervariblename.log(Status.PASS, MarkupHelper.createLabel("Successfully remove the action", ExtentColor.GREEN));
                            break;
                        }
                    }
                }catch (Exception actiontitle)
                {System.out.println("Action not present");
                    logervariblename.log(Status.PASS, MarkupHelper.createLabel("Action not found", ExtentColor.GREEN));
                }
            }else
            {
                System.out.println("No any action present in Day plan");
                logervariblename.log(Status.PASS, MarkupHelper.createLabel("No any action present in Day plan", ExtentColor.GREEN));
            }
    }
}
