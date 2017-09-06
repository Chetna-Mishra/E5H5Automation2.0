package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A109 Element Control Accounts
 * Purpose              :   Amend Element Control Accounts
 * Date					:   Modified on 15-May-2017
 * ACCESS               :   ECI, ECJ
 */

public class A109_Element_Control_AccountsTest extends BaseTest{
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
		List<String> eastControl = dataRow.findNamesReturnValues("eastControl");
		List<String> westControl = dataRow.findNamesReturnValues("westControl");		
		List<String> northControl = dataRow.findNamesReturnValues("northControl");
		List<String> southControl = dataRow.findNamesReturnValues("southControl");

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		createIMAccounts(currencyPage,eastControl,currencyCode);
		createIMAccounts(currencyPage,westControl,currencyCode);
		createIMAccounts(currencyPage,northControl,currencyCode);
		createIMAccounts(currencyPage,southControl,currencyCode);
		
//		currencyPage.fillCurrenceyCode(currencyCode.get(1));
//		currencyPage.ClickOnAnyButton("OK", 1);
//	
//		verifyValues(currencyPage,eastControl);
//		verifyValues(currencyPage,westControl);
//		verifyValues(currencyPage,northControl);
//		verifyValues(currencyPage,southControl);
		
		currencyPage.logOut(1);
	}
	
	
	private void createIMAccounts(CurrencyPageNew currencyPage,List<String> elements,List<String> currencyCode) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		String code = "EDTESTRICA ACT=AMEND,CMPY="+companyId+",ELEM="+elements.get(0); 
		
		currencyPage.isCommandDisplayed();
	
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
	
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - ICA Elements Edit","Currency search page","displayed");
				
		/*Amend control accounts*/
		
		currencyPage.amendControlAccounts(elements);	
		
		currencyPage.clickOnUpdate();	
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New Store "+elements.get(0), "updated successfully");
		
		currencyPage.isCommandDisplayed();
			
			
		}
			
//private void verifyValues(CurrencyPageNew currencyPage,List<String> elements) throws InterruptedException{
//		
//		/*Verify new standard text in the list*/
//		if(currencyPage.verifyValues(elements.get(0))){
//			testcases.add(getCurreentDate()+" | Pass : New Store "+elements.get(0)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New Store "+elements.get(0)+ " not displayed in the list");
//		}	
//	}
			
	

//	private void createIMAccounts(CurrencyPageNew currencyPage,List<String> elements,String currencyCode) throws InterruptedException{
//		String message = "The previously-requested action has been performed";
//		String code = "EDTESTRICA ACT=AMEND,CMPY="+companyId+",ELEM="+elements.get(0); 
//		
//		currencyPage.isCommandDisplayed();
	
//		/*Verify command line*/
//		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
//		
//		currencyPage.fillCurrenceyCode(code);
	
//		/*Verify currency search page displayed*/
//		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - ICA Elements Edit","Currency search page","displayed");
//				
//		/*Amend control accounts*/
//		currencyPage.amendControlAccounts(elements);	
//		
//		currencyPage.clickOnUpdate();	
//		
//		if(currencyPage.getToolContentText().contains(message)){
//			testcases.add(getCurreentDate()+" | Pass : Control account "+elements.get(0)+ " updated");
//		}
//		else{
//			currencyPage.clickOnCancel();
//			
//			testcases.add(getCurreentDate()+" | Fail : Control account "+elements.get(0)+ " not updated");
//		}
//	}

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A109" };
		String [] selectedNames = {"userName","passWord","currencyCode","eastControl","westControl","northControl","southControl"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
