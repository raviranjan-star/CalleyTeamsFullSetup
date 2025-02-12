package pompages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(id = "txtName")
    @CacheLookup
    private WebElement txtName;

    @FindBy(id = "txtEmail")
    @CacheLookup
    private WebElement txtEmailId;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(id = "txt_mobile")
    @CacheLookup
    private WebElement txtMobileNumber;

    @FindBy(css = "iframe[title='reCAPTCHA']")
    private WebElement iframeCaptcha;

    @FindBy(css = ".recaptcha-checkbox-border")
    private WebElement chkCaptchaBox;

    @FindBy(xpath = "//label[contains(text(), 'I accept')]")
    @CacheLookup
    private WebElement chkTermsAndConditions;

    @FindBy(id = "btnSignUp")
    @CacheLookup
    private WebElement btnSignUp;
    
	@FindBy(xpath="//div[@class='sa-icon sa-error animateErrorIcon']")
	private WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='sa-icon sa-warning pulseWarning']")
	private WebElement errorCaptcha;
	
	
	//Methods
	public void enterName(String name)
	{
		txtName.sendKeys(name);
	}
	public void enterEmail(String email)
	{
		txtEmailId.sendKeys(email);
	}
	public void enterPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void enterNumber(String number)
	{
		txtMobileNumber.sendKeys(number);
	}
	public void clickCaptchaBox()
	{
		try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeCaptcha));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(chkCaptchaBox)).click();
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            
        } catch (Exception e) {
            System.out.println("Captcha not available or timed out: " + e.getMessage());
        }
	}
	
    private void clickUsingJS(WebDriver driver,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
	public void clickCheckbox(WebDriver driver) {
        clickUsingJS(driver, chkTermsAndConditions);
    }

    public void clickSignUp(WebDriver driver) {
        clickUsingJS(driver, btnSignUp);
    }
	public boolean errMsgDisplayed() {
		try{
			System.out.println("Duplicate Data Found in registered Account");
			return errorMsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean errCaptchaDisplayed() {
		System.out.println("Captcha Occurs");
		try{
			return errorCaptcha.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
 
}
