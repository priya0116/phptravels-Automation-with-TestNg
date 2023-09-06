package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.WebtestBase;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class Utility extends WebtestBase {
	public static void selectValue(WebElement element, String term, String value) {
		// TODO Auto-generated method stub
		Select dropDown=new Select(element);
		if(term.equalsIgnoreCase("byValue")){
            dropDown.selectByValue(value);
        }else if(term.equalsIgnoreCase("byIndex")){
            dropDown.selectByIndex(Integer.parseInt(value));
        }else if(term.equalsIgnoreCase("byVisibleText")){
            dropDown.selectByVisibleText(value);
        }else{
            System.out.println("Please select the correct value");
        }
	}
	public static void mouseHover(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element)
                .build()
                .perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   }
	public static void scrollDownByElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
	
	public static void scrollUp(WebDriver driver) {
		
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,800)");
		javascriptExecutor.executeScript("window.scrollBy(0,-800)");
	}
	
	public static void getScreenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		//taking screenshot and storing it in the temporary file
		File source=tk.getScreenshotAs(OutputType.FILE);
		//creating destination file
		//File des=new File("D:/nurserylive.png");"./screenshots/" + fileName
		File des=new File("/FinalProjectForTesting/screenshot1");
		//moving the file from source to destination
		FileUtils.copyFile(source,des);
		
	}
	public static void switchToWindows(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		String parentWindow=driver.getWindowHandle();
		Set<String> allwindow=driver.getWindowHandles();
		for(String s : allwindow) {
			if(!parentWindow.contentEquals(s)) {
				driver.switchTo().window(s);
				Thread.sleep(5000);
				driver.close();
			}
			
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);		
	}
	public static void getCookies() {
		// TODO Auto-generated method stub
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie c : cookies)
		{
			System.out.println(c);
		}
	
}
}
