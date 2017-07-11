package com.adv.qa.selenium.tests.currency;

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
 * Test Reference No	: 	A030 Security Elements
 * Purpose              :   Set Up Default Security Group Structure Elements
 * Date					:   02-05-2014
 * ACCESS               :   ENI and AFF
 */

public class A030_Security_ElementsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		
		List<String> currencyCode = dataRow.findNamesReturnValues("code");
		List<String> securityList = dataRow.findNamesReturnValues("securityList");
		String securityAdd = "EDTUSRCMPY ACT=INSERT,USER="+userName+",COMPANY="+companyId+",SCTY-GROUP="+securityList.get(0)+"";
		String securityAmend = "EDTUSRCMPY ACT=AMEND,USER="+userName+",COMPANY="+companyId+",SCTY-GROUP="+securityList.get(0)+"";
				
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
			
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Security Group Struc Element","Currency search page","displayed");
			
		currencyPage.searchValue(companyId,securityList, 4, 3);
			
		currencyPage.clickOnInsert();
			
		/*Create security element code*/
		currencyPage.enterSecurityGroupStructureDetails(securityList);	
			
		currencyPage.clickOnUpdate();
			
		/*Exit from the security element page*/
		currencyPage.clickOnCancel();
	
		/*Verify new security element displayed in the list*/
		if(currencyPage.verifyValues(securityList.get(2))){
			testcases.add(getCurreentDate()+" | Pass : Security element "+securityList.get(2)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : Security element "+securityList.get(2)+ " not displayed in the list");
		}
			
		currencyPage.clickOnCancel();

		currencyPage.fillCurrenceyCode(securityAdd);
			
		currencyPage.enterUserDetails(securityList);
			
		currencyPage.clickOnUpdate();
			
		currencyPage.isCommandDisplayed();
			
		currencyPage.fillCurrenceyCode(securityAmend);
			
		boolean userDetail = currencyPage.getUserDetails(securityList);
			
		Assert.assertTrue(testcases,userDetail,"User does","have access to Element HQ");
			
		currencyPage.clickOnCancel();
			
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.logOut(1);
	}
	

	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A030" };
		String [] selectedNames = {"userName","passWord","code","securityList"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
	
}
