package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdownselect
{
    public void dropDownlist(WebElement element,String visibletext)
    {
        Select drpdown =  new Select(element);
        drpdown.selectByVisibleText(visibletext);
    }
}
