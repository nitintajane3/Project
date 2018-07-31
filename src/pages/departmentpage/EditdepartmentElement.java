package pages.departmentpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditdepartmentElement {

    WebDriver  driver;

    public EditdepartmentElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[1]/section/nav/div/ul/li[9]/ul/li[1]/label/a")
    WebElement getdepartmentname;




}
