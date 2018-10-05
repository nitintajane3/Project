package functional.projecttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.projectpage.EditProjectElement;
import pages.projectpage.RemoveProjectElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class RemoveProjectTest
{
    NewExtendReport deleteprojectreport =  new NewExtendReport();
    EditProjectTest editprojcttest = new EditProjectTest();
    EditProjectElement editprojectelement = new EditProjectElement(driver);
    RemoveProjectElement removeprojctelement = new RemoveProjectElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        deleteprojectreport.newReport("Remove project test","Remove_project_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }

    @Test
    public void removeProjectTest() throws InterruptedException
    {
        editprojcttest.openProjectDetails();

        logger2 =  extent.createTest("Remove Project Test");

        String getpjctname = editprojectelement.clkProjectName();

        System.out.println("project name = " + getpjctname);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//h3[@title='" + getpjctname + "']/preceding-sibling::div[@class='itemOverflush']/span[2]/div/ul/li[2]/a[text()='REMOVE']")).click();

        logger2.log(Status.PASS, MarkupHelper.createLabel(getpjctname + " = This project select for Remove ", ExtentColor.GREEN));

        extent.flush();
    }
}
