package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ActionStatus;
import Utility.Product;
import Utility.WebDriverUtil;

public class CartPO {

	private String productDivsXpath = "";
		private String nameSubXpath = "";
		private String descriptionSubXpath = "";
		private String priceSubXpath = "";
		private String cartStatusSubXpath = "";
	

	List<Product> productList = new ArrayList<Product>();
	
	

	public void initializeItemPO(WebDriver webDriver) {
		
		List<WebElement> productDivs = WebDriverUtil.findElementsByXpath(webDriver, productDivsXpath);
		if(productDivs != null) {
			for(WebElement productDiv : productDivs) {
				Product newProduct = new Product();
				WebElement nameDiv = WebDriverUtil.findSubElementByXpath(productDiv, nameSubXpath);
				if(nameDiv != null)
					newProduct.setName(nameDiv.getText());
				
				WebElement descriptionDiv = WebDriverUtil.findSubElementByXpath(productDiv, descriptionSubXpath);
				if(descriptionDiv != null)
					newProduct.setDescription(descriptionDiv.getText());
				
				WebElement priceDiv = WebDriverUtil.findSubElementByXpath(productDiv, priceSubXpath);
				if(priceDiv != null)
					newProduct.setPrice(priceDiv.getText());
				
				WebElement cartStatusDiv = WebDriverUtil.findSubElementByXpath(productDiv, cartStatusSubXpath);
				if(cartStatusDiv != null)
					newProduct.setCartStatus(cartStatusDiv.getText());
				
				productList.add(newProduct);
			}
		}
		
	}
	
	
	
	
	public ActionStatus isProductPresent(WebDriver webDriver, Product product) {
		ActionStatus actionStatus = new ActionStatus();
		this.initializeItemPO(webDriver);
		
		if(productList != null && productList.contains(product)) {

			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: Product "+product+" present in Cart");
		
		}else {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: Product "+product+" not present in Cart");
		}
		
		return actionStatus;
		
	}
	
	public ActionStatus isProductNotPresent(WebDriver webDriver, Product product) {
		ActionStatus actionStatus = new ActionStatus();
		this.initializeItemPO(webDriver);
		
		if(productList == null || !productList.contains(product)) {

			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: Product "+product+" not present in Cart");
		
		}else {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: Product "+product+" present in Cart");
		}
		
		return actionStatus;
		
	}
	
}
