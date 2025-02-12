package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//span[@aria-hidden='true']") 
	@CacheLookup 
	private WebElement btncross;
	
	
	@FindBy(xpath="//ul[@id='nav']//li//a[@href='call-list-personal.aspx']//span[contains(text(),'Call List')]")
	@CacheLookup 
	private WebElement callList;
	
	@FindBy(xpath="//span[normalize-space()='Add - Standard Import']") //"//body//form[@id='form1']//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//div[2]//a[1]") 
	@CacheLookup 
	private WebElement optionStandardImport;
	
	public void closeModelContent() {
		
		btncross.click();
    }
    public void openCallList(WebDriver driver) {
		actions.moveToElement(callList).perform();  // Hovers over the element
    }

    public void selectStandardImport() {
    	try {
			Thread.sleep(1000);
			actions.moveToElement(optionStandardImport).perform();  // Hovers over the element
	        optionStandardImport.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
}
