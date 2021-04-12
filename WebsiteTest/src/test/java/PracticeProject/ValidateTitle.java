package PracticeProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	public static Logger Log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initial() throws IOException
	{
		driver =InitializeDriver();
		Log.info("Initialize driver");
		driver.get(prop.getProperty("URL")); //Data provider annotation
		Log.info("Fatching data from data provider");
	}	
 
	@Test
	public void TitleValidation() 
	{
		
		LandingPage land =new LandingPage(driver);
		
		Assert.assertEquals(land.checkTitle().getText(),"FEATURED COURSES 123" );
		//Assert.assertTrue("", true);
		System.out.println(land.checkTitle().getText());
		Log.info("Successfully validate Title");
	}
	@AfterTest
	public void Ending()
	{
		driver.close();
		driver=null;
	}
}
