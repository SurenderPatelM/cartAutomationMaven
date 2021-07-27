package sausedemo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PageObjects.LoginPO;
import PageObjects.ProductPO;
import Utility.ActionStatus;
import Utility.SauseDemoConstants;
import Utility.WebDriverUtil;

public class ProductFilterTest {

	WebDriver webDriver;
	
	@BeforeClass
	public void loadRequirePage() throws Exception{
		ActionStatus actionStatus;
		webDriver = WebDriverUtil.getWebDriver();
		if(webDriver == null)
			throw new Exception("Web Driver not created");
		
		webDriver.get(SauseDemoConstants.baseURL);
		
		LoginPO login = new LoginPO();
		actionStatus = login.login(webDriver, SauseDemoConstants.testUserName, SauseDemoConstants.testUserPasword);
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
			
		
		
	}
	
	
	@Test
	public void testFilterOrderLowToHigh() throws Exception{
		ActionStatus actionStatus;
		
		ProductPO productPage = new ProductPO();
		actionStatus = productPage.selectFilter(webDriver, "Low To High");
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
		
		actionStatus = productPage.compareProductsPriceLowToHigh(webDriver);
		
		Assert.assertTrue(actionStatus.getActionResultMessage(), actionStatus.getActionStatus());
		
		
	}
	
	
	@Test
	public void testFilterOrderHighToLow() throws Exception{
		ActionStatus actionStatus;
		
		ProductPO productPage = new ProductPO();
		actionStatus = productPage.selectFilter(webDriver, "High To Low");
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
		
		actionStatus = productPage.compareProductsPriceHighToLow(webDriver);
		
		Assert.assertTrue(actionStatus.getActionResultMessage(), actionStatus.getActionStatus());
		
		
	}
	
}
