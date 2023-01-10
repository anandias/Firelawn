package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address {
	public WebDriver driver;
	@FindBy(xpath = "//span[text()='Add New Address']")
	private WebElement addnewaddress;
	
	@FindBy(xpath = "(//*[@id='outlined-size-small'])[1]")
	private WebElement nametb;
	
	@FindBy(xpath = "(//*[@id='outlined-size-small'])[2]")
	private WebElement housetb;
	
	@FindBy(xpath = "(//*[@id='outlined-size-small'])[3]")
	private WebElement streettb;
	
	@FindBy(xpath = "(//*[@id='outlined-size-small'])[4]")
	private WebElement landmarktb;
	
	@FindBy(xpath = "(//*[@id='demo-simple-select-placeholder-label'])[1]")
	private WebElement countrydd;
	
	@FindBy(xpath = "(//*[@id='demo-simple-select-placeholder-label'])[2]")
	private WebElement statedd;
	
	@FindBy(xpath = "(//*[@id='demo-simple-select-placeholder-label'])[3]")
	private WebElement citydd;
	
	@FindBy(id="outlined-adornment-pincode")
	private WebElement pincodetb;
	
	@FindBy(xpath = "(//*[@id='outlined-size-small'])[5]")
	private WebElement phonenumbertb;
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addaddressbtn;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement addressselectionradiobtn;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedbtn;
	
	@FindBy(xpath = "//button[text()='Add Card']")
	private WebElement addcardbtn;
	
	
	
	public Address() {
		PageFactory.initElements(driver,this);
	}
	
	}
	public void addaddress(String name, String house, String street,String landmark) {
		nametb.sendKeys(name);
		housetb.sendKeys(house);
		streettb.sendKeys(street);
		landmarktb.sendKeys(landmark);
		
	}
	public void code(String pin, String numb) {
		pincodetb.sendKeys(pin);
		phonenumbertb.sendKeys(numb);
		
		
	}
	public Payment addressradiobtn() {
		addaddressbtn.click();
		proceedbtn.click();
		return new Payment(driver);	
	}
	
 