package pages.personaltaskpage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class ChangeImportancePersnalTaskElement
{
    WebDriver driver;
    ResourceBundle propetiesfile = ResourceBundle.getBundle("tamplo5");

    public ChangeImportancePersnalTaskElement(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul/li/div[4]/span[1]/tamplo-icon-select/span/div/ul/li")
    List<WebElement> listofimportance;


    @FindBy(xpath = "//ul/li/div[4]/span[1]/tamplo-icon-select/span")
    WebElement importanceicon;

    @FindBy(xpath = "//ul/li/div[4]/span[1]/tamplo-icon-select/span/div/ul/li[@class='ng-scope selected']")
    WebElement selectedimportance;

    public void btnImportance()
    {
        importanceicon.click();
    }

    public void  selectImportance(ExtentTest loggername)
    {
        int countimportancelist = listofimportance.size();

        String getselectimportantname = selectedimportance.getText();


        for(int i = 1;i<= countimportancelist;i++)
        {
            String  getimportancename = driver.findElement(By.xpath("//ul/li/div[4]/span[1]/tamplo-icon-select/span/div/ul/li["+i+"]")).getText();

            if(getselectimportantname.equals(getimportancename))
            {
                System.out.println("This Importance already selected");
                loggername.log(Status.PASS, MarkupHelper.createLabel(getselectimportantname + " This Importance already selected", ExtentColor.RED));

            }else
            {
                if(getimportancename.equals(propetiesfile.getString("personaltaskimportance")))
                {
                    driver.findElement(By.xpath("//ul/li/div[4]/span[1]/tamplo-icon-select/span/div/ul/li[" + i + "][@class='ng-scope']")).click();
                    loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully select the " +propetiesfile.getString("personaltaskimportance")+ " importance", ExtentColor.GREEN));
                    break;
                }else {
                    System.out.println("importance name not  match");

                }
            }

        }
    }

}
