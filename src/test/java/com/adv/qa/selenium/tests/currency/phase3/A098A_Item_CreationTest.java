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
 * Test Reference No	: 	A098 Item Creation
 * Purpose              :   Set Up Items
 * ACCESS               :   PIV/PYE
 * Date					:   Modified on 10-May-2017   
 */

public class A098A_Item_CreationTest extends BaseTest{
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
		List<String> manufacturer01 = dataRow.findNamesReturnValues("manufacturer01");
		List<String> manufacturer02 = dataRow.findNamesReturnValues("manufacturer02");
		List<String> manufacturerItem = dataRow.findNamesReturnValues("manufacturerItem");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Manufacturer List","Currency search page","displayed");
				
		currencyPage.searchValue(companyId, 2, 0);
		
		currencyPage.clickOnInsert();
		createManufacturer(currencyPage,manufacturer01);
		createManufacturer(currencyPage,manufacturer02);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.clickOnCancel();
		
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));	
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Item Manufacturer List","Currency search page","displayed");

		currencyPage.searchValue(companyId,manufacturerItem, 4, 1);
		
		currencyPage.clickOnInsert();
		
		boolean update= currencyPage.createManufacturerItem(manufacturerItem);
		
		String SuccMessage = "The previously-requested action has been performed";
		
		if(update== true)
		{

		currencyPage.clickOnUpdate();
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New manufacturer "+manufacturerItem.get(0)," created successfully");
		
		}
		
		else
		{	
			testcases.add(getCurreentDate()+" | Pass : New manufacturer "+manufacturerItem.get(0)+" Already Created");
			currencyPage.clickOnCancel();
			currencyPage.isConfirmPopUpDisplayed();
		}

		currencyPage.logOut(2);
	}
	
	private void createManufacturer(CurrencyPageNew currencyPage,List<String> manufacturer){
		
		String SuccMessage = "The previously-requested action has been performed";
		
		boolean update = currencyPage.createManufacturer(manufacturer);	
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New manufacturer"+manufacturer.get(0), " created successfully");
		}
		
		else{
			testcases.add(getCurreentDate()+" | Pass : New manufacturer "+manufacturer.get(0)+ "Already Created");
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
		String[] nodeID = { "A098A" };
		String [] selectedNames = {"userName","passWord","currencyCode","manufacturer01","manufacturer02","manufacturerItem"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
