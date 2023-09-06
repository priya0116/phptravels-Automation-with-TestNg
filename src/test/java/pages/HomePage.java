package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebtestBase;

public class HomePage extends WebtestBase{

	@FindBy(id = "ctl00_lblUser")
    WebElement usersearch;
//creating web elements
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

  
    public void userSearchClick(){
        usersearch.click();
    }
}