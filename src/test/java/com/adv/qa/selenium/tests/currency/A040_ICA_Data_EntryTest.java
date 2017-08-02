package com.adv.qa.selenium.tests.currency;

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
import com.adv.qa.selenium.helpers.WaitHelper;

/**
 * @author : Draxayani Test Reference No : A040 ICA Data Entry Purpose : General
 *         Ledger ICA Postings Date : 26-05-2014 Modified : 04 July 2017 by
 *         Chetna ACCESS : EJI
 */

public class A040_ICA_Data_EntryTest extends BaseTest {
	/* Launch the browser */
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}

	@Test(dataProvider = "dp")
	public void verify(DataRow dataRow) throws InterruptedException {
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");

		List<String> aGroup = dataRow.findNamesReturnValues("aGroup");
		List<String> NstructureEnqForA02 = dataRow.findNamesReturnValues("NstructureEnqForA02");

		List<String> firstICAData = dataRow.findNamesReturnValues("firstICAData");
		List<String> firstJounData1 = dataRow.findNamesReturnValues("firstJounData1");
		List<String> firstJounData2 = dataRow.findNamesReturnValues("firstJounData2");

		List<List<String>> FJounList = new ArrayList<>();
		FJounList.add(firstJounData1);
		FJounList.add(firstJounData2);

		List<String> fAccount1500 = dataRow.findNamesReturnValues("fAccount1500");
		List<String> account6300 = dataRow.findNamesReturnValues("account6300");

		List<List<String>> NAccList1 = new ArrayList<>();
		NAccList1.add(fAccount1500);
		NAccList1.add(account6300);

		List<String> secondICAData = dataRow.findNamesReturnValues("secondICAData");
		List<String> secondJounData1 = dataRow.findNamesReturnValues("secondJounData1");
		List<String> secondJounData2 = dataRow.findNamesReturnValues("secondJounData2");

		List<List<String>> SJounList = new ArrayList<>();
		SJounList.add(secondJounData1);
		SJounList.add(secondJounData2);

		List<String> sAccount1500 = dataRow.findNamesReturnValues("sAccount1500");
		List<String> account6400 = dataRow.findNamesReturnValues("account6400");

		List<List<String>> NAccList2 = new ArrayList<>();
		NAccList2.add(sAccount1500);
		NAccList2.add(account6400);

		List<String> structureEnqForN1 = dataRow.findNamesReturnValues("structureEnqForN1");
		List<String> structureEnqForN2 = dataRow.findNamesReturnValues("structureEnqForN2");
		List<String> structureEnqForNBTZ = dataRow.findNamesReturnValues("structureEnqForNBTZ");

		List<List<String>> NstrctureList1 = new ArrayList<>();
		NstrctureList1.add(structureEnqForN1);
		NstrctureList1.add(structureEnqForN2);
		NstrctureList1.add(structureEnqForNBTZ);

		List<String> structureEnq2ForN1 = dataRow.findNamesReturnValues("structureEnq2ForN1");
		List<String> structureEnq2ForN2 = dataRow.findNamesReturnValues("structureEnq2ForN2");
		List<String> structureEnq2ForNBTZ = dataRow.findNamesReturnValues("structureEnq2ForNBTZ");

		List<List<String>> NstrctureList2 = new ArrayList<>();
		NstrctureList2.add(structureEnq2ForN1);
		NstrctureList2.add(structureEnq2ForN2);
		NstrctureList2.add(structureEnq2ForNBTZ);

		List<String> SstructureEnqForA02 = dataRow.findNamesReturnValues("SstructureEnqForA02");
		List<String> structureEnqForS1 = dataRow.findNamesReturnValues("structureEnqForS1");
		List<String> structureEnqForSBTZ = dataRow.findNamesReturnValues("structureEnqForSBTZ");

		List<List<String>> SstrctureList1 = new ArrayList<>();
		SstrctureList1.add(structureEnqForS1);
		SstrctureList1.add(structureEnqForSBTZ);

		List<String> NaccountGLICA = dataRow.findNamesReturnValues("NaccountGLICA");
		List<String> SaccountGLICA = dataRow.findNamesReturnValues("SaccountGLICA");

		List<List<String>> NSAccList1 = new ArrayList<>();
		NSAccList1.add(NaccountGLICA);
		NSAccList1.add(SaccountGLICA);

		List<String> thirdICAData = dataRow.findNamesReturnValues("thirdICAData");

		List<String> thirdJounData1 = dataRow.findNamesReturnValues("thirdJounData1");
		List<String> thirdJounData2 = dataRow.findNamesReturnValues("thirdJounData2");
		List<String> thirdJounData3 = dataRow.findNamesReturnValues("thirdJounData3");

		List<List<String>> TJounList = new ArrayList<>();
		TJounList.add(thirdJounData1);
		TJounList.add(thirdJounData2);
		TJounList.add(thirdJounData3);

		List<String> tAccount1500 = dataRow.findNamesReturnValues("tAccount1500");
		List<String> account16500 = dataRow.findNamesReturnValues("account16500");
		List<String> account26500 = dataRow.findNamesReturnValues("account26500");

		List<List<String>> NAccList3 = new ArrayList<>();
		NAccList3.add(tAccount1500);
		NAccList3.add(account16500);
		NAccList3.add(account26500);

		List<String> structureEnq3ForN1 = dataRow.findNamesReturnValues("structureEnq3ForN1");
		List<String> structureEnq3ForN2 = dataRow.findNamesReturnValues("structureEnq3ForN2");
		List<String> structureEnq3ForNBTZ = dataRow.findNamesReturnValues("structureEnq3ForNBTZ");

		List<List<String>> NstrctureList3 = new ArrayList<>();
		NstrctureList3.add(structureEnq3ForN1);
		NstrctureList3.add(structureEnq3ForN2);
		NstrctureList3.add(structureEnq3ForNBTZ);

		List<String> Naccount1GLICA = dataRow.findNamesReturnValues("Naccount1GLICA");

		List<List<String>> NAccList4 = new ArrayList<>();
		NAccList4.add(NaccountGLICA);
		NAccList4.add(Naccount1GLICA);

		List<String> EstructureEnqForA02 = dataRow.findNamesReturnValues("EstructureEnqForA02");
		List<String> structureEnqForE1 = dataRow.findNamesReturnValues("structureEnqForE1");
		List<String> structureEnqForEBTZ = dataRow.findNamesReturnValues("structureEnqForEBTZ");

		List<List<String>> EstrctureList1 = new ArrayList<>();
		EstrctureList1.add(structureEnqForE1);
		EstrctureList1.add(structureEnqForEBTZ);

		List<String> EaccountGLICA = dataRow.findNamesReturnValues("EaccountGLICA");

		List<List<String>> EAccList = new ArrayList<>();
		EAccList.add(EaccountGLICA);

		List<String> structureEnq1ForS1 = dataRow.findNamesReturnValues("structureEnq1ForS1");
		List<String> structureEnq1ForSBTZ = dataRow.findNamesReturnValues("structureEnq1ForSBTZ");

		List<List<String>> SstrctureList2 = new ArrayList<>();
		SstrctureList2.add(structureEnq1ForS1);
		SstrctureList2.add(structureEnq1ForSBTZ);

		List<String> Saccount1GLICA = dataRow.findNamesReturnValues("Saccount1GLICA");
		List<String> Saccount2GLICA = dataRow.findNamesReturnValues("Saccount2GLICA");

		List<List<String>> SAccList = new ArrayList<>();
		SAccList.add(Saccount1GLICA);
		SAccList.add(Saccount2GLICA);

		List<String> WstructureEnqForA02 = dataRow.findNamesReturnValues("WstructureEnqForA02");
		List<String> structureEnqForW1 = dataRow.findNamesReturnValues("structureEnqForW1");
		List<String> structureEnqForWBTZ = dataRow.findNamesReturnValues("structureEnqForWBTZ");

		List<List<String>> WstrctureList1 = new ArrayList<>();
		WstrctureList1.add(structureEnqForW1);
		WstrctureList1.add(structureEnqForWBTZ);

		List<String> Waccount1GLICA = dataRow.findNamesReturnValues("Waccount1GLICA");
		List<String> Waccount2GLICA = dataRow.findNamesReturnValues("Waccount2GLICA");
		List<String> Waccount3GLICA = dataRow.findNamesReturnValues("Waccount3GLICA");

		List<List<String>> WAccList = new ArrayList<>();
		WAccList.add(Waccount1GLICA);
		WAccList.add(Waccount2GLICA);
		WAccList.add(Waccount3GLICA);

		/* Log in to application */
		LoginPage loginPage = new LoginPage(driver);

		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);

		/* Navigate to currency page Home page e5 application */
		CurrencyPage currencyPage = new CurrencyPage(driver);

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		// EDB
		enterJournalDetails(currencyPage, dataRow, FJounList, firstICAData, 2);// 1st

		// EJI
		accountDetailEnquiry(currencyPage, dataRow, NAccList1, aGroup, 2);

		currencyPage.clickOnCancel();

		// EJJ
		verifyBalanceEnquiry(currencyPage, dataRow, NstrctureList1, NstructureEnqForA02, 3);

		// EDB
		enterJournalDetails(currencyPage, dataRow, SJounList, secondICAData, 2); // 2nd
																					// JournalDetails

		// EJI
		accountDetailEnquiry(currencyPage, dataRow, NAccList2, aGroup, 2);// 2nd
																			// AccountDetails

		currencyPage.clickOnCancel();

		// EJJ
		verifyBalanceEnquiry(currencyPage, dataRow, NstrctureList2, NstructureEnqForA02, 3); // 2nd
																								// BalanceEnq

		verifyBalanceEnquiry(currencyPage, dataRow, SstrctureList1, SstructureEnqForA02, 2);//South

		// EJB
		TansacDetailEnquiry(currencyPage, dataRow, NSAccList1, 2);//North & South

		currencyPage.clickOnCancel();

		// EDB
		enterJournalDetails(currencyPage, dataRow, TJounList, thirdICAData, 3); // 3rd
																				// JournalDetails

		// EJJ
		verifyBalanceEnquiry(currencyPage, dataRow, NstrctureList3, NstructureEnqForA02, 3);//North

		// EJB
		TansacDetailEnquiry1(currencyPage, dataRow, NAccList4, 2);//North

		currencyPage.clickOnCancel();
		
		// EJJ
		verifyBalanceEnquiry(currencyPage, dataRow, EstrctureList1, EstructureEnqForA02, 2);//East

		// EJB
		TansacDetailEnquiry1(currencyPage, dataRow, EAccList, 1);//East

		currencyPage.clickOnCancel();

		// EJJ
		verifyBalanceEnquiry(currencyPage, dataRow, SstrctureList2, SstructureEnqForA02, 2);//South

		// EJB
		TansacDetailEnquiry1(currencyPage, dataRow, SAccList, 2);//South

		/* Need to check data */
		// EJJ
		 verifyBalanceEnquiry(currencyPage, dataRow, WstrctureList1,WstructureEnqForA02, 2);//West

		 // EJB
		 TansacDetailEnquiry1(currencyPage, dataRow, WAccList, 3);//West
		 
		 currencyPage.clickOnCancel();

		 currencyPage.logOut(1);

	}

	
	
	// maxVal=3, int maxVal is for number of List element
	// int i =0, for Picking List values
	// i+1, is for row number

	private void enterJournalDetails(CurrencyPage currencyPage, DataRow dataRow, List<List<String>> Journ,
			List<String> icaData, int maxVal) throws InterruptedException {

		String code = "EDTEBTCH ACT=INSERT,CMPY=" + companyId;

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");

		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.fillCurrenceyCode(code);

		/* Verify currency search page displayed */
		Assert.assertEquals(testcases, currencyPage.getTableHeader(), "M" + currencyCode.get(0) + " - Journal Header",
				"Search page", "displayed");

		/* Enter Journal details */
		currencyPage.enterJournalDetails(icaData);

		currencyPage.clickOnLines();

		WaitHelper.waitAdditional(3);

		for (int i = 0; i < maxVal; i++) {

			boolean enterJournalLines;

			enterJournalLines = currencyPage.enterJournalLines(Journ.get(i), i + 1);

			Assert.assertTrue(testcases, enterJournalLines, "Journal Lines values are", " as expected");

		}
		currencyPage.clickOnUpdate();

		currencyPage.clickOnAcceptWarnings();

		currencyPage.clickOnUpdate();

	}

	private void accountDetailEnquiry(CurrencyPage currencyPage, DataRow dataRow, List<List<String>> Acc,
			List<String> group, int maxVal) throws InterruptedException {

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.clickOnChangeCompany(companyId);

		currencyPage.fillCurrenceyCode(currencyCode.get(1));

		currencyPage.verifyBalanceSheetDetail(group);

		currencyPage.navigateToAccountDetailPage();

		for (int i = 0; i < maxVal; i++) {

			currencyPage.getAccountDetailValues(Acc.get(i));

			boolean verifyAccValuesForAcc;

			verifyAccValuesForAcc = currencyPage.verifyAccValues(Acc.get(i), i + 1);
			Assert.assertTrue(testcases, verifyAccValuesForAcc, "Account Enquiry values are", " as expected");

		}
		currencyPage.clickOnCancel();

	}

	private void verifyBalanceEnquiry(CurrencyPage currencyPage, DataRow dataRow, List<List<String>> structure, List<String> structureEnqForCategory, int maxVal) throws InterruptedException {

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");

		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.clickOnChangeCompany(companyId);

		currencyPage.fillCurrenceyCode(currencyCode.get(2));

		currencyPage.structureEnquiry(structureEnqForCategory);

		for (int i = 0; i < maxVal; i++) {

			boolean verifyStrEnqValuesForCost;

			verifyStrEnqValuesForCost = currencyPage.verifyStrEnqValues(structure.get(i), i + 1);
			
			Assert.assertTrue(testcases, verifyStrEnqValuesForCost, "Struncture Enquiry values are", " as expected");
		}

		currencyPage.clickOnCancel();

	}

	private void TansacDetailEnquiry(CurrencyPage currencyPage, DataRow dataRow, List<List<String>> Transc, int maxVal) throws InterruptedException {

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.clickOnChangeCompany(companyId);

		currencyPage.fillCurrenceyCode(currencyCode.get(3));

		currencyPage.getTranDetailValues(Transc.get(0));

		currencyPage.navigateToCostDetailPage();

		for (int i = 0; i < maxVal; i++) {

			boolean verifyTranscValues;

			verifyTranscValues = currencyPage.verifyTranscValues(Transc.get(i), i + 1);

			Assert.assertTrue(testcases, verifyTranscValues, "Transaction Enquiry values are", " as expected");

		}
		currencyPage.clickOnCancel();
		currencyPage.clickOnCancel();

	}

	private void TansacDetailEnquiry1(CurrencyPage currencyPage, DataRow dataRow, List<List<String>> Transc, int maxVal)
			throws InterruptedException {

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.clickOnChangeCompany(companyId);

		currencyPage.fillCurrenceyCode(currencyCode.get(3));

		currencyPage.getTranDetailValues1(Transc.get(0));

		currencyPage.clickOnDrillDown();

		for (int i = 0; i < maxVal; i++) {

			boolean verifyTranscValues;

			verifyTranscValues = currencyPage.verifyTranscValues(Transc.get(i), i + 1);

			Assert.assertTrue(testcases, verifyTranscValues, "Transaction Enquiry values are", " as expected");
		}

		currencyPage.clickOnCancel();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		super.tearDown();
	}

	@DataProvider
	public Object[][] dp() {
		String folder = "src/test/resources/";
		String xmlFilePath = folder + "A040.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow[][] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
