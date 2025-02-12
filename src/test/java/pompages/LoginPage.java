package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators
	@FindBy(xpath = "//input[@id='txtEmailId']") 
	@CacheLookup
	private WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	@CacheLookup
	private WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='btnLogIn']")
	@CacheLookup
	private WebElement btnLogIn;
	
	@FindBy(xpath = "//a[@id='cmdsinup']")
	@CacheLookup
	private WebElement btnSignup;

	// Methods used by LoginTest
		public void enterEmail(String email) {
			txtEmailAddress.sendKeys(email);
		}
	
		public void enterPassword(String password) {
			txtPassword.sendKeys(password);
		}
	
		public void clickLoginBtn() {
			btnLogIn.click();
		}

	// Methods used by Registration Test
		public void clickSignUp() {
	    js.executeScript("arguments[0].click();", btnSignup);
		}
}
