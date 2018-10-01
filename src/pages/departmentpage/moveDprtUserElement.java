package pages.departmentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.departmentpage.DeptUserActiveDeactiveElement;


import java.util.List;
import java.util.ResourceBundle;

public class moveDprtUserElement
{
    WebDriver driver;
    ResourceBundle rb = ResourceBundle.getBundle("tamplo5");



    public moveDprtUserElement(WebDriver driver)
    {
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[1]")
    WebElement clickonusericon;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[1]/tamplo-icon-select/span/div/ul/li/a")
    WebElement choicefirstoption;


    public void btnMveToDprtMember()
    {
        WebDriverWait waitest = new WebDriverWait(driver,3);
        waitest.until(ExpectedConditions.elementToBeClickable(clickonusericon));
        clickonusericon.click();

        choicefirstoption.click();
    }

    public void btnMveToDprtManager()
    {
        WebDriverWait waitest = new WebDriverWait(driver,3);
        waitest.until(ExpectedConditions.elementToBeClickable(clickonusericon));
        clickonusericon.click();

        choicefirstoption.click();
    }



    public String managerEditButton() throws InterruptedException
    {
        DeptUserActiveDeactiveElement dptactiveuserelement = new DeptUserActiveDeactiveElement(driver);

        int usermanagernum = dptactiveuserelement.activeManagerDptcnt();
        String returnusername = null;
        if(usermanagernum!=0)
        {
            int countusername =  dptactiveuserelement.listofusername.size();

            for(int i=1;i<=countusername;i++)
            {
                WebElement getusrname = driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[2]/span"));
                String readusername = getusrname.getText();
                if(readusername.equals(rb.getString("removeusername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[4]/button")).click();
                    returnusername=readusername;
                    break;
                }

                returnusername = "No User present in Department manager level";
            }


        }else
        {
            System.out.println("No User present in Department manager level");
            returnusername = "No User present in Department manager level";
        }


        return returnusername;
    }


    public String memberEditButton() throws InterruptedException
    {
        DeptUserActiveDeactiveElement dptactiveuserelement2 = new DeptUserActiveDeactiveElement(driver);
        int usermembernum = dptactiveuserelement2.activeMemberDptCont();
        String returnmembername = null;
        if(usermembernum!=0)
        {
            int countmembername =  dptactiveuserelement2.listofmembername.size();

            for(int i=1;i<=countmembername;i++)
            {
                WebElement getmembername = driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[2]/span"));
                String readmembername = getmembername.getText();
                if(readmembername.equals(rb.getString("removeusername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[4]/button")).click();
                    returnmembername = readmembername;
                    break;
                }
                returnmembername = "No User present in Department member level";
            }


        }else
        {
            System.out.println("No User present in Department member level");
            returnmembername = "No User present in Department member level";
        }


        return returnmembername;
    }


}
