package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pompages.CSVUploadPage;
import pompages.DashboardPage;
import pompages.LoginPage;
import testBase.BaseClass;

public class UploadCSVTest extends BaseClass{

	@Test(groups= {"Masters","Regression"})
	public void uploadCsv()
	{
		logger.info("***** Login Test Started *****");

        LoginPage lp = new LoginPage(driver);
        
        try {
            lp.enterEmail(properties.getProperty("usr1Email"));
            logger.info("Username Entered");
            
            lp.enterPassword(properties.getProperty("usr1Password"));
            logger.info("Password Entered");

            lp.clickLoginBtn();
            logger.info("Login Button clicked");

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed");
        } catch (Exception e) {
            logger.error("Test Failed: ", e);
            Assert.fail("Exception occurred during login test");
        }
        
        logger.info("***** Login Test Completed *****");
        
		logger.info("***** Uploading CSV Test Started *****");
		DashboardPage dp=new DashboardPage(driver);
		
		CSVUploadPage csvUpload=new CSVUploadPage(driver);
		
		try {
			dp.closeModelContent();
			logger.info("Model Content Closed");
			
			dp.openCallList(driver);
			logger.info("Call list Menu Clicked");
			 	 
			dp.selectStandardImport();
			logger.info("Standard Import Option is selected");
			 
			csvUpload.enterListName(properties.getProperty("listName"));
	        logger.info("List Name Entered");
	        
	        csvUpload.uploadCSVFile(System.getProperty("user.dir")+properties.getProperty("file"));
	        logger.info("CSV File Selected");
	        
	        csvUpload.clickUploadButton();
	        logger.info("Upload Button Clicked");
	        
	        csvUpload.selectColumn1(properties.getProperty("Column1"));
	        logger.info("Column1 Selected");
	        
	        csvUpload.selectColumn2(properties.getProperty("Column2"));
	        logger.info("Column2 Selected");
	        
	        csvUpload.selectColumn3(properties.getProperty("Column3"));
	        logger.info("Column3 Selected");
	        
	        csvUpload.clickImport();
	        logger.info("Import Button Clicked");
	        
	        logger.info("***** Uploading CSV Test Completed *****");
	        
		}catch(Exception e) {
			try {
				if(csvUpload.chkError()){
					logger.info("File upload stopped due to Upgrade Notification");
				}
			}
			catch(Exception f) {
            Assert.fail("Exception occurred during CSV Upload test");
			}
		}
		
		
	}
	
}
