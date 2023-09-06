package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebtestBase;

public class LoginPage extends WebtestBase {
	 @FindBy(xpath = "//*[@id=\"inputEmail\"]")
	    WebElement emailTextBox;

	    @FindBy(xpath = "//*[@id=\"inputPassword\"]")
	    WebElement passwordTextBox;

	    @FindBy(xpath = "//*[@id=\"login\"]")
	    WebElement loginbtn;

	    @FindBy(xpath = "//*[@id=\"mynavbar\"]/div/a[1]")
	    WebElement loginclick;
	    
	    public LoginPage(){
	    	//used for creating webelements
	        PageFactory.initElements(driver, this);
	    }
//sending the email and passwrord to the login
	    public void login(String mobile, String password){
	    	loginclick.click();
	        emailTextBox.sendKeys(mobile);
	        passwordTextBox.sendKeys(password);
	        loginbtn.click();
	    }

}	


