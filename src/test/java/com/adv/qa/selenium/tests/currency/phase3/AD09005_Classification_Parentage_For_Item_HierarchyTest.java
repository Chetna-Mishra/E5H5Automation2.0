package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	D09005 Classification Parentage for Item Hierarchy 
* Modified Date		:   Modified by Chetna/Dt: 28-Aug-2017
 * Purpose              :   Create Parentage Codes for Item Hierarchy 
 * ACCESS               :   PYC
 */

public class AD09005_Classification_Parentage_For_Item_HierarchyTest extends BaseTest{
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
		List<String> classificationStructure = dataRow.findNamesReturnValues("classificationStructure");
		List<String> amendCompany = dataRow.findNamesReturnValues("amendCompany");
		List<String> classificationCodeBud = dataRow.findNamesReturnValues("classificationCodeBud");
		List<String> classificationCodeHigh = dataRow.findNamesReturnValues("classificationCodeHigh");
		List<String> classificationCodeMid = dataRow.findNamesReturnValues("classificationCodeMid");
		String SuccMessage = "The previously-requested action has been performed";

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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Classification Structure List","Currency search page","displayed");

		currencyPage.searchValue(companyId,2,0);
		
		currencyPage.clickOnInsert();
		
		currencyPage.createClassificationStructure(classificationStructure);
		
		currencyPage.clickOnUpdate();
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "Classification Structure", " created successfully");//Update
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.clickOnCancel();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Purchasing Company Controls Li","Currency search page","displayed");

		currencyPage.searchValue(companyId,1,0);

		currencyPage.clickOnAmend();
		
		currencyPage.amendPurchasingCompanyControl(amendCompany);
		
		currencyPage.clickOnUpdate();
		
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "Purchasing Company Control ", "Updated successfully");
		
		currencyPage.clickOnCancel();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Classification Parentage List","PYB search page","displayed");
		
		currencyPage.searchValue(companyId,classificationStructure,2,6);
		
		currencyPage.clickOnInsert();
		
		createSecurityGroups(currencyPage,classificationCodeHigh,0);
		createSecurityGroups(currencyPage,classificationCodeMid,1);
		createSecurityGroups(currencyPage,classificationCodeBud,1);
		
		currencyPage.clickOnCancel();
		

		currencyPage.logOut(2);
	}
	
	
	private void createSecurityGroups(CurrencyPageNew currencyPage,List<String> elements,int i) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		currencyPage.classificationParentage(elements,i);
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New classification code "+elements.get(0), "created successfully");
		
		
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
		String[] nodeID = { "AD09005" };
		String [] selectedNames = {"userName","passWord","currencyCode","classificationStructure","amendCompany","classificationCodeMid"
				,"classificationCodeHigh","classificationCodeBud"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
