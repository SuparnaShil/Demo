package PracticeProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	@BeforeTest
	public void initial() throws IOException
	{
		driver =InitializeDriver();
		driver.get(prop.getProperty("URL")); //Data provider annotation
	}	
 
	@Test
	public void basePageNavigation() 
	{
		
		LandingPage land =new LandingPage(driver);
		
		Assert.assertEquals(land.checkTitle().getText(),"FEATURED COURSES" );
		//Assert.assertTrue("", true);
		System.out.println(land.checkTitle().getText());
	}
	@AfterTest
	public void Ending()
	{
		driver.close();
	}
}
