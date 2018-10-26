package pages.personaltaskpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class ChangeDueDatePersonalTaskElement
{
    WebDriver driver;
    ResourceBundle propetiesfile = ResourceBundle.getBundle("tamplo5");

    public ChangeDueDatePersonalTaskElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationcritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationimportnt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li[6]/paging/ul/li")
    List<WebElement> paginationlessimportant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li/div[3]/span[2]")
    List<WebElement> btnduedatecritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/div/ul/li/div[3]/span[2]")
    List<WebElement> btnduedateimportant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/div/ul/li/div[3]/span[2]")
    List<WebElement> btnduedatelessimportant;


    public String editBtnCriticaltest() throws InterruptedException {
        AddPersonalTkElement addpersonaltaskelement = new AddPersonalTkElement(driver);
        String readduedate  = null;
        int usermanagernum = addpersonaltaskelement.getCriticalCount();
        int peginationcount = paginationcritical.size();

        if (peginationcount != 0)
        {
            if (usermanagernum != 0) {
                try {


                    for (int j = 2; j <= peginationcount + 1; j++)

                    {
                        Thread.sleep(500);
                        int editbuttoncount = btnduedatecritical.size();

                        int i;
                        for (i = 1; i <= editbuttoncount; i++) {
                            Thread.sleep(500);
                            WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li[" + i + "]/div[2]/div[1]/a/span"));
                            String getactiontitle = actiontitle.getText();
                            if (getactiontitle.equals(propetiesfile.getString("actiontitlecritcal"))) {
                                Thread.sleep(500);
                                WebElement gettext  = driver.findElement(By.xpath(""));
                                readduedate = gettext.getText();
                                driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[3]/span[2]/button")).click();
                                break;
                            }
                        }
                        try {

                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[3]/span[2]/div/table")).isSelected();

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

                    int editbuttoncount =  btnduedatecritical.size();

                    for(int i=1;i<=editbuttoncount;i++)
                    {
                        WebElement actiontitle = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[2]/div[1]/a/span"));
                        String getactiontitle = actiontitle.getText();
                        if(getactiontitle.equals(propetiesfile.getString("actiontitlecritcal")))
                        {
                            Thread.sleep(500);
                            driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/div/ul/li["+i+"]/div[3]/span[2]/button")).click();
                            break;
                        }
                    }
                }catch (Exception actiontitle){System.out.println("Action not present");}
            }else
            {
                System.out.println("No any action present in this section");
            }

        }
    return readduedate;
    }


}
