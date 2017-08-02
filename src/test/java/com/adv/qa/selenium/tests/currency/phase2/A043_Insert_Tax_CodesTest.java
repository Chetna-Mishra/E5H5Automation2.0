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
 * Test Reference No	: 	A043 Insert Tax Codes
 * Purpose              :   Insert Tax Types
 * Date					:   12-06-2014
 * ACCESS               :   RAI,RAJ,EDTRTYPE ACT=INSERT,TAX-TYPE=PE,PARAM-CMPY=04
 */

public class A043_Insert_Tax_CodesTest extends BaseTest{
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
		List<String> location = dataRow.findNamesReturnValues("location");
		List<String> eType = dataRow.findNamesReturnValues("eType");
		List<String> sType = dataRow.findNamesReturnValues("sType");
		List<String> vType = dataRow.findNamesReturnValues("vType");
		List<String> zType = dataRow.findNamesReturnValues("zType");	
		List<String> uksTaxCode = dataRow.findNamesReturnValues("uksTaxCode");
		List<String> ukeTaxCode = dataRow.findNamesReturnValues("ukeTaxCode");
		List<String> ukzTaxCode = dataRow.findNamesReturnValues("ukzTaxCode");
		List<String> ukvTaxCode = dataRow.findNamesReturnValues("ukvTaxCode");
		

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		insertTaxCode(currencyPage,eType,currencyCode.get(0));
		insertTaxCode(currencyPage,sType,currencyCode.get(0));
		insertTaxCode(currencyPage,vType,currencyCode.get(0));
		insertTaxCode(currencyPage,zType,currencyCode.get(0));
		
//		currencyPage.fillCurrenceyCode(currencyCode.get(1));
//		
//		/*Verify currency search page displayed*/
//		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Tax Type List","Tax Type list page","displayed");
//
//		currencyPage.searchValue(companyId,3,1);
//		
//		verifyValues(currencyPage,eType);
//		verifyValues(currencyPage,sType);
//		verifyValues(currencyPage,vType);
//		verifyValues(currencyPage,zType);
//		
//		currencyPage.clickOnCancel();
		
		
		/*Verify command line for Creating Location*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(3));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(3)+" - Tax Location List","Tax Location list page","displayed");	
		
		currencyPage.searchValue(location.get(0), 1, 0);
		
		currencyPage.clickOnInsert();
		
		createLocations(currencyPage,location);
		
		currencyPage.clickOnCancel();
		
		currencyPage.clickOnCancel();
		
				
		/*Verify command line for creating Tax Code*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Tax Code List","Tax Code List page","displayed");
		
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnInsert();
				
		/*Create tax Code*/
		createTaxCode(currencyPage,uksTaxCode,currencyCode.get(2));
		createTaxCode(currencyPage,ukeTaxCode,currencyCode.get(2));
		createTaxCode(currencyPage,ukvTaxCode,currencyCode.get(2));
		createTaxCode(currencyPage,ukzTaxCode,currencyCode.get(2));
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
//		verifyValues(currencyPage,uksTaxCode);
//		verifyValues(currencyPage,ukeTaxCode);
//		verifyValues(currencyPage,ukvTaxCode);
//		verifyValues(currencyPage,ukzTaxCode);

		currencyPage.logOut(2);

	}

	/*Create tax code*/
	private void insertTaxCode(CurrencyPage currencyPage,List<String> taxList,String currencyCode) throws InterruptedException{
		String command = "EDTRTYPE ACT=INSERT,PARAM-CMPY="+companyId;
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(command);

		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Tax Type Edit","Tax Type Edit page","displayed");
			
		/*Create Tax type*/
		boolean update = currencyPage.createTaxType(taxList);
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New tax type "+taxList.get(0), "created successfully");	
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New tax type "+taxList.get(0) +"present in the list");
			
			currencyPage.clickOnCancel();
		}
		
		
//		if(update == true){
//			currencyPage.clickOnUpdate();
//			
//			Assert.assertTrue(testcases, update, "Tax Codes are", " Inserted");
//			
//			
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Pass : New tax code "+taxList.get(0) +"present in the list");
//			currencyPage.clickOnCancel();
//		}
//		
		
	
	
	}
	
	
	/*Create tax Location */
		private void createLocations(CurrencyPage currencyPage,List<String> location) throws InterruptedException{
		
			String SuccMessage = "The previously-requested action has been performed";
			/*Create Tax type*/
			boolean update = currencyPage.createLocation(location);	
			
			if(update == true){
				
				currencyPage.clickOnUpdate();
				
				Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New locations "+location.get(0), "created successfully");		
			}
			
			else{
				testcases.add(getCurreentDate()+" | Pass : New locations  "+location.get(0)+ " displayed in the list");
			}	
		}	
		
	
	/*Create tax Code */
	private void createTaxCode(CurrencyPage currencyPage,List<String> taxList,String currencyCode) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		/*Create Tax type*/
		boolean update = currencyPage.createTaxCodeLocation(taxList);	
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New tax code "+taxList.get(0), "created successfully");
			
		}
		
		else{
			testcases.add(getCurreentDate()+" | Pass : New tax code "+taxList.get(0)+ " displayed in the list");
		}	
	}
	
//	/*Verify Values in the table list*/
//	
//	private void verifyValues(CurrencyPage currencyPage,List<String> taxCode){
//		
//		if(currencyPage.verifyValues(taxCode.get(0)))
//		
//		{
//			testcases.add(getCurreentDate()+" | Pass : New tax code "+taxCode.get(0)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New tax code "+taxCode.get(0)+ " not displayed in the list");
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
		String xmlFilePath = folder  + "A043.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
