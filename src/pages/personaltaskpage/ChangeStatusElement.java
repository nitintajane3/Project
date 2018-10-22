package pages.personaltaskpage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

import static utilities.NewExtendReport.logger;

public class ChangeStatusElement
{
    WebDriver  driver;
    ResourceBundle propetiesfile = ResourceBundle.getBundle("tamplo5");
    public ChangeStatusElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = " //ul/li/div[4]/span[2]/tamplo-icon-select")
    WebElement statusicon;

    @FindBy(xpath = "//ul/li/div[4]/span[2]/tamplo-icon-select/span/div/ul/li")
    List<WebElement> listofstatus;

    @FindBy(xpath = "//ul/li/div[4]/span[2]/tamplo-icon-select/span/div/ul/li[@class='ng-scope selected']")
    WebElement selectedstatus;





    public void  selectStatus(ExtentTest loggername)
    {
        int countstatuslist = listofstatus.size();

        String getselectstutsname = selectedstatus.getText();


        for(int i = 1;i<= countstatuslist;i++)
        {
            String  getstatusname = driver.findElement(By.xpath("//ul/li/div[4]/span[2]/tamplo-icon-select/span/div/ul/li["+i+"]")).getText();

            if(getselectstutsname.equals(getstatusname))
            {
               System.out.println("This status already selected");
               loggername.log(Status.PASS, MarkupHelper.createLabel(getselectstutsname + " This status already selected", ExtentColor.RED));

            }else
            {
                if(getstatusname.equals(propetiesfile.getString("personaltaskstatus")))
                {
                    driver.findElement(By.xpath("//ul/li/div[4]/span[2]/tamplo-icon-select/span/div/ul/li[" + i + "][@class='ng-scope']")).click();
                    loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully select the " +propetiesfile.getString("personaltaskstatus")+ " status", ExtentColor.GREEN));
                    break;
                }else {
                    System.out.println("Status name not  match");

                }
            }

        }
    }


    public void btnStatusList()
    {

      statusicon.click();

    }
}
