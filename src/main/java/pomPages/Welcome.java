package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome {
	public WebDriver driver;
	@FindBy(id="fl_login_btn")
	private WebElement Loginbtn;

	public Welcome(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public Login loginButton() {
		Loginbtn.click();
		return new Login(driver);
	}
	
	
	

}
