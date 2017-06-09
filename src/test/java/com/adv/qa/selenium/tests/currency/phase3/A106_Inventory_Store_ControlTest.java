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
import com.adv.qa.selenium.helpers.WaitHelper;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A106 Inventory Store Controls
 * Purpose              :   Inventory Store Controls 
 * Date					:   Modified on 12-May-2017
 * ACCESS               :   HAD,HAC
 */

public class A106_Inventory_Store_ControlTest extends BaseTest{
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
		List<String> warehseStore = dataRow.findNamesReturnValues("warehseStore");
		List<String> northStore = dataRow.findNamesReturnValues("northStore");
		List<String> southStore = dataRow.findNamesReturnValues("southStore");
		List<String> eastStore = dataRow.findNamesReturnValues("eastStore");
		List<String> westStore = dataRow.findNamesReturnValues("westStore");
		List<String> northITS = dataRow.findNamesReturnValues("northITS");
		List<String> southITS = dataRow.findNamesReturnValues("southITS");
		List<String> eastITS = dataRow.findNamesReturnValues("eastITS");
		List<String> westITS = dataRow.findNamesReturnValues("westITS");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		createInventoryStoreControl(currencyPage,warehseStore,currencyCode);
		createInventoryStoreControl(currencyPage,northStore,currencyCode);
		createInventoryStoreControl(currencyPage,southStore,currencyCode);
		createInventoryStoreControl(currencyPage,eastStore,currencyCode);
		createInventoryStoreControl(currencyPage,westStore,currencyCode);
		
		createTransitStore(currencyPage,southITS,currencyCode);
		createTransitStore(currencyPage,northITS,currencyCode);
		createTransitStore(currencyPage,eastITS,currencyCode);		
		createTransitStore(currencyPage,westITS,currencyCode);
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		currencyPage.ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
		
		verifyValues(currencyPage,warehseStore);
		verifyValues(currencyPage,northStore);
		verifyValues(currencyPage,southStore);
		verifyValues(currencyPage,eastStore);
		verifyValues(currencyPage,westStore);
		verifyValues(currencyPage,southITS);
		verifyValues(currencyPage,northITS);
		verifyValues(currencyPage,eastITS);
		verifyValues(currencyPage,westITS);
				
		currencyPage.logOut(2);
	}
	
	
	private void createInventoryStoreControl(CurrencyPageNew currencyPage,List<String> elements, List<String> currencyCode) throws InterruptedException{
		String code = "EDTHSTORE ACT=INSERT,CMPY="+companyId;
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Store Controls Edit","Currency search page","displayed");
		
		/*Create inventory store*/
		currencyPage.insertInventoryStore(elements);	
		
		currencyPage.clickOnUpdate();
		
		currencyPage.isCommandDisplayed();
		
	}
	
	private void createTransitStore(CurrencyPageNew currencyPage,List<String> elements,List<String> currencyCode) throws InterruptedException{
		String code = "EDTHSTORE ACT=INSERT,CMPY="+companyId;

		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Store Controls Edit","Currency search page","displayed");

		boolean update = currencyPage.createTransitStore(elements);
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
		}
		else{
			currencyPage.clickOnCancel();
			
			currencyPage.isConfirmPopUpDisplayed();
			
			testcases.add(getCurreentDate()+" | Pass : New Store "+elements.get(0)+ " displayed in the list");
		}	
		
		currencyPage.isCommandDisplayed();
	
	}
	
	
private void verifyValues(CurrencyPageNew currencyPage,List<String> Store) throws InterruptedException{
		
		/*Verify new standard text in the list*/
		if(currencyPage.verifyValues(Store.get(0))){
			testcases.add(getCurreentDate()+" | Pass : New Store "+Store.get(0)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : New Store "+Store.get(0)+ " not displayed in the list");
		}
		
		
	}
	
	
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A106" };
		String [] selectedNames = {"userName","passWord","currencyCode","warehseStore","northStore","southStore","eastStore","westStore",
				"northITS","southITS","eastITS","westITS"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
