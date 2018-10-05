package pages.projectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class RemoveProjectElement
{
    WebDriver driver;
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");
    public RemoveProjectElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[1]/div")
    List<WebElement> listofrecentproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div")
    List<WebElement> listofallproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div/div[1]/div[1]/h2/span")
    WebElement isrecentpresent;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div[1]/div[1]/h2/span")
    WebElement isallviewpresent;

    public String clkThreeDotProjectName() throws InterruptedException {

        String returnprojectname = null;

        try
        {
            Thread.sleep(1000);

            isrecentpresent.isDisplayed();

            int recentcount = listofrecentproject.size();

            for (int i = 2; i <= recentcount; i++)
            {
                WebElement nameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div["+i+"]/header/h3/a"));

                String getdptname = nameread.getText();

                System.out.println("get deparmtent name  from recent view" + getdptname);

                if (proertiflename.getString("projectname").equals(getdptname))
                {
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div["+i+"]/header/div[1]/span[2]")).click();
                    System.out.println("successfully click on all view of this  department" + getdptname);
                    returnprojectname = getdptname;
                    break;
                }
            }
            // returnprojectname = "No project found";
            //driver.findElement(By.xpath("//div[@id='drop-down-project-action-120262-2399']/ul/li[1]/a")).click();
            driver.findElement(By.xpath("//h3[@title='" + returnprojectname + "']/preceding-sibling::div[@class='itemOverflush']/span[2]/div/ul/li[2]/a[text()='REMOVE']")).isDisplayed();
        }catch (Exception retu)
        {
            try
            {
                Thread.sleep(1000);

                isallviewpresent.isDisplayed();

                int allcunt = listofallproject.size();

                for (int j = 2; j <= allcunt; j++)
                {
                    WebElement allnameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div["+j+"]/header/h3/a"));

                    String getallprojctname = allnameread.getText();

                    System.out.println("get deparmtent name  from recent view" + getallprojctname);

                    if (proertiflename.getString("projectname").equals(getallprojctname))
                    {
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div["+j+"]/header/div/span[2]")).click();
                        System.out.println("successfully click on all view of this  department" + getallprojctname);
                        returnprojectname = getallprojctname;
                        break;
                    }

                }

            }catch (Exception testmail)
            {
                System.out.println("Project name not found");
                returnprojectname = "No project found";
            }

        }


        return  returnprojectname;
    }

}
