package com.adv.qa.selenium.tests.currency.phase2;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A072  Common Purchasing Users
 * Purpose              :   Set Up Initial Batch Types
 * Date					:   20-06-2014/Modified on 26-Apr-2017 (Chetna)
 * ACCESS               :   PX2
 */

public class A072_Common_Purchasing_UsersTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		String code = "EDTPUSER ACT=INSERT,COMPANY="+companyId;
		List<String> cpUserIM = dataRow.findNamesReturnValues("cpUserIM");
		List<String> cpUserAccept = dataRow.findNamesReturnValues("cpUserAccept");
		List<String> cpUserBuyer = dataRow.findNamesReturnValues("cpUserBuyer");
		List<String> cpUserExped = dataRow.findNamesReturnValues("cpUserExped");
		List<String> cpUserGrec = dataRow.findNamesReturnValues("cpUserGrec");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
						
		
		createCPUser(currencyPage,code,currencyCode,cpUserIM);
		createCPUser(currencyPage,code,currencyCode,cpUserAccept);
		createCPUser(currencyPage,code,currencyCode,cpUserBuyer);
		createCPUser(currencyPage,code,currencyCode,cpUserExped);
		createCPUser(currencyPage,code,currencyCode,cpUserGrec);


		currencyPage.logOut(1);

	}
		
	private void createCPUser(CurrencyPage currencyPage,String code,List<String> currencyCode,List<String> document) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		
		currencyPage.isCommandDisplayed();
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - CP User - Edit","Currency search page","displayed");
				
		/*Create batch type code*/
		
		
		boolean update= currencyPage.enterCPUserDetails(document);	
		
		if(update==true){
			
		currencyPage.clickOnUpdate();
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "CP User "+document.get(0), "created successfully");
		
			}
		else {
			testcases.add(getCurreentDate()+" | Pass : CP User "+document.get(0)+ " already created");
			
			currencyPage.clickOnCancel();
			currencyPage.isConfirmPopUpDisplayed();
			
		}
			
	}
//		if(currencyPage.getToolContentText().contains(message)){
//			testcases.add(getCurreentDate()+" | Pass : CP User "+document.get(0)+ " displayed in the list");
//		}
//		else{
//			currencyPage.clickOnCancel();
//			
//			currencyPage.isConfirmPopUpDisplayed();
//			
//			testcases.add(getCurreentDate()+" | Fail : CP User "+document.get(0)+ " not displayed in the list");
//		}
		
//		currencyPage.isCommandDisplayed();

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A072" };
		String [] selectedNames = {"userName","passWord","currencyCode","cpUserAccept","cpUserBuyer","cpUserIM","cpUserExped","cpUserGrec"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
