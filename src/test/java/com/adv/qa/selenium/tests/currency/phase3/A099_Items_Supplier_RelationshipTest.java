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
 * Date					:   Modified on 10-May-2017    
 * ACCESS               :   PIK
 */

public class A099_Items_Supplier_RelationshipTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		
		
		List<String> item524 = dataRow.findNamesReturnValues("item524");
		List<String> item525 = dataRow.findNamesReturnValues("item525");
		List<String> item626 = dataRow.findNamesReturnValues("item626");
		List<String> item325 = dataRow.findNamesReturnValues("item325");
		List<String> item335 = dataRow.findNamesReturnValues("item335");
		List<String> itemA160 = dataRow.findNamesReturnValues("itemA160");
				
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);

		/*Verify Supplier search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Item Supplier List","Supplier search page","displayed");

		currencyPage.searchValue(companyId,item525, 3, 1);
		
		currencyPage.clickOnInsert1();
		
		createSupplierForItem(currencyPage,item524);
		createSupplierForItem(currencyPage,item525);
		createSupplierForItem(currencyPage,item626);
		createSupplierForItem(currencyPage,item325);
		createSupplierForItem(currencyPage,item335);
		createSupplierForItem(currencyPage,itemA160);
				
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		
//		verifySupplierItem(currencyPage,item524);
//		verifySupplierItem(currencyPage,item525);
//		verifySupplierItem(currencyPage,item626);
//		verifySupplierItem(currencyPage,item325);
//		verifySupplierItem(currencyPage,item335);
//		verifySupplierItem(currencyPage,itemA160);
		
		
		currencyPage.logOut(2);
	}
	
	private void createSupplierForItem(CurrencyPageNew currencyPage,List<String> item){

		String SuccMessage = "The previously-requested action has been performed";
		boolean update = currencyPage.createItemSupplier(item);
		
		if (update == true)
			
		{
			currencyPage.clickOnUpdate();
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New supplier item "+item.get(1), " created successfully");
			
		}
		
		else{
			testcases.add(getCurreentDate()+" | Pass : New supplier item "+item.get(1)+ " Already Created");
			
		}
		
		
	}
	
//	private void verifySupplierItem(CurrencyPageNew currencyPage,List<String> item){
//		
//		currencyPage.searchValue(companyId,item, 3, 1);
//		
//		
//		/*Verify new item supplier in the list*/
//		if(currencyPage.verifyValues(item.get(1))){
//			testcases.add(getCurreentDate()+" | Pass : New supplier item "+item.get(1)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New supplier item "+item.get(1)+ " not displayed in the list");
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
		String[] nodeID = { "A099" };
		String [] selectedNames = {"userName","passWord","currencyCode","item524","item525","item626","item325","item335","itemA160"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
