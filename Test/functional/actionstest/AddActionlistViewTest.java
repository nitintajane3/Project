package functional.actionstest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddActionslistViewElement;
import pages.actionspage.AddactionProjectElement;
import pages.dayplanpage.DyplnMveActionElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import static functional.dayplantest.DayPlanAddactionTest.dashboardpage;
import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class AddActionlistViewTest
{


    NewExtendReport addpersonaltask =  new NewExtendReport();
    AddActionslistViewElement actionlistelmnt = new AddActionslistViewElement(driver);
    AddactionProjectElement actionelment = new AddactionProjectElement(driver);
    OvrViewAddPesnalTaskElement overviewpersonalTask = new OvrViewAddPesnalTaskElement(driver);
    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);

    @BeforeTest
    public void loginTest() throws InterruptedException
    {
        addpersonaltask.newReport("Add action into action list view","Action_Add_Action_into_listview_Report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkActionPage() throws InterruptedException
    {
        logger1 =  extent.createTest("Open the Action page ");

        dashboardpage.lnkaction();

        logger1.log(Status.PASS,MarkupHelper.createLabel("Successfully click on Action Module",ExtentColor.GREEN));

        Thread.sleep(500);

        actionlistelmnt.linkListView();

        logger1.log(Status.PASS,MarkupHelper.createLabel("Successfully open the list view",ExtentColor.GREEN));

        dayplanelements.clickMyAction();

        extent.flush();
    }

    @Test(priority = 2)
     public void addCriticalAction() throws InterruptedException
    {
        logger2 =  extent.createTest("Add Action into critical section ");

        Thread.sleep(800);

        int beforecriticalcount = actionlistelmnt.getCountCritical();

        logger2.log(Status.PASS,MarkupHelper.createLabel("before adding action, Critical count is = " + beforecriticalcount ,ExtentColor.GREEN));

        actionelment.btnaddcriticalaction();


       logger2.log(Status.PASS,MarkupHelper.createLabel("Successfully click on add critical button",ExtentColor.GREEN));

        addActionDetails(logger2);

        int aftercriticalcount= actionlistelmnt.getCountCritical();

        logger2.log(Status.PASS,MarkupHelper.createLabel("after adding action, Critical count is = " + aftercriticalcount ,ExtentColor.GREEN));

        extent.flush();
}


    @Test(priority = 3)
    public void addImportantAction() throws InterruptedException
    {

        logger3 =  extent.createTest("Add Action into importnant section ");

        int beforeimportnantcount = actionlistelmnt.getCountImportant();

        logger3.log(Status.PASS,MarkupHelper.createLabel("before adding action, important count is = " + beforeimportnantcount ,ExtentColor.GREEN));

        Thread.sleep(500);

        actionelment.btnaddimportntaction();

        logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully click on add important button",ExtentColor.GREEN));

        addActionDetails(logger3);

        int afterimportnantcount = actionlistelmnt.getCountImportant();

        logger3.log(Status.PASS,MarkupHelper.createLabel("after adding action, important count is = " + afterimportnantcount ,ExtentColor.GREEN));

        extent.flush();
    }


    @Test(priority = 4)
    public void addLessImportantAction() throws InterruptedException
    {
        logger4 =  extent.createTest("Add Action into less important section ");

        int beforelessimportnantcount = actionlistelmnt.getCountLessImportant();

        logger4.log(Status.PASS,MarkupHelper.createLabel("before adding action,less important count is = " + beforelessimportnantcount ,ExtentColor.GREEN));

        Thread.sleep(500);

        actionelment.btnaddlessimportantaction();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Successfully click on add less important button",ExtentColor.GREEN));

        addActionDetailsLessImportant(logger4);

        int afterlessimportnantcount = actionlistelmnt.getCountLessImportant();

        logger4.log(Status.PASS,MarkupHelper.createLabel("after adding action, less important count is = " + afterlessimportnantcount ,ExtentColor.GREEN));

        extent.flush();
    }


    public void addActionDetails(ExtentTest loggername) throws InterruptedException
    {
        try {
            actionelment.enterActiontitle();

            loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully enter the action title", ExtentColor.GREEN));

            overviewpersonalTask.selectTodayDate();

            loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully select the due date", ExtentColor.GREEN));

            Thread.sleep(500);

            actionlistelmnt.selectproject();

            loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully select the project", ExtentColor.GREEN));

            Thread.sleep(500);

            actionlistelmnt.selectactionassigneename();

            loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully select the assignee", ExtentColor.GREEN));

            actionelment.clicksaveaction();

            loggername.log(Status.PASS, MarkupHelper.createLabel("Successfully add the action", ExtentColor.GREEN));
        }catch (Exception elementnotfund)
        {
            try
            {
                actionlistelmnt.btnOk();

            }catch (Exception cancelclick)
            {

              actionlistelmnt.btnCancel();

            }
        }
    }

    public void addActionDetailsLessImportant(ExtentTest loggername) throws InterruptedException
    {
        try
        {
        actionelment.enterActiontitle();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully enter the action title",ExtentColor.GREEN));

        overviewpersonalTask.selectTodayDate();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the due date",ExtentColor.GREEN));

        Thread.sleep(500);

        actionlistelmnt.selectprojectlessimportant();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the project",ExtentColor.GREEN));

        Thread.sleep(500);

        actionlistelmnt.selectactionassigneenamelessimportant();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the assignee",ExtentColor.GREEN));

        actionelment.clicksaveaction();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully add the action",ExtentColor.GREEN));

    }catch (Exception elementnotfund)
    {
        try
        {
            actionlistelmnt.btnOk();

        }catch (Exception cancelclick)
        {

            actionlistelmnt.btnCancel();

        }
    }
    }

}
