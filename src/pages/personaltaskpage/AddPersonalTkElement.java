package pages.personaltaskpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPersonalTkElement
{
    WebDriver  driver;

    public AddPersonalTkElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[1]/h2[@class='headingprojectPriority ng-binding']")
    WebElement criicallable;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[1]/h2[@class='headingprojectPriority ng-binding']")
    WebElement impotyntlabel;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[1]/h2[@class='headingprojectPriority ng-binding']")
    WebElement lessimportntlabel;

    public int getCriticalCount()
    {
        String critcallabelnname = criicallable.getText();
        String substringdevde = critcallabelnname.substring(critcallabelnname.length()-2);
        String removeingspace = substringdevde.replaceAll("-","").trim();
        int criticalcount = Integer.parseInt(String.valueOf(removeingspace));
        System.out.println("list of critical personal task count = " + criticalcount);
        return criticalcount;

    }

    public int getImportntCount()
    {
        String importntlabelname = impotyntlabel.getText();
        String substringdevde = importntlabelname.substring(importntlabelname.length()-2);
        String removeingspace = substringdevde.replaceAll("-","").trim();
        int importntcount = Integer.parseInt(String.valueOf(removeingspace));
        System.out.println("list of important personal task count = " + importntcount);
        return importntcount;

    }

    public int getLessImportntCount()
    {
        String lessimportntlabelname = lessimportntlabel.getText();
        String substringdevde = lessimportntlabelname.substring(lessimportntlabelname.length()-2);
        String removeingspace = substringdevde.replaceAll("-","").trim();
        int lessimportntcount = Integer.parseInt(String.valueOf(removeingspace));
        System.out.println("list of less important personal task count = " + lessimportntcount);
        return lessimportntcount;

    }



}
