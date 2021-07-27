package sausedemo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PageObjects.CartPO;
import PageObjects.LoginPO;
import PageObjects.ProductPO;
import Utility.ActionStatus;
import Utility.SauseDemoConstants;
import Utility.WebDriverUtil;

public class CartItemTest {

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
			
		
		ProductPO productPage = new ProductPO();
		actionStatus = productPage.clickCartButton(webDriver, SauseDemoConstants.SauceLabsBackpack);
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
		
		
	}
	
	
	@Test
	public void testIsProductPresent() throws Exception{
		ActionStatus actionStatus;
		
		CartPO cartPO = new CartPO();
		actionStatus = cartPO.loadCart(webDriver);
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
		
		actionStatus = cartPO.isProductPresent(webDriver, SauseDemoConstants.SauceLabsBackpack);
		
		Assert.assertTrue(actionStatus.getActionResultMessage(), actionStatus.getActionStatus());
		
		
	}
	
	
	@Test
	public void testIsProductNotPresent() throws Exception{
		ActionStatus actionStatus;
		
		CartPO cartPO = new CartPO();
		actionStatus = cartPO.loadCart(webDriver);
		if(!actionStatus.getActionStatus())
			throw new Exception(actionStatus.getActionResultMessage());
		
		actionStatus = cartPO.isProductPresent(webDriver, SauseDemoConstants.SauceLabsBackpack);
		
		Assert.assertTrue(actionStatus.getActionResultMessage(), actionStatus.getActionStatus());
		
		
	}
	
}
