package functional.login;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.dashboardpage.DashboardPagElement;
import pages.loginpage.LoginPageElements;
import utilities.DateCoversion;
import utilities.Driver;
import utilities.Reportsextend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static utilities.Reportsextend.test;

/**
 * Created by Admin on 3/20/2018.
 */
public class LoginTest
{
    WebDriver driver;
    String classname = "LoginTest";

    @Test(dataProvider = "testlogin")
    public void commonforlogin(String usernmae,String password)
    {
        driver = Driver.getDriver(Driver.drivertype.Chromedriver);
        Reportsextend ext = new Reportsextend();
        ext.reports(classname);
       // extend = new ExtentReports("Extent-Reports/report.html",false);
        //test = extend.startTest("Script to login to application");

        Reportsextend.test.log(LogStatus.INFO,"Browser open successfully");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        ResourceBundle rb = ResourceBundle.getBundle("resource");
        LoginPageElements loginpge = new LoginPageElements(driver);
        DashboardPagElement landingelement = new DashboardPagElement(driver);
        DateCoversion date22 =  new DateCoversion();


        driver.get(rb.getString("url"));
        loginpge.loginbtnclick();
        loginpge.usernameenter(usernmae);
        Reportsextend.test.log(LogStatus.INFO,"Username entered successfully");
        loginpge.passwordenter(password);
        Reportsextend.test.log(LogStatus.INFO,"password entered successfully");

           loginpge.loginbutton();

         try
         {
               String expected = date22.dateconvert();
               String  actual = landingelement.readdate();
               Assert.assertEquals(actual,expected);
               Reportsextend.test.log(LogStatus.INFO,"Login Successfully");

          }catch (Exception e)
          {
              String actuallabel = "Wrong test username or password.";
              String  failalert = loginpge.lblfailtologin();
              Assert.assertNotEquals(failalert,actuallabel);
              Reportsextend.test.log(LogStatus.INFO,usernmae +" This user not able to login to application System show alert  as '" +failalert);

          }


        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }



    @DataProvider
    public Object[][] testlogin() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\Project\\files\\logindata.xls");
        HSSFWorkbook wrbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = wrbook.getSheet("Sheet1");
        int rowcout  =  sheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowcout-1][2];

        for(int i=1 ;i < rowcout ; i++)
        {
            HSSFRow row = sheet.getRow(i);

            HSSFCell username = row.getCell(0);
            if(username==null)
            data[i-1][0] = "";
            else
                {
                username.setCellType(CellType.STRING);
                data[i-1][0] = username.getStringCellValue();
                }

            HSSFCell password = row.getCell(1);
            if(password==null)
                data[i-1][1] ="";
            else
                {
                password.setCellType(CellType.STRING);
                data[i-1][1]= password.getStringCellValue();
                }
        }
        return data;
    }

}
