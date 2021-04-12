package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;   //another class cant modify. IFRAME PROBLEM
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException
	{
		//Data driven properties file
		
		prop = new Properties();
		FileInputStream file= new FileInputStream("E:\\Selenium file\\GitHub\\Real Time Project\\WebsiteTest\\src\\test\\java\\resources\\data.properties");
		prop.load(file);
		String browserName =prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium file\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//Firefox
		}
		else if(browserName.equals("IE"))
		{
			//Internet Explorer fdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShots(String result) throws IOException
	{
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //casting driver to take screenshots
		FileUtils.copyFile(src,new File ("ScreenShots/"+result+"screenshot.png"))  ;
		
	}

}
