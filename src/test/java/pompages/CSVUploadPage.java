package pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CSVUploadPage extends BasePage{

	public CSVUploadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="input#ContentPlaceHolder1_txtlistname") 
	@CacheLookup 
	private WebElement txtlistName;
	
	@FindBy(css="input#ContentPlaceHolder1_fileUpload") 
	@CacheLookup 
	private WebElement btnChooseFile;
	
	@FindBy(css="a#btnUp") 
	@CacheLookup 
	private WebElement uploadFile;
	
	@FindBy(css="button.confirm")
	private WebElement btnConfirm;
	
	@FindBy(css="select#ddlbelongto_1")
	private WebElement select1;
	
	@FindBy(css="select#ddlbelongto_2")
	private WebElement select2;
	
	@FindBy(css="select#ddlbelongto_3")
	private WebElement select3;
	
	@FindBy(css="input#ContentPlaceHolder1_btnUpload")
	private WebElement btnImport;
	
	@FindBy(xpath="//h5[text()='Upgrade Now!']")
	private WebElement errMsg;
	
	public void enterListName(String listName) {
        txtlistName.sendKeys(listName);
    }

    public void uploadCSVFile(String filePath) {
        btnChooseFile.sendKeys(filePath);
    }

    public void clickUploadButton() {
    	
        uploadFile.click();
        try{
        	Thread.sleep(1000);
        	btnConfirm.click();
        }
        catch(Exception e){
        	System.out.print("File accepted");
        }
    }
  
    private void selectOptions(WebElement element,String option)
    {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	Select sel=new Select(element);
    	sel.selectByVisibleText(option);
    }

	public void selectColumn1(String col1) {
		selectOptions(select1,col1);
	}

	public void selectColumn2(String col2) {
		selectOptions(select2,col2);
	}

	public void selectColumn3(String col3) {
		selectOptions(select3,col3);
	}

	public void clickImport() {
	     js.executeScript("arguments[0].click();", btnImport);
	}
	
	public  boolean chkError()
	{
		System.out.print("CSV upload page msg: "+errMsg.getText());
		return  errMsg.toString().contains("Upgrade Now!");
	}

}
