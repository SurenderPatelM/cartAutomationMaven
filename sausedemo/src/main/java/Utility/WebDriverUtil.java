package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.gecko.driver",SauseDemoConstants.geckoDriverPath);
		return new FirefoxDriver();
	}
	
	
	
	public ActionStatus clickWebElement(WebElement webElement, String identifer) {
		ActionStatus actionStatus = new ActionStatus();
		try {
			webElement.clear();
			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: "+identifer+" element clicked");
		}catch(Exception e) {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: "+identifer+" element not clicked");
			actionStatus.setActionException(e);
		}
		return actionStatus;
	}
	
	
	public ActionStatus fillWebElement(WebElement webElement, String identifer, String value) {
		ActionStatus actionStatus = new ActionStatus();
		try {
			webElement.sendKeys(value);
			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: "+identifer+" filled with "+value);
		}catch(Exception e) {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Succes :: "+identifer+" not filled with "+value);
			actionStatus.setActionException(e);
		}
		return actionStatus;
	}
	
	
	public WebElement findElementByXpath(WebDriver webDriver, String xpathExpression) {
		try {
			return webDriver.findElement(By.xpath(xpathExpression));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<WebElement> findElementsByXpath(WebDriver webDriver, String xpathExpression) {
		try {
			return webDriver.findElements(By.xpath(xpathExpression));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public WebElement findSubElementByXpath(WebElement webElement, String xpathExpression) {
		try {
			return webElement.findElement(By.xpath(xpathExpression));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<WebElement> findSubElementsByXpath(WebElement webElement, String xpathExpression) {
		try {
			return webElement.findElements(By.xpath(xpathExpression));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
