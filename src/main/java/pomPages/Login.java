package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="fl_email")
	private WebElement emailtb;
	
	@FindBy(id="fl_password")
	private WebElement passwordtb;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginbtn;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void logindetails(String username, String password) {
		emailtb.sendKeys(username);
		passwordtb.sendKeys(password);
		loginbtn.click();
		
	}
	
	

}
