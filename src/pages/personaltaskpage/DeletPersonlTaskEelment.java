package pages.personaltaskpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class DeletPersonlTaskEelment
{
    WebDriver driver;
    ResourceBundle propetiesfile = ResourceBundle.getBundle("tamplo5");

    public DeletPersonlTaskEelment(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li/div[4]/button")
    List<WebElement> btneditlisteditcritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li/div[4]/button")
    List<WebElement> btneditlisteditimportnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li/div[4]/button")
    List<WebElement> btneditlisteditlessimportnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li/div[2]/div[1]/a/span")
    List<WebElement> txtactiontitlecritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li/div[2]/div[1]/a/span")
    List<WebElement> txtactiontitleimportnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li/div[2]/div[1]/a/span")
    List<WebElement> txtactiontitlelessimportnant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li/div[3]/span[1]")
    List<WebElement> readdatecritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li/div[3]/span[1]")
    List<WebElement> readdateimpotnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li/div[3]/span[1]")
    List<WebElement> readdatelessimportnant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationcritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationimportnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationlessimportant;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[3]")
    WebElement threedot;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[3]/div/ul/li/a")
    WebElement selectdeleteoption;

    public void clkThreeDot()
    {
        JavascriptExecutor actionlinkexcecute = (JavascriptExecutor)driver;
        actionlinkexcecute.executeScript("arguments[0].click();", threedot);
    }

    public void selectDelteOption()
    {
        JavascriptExecutor actionlinkexcecute = (JavascriptExecutor)driver;
        actionlinkexcecute.executeScript("arguments[0].click();", selectdeleteoption);
    }

    public void editBtnCritical() throws InterruptedException
    {
        AddPersonalTkElement addpersonaltaskelement = new AddPersonalTkElement(driver);
        int usermanagernum = addpersonaltaskelement.getCriticalCount();

        if(usermanagernum!=0)
        {
            try
            {

            int editbuttoncount =  btneditlisteditcritical.size();

            for(int i=1;i<=editbuttoncount;i++)
            {
                WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[2]/div[1]/a/span"));
                String getactiontitle = actiontitle.getText();
                if(getactiontitle.equals(propetiesfile.getString("actiontitlecritcal")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[4]/button")).click();
                    break;
                }
            }
            }catch (Exception actiontitle){System.out.println("Action not present");}
        }else
        {
            System.out.println("No any action present in this section");
        }

    }



    public void editBtnCriticaltest() throws InterruptedException {
        AddPersonalTkElement addpersonaltaskelement = new AddPersonalTkElement(driver);
        int usermanagernum = addpersonaltaskelement.getCriticalCount();
        int peginationcount = paginationcritical.size();

        if (peginationcount != 0)
        {
            if (usermanagernum != 0) {
                try {


                    for (int j = 2; j <= peginationcount + 1; j++)

                    {
                        Thread.sleep(500);
                        int editbuttoncount = btneditlisteditcritical.size();

                        for (int i = 1; i <= editbuttoncount; i++) {
                            Thread.sleep(500);
                            WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[" + i + "]/div[2]/div[1]/a/span"));
                            String getactiontitle = actiontitle.getText();
                            if (getactiontitle.equals(propetiesfile.getString("actiontitlecritcal"))) {
                                Thread.sleep(500);
                                driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[" + i + "]/div[4]/button")).click();
                                break;
                            }
                        }
                        try {

                            threedot.isDisplayed();

                        } catch (Exception elementdisplay) {
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[6]/paging/ul/li[" + j + "]")).click();
                        }

                    }
                } catch (Exception actiontitle) {
                    System.out.println("Action not present");
                }
            } else {
                System.out.println("No any action present in this section");
            }

        }else
        {
            if(usermanagernum!=0)
            {
                try
                {

                    int editbuttoncount =  btneditlisteditcritical.size();

                    for(int i=1;i<=editbuttoncount;i++)
                    {
                        WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[2]/div[1]/a/span"));
                        String getactiontitle = actiontitle.getText();
                        if(getactiontitle.equals(propetiesfile.getString("actiontitlecritcal")))
                        {
                            Thread.sleep(500);
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[4]/button")).click();
                            break;
                        }
                    }
                }catch (Exception actiontitle){System.out.println("Action not present");}
            }else
            {
                System.out.println("No any action present in this section");
            }

        }
    }


    public void editBtnImportnt() throws InterruptedException
    {
        AddPersonalTkElement addpersonaltaskelement = new AddPersonalTkElement(driver);
        int usermanagernum = addpersonaltaskelement.getImportntCount();
        int peginationcount  = paginationimportnt.size();

        if (peginationcount != 0)
        {
        if(usermanagernum!=0) {

                try {
                    for (int j = 2; j <= peginationcount + 1; j++)

                    {
                        Thread.sleep(500);
                        int editbuttoncount = btneditlisteditimportnt.size();

                        for (int i = 1; i <= editbuttoncount; i++) {
                            Thread.sleep(500);
                            WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li[" + i + "]/div[2]/div[1]/a/span"));
                            String getactiontitle = actiontitle.getText();
                            if (getactiontitle.equals(propetiesfile.getString("actiontitleimportant"))) {
                                Thread.sleep(500);
                                driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li[" + i + "]/div[4]/button")).click();
                                break;
                            }
                        }
                        try {

                            threedot.isDisplayed();

                        } catch (Exception elementdisplay) {
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li[6]/paging/ul/li[" + j + "]")).click();
                        }

                    }
                } catch (Exception actiontitle) {
                    System.out.println("Action not present");
                }
            } else {
                System.out.println("No any action present in this section");
            }
        }else
            {
            if(usermanagernum!=0)
            {
                try {

                    int editbuttoncount = btneditlisteditlessimportnt.size();

                    for (int i = 1; i <= editbuttoncount; i++) {
                        WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li["+i+"]/div[2]/div[1]/a/span"));
                        String getactiontitle = actiontitle.getText();
                        if (getactiontitle.equals(propetiesfile.getString("actiontitleimportant")))
                        {
                            Thread.sleep(500);
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li["+i+"]/div[4]/button")).click();
                            break;
                        }
                    }
                }catch (Exception actiontitle){System.out.println("Action not present");}

            }else
            {
                System.out.println("No any action present in this section");
            }


        }
    }


    public void editBtnLessImportntTest() throws InterruptedException
    {
        AddPersonalTkElement addpersonaltaskelement = new AddPersonalTkElement(driver);
        int usermanagernum = addpersonaltaskelement.getLessImportntCount();
        int peginationcount  = paginationlessimportant.size();

        if (peginationcount != 0) {
            if (usermanagernum != 0) {
                try {
                    for (int j = 2; j <= peginationcount + 1; j++)

                    {
                        Thread.sleep(500);
                        int editbuttoncount = btneditlisteditlessimportnt.size();

                        for (int i = 1; i <= editbuttoncount; i++) {
                            Thread.sleep(500);
                            WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li[" + i + "]/div[2]/div[1]/a/span"));
                            String getactiontitle = actiontitle.getText();
                            if (getactiontitle.equals(propetiesfile.getString("actiontitlelessimportant"))) {
                                Thread.sleep(500);
                                driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li[" + i + "]/div[4]/button")).click();
                                break;
                            }
                        }
                        try {

                            threedot.isDisplayed();

                        } catch (Exception elementdisplay) {
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li[6]/paging/ul/li[" + j + "]")).click();
                        }

                    }
                } catch (Exception actiontitle) {
                    System.out.println("Action not present");
                }
            } else {
                System.out.println("No any action present in this section");
            }
        }else {
            if(usermanagernum!=0)
            {
                try {

                    int editbuttoncount = btneditlisteditlessimportnt.size();

                    for (int i = 1; i <= editbuttoncount; i++) {
                        WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li["+i+"]/div[2]/div[1]/a/span"));
                        String getactiontitle = actiontitle.getText();
                        if (getactiontitle.equals(propetiesfile.getString("actiontitlelessimportant")))
                        {
                            Thread.sleep(500);
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li["+i+"]/div[4]/button")).click();
                            break;
                        }
                    }
                }catch (Exception actiontitle){System.out.println("Action not present");}

            }else
            {
                System.out.println("No any action present in this section");
            }
        }

    }

}
