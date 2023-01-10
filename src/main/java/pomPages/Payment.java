package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	public WebDriver driver;
	@FindBy(id=":r2:")
	private WebElement cardholdernametb;
	
	@FindBy(id=":r3:")
	private WebElement cardnumbertb;
	
	@FindBy(id=":r4:")
	private WebElement pintb;
	
	@FindBy(id=":r5:")
	private WebElement expirymonthtb;
	
	@FindBy(id=":r6:")
	private WebElement expiryyeartb;
	
	@FindBy(id=":r7:")
	private WebElement cvvtb;
	
	@FindBy(xpath = "//input[@value='DEBIT']")
	private WebElement debitbtn;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement adddebitcardbtn;
	
	@FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
	private WebElement selectpayment;
	
	@FindBy(id=":rs:")
	private WebElement enterpin;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement pinsubmitbtn;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedbtnaftercardadded;
	
	public Payment() {
		PageFactory.initElements(driver,this);
	}
	
	
	public void addcard(String cardholdername, String cardnamber, String pin, String month, String year, String cvv) {
		cardholdernametb.sendKeys(cardholdername);
		cardnumbertb.sendKeys(cardnamber);
		pintb.sendKeys(pin);
		expirymonthtb.sendKeys(month);
		expiryyeartb.sendKeys(year);
		cvvtb.sendKeys(cvv);
		debitbtn.click();
		adddebitcardbtn.click();
		selectpayment.click();
		enterpin.sendKeys(pin);
		pinsubmitbtn.submit();
		proceedbtnaftercardadded.click();
		
	}

}


