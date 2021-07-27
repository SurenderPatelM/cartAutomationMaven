package Utility;

public class Product {
	private String name;
	private String description;
//	private String imageClass;
	private String price;
	private String cartStatus;
	
	public Product(String name, String description, String price, String cartStatus) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setCartStatus(cartStatus);
	}
	public Product() {
		this.setName("");
		this.setDescription("");
		this.setPrice("");
		this.setCartStatus("");
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartStatus == null) ? 0 : cartStatus.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)){
			if(!name.equals("IGNORE") && !other.name.equalsIgnoreCase("IGNORE"))
				return false;
		}
		
		if (cartStatus == null) {
			if (other.cartStatus != null)
				return false;
		} else if (!cartStatus.equals(other.cartStatus)) {
			if(!cartStatus.equals("IGNORE") && !other.cartStatus.equalsIgnoreCase("IGNORE"))
				return false;
		}
		
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description)){
			if(!description.equals("IGNORE") && !other.description.equalsIgnoreCase("IGNORE"))
				return false;
		}
		
		
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price)){
			if(!price.equals("IGNORE") && !other.price.equalsIgnoreCase("IGNORE"))
				return false;
		}
		
		return true;
	}
	@Override
	public String toString() {
		return "ProductItem [name=" + name + ", description=" + description + ", price=" + price + ", cartStatus="
				+ cartStatus + "]";
	}
	
	
}
