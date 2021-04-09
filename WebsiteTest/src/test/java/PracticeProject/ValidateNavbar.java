package PracticeProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;



public class ValidateNavbar extends Base {
	
	@BeforeTest
	public void initial() throws IOException
	{
		driver =InitializeDriver();
		driver.get(prop.getProperty("URL")); //Data provider annotation
	}	
	@Test
	public void BasepageNavbar() {
	
	LandingPage land =new LandingPage(driver);
    Assert.assertTrue(land.checkNavBar().isDisplayed());
    System.out.println("Ok");
	}
	
	@AfterTest
	public void Ending()
	{
		driver.close();
	}
}
 