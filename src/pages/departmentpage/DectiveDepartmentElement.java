package pages.departmentpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DectiveDepartmentElement {

    WebDriver  driver;

    public DectiveDepartmentElement(WebDriver driver)
    {
        this.driver =  driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='dropdown-content show']/ul/li[3]/a")
    WebElement deactivatedpertmrrnt;

    @FindBy(xpath = "//div[@class='swal-footer']/div[2]/button")
    WebElement confombtn;

    @FindBy(xpath = "//div[@class='swal-footer']/div[1]/button")
    WebElement cancelbtn;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement onbutton;

    @FindBy(xpath = "//ul[@class='labelWithDropDownList']/li[2]/label")
    WebElement openinactivatedptlist;

    @FindBy(xpath = "//div[@class='dropdown-content show']/ul/li[2]/a")
    WebElement activatedpt;

    public void makeActivateDpt()
    {
        activatedpt.click();
    }


    public void deactivateDptDetails()
    {
        openinactivatedptlist.click();
    }

    public void clickDeactivateBtn()
    {
        deactivatedpertmrrnt.click();
    }

    public void confirmBtn()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        executor.executeScript("arguments[0].click();", confombtn);

    }
    public void cencelBtn()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", cancelbtn);
    }

    public void okBtn()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        js.executeScript("arguments[0].click();", onbutton);
    }



}
