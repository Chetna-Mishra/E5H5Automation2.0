package com.adv.qa.selenium.tests.currency.phase2;

import java.util.ArrayList;
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
 * Test Reference No	: 	A087 Authorisation by Level/GL Responsibility (AP)
 * Purpose              :   Authorisation by Level/GL Responsibility for Accounts Payable
 * Date					:   25-06-2014/Modified on 02-May-2017, Its not yet completely modified (Chetna)
 * ACCESS               :   GOK
 */

public class A087_Authorisation_By_Level_Or_GL_ResponsibilityTest extends BaseTest{
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
		List<String> authorisationCode = dataRow.findNamesReturnValues("authorisationCode");
		List<String> Elements = dataRow.findNamesReturnValues("Elements");
		
		
		List<String> authorisationLev1 = dataRow.findNamesReturnValues("authorisationLev1");
		List<String> authorisationLev2 = dataRow.findNamesReturnValues("authorisationLev2");
		List<String> authorisationLev3 = dataRow.findNamesReturnValues("authorisationLev3");
		List<String> authorisationLev4 = dataRow.findNamesReturnValues("authorisationLev4");
		
		List<List<String>> authorisationLev = new ArrayList<>();
		authorisationLev.add(authorisationLev1);
		authorisationLev.add(authorisationLev2);
		authorisationLev.add(authorisationLev3);
		authorisationLev.add(authorisationLev4);
		
		
					
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Val Lvl/GL Resp Auth Defn list","Currency search page","displayed");
		
		
		for (int k = 0; k <= 4; k++) 
			
		{
		
		currencyPage.searchAUCode(companyId,authorisationCode, Elements, k);
			
		/*Verify New authorization by level or GL responsibility code displayed in the list*/
			if(currencyPage.verifyValues(Elements.get(k)))
			
			{
				testcases.add(getCurreentDate()+" | Pass : New authorisation by level or GL responsibility code "+Elements.get(k)+ " displayed in the list");
			
			}
			
			else
				
			{
				
			currencyPage.clickOnInsert();
			

			
			currencyPage.enterAuthorisationByLevelOrGLResponsibilityForAP(authorisationCode, Elements, k, authorisationLev,4);			
			
			/*Create batch type code*/
//			currencyPage.enterAuthorisationByLevelOrGLResponsibilityForAP(authorisationCode, Elements, k, authorisationLev1, authorisationLev2, authorisationLev3, authorisationLev4);
			
			currencyPage.clickOnCancel();
	
			/*Verify New authorization by level or GL responsibility code displayed in the list*/
			if(currencyPage.verifyValues(Elements.get(k)))
			
			{
				testcases.add(getCurreentDate()+" | Pass : New authorisation by level or GL responsibility code "+Elements.get(k)+ " displayed in the list");
			}
			else{
				testcases.add(getCurreentDate()+" | Fail : New authorisation by level or GL responsibility code "+Elements.get(k)+ " not displayed in the list");
				}
				
				}
				
			}
		
	
		
		currencyPage.logOut(2);
		
	}
		

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "A087.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
