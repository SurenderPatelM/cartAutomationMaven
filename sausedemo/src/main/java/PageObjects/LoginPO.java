package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ActionStatus;
import Utility.WebDriverUtil;

public class LoginPO {

	private String userNameXpath = "";
	private String passwordXpath = "";
	private String loginButtonXpath = "";

	public ActionStatus login(WebDriver webDriver, String userName, String password) {
		ActionStatus actionStatus = new ActionStatus();
		
		WebElement userNameInput = WebDriverUtil.findElementByXpath(webDriver, userNameXpath);
		WebElement passwordInput = WebDriverUtil.findElementByXpath(webDriver, passwordXpath);
		WebElement loginButton = WebDriverUtil.findElementByXpath(webDriver, loginButtonXpath);
		
		if(userNameInput == null || passwordInput == null || loginButton == null) {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: Login Error");
			return actionStatus;
		
		}
		actionStatus = WebDriverUtil.fillWebElement(userNameInput, "Loing user ", userName);
		if(!actionStatus.getActionStatus())
			return actionStatus;
		
		actionStatus = WebDriverUtil.fillWebElement(passwordInput, "Loing password ", password);
		if(!actionStatus.getActionStatus())
			return actionStatus;
		
		actionStatus = WebDriverUtil.clickWebElement(loginButton, "Login Button");
		
		return actionStatus;
		
		
	}
	
	
	
}
