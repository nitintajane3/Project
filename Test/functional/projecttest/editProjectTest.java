package functional.projecttest;

import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.projectpage.EditProjectElement;

import java.util.concurrent.TimeUnit;

import static functional.login.TestcaseLogin.driver;

public class editProjectTest {


    @Test
    public void EditProject() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TestcaseLogin logintest = new TestcaseLogin();

        logintest.validlogintest();
        Thread.sleep(300);
        SelectCompanyTest selectcompy = new SelectCompanyTest();
        selectcompy.selectcompanuydropdown();
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);
        EditProjectElement editprojectelement = new EditProjectElement(driver);
        Thread.sleep(300);
        dashboardpage.lnkprojects();
        Thread.sleep(200);
        editprojectelement.clickprojectfirst();



    }
}
