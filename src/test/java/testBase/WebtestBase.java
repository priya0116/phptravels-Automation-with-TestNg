package testBase;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class WebtestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public WebtestBase()
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//properties//config.properties");
			prop = new Properties();
			prop.load(fileInputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization() {
        String browserName = prop.getProperty("browser");
        
        
        if (browserName.equals("chrome")){
        	System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Desktop\\Copy\\edubridgepro\\FinalProjectForTesting\\driver\\chromedriver.exe");
        	ChromeOptions options=new ChromeOptions();
        	options.addArguments("--remote-allow-origins=*");
        	driver = new ChromeDriver(options);
    	    driver.navigate().to(prop.getProperty("url"));
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           driver.manage().deleteAllCookies();
        }
}
}


