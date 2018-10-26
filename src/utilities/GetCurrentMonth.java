package utilities;

import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class GetCurrentMonth
{
    public  static String Month(WebElement vairblename) throws InterruptedException {
        Thread.sleep(1000);
        String labelname = vairblename.getText();
        String substringdevde = labelname.substring(0,3);
        String removeingspace = substringdevde.replaceAll("-","").trim();
        return removeingspace;

    }
}
