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
 * @author              :   Draxayani/Chetna
 * Test Reference No	: 	A091 Suppliers
 * Purpose              :   Amend Purchasing Management Company Controls for Authorisation and Update Doc Codes.
 * Date					:   24-06-2014/Modified on 04-May-2017
 * ACCESS               :   PBA
 */

public class A091_SuppliersTest extends BaseTest{
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
		List<String> sonySupplier = dataRow.findNamesReturnValues("sonySupplier");
		List<String> pioneerSupplier = dataRow.findNamesReturnValues("pioneerSupplier");
		List<String> panasonicSupplier = dataRow.findNamesReturnValues("panasonicSupplier");
		List<String> yamahaSupplier = dataRow.findNamesReturnValues("yamahaSupplier");
		List<String> denonSupplier = dataRow.findNamesReturnValues("denonSupplier");
		List<String> akaiSupplier = dataRow.findNamesReturnValues("akaiSupplier");
		List<String> SamsungSupplier = dataRow.findNamesReturnValues("SamsungSupplier");
		
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Supplier List","Currency search page","displayed");
		
		/*Create batch type code*/
		createSuppliers(currencyPage,sonySupplier);	
		createSuppliers(currencyPage,pioneerSupplier);	
		createSuppliers(currencyPage,panasonicSupplier);	
		createSuppliers(currencyPage,yamahaSupplier);	
		createSuppliers(currencyPage,denonSupplier);	
		createSuppliers(currencyPage,akaiSupplier);
		createSuppliers(currencyPage,SamsungSupplier);	
	
		currencyPage.logOut(2);

	}
	
	private void createSuppliers(CurrencyPage currencyPage, List<String> supplier) {

		String SuccMessage = "The previously-requested action has been performed";

		currencyPage.searchValue(companyId, supplier, 8, 1);

		if (!currencyPage.verifyValues(supplier.get(0))) {

			currencyPage.clickOnInsert();

			/* Create batch type code */
			boolean update = currencyPage.enterSupplierListDetail(supplier);

			if (update == true)

			{
				currencyPage.clickOnUpdate();

				Assert.assertTrue(testcases, currencyPage.getErrorContentText().contains(SuccMessage),
						"New supplier  " + supplier.get(0), "created successfully");

			}

			else {

				testcases.add(getCurreentDate() + " | Pass : New supplier  " + supplier.get(0) + " already created");

			}

			currencyPage.clickOnCancel();
		}

		else {

			testcases.add(getCurreentDate() + " | Pass : New supplier  " + supplier.get(0)
					+ " already created and displayed in list");

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
		String xmlFilePath = folder  + "A091.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
