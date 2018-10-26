package utilities;

import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class GetActionCount
{
    public  static int Count(WebElement vairblename) throws InterruptedException {
        Thread.sleep(1000);
        String labelname = vairblename.getText();
        String substringdevde = labelname.substring(labelname.length()-3);
        String removeingspace = substringdevde.replaceAll("-","").trim();
        int gettcount = parseInt(String.valueOf(removeingspace));
        return gettcount;

    }
}
