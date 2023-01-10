package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	public WebDriver driver;
	@FindBy(id="buynow_fl")
	private WebElement buy;
	
	public Cart() {
		PageFactory.initElements(driver,this);
	}
	public Address buynow() {
		buy.click();
		return new Address(driver);
	}

}
