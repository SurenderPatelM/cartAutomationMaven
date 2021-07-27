package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ActionStatus;
import Utility.Product;
import Utility.WebDriverUtil;

public class ProductPO {

	private String productDivsXpath = "";
		private String nameSubXpath = "";
		private String descriptionSubXpath = "";
		private String priceSubXpath = "";
		private String cartStatusSubXpath = "";
	

	private String filterDropDownxpath = "";
	
	
	List<Product> productList = new ArrayList<Product>();
	
	
	public ActionStatus selectFilter(WebDriver webDriver, String value) {
		ActionStatus actionStatus = new ActionStatus();
		
		WebElement filterDropDown = WebDriverUtil.findElementByXpath(webDriver, filterDropDownxpath);
		if(filterDropDown == null) {
			actionStatus.setActionResultMessage("Failure :: Filter drop down not found");
			actionStatus.setActionStatus(false);
			return actionStatus;
		}
		
		return WebDriverUtil.selectDropdown(filterDropDown, "Sort Drop Down",value);
		
	
		
	}

	public void initializeProductPO(WebDriver webDriver) {
		
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
	
	
	public ActionStatus clickCartButton(WebDriver webDriver, Product product) {
		ActionStatus actionStatus = new ActionStatus();
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
				
				if(newProduct.equals(product)) {
					cartStatusDiv.click();
					actionStatus.setActionStatus(true);
					actionStatus.setActionResultMessage("Succes :: Cart button clicked for "+product);
					
				}
			}
		}
		
		actionStatus.setActionStatus(false);
		actionStatus.setActionResultMessage("Failure :: No Products found to add to cart");
		
		return actionStatus;
		
	}
	
	
	public ActionStatus compareProductsPriceLowToHigh(WebDriver webDriver) {
		ActionStatus actionStatus = new ActionStatus();
		this.initializeProductPO(webDriver);
		
		if(productList != null) {
			for(int index = 1; index < productList.size(); index++) {
				
				Float currentProductPrice = Float.parseFloat(productList.get(index).getPrice());
				Float nextProductPrice = Float.parseFloat(productList.get(index+1).getPrice());
				
				if(currentProductPrice > nextProductPrice) {
					actionStatus.setActionStatus(false);
					actionStatus.setActionResultMessage("Failure :: Price high for "+productList.get(index)+" from next product "+productList.get(index+1));
					return actionStatus;
				}
			}

			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: Products are in order of Price low to high");
		
		}else {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: No Products found to compare price");
		}
		
		
		return actionStatus;
		
	}
	
	
	public ActionStatus compareProductsPriceHighToLow(WebDriver webDriver) {
		ActionStatus actionStatus = new ActionStatus();
		this.initializeProductPO(webDriver);
		
		if(productList != null) {
			for(int index = 1; index < productList.size(); index++) {
				
				Float currentProductPrice = Float.parseFloat(productList.get(index).getPrice());
				Float nextProductPrice = Float.parseFloat(productList.get(index+1).getPrice());
				
				if(currentProductPrice < nextProductPrice) {
					actionStatus.setActionStatus(false);
					actionStatus.setActionResultMessage("Failure :: Price low for "+productList.get(index)+" from next product "+productList.get(index+1));
					return actionStatus;
				}
			}

			actionStatus.setActionStatus(true);
			actionStatus.setActionResultMessage("Succes :: Products are in order of Price high to low");
		
		}else {
			actionStatus.setActionStatus(false);
			actionStatus.setActionResultMessage("Failure :: No Products found to compare price");
		}
		
		
		return actionStatus;
		
	}
	
	
}
