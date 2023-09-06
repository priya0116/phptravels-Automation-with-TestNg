package pages;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebtestBase;
import utils.Utility;

public class MyAccountPage extends WebtestBase {
	@FindBy(xpath = "//*[@id=\"mynavbar\"]/ul/li[1]/a")
    WebElement hover;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[1]/div[2]/a[4]/svg")
    WebElement youtubeOption;
	
	public MyAccountPage(){
        PageFactory.initElements(driver, this);
    }
	
	public void mouseHover() {
		Utility.mouseHover(driver,hover);
	}
	public void getScreenshot() throws IOException {
		Utility.getScreenshot();
	}
public void verifyGetWindowhandle() throws InterruptedException {
		
		Utility.scrollDownByElement(driver,youtubeOption);
		youtubeOption.click();
		Utility.switchToWindows(driver);
}
public void getCookiesHandle() {
	// TODO Auto-generated method stub
	Utility.getCookies();
	
}
}

	
