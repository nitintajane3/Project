package functional.landingpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;

import java.util.List;
import java.util.ResourceBundle;

import static functional.login.TestcaseLogin.driver;

public class SelectCompanyTest {


    @Test


    public void selectcompanuydropdown() throws InterruptedException {

        ResourceBundle properties = ResourceBundle.getBundle("config");
        DashboardPagElement dashelement = new DashboardPagElement(driver);
        Thread.sleep(500);
        String  actualcompany=properties.getString("companyname");
        dashelement.dropdowncompany();
        List<WebElement> compnycount = driver.findElements(By.xpath("//*[@id='jq-dropdown-3']/ul/li"));
        Thread.sleep(200);
        int activecompnycount = compnycount.size();
        for(int i=1;i<=activecompnycount;i++)
        {
            Thread.sleep(200);
            try {

                WebElement readcompanyname = driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]"));
                String getcompanyname = readcompanyname.getText();
                System.out.println("list of company = " + getcompanyname);
                if (getcompanyname.equals(actualcompany)) {
                    driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]/a")).click();
                    System.out.println("click on expected company");

                }
            }catch (Exception e44){
                System.out.println("condition not match");
            }
        }

    }
}
