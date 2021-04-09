package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By sign =By.cssSelector("a[href*='sign_in']");
	By title= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By nav= By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement SignIn()
	{
		return driver.findElement(sign);
	}
	
	public WebElement checkTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement checkNavBar()
	{
		return driver.findElement(nav);
	}
}
