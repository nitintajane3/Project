package pages.departmentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class EditdepartmentElement
{

    WebDriver driver;

    ResourceBundle bundlename = ResourceBundle.getBundle("tamplo5");

    @FindBy(xpath = "//div[@class='tamplo-projectInfoContainer']/header/div/div/h1/textarea")
    WebElement namedepartment;

    @FindBy(xpath = "//div[@class='dropdown-content show']/ul/li[1]/a")
    WebElement editdpertmrrnt;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/h5")
    WebElement outsideCLick;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContent projectInfoContent ng-scope']/div/button")
    WebElement adddeprtmanager;

    @FindBy(xpath = "//input[@id='userQuery']")
    WebElement usertextfield;

    @FindBy(xpath = "//div[@class='swal-overlay swal-overlay--show-modal']/div/div[2][text()='Already added to this department.']")
    WebElement readduplicatetext;

    @FindBy(xpath = "//div[@class='swal-overlay swal-overlay--show-modal']/div/div[2][text()='User added successfully!']")
    WebElement readuseraddedtext;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div/div/button[2][text()='Cancel']")
    WebElement clickcancelbtn;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div/div/button[2][text()='Cancel']")
    WebElement clickCancelbtnmember;

    public void userAddsucess()
    {
        readuseraddedtext.isDisplayed();
        driver.findElement(By.xpath("//button[text()='OK']")).click();
    }

    public void userDuplicateAlert()
    {
        readduplicatetext.isDisplayed();
    }
    public void btnCancelManager()
    {
        WebDriverWait waitest = new WebDriverWait(driver,20);
        waitest.until(ExpectedConditions.elementToBeClickable(clickcancelbtn));
        clickcancelbtn.click();
    }

    public void btnCanceMember()
    {
        WebDriverWait waitest = new WebDriverWait(driver,20);
        waitest.until(ExpectedConditions.elementToBeClickable(clickCancelbtnmember));
        clickCancelbtnmember.click();
    }

    public void textAddManager()
    {
        usertextfield.sendKeys("nitin.tajane@tutanota.com");
    }

    public void btnAddDeptManager()
    {
        adddeprtmanager.click();
    }

    public void clickOutSide()
    {
        outsideCLick.click();
    }


    public void clickEditBtn()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", editdpertmrrnt);
        //editdpertmrrnt.click();
    }

    public EditdepartmentElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickDeptName()
    {
        namedepartment.click();
    }

    public void sendDepartment()
    {
        namedepartment.clear();
        namedepartment.sendKeys(bundlename.getString("updatedepartmnae"));
    }




}
