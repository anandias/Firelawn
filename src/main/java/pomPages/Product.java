package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	public WebDriver driver;
	@FindBy(xpath = "(//img[@alt='APPLE iPhone 14 Pro']/../..//button[text()='add to cart'])[1]")
	private WebElement addtocart;
	@FindBy(id="cart_fl")
	private WebElement cart;
	
	public Product() {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getCart() {
		return cart;
	}
	public Cart addtocartbtn() {
		addtocart.click();
		cart.click();
		return new Cart(driver);
	}
	
	

	
	
}
