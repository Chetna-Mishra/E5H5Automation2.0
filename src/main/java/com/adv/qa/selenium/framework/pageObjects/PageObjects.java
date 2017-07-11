package com.adv.qa.selenium.framework.pageObjects;

public class PageObjects {
	public final String ZERO = "0";
	public final String ONE = "1";
	public final String TWO = "2";
	public final String THREE = "3";
	public final String FOUR = "4";
	public final String FIVE = "5";
	public final String SIX = "6";
	public final String EIGHT = "8";
	public final String SEVEN = "7";
	public final String NINE = "9";
	public final String TEN = "10";
	public final String _ = "_";
	public final String LABEL = "_label";
	public final String CURRENCY_PANE = "dijitContentPane";
	// public final String SECTION_LAYOUT = "dijitTitlePaneTextNode";
	public final String SECTION_LAYOUT = "html_TitlePaneTitle panelCollapsed";
	// Use AllPG_SELEC and AllPG_EXT_SELEC for SECTION_LAYOUT
	// public final String CURRENCY_TABLE_CELL = "dojoxGridCell";
	// Use A001A_CURRENCY_TABLE_CELL for CURRENCY_TABLE_CELL
	// public final String XDJ_COLUMN_DEF = "0_tabPaneId_2";
	public final String XDJ_COLUMN_DEF = "ui-id-12";
	public final String XDJ_DEFINITION_DEF = "0_tabPaneId_5";
	public final String HEADER_TAB_BTN = "roundedbutton";
	public final String TOP_HEADER_TAB_BTN = "dijitReset";
	// public final String COLUMN_DEFINITION_LABEL =
	// "0_tabbedPanel_1_tablist_0_tabPaneId_2";
	// public final String DEFINITION_DEF_LABEL =
	// "0_tabbedPanel_1_tablist_0_tabPaneId_5";
	public final String COMPANY_EDIT_TABLE = "0_tabbedPanel_1";
	public final String FIRST_TAB = "0_tabPaneId_1";
	// Use for A006_PRIMARY_TAB FOR FIRST_TAB
	public final String SECOND_TAB = "0_tabPaneId_2";
	public final String THIRD_TAB = "0_tabPaneId_3";
	public final String FOURTH_TAB = "0_tabPaneId_4";
	public final String FIFTH_TAB = "0_tabPaneId_5";
	public final String SIXTH_TAB = "0_tabPaneId_6";
	public final String SEVENTH_TAB = "0_tabPaneId_7";
	public final String EIGHTH_TAB = "0_tabPaneId_8";
	public final String NINTH_TAB = "0_tabPaneId_9";
	public final String TAB = "0_tabPaneId_";
	public final String TAB_STRIP = "0_tabbedPanel_1_tablist_";
	public final String CHECK = "chk_";
	public final String SIX_ = "6_";
	public final String TWO_ = "2_";
	public final String ZERO_ = "0_";
	public final String _ZERO = "_0";
	public final String _FIRST = "_1";
	public final String _TWO = "_2";
	public final String FOUR_ = "4_";
	public final String ABOUT_TO_SUBMIT = "dojoxFloatingPaneTitle";
	public final String MESSAGE_NODE_LABEL = "msgnode_label";
	// Use AllPG_MSG_BUTTON_LABEL for MESSAGE_NODE_LABEL
	public final String TOOL_TIP_CONTENT = "msgtooltip";
	// Use AllPG_MSG_TOOLBAR for TOOL_TIP_CONTENT
	public final String PAGE_NAME = "action_0";
	public final String NEW_TOP_HEADER_TAB_BTN = "roundedbutton";
	// Use AllPG_HeaderSection for NEW_TOP_HEADER_TAB_BTN

	// Top Most Section common Application Menus
	public final String TPMN_EXIT = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Exit']";
	public final String TPMN_SELECTION = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Selection']";
	public final String TPMN_CHANGE = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Change']";
	public final String TPMN_DIARY = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Diary']";
	public final String TPMN_FUNCTIONS = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Functions']";
	public final String TPMN_SESSION = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Session']";

	// Common Buttons on All pages

	public final String AllPG_SELEC = "//div[@class='html_TitlePaneTitle panelCollapsed']/a[not(contains(text(),'Extended'))]";
	public final String AllPG_EXT_SELEC = "//div[@class='html_TitlePaneTitle panelCollapsed']/a[contains(text(),'Extended Selection')]";

	public final String AllPG_HeaderSection = "//button[contains(@class,'roundedbutton')]/span";
	public final String AllPG_MSG_TOOLBAR = "//span[contains(@class,'toolbarMessages')]";

	public final String ERROR_MSG_BAR = "//div[contains(@class,'errorLine')]";

	public final String AllPG_MSG_DIV = "//div[@class='errorsDiv']";

	public final String AllPG_MSG_BUTTON_LABEL = "//button[@name='msgnode']/span[contains(@class,'ButtonLabel')]";
	public final String All_SEARCH_MSG_TOOLBAR = "//div[contains(@class,'errorLine')]";

	public final String AllPG_CANCEL = "//button[starts-with(@class,'roundedbutton')][@value='Cancel']";
	public final String AllPG_EXIT = "//button[starts-with(@class,'roundedbutton')][@value='Exit']";
	public final String AllPG_BKWD = "//button[starts-with(@class,'roundedbutton')][@value='Bkwd']";
	public final String AllPG_REFRESH = "//button[starts-with(@class,'roundedbutton')][@value='Refresh']";
	public final String AllPG_MORE = "//button[starts-with(@class,'roundedbutton')][@value='More']";
	public final String AllPG_AMEND = "//button[starts-with(@class,'roundedbutton')][@value='Amend']";
	public final String AllPG_VIEW = "//button[starts-with(@class,'roundedbutton')][@value='View']";
	public final String AllPG_INSERT = "//button[starts-with(@class,'roundedbutton')][@value='Insert']";
	public final String AllPG_COPY = "//button[starts-with(@class,'roundedbutton')][@value='Copy']";
	public final String AllPG_PAPERCLIP = "//button[starts-with(@class,'roundedbutton')][@value='Paperclip']";
	public final String AllPG_FUNCTION_HISTORY = "//button[starts-with(@class,'roundedbutton')][@value='Functions History']";
	public final String AllPG_FUNCTION_SEARCH = "//button[starts-with(@class,'roundedbutton')][@value='Functions Search']";
	public final String AllPG_FAVOURITE_ENQUIRIES = "//button[starts-with(@class,'roundedbutton')][@value='Favourite Enquiries']";
	public final String AllPG_CODE_SWITCH = "//button[starts-with(@class,'roundedbutton')][@value='Code Switch']";
	public final String AllPG_PROMPT = "//button[starts-with(@class,'roundedbutton')][@value='Prompt']";
	public final String AllPG_HELP = "//button[starts-with(@class,'roundedbutton')][@value='Help']";

	public final String AllPG_INSERT1 = "//button[starts-with(@class,'roundedbutton')][@name='action_503']";
	public final String AllPG_UPDATE1 = "//button[starts-with(@class,'roundedbutton')][@name='action_940']";
	public final String AllPG_CANCEL1 = "//button[starts-with(@class,'roundedbutton')][@name='action_998']";
	public final String AllPG_AMEND1 = "//button[starts-with(@class,'roundedbutton')][@name='action_502']";
	public final String AllPG_REFRESH1 = "//button[starts-with(@class,'roundedbutton')][@name='action_943']";

	// public final String AllPG_EXIT =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_942']";
	//
	// public final String AllPG_FWD =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_960']";
	// public final String AllPG_BKWD =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_961']";
	// public final String AllPG_REFRESH =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_943']";
	// public final String AllPG_MORE =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_947']";
	// public final String AllPG_AMEND =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_502']";
	// public final String AllPG_VIEW =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_501']";
	// public final String AllPG_COPY =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_504']";
	// public final String AllPG_HIREACHI =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_56']";
	// public final String AllPG_PAPERCLIP =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_0']";
	// public final String AllPG_PER_QUERY =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_949']";
	// public final String AllPG_FAVOURITE_ENQUIRIES =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_924']";
	// public final String AllPG_DISABLD_SWI =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_959']";
	// public final String AllPG_CODE_SWITCH =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_958']";
	// public final String AllPG_PROMPT =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_950']";
	// public final String AllPG_HELP =
	// "//button[starts-with(@class,'roundedbutton')][@name='action_980']";
	//
	// public final String AllPG_FUNCTION_HISTORY =
	// "//button[starts-with(@class,'roundedbutton')][@value='Functions
	// History']";
	// public final String AllPG_FUNCTION_SEARCH =
	// "//button[starts-with(@class,'roundedbutton')][@value='Functions
	// Search']";

	// Common Footer Buttons on All pages

	public final String AllPG_FOOT_SEC = "//button[starts-with(@class,'button roundedbutton')]";

	// Exit Confirmation Message Page Objects

	public final String CONF_BUT_YES = "//div[contains(@class,'roundedCorners')]/button[@value='Yes']";

	// Login Page Objects
	public final String LOGIN_USER_NAME = "//input[starts-with(@name,'USR_')]";
	public final String LOGIN_PASSWORD = "//input[starts-with(@name,'PSWD_')]";
	public final String LOGIN_NWPASSWORD = "//input[starts-with(@name,'NEW-PSWD_')]";
	public final String LOGIN_SIGNIN = "//button[@value='Sign in']";

	// Command prompt Page objects
	public final String CMD_COMMAND = "//fieldset/legend[text()='Command']/..//input[contains(@name,'COMMAND')]";
	public final String CMD_OK = "//div/button[contains(@class,'button roundedbutton')][@value='OK']";
	public final String CMD_PROMPT = "//div/button[contains(@class,'button roundedbutton')][@value='Prompt']";
	public final String CMD_CHANGE_COMPANY_ROLE = "//div/button[contains(@class,'button roundedbutton')][@value='Change Company / Role']";
	public final String CMD_CANCEL = "//div/button[contains(@class,'button roundedbutton')][@value='Cancel']";

	// Page Objects for "A001_Switch_Intra_Company_Accounting_OnTest"

	public final String A001_FINANCIAL_MODULE_TAB = "//a[contains(@class,'ui-tabs-anchor')]/following::a[text()='Financial Modules']";

	public final String A001_GENERAL_LEDGER = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='General Ledger']/../input[1]";
	public final String A001_INTRA_COMPANY_ACCOUNTING = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Intra Company Accounting']/../input[1]";
	public final String A001_AVERAGE_DAY_BALANCE = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Average Days Balance']/../input[1]";
	public final String A001_VALUE_DATED_ACCOUNTING = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Value Dated Accounting']/../input[1]";
	public final String A001_COMM_ACCOUNTING = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Commitment Accounting']/../input[1]";
	public final String A001_TIME_RECO = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Timesheet Recording']/../input[1]";
	public final String A001_JOB_BIL = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Job Billing']/../input[1]";

	public final String A001_PROJECT_TRACKING = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Project Tracking']/../input[1]";
	public final String A001_BANK_REC = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Bank Reconciliation']/../input[1]";
	public final String A001_DRIECT = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Direct Debit Mandates']/../input[1]";
	public final String A001_PROPS_MNGT = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Proposed Project Management']/../input[1]";
	public final String A001_FIXD_ASS = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Fixed Assets']/../input[1]";
	public final String A001_LEAS = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Leasing']/../input[1]";

	public final String A001_PURCHASING_MODULE_TAB = "//a[contains(@class,'ui-tabs-anchor')]/following::a[text()='Purchasing Modules']";
	public final String A001_ACCOUNTS_PAYABLE = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Accounts Payable']/../input[1]";
	public final String A001_cISEDI = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='CIS EDI']/../input[1]";
	public final String A001_SER_LDGR = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Service Ledger']/../input[1]";
	public final String A001_PURCHASING_MANAGEMENT = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Purchasing Management']/../input[1]";
	public final String A001_INVENTORY_MANAGEMENT = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Inventory Management']/../input[1]";
	public final String A001_IN_FLIGHT = "//fieldset/legend[text()='E5 Modules Available']/..//label[text()='In Flight Direct Operating Costs']/../input[1]";

	// Page Objects for "A001A_On_line_AuditingTest"
	public final String A001A_NAV_BAR = "//div[contains(@class,'navbar')]/..//div[contains(@class,'variantHeader')]";
	public final String A001A_TABLE = "//div/input[starts-with(@name,'PARAM-ENTY_')]";

	public final String A001A_CURRENCY_TABLE_CELL = "//td[starts-with(@class,'dojoxGridCell')]";
	public final String A001A_COLUMN_DEFINATION_TAB = "//a[@class='ui-tabs-anchor'][text()='Column Definition']";
	public final String A001A_DEFINATION_DEF_TAB = "//a[@class='ui-tabs-anchor'][text()='Definition Defn.']";
	public final String A001A_OK = "//button[contains(@class,'roundedbutton')][@value='OK']";

	public final String A001A_AUDIT = "//label[text()='Audit']/../input[1]";
	public final String A001A_SUPP_AUDIT = "//label[text()='Support Auditing']/../input[1]";

	public final String A001A_AUD_KEPT = "//input[starts-with(@name,'AUDT-KEEP-NUM_')]";
	public final String A001A_PROC_LVL = "//input[starts-with(@name,'PROC-LVL_')]";

	// Page Objects for "A002_Currency_DescriptionTest"
	public final String A002_CURRENCY = "//input[contains(@name,'CURR_')]";
	public final String A002_OK = "//button[contains(@class,'roundedbutton')][@value='OK']";
	public final String A002_DESCRIPTION = "//input[contains(@name,'DESCR_')]";
	public final String A002_DECIMAL_P = "//input[contains(@name,'DECMLP_')]";
	public final String A002_UNIT = "//input[contains(@name,'UNIT_')]";
	public final String A002_UNITS = "//input[contains(@name,'UNITS_')]";
	public final String A002_SUN_UNIT = "//input[contains(@name,'SUB-UNIT_')]";
	public final String A002_SUN_UNITS = "//input[contains(@name,'SUB-UNITS_')]";
	public final String A002_EMU_IND = "//select[contains(@name, 'EMU-IND_')]";

	public final String A002_FIXED_RATE = "//input[contains(@name,'FIXED-XRATE_')]";
	public final String A002_DATE_OF_ENTRY = "//input[contains(@name,'datefield_')]";
	public final String A002_ROUNDING_IND = "//select[contains(@name,'RNDG-IND_')]";

	// Page Objects for "A003_Currency_Base_NonBase_RelationshipsTest"

	public final String A003_BASE_CURR = "//input[starts-with(@name,'PARAM-BASE-CURR')]";
	public final String A003_NONBASE_CURR = "//input[starts-with(@name,'PARAM-NBASE-CURR')]";
	public final String A003_DIRECTION = "//select[starts-with(@name,'CONV-DRCTN_')]";
	public final String A003_CONVERSION_UNIT = "//input[starts-with(@name,'CONV-UNITS_')]";
	public final String A003_TOLERANCE_PERC = "//input[starts-with(@name,'TOL-PERC_')]";
	public final String A003_TOLERANCE_AMT = "//input[starts-with(@name,'TOL-AMOUNT_')]";
	public final String A003_BASE_CURR_IN = "//input[starts-with(@name,'BASE-CURR_')]";
	public final String A003_NONBASE_CURR_IN = "//input[starts-with(@name,'NON-BASE-CURR_')]";

	// Page Objects for "A004_Currency_Exchange_Rate_TypesTest"

	public final String A004_RATE_TYPE = "//input[starts-with(@name,'RATE-TYPE')]";

	// Page Objects for "A004A_Rate_Type_Currency_ExchangeTest"
	public final String A004A_DESCR = "//input[starts-with(@name,'DESCR')]";

	// Page Objects for "A005_Currency_Exchange_RatesTest"
	public final String A005_RATE_TYPE = "//input[starts-with(@name,'PARAM-RATE-TYPE')]";
	public final String A005_EXCHANGE_RATE = "//input[starts-with(@name,'EXCH-RATE')]";
	public final String A005_TOLERANCE_PER = "//input[starts-with(@name,'TOL-PERC')]";
	public final String A005_TOLERANCE_AMT = "//input[starts-with(@name,'TOL-AMOUNT')]";

	// Page Objects for "A006_Company_DefinitionTest"

	// public final String A006_PRIMARY_TAB =
	// "//a[@class='ui-tabs-anchor'][text()='Primary Details']";
	public final String A006_PRIMARY_TAB = "//ul/li/a[@class='ui-tabs-anchor'][text()='Primary Details']";
	public final String A006_COMPANY = "//input[starts-with(@name,'CMPY_')]";
	public final String A006_NAME = "//input[starts-with(@name,'ADDR-NAME_')]";
	public final String A006_ADDR1 = "//input[starts-with(@name,'ADDR1_')]";
	public final String A006_ADDR2 = "//input[starts-with(@name,'ADDR2_')]";
	public final String A006_ADDR3 = "//input[starts-with(@name,'ADDR3_')]";
	public final String A006_ADDR4 = "//input[starts-with(@name,'ADDR4_')]";
	public final String A006_ADDR5 = "//input[starts-with(@name,'ADDR5_')]";
	public final String A006_ADDR6 = "//input[starts-with(@name,'ADDR6_')]";
	public final String A006_PSOT_CODE = "//input[starts-with(@name,'POST-CODE_')]";
	public final String A006_TEL = "//input[starts-with(@name,'TEL_')]";
	public final String A006_FAX = "//input[starts-with(@name,'FAX_')]";
	public final String A006_TELEX = "//input[starts-with(@name,'TELEX_')]";
	public final String A006_REG_NUM = "//input[starts-with(@name,'REG-NUM_')]";

	public final String A006_CURRENCY_EC_TAB = "//a[@class='ui-tabs-anchor'][text()='Currency/EC Intrastat']";
	public final String A006_EMU_FLAG = "//label[text()='EMU Flag']/../input[1]";
	public final String A006_CURR_FLAG = "//label[text()='Currency Flag']/../input[1]";
	public final String A006_CACHE = "//label[text()='Cache']/../input[1]";
	public final String A006_COUNTRY = "//input[starts-with(@name,'CNTRY_')]";

	// Page Objects for "A007_DevicesTest"

	public final String A007_DEVICE = "//input[starts-with(@name,'DEVICE_')]";
	public final String A007_DEFINATION1 = "//input[starts-with(@name,'DATA-DESCR-01_')]";
	public final String A007_DEFINATION2 = "//input[starts-with(@name,'DATA-DESCR-02_')]";
	public final String A007_DEFINATION3 = "//input[starts-with(@name,'DATA-DESCR-03_')]";
	public final String A007_DEFINATION4 = "//input[starts-with(@name,'DATA-DESCR-04_')]";
	public final String A007_DEFINATION5 = "//input[starts-with(@name,'DATA-DESCR-05_')]";
	public final String A006_UPPR_CASE = "//label[text()='Upper Case']/../input[1]";

	// Page Objects for "A008_DestinationsTest"
	public final String A007_DEST = "//input[starts-with(@name,'DEST_')]";
	public final String A007_SPOOL_ONLY = "//div/input[@name='TYPE']/..//label[contains(text(), 'Spool Only')]";

	// Page Objects for "A009_Distribution_ProfileTest"
	public final String A009_PROFILE = "//input[starts-with(@name,'DSTRP_')]";
	public final String A009_NO_COPIES = "//input[starts-with(@name,'COPIES_')]";
	public final String A009_SUPPR_BANN = "//div/input[@type='checkbox']/..//label[text()='Suppress Banner']/../input[1]";

	// Page Objects for "A010_Environment_Groups_Test"

	public final String A010_ENV_GRP = "//input[starts-with(@name,'ENVR-GRP_')]";
	public final String A010_SESS_TIME = "//input[starts-with(@name,'TIME-LIMIT_')]";
	public final String A010_PASS_EXP = "//input[starts-with(@name,'PSWD-LIMIT_')]";
	public final String A010_MAX_SESS = "//input[starts-with(@name,'SESS-LIMIT_')]";
	public final String A010_PROFILE = "//input[starts-with(@name,'DFLT-DSTRP_')]";
	public final String A010_RAD_NORMAL = "//div/input[@name='CONV-IND_1'][@value='Normal']";

	// Page Objects for "A011_UsersTest"

	public final String A011_SEARCH_USER = "//input[starts-with(@name,'PARAM-USR_')]";
	public final String A011_DEFAULT_CMPNY = "//input[starts-with(@name,'DFLT-CMPY_')]";
	public final String A011_USER1 = "//input[starts-with(@name,'USR_')]";
	public final String A011_MENU = "//input[starts-with(@name,'MENU_')]";
	public final String A011_NON_CMPNY = "//input[starts-with(@name,'SCTY-GRP_')]";
	public final String A011_CMPNY = "//input[starts-with(@name,'SCTY-GRP-CMPY_')]";

	public final String A011_REPORT = "//input[starts-with(@name,'RPRT-SCTY-GRP_')]";
	public final String A011_REPORT_CMPNY = "//input[starts-with(@name,'RPRT-SCTY-CMPY_')]";
	public final String A011_EWS_PRTN = "//input[starts-with(@name,'EWS-PRTN_')]";
	public final String A011_LANG = "//input[starts-with(@name,'LANG_')]";

	// Page Objects for "A012_CalendarsTest"
	public final String A012_ACTIVITY = "//input[starts-with(@name,'ACTVT')]";
	public final String A012_TYPE = "//select[starts-with(@name,'ACTVT-TYPE_')]";
	public final String A012_MON = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[1]";
	public final String A012_TUE = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[2]";
	public final String A012_WED = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[3]";
	public final String A012_THU = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[4]";
	public final String A012_FRI = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[5]";
	public final String A012_SAT = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[6]";
	public final String A012_SUN = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[7]";
	public final String A012_O_FREQ = "//input[starts-with(@name,'FREQ')]";
	public final String A012_DAY_OF_WEEK = "//fieldset/div/select[contains(@name,'DD_')]";
	public final String A012_EVENT_SPECIFIED = "//INPUT[starts-with(@name,'CHILD-ACTVT-W_')]";

	// Page Objects for "A013_Fiscal_CalendarTest"
	public final String A013_BTM_BUT_SECTION = "//div/button[contains(@class,'button roundedbutton')]";
	public final String A013_CALENDER = "//input[starts-with(@name,'CLNDR_')]";
	public final String A013_YEARS = "//button[starts-with(@class,'button roundedbutton')][@value='Years']";
	public final String A013_EVENTH = "//div/button[contains(@class,'button roundedbutton')][@value='Events (H)']";
	public final String A013_WEEKENDDAY = "//div/select[starts-with(@name,'WK-END-DATE_')]";
	public final String A013_LVL_NAME = "//div[1]/table/tbody/tr/td[3]";
	public final String A013_LVL_NAME1 = "//div[1]/table/tbody/tr/td[3]/input";
	public final String A013_LVL_DESC = "//div[1]/table/tbody/tr/td[4]";
	public final String A013_LVL_DESC1 = "//div[1]/table/tbody/tr/td[4]/input";
	public final String A013_YR_YEAR = "//div[1]/table/tbody/tr/td[2]";
	public final String A013_YR_YEAR1 = "//div[1]/table/tbody/tr/td[2]/input";
	public final String A013_YR_NAME = "//div[1]/table/tbody/tr/td[3]";
	public final String A013_YR_NAME1 = "//div[1]/table/tbody/tr/td[3]/input";
	public final String A013_YR_START = "//div[1]/table/tbody/tr/td[4]";
	public final String A013_YR_START1 = "//div[1]/table/tbody/tr/td[4]/input";
	public final String A013_YR_END = "//div[1]/table/tbody/tr/td[5]";
	public final String A013_YR_END1 = "//div[1]/table/tbody/tr/td[5]/input";
	public final String A013_START_DATE = "//div/Input[starts-with(@name,'datefield_')]";
	public final String A013_ACTIVITY = "//Input[starts-with(@name,'ACTVT-NAME_')]";
	public final String A013_EVENT_LVL = "//div[1]/table/tbody/tr/td[2]";

	// Page Objects for "A014_Account_Code_DefinitionTest1",
	// enterAccountDefinitionDetails
	public final String A014_NOMINAL_CODE = "//input[starts-with(@name,'NOML-CODE_')]";

	// Page Objects for "A015_BalanceSheetTest"
	public final String A015_VERSION = "//input[starts-with(@name,'FRMAT_')]";
	public final String A015_DESC = "//input[starts-with(@name,'FRMAT-DESC_')]";
	public final String A015_NOM_MAN = "//label[text()='Nominal Mandatory']/../input[1]";
	public final String A015_NOM_BAL_SHEET = "//label[text()='Normal Balance Sheet']/../input[1]";

	// Page Objects for "A016_Normal_Balance_Sheet_GroupsTest"
	public final String A016_GRP = "//input[starts-with(@name,'GRP_')]";
	public final String A016_PRPT_LS = "//label[text()='Profit and Loss']/../input[1]";

	// Page Objects for "A016_Normal_Balance_Sheet_GroupsTest"
	public final String A017_CATEG = "//input[starts-with(@name,'CATEG_')]";
	public final String A017_CATEG_TYPE = "//div/select[starts-with(@name,'CATEG-TYPE_')]";

	// Page Objects for "A018_Ledger_Control_Nominals"
	public final String A018_CATEG_TYPE = "//input[starts-with(@name,'NOML_')]";
	public final String A018_NOMINAL = "//input[starts-with(@name,'NOML_')]";
	public final String A018_NOML_TYPE = "//div/select[starts-with(@name,'TYPE_')]";
	public final String A018_NOML_PST_TYPE = "//div/select[starts-with(@name,'POST-IND_')]";
	public final String A018_MNGT_CODE_REL1 = "//input[starts-with(@name,'MGMT-RLTN-FLAG_')][1]";
	public final String A018_MNGT_CODE_REL2 = "//input[starts-with(@name,'MGMT-RLTN-FLAG_')][2]";
	public final String A018_CURR_CODE = "//input[starts-with(@name,'CURR_')]";
	public final String A018_CURR_PROCESS = "//div/select[starts-with(@name,'CURR-PROCESS-IND_')]";
	public final String A018_FIN_ALLW = "//label[text()='Financial Allowed']/../input[1]";
	public final String A018_PLN_ALLW = "//label[text()='Planning Allowed']/../input[1]";
	public final String A018_CST_ALLW = "//label[text()='Cost Allocation Allowed']/../input[1]";
	public final String A018_CHK_REV_ALLW = "//label[text()='Revaluation Allowed']/../input[1]";

	// Page Objects for "A019_Ledger_Control_Management_CodeTest"
	public final String A019_MNGT_KEY = "//input[starts-with(@name,'PATH-KEY_')]";
	public final String A019_SHRT_NAME = "//input[starts-with(@name,'SHORT-NAME_')]";
	public final String A019_FINC = "//label[text()='Financial']/../input[1]";
	public final String A019_PLNG = "//label[text()='Planning']/../input[1]";
	public final String A019_CST_ALC = "//label[text()='Cost Allocation']/../input[1]";
	public final String A019_SUMM_TRANC = "//label[text()='Summarise Transactions']/../input[1]";
	public final String A019_AVG_BLNC = "//label[text()='Average Balances']/../input[1]";

	// Page Objects for "A020_Ledger_Control_AccountsTest"
	public final String A020_LEDGR_COD = "//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A020_CURR_RND_ACC = "//div/input[starts-with(@name,'subfield')][1]";
	public final String A020_CURR_RND_CST = "//div/input[starts-with(@name,'subfield')][2]";
	public final String A020_CLOS_OUT_ACC = "//div/input[starts-with(@name,'subfield')][4]";
	public final String A020_CLOS_OUT_CST = "//div/input[starts-with(@name,'subfield')][5]";
	public final String A020_JRN_SUSP_ACC = "//div/input[starts-with(@name,'subfield')][7]";
	public final String A020_JRN_SUSP_CST = "//div/input[starts-with(@name,'subfield')][8]";

	// Page Objects for "A021_Batch_TypesTest"
	public final String A021_BATCH_TYPE = "//input[starts-with(@name,'BTCH-TYPE_')]";
	public final String A021_LEDR_CTRL_CD = "//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A021_UPDT_IND = "//select[starts-with(@name,'UPDT-IND_')]";
	public final String A021_BS_VALUE = "//label[text()='Base Values']/../input[1]";
	public final String A021_FRN_VALUE = "//label[text()='Foreign Values']/../input[1]";
	public final String A021_BSN_FRN = "//label[text()='Base and Foreign']/../input[1]";

	// Page Objects for "A022_Balance_ClassesTest"
	public final String A022_BAL_CLS = "//input[starts-with(@name,'BAL_')]";
	public final String A022_STASTICAL = "//label[text()='Statistical']/../input[1]";
	public final String A022_TRANSATION = "//label[text()='Transaction']/../input[1]";
	public final String A022_ROLL_FLAG = "//label[text()='Roll Flag']/../input[1]";
	public final String A022_PATH = "//input[starts-with(@name,'PATH_')]";
	public final String A022_CALN_TYPE = "//input[starts-with(@name,'CLNDR-LVL_')]";
	public final String A022_SECND_TAB = "//a[@class='ui-tabs-anchor'] [text()='Secondary Details']";
	public final String A022_FRN_CURR = "//label[text()='Foreign Currency']/../input[1]";
	public final String A022_VAT = "//label[text()='VAT']/../input[1]";
	public final String A022_ALW_BTCH_BAL = "//label[text()='Allow Batches Out Of Balance']/../input[1]";
	public final String A022_AVG_DLY_BAL = "//select[starts-with(@name,'ADB-IND_')]";

	// Page Objects for "A023_Balance_ClassesTest"
	public final String A023_CURNT_PER = "//input[starts-with(@name,'CURNT-PER-NUM_')]";
	public final String A023_CURNT_YR = "//input[starts-with(@name,'CURNT-YY_')]";
	public final String A023_CNTL_AC_CD = "//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A023_CALDR = "//input[starts-with(@name,'FSCL-CLNDR_')]";
	public final String A023_YR_RNGE_FUTR = "//input[starts-with(@name,'YY-RNGE-FUTR_')]";
	public final String A023_YR_RNGE_HIST = "//input[starts-with(@name,'YY-RNGE-HIST_')]";
	public final String A023_CHK_AVGBALSH = "//label[text()='Alternative Balance Sheet']/../input[1]";

	public final String A023_SUMMAR = "//input[starts-with(@name,'SUMM-BTCH-TYPE_')]";
	public final String A023_TRANSAC = "//input[starts-with(@name,'CURNT-DD_')]";
	public final String A023_STSCL_BAL = "//input[starts-with(@name,'STSCL-BAL_')]";
	public final String A023_CHK_FINC = "//label[text()='Financial']/../input[1]";
	public final String A023_CHK_CST_ALOC = "//label[text()='Cost Allocation']/../input[1]";
	public final String A023_CHK_AVG_BAL = "//label[text()='Average Balances']/../input[1]";
	public final String A023_CHK_SUMM = "//label[text()='Summarise']/../input[1]";
	public final String A023_CHK_PLANG = "//label[text()='Planning']/../input[1]";
	public final String A023_SUSPN_ACC = "//select[starts-with(@name,'SUSP-ACCT-IND_')]";
	public final String A023_ACCEPT_WAR_OFF = "//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CHK_ACCEPT_WAR_OFF = "//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CHK_TOTL_ON_QTY = "//label[text()='Totalling on Quantity']/../input[1]";
	public final String A023_CHK_GNE_BATCH_BAL_RCRD = "//label[text()='Generate Batch Balancing Records']/../input[1]";
	public final String A023_CHK_CLS_ACC_LST_YR = "//label[text()='Close Accounts for Last Year']/../input[1]";
	public final String A023_CHK_REV_WRIT_FLG = "//label[text()='Revaluation Writeoff Flag']/../input[1]";
	public final String A023_CHK_DTA_ENTRY_IMD_UPD = "//label[text()='Data Entry Immediate Update']/../input[1]";
	public final String A023_CHK_REC_MSG = "//label[text()='Reconciliation Messages']/../input[1]";
	public final String A023_CHK_DEL_CHK = "//label[text()='Delete Check']/../input[1]";
	public final String A023_ACC_WAR_OFL = "//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CURR_R_TYPE = "//input[starts-with(@name,'RATE-TYPE_')]";
	public final String A023_RNDG_TOLRN_AMT = "//input[starts-with(@name,'RNDG-TOLRN-AMT_')]";
	public final String A023_RNDG_TOLRN_PERC = "//input[starts-with(@name,'RNDG-TOLRN-PERC_')]";
	public final String A023_CHK_CURR_REV_ALLW = "//label[text()='Currency Revaluation Allowed']/../input[1]";
	public final String A023_CURR_TOL_PROC = "//select[starts-with(@name,'NBASE-TOLRN-IND_')]";
	public final String A023_BTCH_TYPE = "//input[starts-with(@name,'REVAL-BTCH-TYPE_')]";

	public final String A023_CHK_ACCT_PAYBL = "//label[text()='Accounts Payable']/../input[1]";
	public final String A023_CHK_ACCT_RECIBL = "//label[text()='Accounts Receivable']/../input[1]";
	public final String A023_CHK_PURC_MNGT = "//label[text()='Purchasing Management']/../input[1]";
	public final String A023_CHK_INV_MNGT = "//label[text()='Inventory Management']/../input[1]";
	public final String A023_CHK_FIX_ASST = "//label[text()='Fixed Assets']/../input[1]";
	public final String A023_CHK_FIX_ASST_LEA = "//label[text()='Fixed Assets Leasing']/../input[1]";
	public final String A023_CHK_ARC_TRAN_INDI = "//label[text()='Archive Transaction Indices']/../input[1]";
	public final String A023_CHK_ARC_UNREC_TRANS = "//label[text()='Archive Unreconciled Transactions']/../input[1]";

	// Page Objects for "A024_Batch_TypesTest"
	public final String A024_SECDRY_IND = "//label[text()='Secondary Index']/../input[1]";
	public final String A024_ACCRL = "//select[starts-with(@name,'ACCRL-IND_')]";
	public final String A024_RCCRL = "//select[starts-with(@name,'RECUR-BTCH-IND_')]";

	// Page Objects for "A025_FormulaTest"
	public final String A025_FORM = "//input[starts-with(@name,'CALC_')]";
	public final String A025_HEADN = "//input[starts-with(@name,'HEAD_')]";
	public final String A025_CHK_APPY_CURR = "//label[text()='Apply Currency']/../input[1]";
	public final String A025_TOTL_CNTRL = "//select[starts-with(@name,'TOTAL-IND_')]";
	public final String A025_FOR_EXP_LNONE = "//input[starts-with(@name,'CALC-LINE-1_')]";

	// Page Objects for "A026_Layout_CodesTest"
	public final String A026_LAYT = "//input[starts-with(@name,'LYT_')]";
	public final String A026_HIGH_VAL = "//div[1]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']";

	// Page Objects for "A027_Default_StructureTest"
	public final String A027_STRUC = "//input[starts-with(@name,'STRUC_')]";
	public final String A027_UNI_ELE_REQ = "//label[text()='Unique Elements Required']/../input[1]";

	// Page Objects for "A028_Default_Structure_ControlsTest"
	public final String A028_PATH_CODE = "//input[starts-with(@name,'PATH_')]";
	public final String A028_SUSP_ELEMNT = "//input[starts-with(@name,'SUSP-ELEM_')]";
	public final String A028_UPDT_CNTRL = "//select[starts-with(@name,'PRCSS-IND_')]";
	public final String A028_NET_BAL_IND = "//select[starts-with(@name,'NET-BAL-UPDT-IND_')]";
	public final String A028_NET_BAL_LYT = "//input[starts-with(@name,'NET-BAL-LYT_')]";
	public final String A028_NOML_BAL_LYT = "//input[starts-with(@name,'NOML-BAL-LYT_')]";

	// Page Objects for "A029_Default_Structure_ElementsTest"
	public final String A029_ELEMENT = "//input[starts-with(@name,'ELEM_')]";
	public final String A029_NEW_PARENT = "//input[starts-with(@name,'PRNT-ELEM_')]";
	public final String A029_CHK_NOM_BAL = "//label[text()='Nominal Balances']/../input[1]";
	public final String A029_PATH_KEY = "//div/label[starts-with(text(), 'Path Key:')]/../input[4]";
	public final String A029_PATH_KEY_IN = "//div/label[starts-with(text(), 'Path Key:')]/../input[1]";
	public final String A029_NEW_PARENT_IN = "//input[starts-with(@name,'NEW-PRNT-ELEM_')]";

	// Page Objects for "A031_Company_ControlsTest"
	public final String A031_ACC_LAY = "//input[starts-with(@name,'DFLT-ACCT-LYT_')]";
	public final String A031_BSPL_LAY = "//input[starts-with(@name,'DFLT-BSPL-LYT_')]";
	public final String A031_STRUCT = "//input[starts-with(@name,'ICA-STRUC_')]";
	public final String A031_CODE_ID = "//input[starts-with(@name,'ICA-CODE-ID_')]";
	public final String A031_TRANS = "//input[starts-with(@name,'TRF-BTCH-TYPE_')]";
	public final String A031_REVRS = "//input[starts-with(@name,'REVSL-BTCH-TYPE_')]";
	public final String A031_ACC_LAY1 = "//input[starts-with(@name,'DFLT-ACCT-LYT_')]/..//label[2]";
	public final String A031_BSPL_LAY1 = "//input[starts-with(@name,'DFLT-ACCT-LYT_')]/..//label[4]";
	public final String A031_IC_STRUCT = "//input[starts-with(@name,'ICA-STRUC_')]/..//label[2]";
	public final String A031_TRANS1 = "//input[starts-with(@name,'TRF-BTCH-TYPE_')]/..//label[4]";
	public final String A031_REVRS1 = "//input[starts-with(@name,'REVSL-BTCH-TYPE_')]/..//label[6]";

	// Page Objects for "A032A_PathKeyNewParentTest"
	public final String A032A_NEW_PAR = "//input[starts-with(@name,'NEW-PRNT-ELEM_')]";
	public final String A032A_PATH_KEY = "//input[starts-with(@name,'subfield_4_0')]";

	// Page Objects for "A033_Analysis_CodeTest"
	public final String A033_PST_LIMIT_CHECKS = "//select[starts-with(@name,'POST-LIMIT-IND_')]";
	public final String A033_PST_CR_LIMITS = "//input[starts-with(@name,'POST-CR-LIMIT_')]";
	public final String A033_PST_DB_LIMITS = "//input[starts-with(@name,'POST-DR-LIMIT_')]";
	public final String A033_BAL_LIMIT_CHECKS = "//select[starts-with(@name,'BAL-LIMIT-IND_')]";
	public final String A033_BAL_CR_LIMITS = "//input[starts-with(@name,'BAL-CR-LIMIT_')]";
	public final String A033_BAL_DB_LIMITS = "//input[starts-with(@name,'BAL-DR-LIMIT_')]";

	// Page Objects for "A035_Structure_RebuildTest"
	public final String A035_REQ = "//input[starts-with(@name,'REQ_')]";
	public final String A035_CMPY = "//input[starts-with(@name,'PARM-CMPY_')]";
	public final String A035_YEAR1 = "//input[@id='chk_0_14']";
	public final String A035_YEAR2 = "//input[@id='chk_0_16']";
	public final String A035_YEAR3 = "//input[@id='chk_0_18']";
	public final String A035_START_CONFIRM = "//div[contains(@class,'roundedCorners')]/button[@value='Start']";
	public final String A035_STOP_CONFIRM = "//div[contains(@class,'roundedCorners')]/button[@value='Stop']";
	public final String A035_FORCE_CONFIRM = "//div[contains(@class,'roundedCorners')]/button[@value='Force']";

	public final String A035_CONFM_SUBMIT = "//div[contains(@class,'roundedCorners')]/button[@id='2_2']";
	public final String A035_HOLD = "//input[@id='chk_2_1']";
	public final String A035_GLSTRUCT = "//div[contains(@class,'licol')]";

	// Page Objects for "A036_BTZ_Elements_For_ICA_StructureTest"
	public final String A036_EELE = "//input[starts-with(@name,'ELEM_field_')]";
	public final String A036_ICA_MNGT_CODE = "//input[starts-with(@name,'ICA-MGMT_')]";
	public final String A036_GEN_LEDGR = "//input[starts-with(@name,'GL-CNTRL_')]";

	// Page Objects for "A037_ICA_Default_Trading_RelationshipsTest"
	public final String A037_FRM_BTZ = "//input[starts-with(@name,'FROM-BTZ-ENTY_')]";
	public final String A037_TO_BTZ = "//input[starts-with(@name,'TO-BTZ-ENTY_')]";
	public final String A037_GEN_ACC = "//input[@id='0_5_0']";
	public final String A037_GEN_COST = "//input[@id='0_5_1']";

	// Page Objects for "A038_Process_EP2Test"
	public final String A038_CHK_UPDT_All = "//label[text()='Update All']/../input[1]";
	public final String A038_CHK_NET_BAL = "//label[text()='Net Balances']/../input[1]";
	public final String A038_CHK_INCLD = "//div[1]/table/tbody/tr/td[5]/input";

	// Page Objects for "A039_EnquiryTest"
	public final String A039_EXT_SEL = "//a[contains(text(),'Extended Selection')]";
	public final String A039_CHANGE_CMPY = "//button[@value='Change Company / Role']";
	public final String A039_LKP_CMPY = "//input[starts-with(@name,'HDR-CMPY_')]";
	public final String A039_LKP_OK = "//div[contains(@class,'roundedCorners')]/button[@id='1_1']";
	public final String A039_EXT_OK = "//button[contains(@class,'roundedbutton')][@id='0_44']";

	// Page Objects for "A040_ICA_Data_EntryTest"
	public final String A040_JOUR_TYPE = "//input[starts-with(@name,'BTCH-TYPE_')]";
	public final String A040_JOUR_REF = "//input[starts-with(@name,'BTCH-REF_')]";
	public final String A040_PERI = "//input[starts-with(@name,'BTCH-PER_')]";
	public final String A040_YEAR = "//select[starts-with(@name,'YY-IND_')]";
	public final String A040_BTZ_ELE = "//input[starts-with(@name,'ELEM_')]";
	public final String A040_DESC = "//input[starts-with(@name,'HDR-DESCR_')]";
	public final String A040_NUM_OF_TRANC = "//input[starts-with(@name,'NUM-OF-TRANS-HEAD_')]";
	public final String A040_SELE_OK = "//button[contains(@class,'roundedbutton')][@id='0_21']";
	public final String A040_SELE1_OK = "//button[contains(@class,'roundedbutton')][@id='0_11']";
	public final String A040_SELE_ACCO = "//input[@id='0_1_0']";
	public final String A040_SELE_COST = "//input[@id='0_1_1']";
	public final String A040_SELE_SEC = "//div[@class='html_TitlePaneTitle']/a[contains(text(),'Selection')]";
	public final String A040_SELE_SEC1 = "//div[@class='html_TitlePaneTitle panelCollapsed']";
	public final String A040_EJI_OK = "//button[contains(@class,'roundedbutton')][@id='0_10']";

	public final String A040_EJE_OK = "//button[contains(@class,'roundedbutton')][@id='0_13']";

	// Page Objects for "A042_Period_End_Test"
	public final String A042_CMPY = "//input[starts-with(@name,'PARAM-CMPY_')]";

	/*--------------------------------PHASE II PageObjects----------------------------------------------------------------*/

	// Page Objects for "A043_Insert_Tax_CodesTest"
	public final String A043_TX_TYPE = "//input[starts-with(@name,'TAX-TYPE_')]";
	public final String A043_TOLRN_PERC = "//input[starts-with(@name,'TOLRN-PERC_')]";
	public final String A043_TOLRN_AMT = "//input[starts-with(@name,'TOLRN-AMT_')]";
	public final String A043_CHK_TX_RATE_EXP = "//label[text()='Tax Rate Exempt']/../input[1]";
	public final String A043_CODE = "//input[starts-with(@name,'TAX-CODE_')]";
	public final String A043_LOC = "//input[starts-with(@name,'LOCTN_')]";
	public final String A043_CHK_ECSTATE = "//label[text()='EC State']/../input[1]";

	// Page Objects for "A044_TAX_Rates_by_Tax_CodesTest"
	public final String A044_EFF_DATE = "//div/input[starts-with(@name,'datefield_')]";
	public final String A044_TOT_RATE = "//input[starts-with(@name,'TOT-RATE_')]";

	// Page Objects for "A045_BACS_CalendarTest"
	public final String A045_CAL = "//input[starts-with(@name,'CLNDR_')]";
	public final String A045_RAD_BACS = "//div/input[@name='CLNDR-TYPE_1'][@value='BACS']";

	public final String A045_RAD_OTH = "//div/input[@name='CLNDR-TYPE_1'][@value='Other']";

	public final String A045_WK_DAY = "//select[starts-with(@name,'WK-END-DAY_')]";
	public final String A045_CHK_SHOW_WK_END = "//label[text()='Show Week Ending']/../input[1]";
	public final String A045_ACT = "//input[starts-with(@name,'ACTVT_')]";
	public final String A045_FRM_YR = "//input[starts-with(@name,'FROM-YR_')]";
	public final String A045_TO_YR = "//input[starts-with(@name,'TO-YR_')]";
	public final String A045_YEAR = "//input[starts-with(@name,'YR_')]";

	// Page Objects for "A046_Bank_Account_Names_for_PurchasingTest"
	public final String A046_CNTRY = "//input[starts-with(@name,'CNTRY_')]";
	public final String A046_SRTCODE = "//input[starts-with(@name,'SRTCODE_')]";
	public final String A046_BANK_NAME = "//input[starts-with(@name,'BANK-NAME_')]";
	public final String A046_ADDRES1 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][1]";
	public final String A046_ADDRES2 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][2]";
	public final String A046_ADDRES3 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][3]";
	public final String A046_PSTCD = "//input[starts-with(@name,'POST-CODE_')]";

	// Page Objects for "A048_UOMTest"
	public final String A048_UOM_CODE = "//input[starts-with(@name,'UOM-CODE_')]";
	public final String A048_CHK_SUBD = "//label[text()='Sub-Division']/../input[1]";
	public final String A048_BASE_UOM = "//input[starts-with(@name,'UOM_')]";
	public final String A048_UOM_NBASE = "//input[starts-with(@name,'UOM-NBASE_')]";
	public final String A048_NBASE_BASE_FACT = "//input[starts-with(@name,'NBASE-BASE-FACT_')]";
	public final String A048_BASE_NBASE_FACT = "//input[starts-with(@name,'BASE-NBASE-FACT_')]";

	// Page Objects for "A049_Common_Purchasing_Company_ControlsTest"
	public final String A049_EXCH_RATE_TYPE = "//input[starts-with(@name,'EXCH-RATE-TYPE_')]";
	public final String A049_GL_HOld_CMPY = "//input[starts-with(@name,'GL-HOLDING-CMPY_')]";
	public final String A049_GL_RLTN_IND = "//input[starts-with(@name,'GL-RLTN-IND_')]";
	public final String A049_RAD_NOR = "//div/input[@name='GL-RLTN-IND_1'][@value='Normal']";
	public final String A049_DD_UOM = "//input[starts-with(@name,'DD-UOM_')]";
	public final String A049_WRK_DAYS_CLNDR = "//input[starts-with(@name,'WRK-DAYS-CLNDR_')]";
	public final String A049_CHK_KEYWD_INUSE = "//label[text()='Keywords In Use']/../input[1]";
	public final String A049_CHK_NSV_INUSE = "//label[text()='NSV In Use ']/../input[1]";
	public final String A049_RAD_DUP_PST_NR = "//div/input[@name='DUP-POSTCODE-IND_1'][@value='Not Required']";
	public final String A049_RAD_SUPP_PST_ALLSUP = "//div/input[@name='SUPP-POSTCODE-IND'][@value='All Supplier Types']";
	public final String A049_RAD_PM_ADDR_NNOT = "//div/input[@name='PM-MULTI-ADDR-IND'][@value='No Notification']";
	public final String A049_RAD_AP_ADDR_NNOT = "//div/input[@name='AP-MULTI-ADDR-IND'][@value='No Notification']";

	// Page Objects for "A050_Accounts_Payable_Control_AccountsTest"
	public final String A050_CNTL_AC_CD = "//input[starts-with(@name,'LEDGR_')]";
	public final String A050_CRE_CONT_ACC = "//div/input[starts-with(@name,'subfield_3_0')]";
	public final String A050_CRE_CONT_CST = "//div/input[starts-with(@name,'subfield_3_1')]";
	public final String A050_DIS_RECE_ACC = "//div/input[starts-with(@name,'subfield_4_0')]";
	public final String A050_DIS_RECE_CST = "//div/input[starts-with(@name,'subfield_4_1')]";
	public final String A050_BNK_CHG_ACC = "//div/input[starts-with(@name,'subfield_5_0')]";
	public final String A050_BNK_CHG_CST = "//div/input[starts-with(@name,'subfield_5_1')]";
	public final String A050_PREPAY_ACC = "//div/input[starts-with(@name,'subfield_6_0')]";
	public final String A050_PREPAY_CST = "//div/input[starts-with(@name,'subfield_6_1')]";
	public final String A050_DET_VAR_ACC = "//div/input[starts-with(@name,'subfield_7_0')]";
	public final String A050_DET_VAR_CST = "//div/input[starts-with(@name,'subfield_7_1')]";
	public final String A050_TRD_CUR_ACC = "//div/input[starts-with(@name,'subfield_8_0')]";
	public final String A050_TRD_CUR_CST = "//div/input[starts-with(@name,'subfield_8_1')]";
	public final String A050_SRV_ACCR_ACC = "//div/input[starts-with(@name,'subfield_9_0')]";
	public final String A050_SRV_ACCR_CST = "//div/input[starts-with(@name,'subfield_9_1')]";
	public final String A050_SRV_DEFE_ACC = "//div/input[starts-with(@name,'subfield_10_0')]";
	public final String A050_SRV_DEFE_CST = "//div/input[starts-with(@name,'subfield_10_1')]";
	public final String A050_AP_AR_ACC = "//div/input[starts-with(@name,'subfield_11_0')]";
	public final String A050_AP_AR_CST = "//div/input[starts-with(@name,'subfield_11_1')]";
	public final String A050_TAX_SUP_ACC = "//div/input[starts-with(@name,'subfield_14_0')]";
	public final String A050_TAX_SUP_CST = "//div/input[starts-with(@name,'subfield_14_1')]";
	public final String A050_TAX_VAR_ACC = "//div/input[starts-with(@name,'subfield_15_0')]";
	public final String A050_TAX_VAR_CST = "//div/input[starts-with(@name,'subfield_15_1')]";
	public final String A050_MUL_GL_ACC = "//div/input[starts-with(@name,'subfield_16_0')]";
	public final String A050_MUL_GL_CST = "//div/input[starts-with(@name,'subfield_16_1')]";
	public final String A050_SLF_ASS_ACC = "//div/input[starts-with(@name,'subfield_17_0')]";
	public final String A050_SLF_ASS_CST = "//div/input[starts-with(@name,'subfield_17_1')]";

	// Page Objects for "A051A_Purchase_Ledger_Bank_CodesTest" and
	// "A051_Purchase_Ledger_Bank_CodesTest"
	public final String A051_BMK_STMT = "//input[starts-with(@name,'STMNT-BAL_')]";
	public final String A051_ADJMT_BAL = "//input[starts-with(@name,'ADJMT-BAL_')]";
	public final String A051_STMNT_BTCH_TYPE = "//input[starts-with(@name,'STMNT-BTCH-TYPE_')]";
	public final String A051_ADJMT_BTCH_TYPE = "//input[starts-with(@name,'ADJMT-BTCH-TYPE_')]";
	public final String A051_GL_AD_BTCH_TYPE = "//input[starts-with(@name,'GL-AD-BTCH-TYPE_')]";
	public final String A051_RAD_ORG_DT = "//div/input[@name='REVERSAL-DATE-IND_1'][@value='Original Date']";
	public final String A051_CHQ_VAD_FOR = "//input[starts-with(@name,'OUT-OF-DATE-DAYS_')]";
	public final String A051_CHK_SUMM_TRANSC = "//label[text()='Summarise Transactions']/../input[1]";
	public final String A051_CHK_AVG_BAL = "//label[text()='Average Balances']/../input[1]";
	public final String A051_CHK_RECO_REQ = "//label[text()='Reconciliation Required']/../input[1]";
	public final String A051_CHK_BANK_ACC = "//label[text()='Bank Account']/../input[1]";
	public final String A051_BNK_CODE = "//input[starts-with(@name,'BANK_')]";
	public final String A051_BNK_ACC_NU = "//input[starts-with(@name,'ACCT-NUM_')]";
	public final String A051_SRT_CODE = "//input[starts-with(@name,'SRT-CODE_')]";
	public final String A050_GL_BNK_ACC = "//div/input[starts-with(@name,'subfield_7_0')]";
	public final String A050_GL_BNK_CST = "//div/input[starts-with(@name,'subfield_7_1')]";

	// Page Objects for "A053_Category_CodeTest"
	public final String A053_HLD_DAY = "//input[starts-with(@name,'HOLD-DD_')]";
	public final String A053_CHK_AUTO_SUPP_CLER = "//label[text()='Auto Supplier Cleardown']/../input[1]";

	// Page Objects for "A054_Discount_TermsTest"
	public final String A054_DSCNT = "//input[starts-with(@name,'DSCNT_')]";
	public final String A054_RAD_PER_D = "//div/input[@name='PER-IND_1'][@value='Daily']";
	public final String A054_NUM_DD = "//input[starts-with(@name,'NUM-DD_')]";
	public final String A054_RATE_PERC = "//input[starts-with(@name,'RATE-PERC_')]";
	public final String A054_RAD_SRTP_INVDT = "//div/input[@name='STRT-POINT-IND_1'][@value='Invoice Date']";

	// Page Objects for "A055_Settlement_TermsTest"
	public final String A055_SETT_TERM = "//input[starts-with(@name,'STLMNT_')]";
	public final String A055_RAD_PERD_M = "//div/input[@name='PER-IND_1'][@value='Monthly']";
	public final String A055_FROM_DD = "//input[starts-with(@name,'FROM-DD_')]";
	public final String A055_TO_DD = "//input[starts-with(@name,'TO-DD_')]";
	public final String A055_MONTH = "//input[starts-with(@name,'NUM-MM_')]";
	public final String A055_DATE = "//input[starts-with(@name,'DUE-DD_')]";
	public final String A055_DAYS = "//input[starts-with(@name,'NUM-DD_')]";
	public final String A055_RAD_STRT_PER = "//div/input[@name='STRT-POINT-IND_1'][@value='Period']";
	public final String A055_RAD_STRT_INV = "//div/input[@name='STRT-POINT-IND_1'][@value='Invoice']";

	// Page Objects for "A056_AP_Ledger_ControlsTest"
	public final String A056_TOL_PROC = "//select[starts-with(@name,'EXCH-TOLRN-IND_')]";
	public final String A056_CHK_CURR_TURN = "//label[text()='Currency Turnover Maintained']/../input[1]";
	public final String A056_CHK_TURN_IN_TAX = "//label[text()='Turnover To Include Tax']/../input[1]";
	public final String A056_CHK_TRNS_ENQ = "//label[text()='Transaction Enquiry in Reverse Date Sequence']/../input[1]";
	public final String A056_AUTO_CNCL = "//select[starts-with(@name,'AUTO-CANC-IND_')]";
	public final String A056_TURN_PER_IND = "//select[starts-with(@name,'TNVR-GL-PER-FLAG_')]";
	public final String A056_TRANS_DUP = "//select[starts-with(@name,'DUP-REF-ERR-FLAG_')]";
	public final String A056_LOG_TRANS = "//select[starts-with(@name,'LOG-IND_')]";
	public final String A056_POSTCD_ETRY = "//select[starts-with(@name,'POSTCODE-ENT-IND_')]";
	public final String A056_CRDT_NT_DUE_DT = "//select[starts-with(@name,'CRED-DUE-DATE-IND_')]";
	public final String A056_CHK_TRNS_TTL_CORR = "//label[text()='Transaction Totals Correction']/../input[1]";
	public final String A056_CHK_TX_DET_LVL = "//label[text()='Tax at Detail Level']/../input[1]";
	public final String A056_CHK_TX_ON_EXP_AT_DL = "//label[text()='Tax On Expenses at Detail Level']/../input[1]";
	public final String A056_CHK_TX_PST_LOG = "//label[text()='Tax Posting at Logging']/../input[1]";
	public final String A056_TAX_VRNC_CODE = "//input[starts-with(@name,'TAX-VRNC-CODE_')]";
	public final String A056_CHK_BTCH_TOT_CORR = "//label[text()='Batch Totals Correction']/../input[1]";
	public final String A056_CHK_BTCH_TOT_NUM_TRAN = "//label[text()='Batch Totals on Number of Transactions']/../input[1]";
	public final String A056_CHK_BTCH_TOT_OVER = "//label[text()='Batch Totals Override']/../input[1]";
	public final String A056_CHK_BTCH_ON_ENT = "//label[text()='Batch on Entry']/../input[1]";
	public final String A056_CHK_BTCH_ON_LOG = "//label[text()='Batch on Logging']/../input[1]";
	public final String A056_CHK_BTCH_ON_EXP = "//label[text()='Batch on Expense']/../input[1]";
	public final String A056_CHK_MNDTY_TRAN_DT = "//label[text()='Mandatory Transaction Date']/../input[1]";
	public final String A056_CHK_USE_VAT_ANLS = "//label[text()='Use VAT Analysis']/../input[1]";
	public final String A056_COD_IDNT = "//input[starts-with(@name,'VAT-MGMT-CODE-ID_')]";
	public final String A056_PSTNG_TYPE = "//select[starts-with(@name,'VAT-ANAL-TYPE_')]";
	public final String A056_WITH_TYPE = "//select[starts-with(@name,'WHOLD-TYPE-IND_')]";
	public final String A056_TX_RATE = "//input[starts-with(@name,'CIT-TAX-RATE_')]";
	public final String A056_NTCOMP_TX_RATE = "//input[starts-with(@name,'NCOMP-TAX-RATE_')]";
	public final String A056_NUM_DAY_TX_PRMPT = "//input[starts-with(@name,'CIT-WARN-DD_')]";
	public final String A056_SCHD_ADV_WARN = "//input[starts-with(@name,'SCHD-WARN-DD_')]";
	public final String A056_MIN_PAY_BAL = "//input[starts-with(@name,'MIN-PAY-VAL_')]";
	public final String A056_PAY_REGST_VAL = "//input[starts-with(@name,'PAY-REGST-VAL_')]";
	public final String A056_PAY_RECON = "//select[starts-with(@name,'PAY-RECON-IND_')]";
	public final String A056_CHQ_DUP = "//select[starts-with(@name,'DUP-CHQ-ERR-FLAG_')]";
	public final String A056_DAYS_BFR_ARCHV = "//input[starts-with(@name,'ARCH-DD_')]";
	public final String A056_REL_IND = "//select[starts-with(@name,'GL-RLTN-IND_')]";
	public final String A056_CNTRL_ACC_CD = "//input[starts-with(@name,'DFLT-LEDGR_')]";
	public final String A056_CHK_DEF_PER = "//div/label[text()='Default Period ']/../input[1]";
	public final String A056_DAYS_RESIT = "//input[starts-with(@name,'DIARY-RESIDENT-DD_')]";
	public final String A056_DEF_BATCH_TYP = "//input[starts-with(@name,'DFLT-BTCH-TYPE_')]";
	public final String A056_LOG_TRANC = "//input[starts-with(@name,'LOG-BTCH-TYPE_')]";
	public final String A056_ENTR_TRANC = "//input[starts-with(@name,'ENTRY-BTCH-TYPE_')]";
	public final String A056_CANLD_TRANC = "//input[starts-with(@name,'CANC-BTCH-TYPE_')]";
	public final String A056_TRANC_TRANSF = "//input[starts-with(@name,'TRF-BTCH-TYPE_')]";
	public final String A056_VAT_ANYS_CST_CNTR = "//input[starts-with(@name,'VAT-CC-BTCH-TYPE_')]";
	public final String A056_PAYMNT = "//input[starts-with(@name,'PAY-BTCH-TYPE_')]";
	public final String A056_AP_AR_NETT_OFF = "//select[starts-with(@name,'NET-OFF-IND_')]";
	public final String A056_TOL_TYPE = "//select[starts-with(@name,'TOLRN-TYPE-IND_')]";
	public final String A056_TOLRNC_PSTV = "//input[starts-with(@name,'TOLRN-PERC-PSTV_')]";
	public final String A056_TOLRNC_NEG = "//input[starts-with(@name,'TOLRN-PERC-NEG_')]";
	public final String A056_TOLRNC_AMT = "//input[starts-with(@name,'TOLRN-AMT_')]";
	public final String A056_CHK_TRNC_HD_DIFF = "//label[text()='Transaction Held for Price Difference']/../input[1]";
	public final String A056_OVR_INVO_GRN = "//select[starts-with(@name,'OVER-INVCE-IND_')]";
	public final String A056_GRN_FURT_MAT = "//select[starts-with(@name,'GRN-MTCH-IND_')]";
	public final String A056_CR_TOL_TYPE = "//select[starts-with(@name,'CR-TOLRN-TYPE-IND')]";
	public final String A056_CR_TOLRNC_PSTV = "//input[starts-with(@name,'CR-TOLRN-PERC_')]";
	public final String A056_CR_TOLRNC_AMT = "//input[starts-with(@name,'CR-TOLRN-AMT_')]";

	// Page Objects for "A056A_System_Assigned_Batch_Numbers_In_AP"
	public final String A056_CHK_SECD_IND = "//label[text()='Secondary Index']/../input[1]";
	public final String A056_CHK_GEN_BTCH_REF = "//label[text()='Generate Batch References']/../input[1]";
	public final String A056_LST_BTCH_REF = "//input[starts-with(@name,'LAST-BTCH-REF_')]";

	// Page Objects for "A057_Legend_ControlsTest"
	public final String A057_TRAN_TYP = "//input[starts-with(@name,'TRAN-TYPE-IND_')]";
	public final String A057_TRAN_SUBTYP = "//input[starts-with(@name,'TRAN-SUB-TYPE_')]";
	public final String A057_LGND = "//input[starts-with(@name,'LGND_')]";

	// Page Objects for "A058_Payment_MethodsTest"
	public final String A058_PYMNT_MTHD = "//input[starts-with(@name,'PYMNT-MTHD_')]";
	public final String A058_PYMNT_MDUM = "//select[starts-with(@name,'PYMNT-MEDIUM_')]";
	public final String A058_PYMNT_RATE = "//input[starts-with(@name,'PYMNT-RATE_')]";
	public final String A058_IND = "//select[starts-with(@name,'INV-PREALLOC-IND_')]";
	public final String A058_CHK_SPLT_PRNT = "//label[text()='Split Print']/../input[1]";

	// Page Objects for "A060_Payment_CodesTest"
	public final String A060_PYMNT_COD = "//input[starts-with(@name,'PYMNT_')]";
	public final String A060_DESC = "//input[starts-with(@name,'DESCR-PYMNT_')]";
	public final String A060_RAD_SET_DU_DT = "//div/input[@name='DSCNT-SCHD-IND'][@value='Settlement Due Date']";

	// Page Objects for "A061_Purchasing_Management_LocationsTest"
	public final String A061_LOC = "//input[starts-with(@name,'SITE_')]";
	public final String A061_ADDR_LINE1 = "//input[starts-with(@name,'ADDR-LINE1_')]";
	public final String A061_ADDR_LINE2 = "//input[starts-with(@name,'ADDR-LINE2_')]";
	public final String A061_ADDR_LINE3 = "//input[starts-with(@name,'ADDR-LINE3_')]";
	public final String A061_ADDR_LINE4 = "//input[starts-with(@name,'ADDR-LINE4_')]";
	public final String A061_ADDR_LINE5 = "//input[starts-with(@name,'ADDR-LINE5_')]";
	public final String A061_ADDR_LINE6 = "//input[starts-with(@name,'ADDR-LINE6_')]";

	public final String A061_PSTCD = "//input[starts-with(@name,'POSTCODE_')]";
	public final String A061_ACPT_USR = "//select[starts-with(@name,'ACCPT-USR-IND_')]";

	// Page Objects for "A062_Tax_Handling_CodesTest"
	public final String A062_HAND = "//input[starts-with(@name,'HAND_')]";
	public final String A062_CHK_INCL = "//label[text()='Inclusive']/../input[1]";
	public final String A062_CHK_PRO_RAT = "//label[text()='Pro-Rata']/../input[1]";
	public final String A062_RCVBLE = "//select[starts-with(@name,'RCVBLE-IND_')]";

	// Page Objects for "A063_Standard_TextTest"
	public final String A063_CHK_DISBLD = "//label[text()='Disabled']/../input[1]";
	public final String A063_TXTREF = "//input[starts-with(@name,'TXT-REF_')]";

	// Page Objects for "A064_PPV_Control_AccountTest"
	public final String A064_PPV_CON_CD = "//input[starts-with(@name,'ACCT-GRP_')]";
	public final String A064_PPV_ACC = "//div/input[starts-with(@name,'subfield')][1]";
	public final String A064_PPV_CST = "//div/input[starts-with(@name,'subfield')][2]";
	public final String A064_PPV_LOCN = "//div/input[starts-with(@name,'subfield')][3]";
	public final String A064_PPVREV_ACC = "//div/input[starts-with(@name,'subfield')][4]";
	public final String A064_PPVREV_CST = "//div/input[starts-with(@name,'subfield')][5]";
	public final String A064_PPVREV_LOCN = "//div/input[starts-with(@name,'subfield')][6]";

	// Page Objects for "A065_CP_Company_ControlsTest"

	public final String A065_CHK_PUR_PRZ = "//label[text()='Purchase Price']/../input[1]";
	public final String A065_PPV_ACC_CD = "//input[starts-with(@name,'PPV-ACCT_')]";
	public final String A065_PRZ_EXP = "//input[starts-with(@name,'DFLT-PRC-XPRY-DD_')]";
	public final String A065_CHK_AT_PTREC = "//label[text()='At Point of Receipt']/../input[1]";
	public final String A065_CHK_PTREC_RET = "//label[text()='Print Receipt/Return Note']/../input[1]";
	public final String A065_NUM_COPY = "//input[starts-with(@name,'NUM-COPIES_')]";

	// Page Objects for "A066_Accrual_Control_CodeTest"
	public final String A066_ACCRU_CNTRL = "//input[starts-with(@name,'ACCRU-CNTRL_')]";
	public final String A066_ACC_ACC = "//div/input[starts-with(@name,'subfield')][1]";
	public final String A066_ACC_CST = "//div/input[starts-with(@name,'subfield')][2]";

	// Page Objects for "A067_Purchasing_Management_Company_ControlsTest"

	public final String A067_CMPY_NUM_LEN = "//input[starts-with(@name,'CMPY-NUM-LEN_')]";
	public final String A067_NEXT_DOC_NUM = "//input[starts-with(@name,'NEXT-DOC-NUM_')]";
	public final String A067_CNTRL_ACC = "//input[starts-with(@name,'GL-CNTRL-ACCT-GRP_')]";
	public final String A067_BTCH_TYPE = "//input[starts-with(@name,'GL-BTCH-TYPE_')]";
	public final String A067_GL_CURNT_PER = "//input[starts-with(@name,'GL-CURNT-PER_')]";
	public final String A067_GL_CURNT_YY = "//input[starts-with(@name,'GL-CURNT-YY_')]";
	public final String A067_CHK_MAIN_TURN = "//label[text()='Maintain Turnover']/../input[1]";
	public final String A067_CHK_TNVR_INC_TX = "//label[text()='Turnover to Include Tax']/../input[1]";
	public final String A067_CHK_MAIN_CURR_TNVR = "//label[text()='Maintain Currency Turnover']/../input[1]";
	public final String A067_TNVR_PER_DEF = "//input[starts-with(@name,'TNVR-GL-PER-IND_')]";
	public final String A067_PRMPT_ACTVE = "//select[starts-with(@name,'PRMPT-ACTVE_')]";
	public final String A067_NUM_PRC_RETN = "//input[starts-with(@name,'NUM-PRC-RETN_')]";
	public final String A067_AMD_REV = "//div/input[@name='AMND-REVN-IND_1'][@value='Amend or Revise']";
	public final String A067_SUPP_ADDR = "//input[starts-with(@name,'DFLT-SUPP-ADDR_')]";
	public final String A067_INV_PNT = "//input[starts-with(@name,'DFLT-INVCE-SITE_')]";
	public final String A067_DLVRY_PNT = "//input[starts-with(@name,'DFLT-DLVRY-SITE_')]";
	public final String A067_PRT_CNCL_SUPP = "//div/input[@name='PRT-CNCL-LINE_1'][@value='Suppressed']";
	public final String A067_CHK_ITM_DESC_AMD = "//label[text()='Item Description Amendable']/../input[1]";
	public final String A067_CHK_USE_EDI = "//label[text()='Use EDI Processing']/../input[1]";
	public final String A067_CHK_LOC_CD_MNDR = "//label[text()='Location Codes Mandatory']/../input[1]";
	public final String A067_CHK_ORDR_LN_ACCPT = "//label[text()='Order Line Accept User']/../input[1]";
	public final String A067_CHK_ALLW_AUTO_ORDR = "//label[text()='Allow Auto Order creation from Requisitions']/../input[1]";
	public final String A067_NUMB = "//select[starts-with(@name,'QUOTE-NUM_')]";
	public final String A067_QUTN_REQ = "//input[starts-with(@name,'REQST-TXT-REF_')]";
	public final String A067_QUTN_ACCPT = "//input[starts-with(@name,'ACCPT-TXT-REF_')]";
	public final String A067_QUTN_REJ = "//input[starts-with(@name,'REJCT-TXT-REF_')]";
	public final String A067_DOCU_RET_PER = "//input[starts-with(@name,'DOC-RETAIN-PER_')]";
	public final String A067_FOR_CURR_RTYP = "//input[starts-with(@name,'CURR-RATE-TYPE')]";

	// Page Objects for "A068/A069/A070"

	public final String A068_INSP_CD = "//input[starts-with(@name,'INSPCT_')]";
	public final String A068_TYP_INSP = "//div/input[@name='INSPCT-IND_1'][@value='Inspection']";
	public final String A069_CODE = "//input[starts-with(@name,'DISPL_')]";
	public final String A070_RES_CD = "//input[starts-with(@name,'RJCT_')]";

	// Page Objects for "A071_Document_PrefixCodesTest"
	public final String A071_DOC_TYP = "//select[starts-with(@name,'DOC-IND_')]";
	public final String A071_PRFX = "//input[starts-with(@name,'PRFX_')]";
	public final String A071_SFX_TYP = "//select[starts-with(@name,'SFX-TYPE-IND_')]";
	public final String A071_SFX_LEN = "//input[starts-with(@name,'SFX-LEN_')]";

	// Page Objects for "A072_Common_Purchasing_UsersTest"
	public final String A072_CHK_BUYER = "//label[text()='Buyer']/../input[1]";
	public final String A072_CHK_EXPEDITOR = "//label[text()='Expeditor']/../input[1]";
	public final String A072_CHK_ACCEPTOR = "//label[text()='Acceptor']/../input[1]";
	public final String A072_CHK_GOOD_REC = "//label[text()='Goods Receiver']/../input[1]";
	public final String A072_BUYER = "//input[starts-with(@name,'DFLT-BYR_')]";

	// Page Objects for "A073_Receipt_ControlTest"
	public final String A073_TOL_PROC = "//select[starts-with(@name,'TOLRN-IND_')]";
	public final String A073_RCPT_CNTRL = "//input[starts-with(@name,'RCPT-CNTRL_')]";
	public final String A073_UNDCHK_WAR = "//input[(starts-with(@name,'QTY-UNDER-IND')) and (@id='0_3_1')]";
	public final String A073_UNDCHK_PER = "//input[starts-with(@name,'QTY-UNDER-PERC_')]";
	public final String A073_UNDCHK_VAL = "//input[starts-with(@name,'UNDER-VAL_')]";
	public final String A073_OVRCHK_WAR = "//input[(starts-with(@name,'QTY-OVER-IND')) and (@id='0_6_1')]";
	public final String A073_OVRCHK_PER = "//input[starts-with(@name,'QTY-OVER-PERC_')]";
	public final String A073_OVRCHK_VAL = "//input[starts-with(@name,'OVER-VAL_')]";
	public final String A073_EARCHK_WAR = "//input[(starts-with(@name,'DLVRY-EARLY-IND')) and (@id='0_10_1')]";
	public final String A073_EARCHK_DAYS = "//input[starts-with(@name,'DLVRY-EARLY_')]";

	// Page Objects for "A074_Automatic_Banking_CodeTest"
	public final String A074_AUTO_BNK_CD = "//input[starts-with(@name,'AUTO-BANK_')]";
	public final String A074_USR_NUM = "//input[starts-with(@name,'BACS-USR-NUM_')]";
	public final String A074_USR_NAME = "//input[starts-with(@name,'BACS-USR-NAME_')]";
	public final String A074_BUREAU_NUM = "//input[starts-with(@name,'BUREAU-NUM_')]";
	public final String A074_PRTCL_ID = "//input[starts-with(@name,'PRTCL-ID_')]";
	public final String A074_CLNDR = "//input[starts-with(@name,'CLNDR_')]";
	public final String A074_PROC_CYC_DD = "//input[starts-with(@name,'PROC-CYCLE-DD_')]";

	// Page Objects for "A075_Circulation_CodeTest"
	public final String A075_NOTIY_USR = "//input[starts-with(@name,'NOTIFY-USR_')]";
	public final String A075_DFLT_RPRT_PRFX = "//input[starts-with(@name,'DFLT-RPRT-PRFX_')]";
	public final String A075_DFLT_RPRT_NO = "//input[starts-with(@name,'DFLT-RPRT-SEQ_')]";
	public final String A075_MAPPNG = "//input[starts-with(@name,'MAPPING_')]";
	public final String A075_CIRC = "//input[starts-with(@name,'CIRC-LST_')]";
	public final String A075_CIRC_DESC = "//input[starts-with(@name,'CIRC-DESCR_')]";

	// Page Objects for "A076_Document_CodesTest"

	public final String A076_DOC_CD = "//input[starts-with(@name,'DOC_')]";
	public final String A076_DOC_TYP = "//select[starts-with(@name,'DOC-IND_')]";
	public final String A076_HEAD_ENT = "//input[starts-with(@name,'HEAD-VARNT_')]";
	public final String A076_DETL_ENT = "//input[starts-with(@name,'DETL-VARNT_')]";
	public final String A076_FAST_ENT = "//input[starts-with(@name,'FAST-VARNT_')]";
	public final String A076_AMD_PNTALL = "//div/input[@name='PRT-AMND-IND_1'][@value='Print All']";
	public final String A076_REV_PNTALL = "//div/input[@name='PRT-REVN-IND_1'][@value='Print All']";
	public final String A076_PNTCANL_ASOTHR = "//div/input[@name='PRT-CNCL-LINE_1'][@value='As Others']";
	public final String A076_PNTCANL_SUPP = "//div/input[@name='PRT-CNCL-LINE_1'][@value='Suppressed']";
	public final String A076_PNTCANL_ANNOT = "//div/input[@name='PRT-CNCL-LINE_1'][@value='Annotated']";
	public final String A076_CHK_IM_PRNT_REQ = "//label[text()='Immediate Print Required']/../input[1]";
	public final String A076_CIRCU = "//input[starts-with(@name,'CIRC_')]";
	public final String A076_PRC_MAN = "//select[starts-with(@name,'PRC-MAND-IND_')]";
	public final String A076_AUTO_NUM_REQ = "//select[starts-with(@name,'AUTO-NUM-IND_')]";
	public final String A076_VAL_CEL_DOC = "//input[starts-with(@name,'VAL-LIMIT_')]";
	public final String A076_RETN = "//label[text()='Returns']/../input[1]";
	public final String A076_MAT_REQ = "//select[starts-with(@name,'MTL-REQ-IND_')]";
	public final String A076_SUP_MAND = "//select[starts-with(@name,'SUPP-MAND-IND_')]";

	public final String A076_CHK_MIS_CHRG_ACC = "//label[text()='Miscellaneous Charges Accepted']/../input[1]";
	public final String A076_CHK_INVPRC_TOL = "//label[text()='Invoice Price Tolerance Check']/../input[1]";
	public final String A076_ORDR_LN_SELDEF = "//select[starts-with(@name,'ORDR-LINE-FLAG_')]";
	public final String A076_ACCRL = "//input[starts-with(@name,'GL-BTCH-TYPE_')]";

	// Page Objects for "A077_CP_Company_ControlsTest"
	public final String A077_AUT_RET_ORCD = "//input[starts-with(@name,'STK-RETN-ORDR_')]";
	public final String A077_PUR_REQSNCD = "//input[starts-with(@name,'IM-PUR-REQSN_')]";
	public final String A077_REPL_REQSNCD = "//input[starts-with(@name,'IM-REPL-REQSN_')]";
	public final String A077_BYR_CD = "//input[starts-with(@name,'IM-BYR-CODE_')]";

	// Page Objects for "A078_Authorisation_Control_Codes_For_APTest"

	public final String A078_AUTH_CNTRL_CD = "//input[starts-with(@name,'AUTH-CNTRL_')]";
	public final String A078_AUTH_CD_ID = "//input[starts-with(@name,'AUTH-STRUC-ID_')]";
	public final String A078_MEHOD = "//select[starts-with(@name,'MTHD_')]";
	public final String A078_TYPE = "//select[starts-with(@name,'TYPE_')]";
	public final String A078_LVL_NON = "//div/input[@name='AUTH-LVL_1'][@value='None']";
	public final String A078_LVL_DOC = "//div/input[@name='AUTH-LVL_1'][@value='Document']";
	public final String A078_LVL_LIN = "//div/input[@name='AUTH-LVL_1'][@value='Line']";
	public final String A078_MIN_VAL = "//input[starts-with(@name,'MIN-VAL_')]";
	public final String A078_QRY_AUTH = "//input[starts-with(@name,'QRY-AUTH_')]";
	public final String A078_CHK_AUTH_REL_TRNSC = "//label[text()='Auth Order Related Transaction']/../input[1]";

	// Page Objects for "A079_Authorisation_GroupsTest"
	public final String A079_AUTH_GRP = "//input[starts-with(@name,'AUTH-GRP_')]";

	// Page Objects for "A080_Authorisation_Control_Codes_For_PMTest"

	public final String A080_MEHOD = "//select[starts-with(@name,'AUTH-MTHD_')]";
	public final String A080_TYPE = "//select[starts-with(@name,'AUTH-TYPE_')]";
	public final String A080_AUT_AMD_NA = "//div/input[@name='AUTH-AMND-IND_1'][@value='Not Applicable']";
	public final String A080_AUT_AMD_NON = "//div/input[@name='AUTH-AMND-IND_1'][@value='None']";
	public final String A080_AUT_AMD_KEYONLY = "//div/input[@name='AUTH-AMND-IND_1'][@value='Key Fields Only']";
	public final String A080_AUT_AMD_ALWAYS = "//div/input[@name='AUTH-AMND-IND_1'][@value='Always']";
	public final String A080_CHK_SITE = "//label[text()='Site']/../input[1]";
	public final String A080_CHK_DOC_TYP = "//label[text()='Document Type']/../input[1]";
	public final String A080_CHK_DOC_CD = "//label[text()='Document Code']/../input[1]";
	public final String A080_CHK_BUYER = "//label[text()='Buyer']/../input[1]";

	// Page Objects for "A081_Authorisation_Groupings_For_PMTest"
	public final String A081_DOC_TYP = "//input[starts-with(@name,'DOC-TYPE_')]";
	public final String A081_DOC_CD = "//input[starts-with(@name,'DOC-CODE_')]";
	public final String A081_BUYER = "//input[starts-with(@name,'BYR_')]";

	// Page Objects for "A082_Authorisation_StructuresTest"
	public final String A082_AUTH_STRUC = "//input[starts-with(@name,'AUTH-STRUC_')]";

	// Page Objects for "A083_Structure_AuthorisersTest_AP/PM"
	public final String A083_PRNT_USR = "//input[starts-with(@name,'PRNT_')]";
	public final String A083_RATNG = "//input[starts-with(@name,'RATING_')]";

	// Page Objects for "A084_Authorisation_Value_Levels_DefinitionTest"
	public final String A084_VAL_LVL = "//input[starts-with(@name,'VAL-LVL_')]";
	public final String A084_VAL = "//input[starts-with(@name,'DOC-VAL')]";
	public final String A084_VAL1 = "//input[starts-with(@name,'VAL_')]";

	// Page Objects for "A085_Authorisation_By_Value_LevelTest"
	public final String A085_MIN_AUTH = "//input[starts-with(@name,'MIN-AUTH_')]";

	// Page Objects for "A089_Amend_AP_Company_Controls_For_AuthorisationTest"
	public final String A089_AUTH_STRUC = "//input[starts-with(@name,'AUTH-STRUC_')]";
	public final String A089_AUTH_CMPY_STRUC = "//input[starts-with(@name,'AUTH-CMPY-STRUC_')]";
	public final String A089_AUTH_STRUC_PTH = "//input[starts-with(@name,'AUTH-MGMT-PATH_')]";
	public final String A089_AUTHORISORS = "//button[starts-with(@class,'button roundedbutton')][@value='Authorisors']";

	// Page Objects for "A091_SuppliersTest"
	public final String A091_SUPP = "//input[starts-with(@name,'SUPP_')]";
	public final String A091_NAME = "//input[starts-with(@name,'NAME_')]";
	public final String A091_SRT_NAME = "//input[starts-with(@name,'SHORT-NAME_')]";
	public final String A091_TYP_SUPP = "//div/input[@name='ACCT-TYPE_1'][@value='Supplier']";
	public final String A091_DSCNT_1 = "//input[starts-with(@name,'DSCNT-1_')]";
	public final String A091_DIS_SUPP = "//div/input[@name='ORDR-TRM-IND_1'][@value='Supplier Discount']";
	public final String A091_DIS_ALWYS_TK = "//div/input[@name='Radio Button group'][@value='Always Take']";
	public final String A091_SEF_ASS_TX = "//select[starts-with(@name,'SLFASSD-TAX-IND_')]";
	public final String A091_TNVR = "//select[starts-with(@name,'TNVR-VAL-IND_')]";
	public final String A091_INVCE_PYMNT = "//select[starts-with(@name,'INVCE-PYMNT-IND_')]";
	public final String A091_RET_NT_GRSS = "//div/input[@name='RETAIN-NET-IND_1'][@value='Gross']";
	public final String A091_OR_TUNVR_NTM = "//div/input[@name='POP-TNVR-VAL-IND'][@value='Not Maintained']";
	public final String A091_EDI_ORD_CRET = "//div/input[@name='EDI-ORDR-IND'][@value='Created']";
	public final String A091_MISC_INV_CHAR = "//div/input[@name='MISC-CHRG-IND'][@value='Yes']";

	/*--------------------------------PHASE III PageObjects----------------------------------------------------------------*/

	// Page Objects for "A093 Transaction Legend Controls"
	public final String A093_CHK_REV = "//label[text()='Revaluation']/../input[1]";

	// Page Objects for "A094_Business_Event_Manager_ObjectsTest"
	public final String A094_NOTI = "//select[starts-with(@name,'BEM-NOTFY-IND_')]";

	// Page Objects for A095_Business_Event_Manager_Program_V_EventTest
	public final String A095_PRG = "//input[starts-with(@name,'PRG_')]";
	public final String A095_EVNT = "//input[starts-with(@name,'EVNT_')]";
	public final String A095_PRG_EVT_HNDLER = "//div/input[@name='EVNT-IND_1'][@value='Handler']";

	// Page Objects for "A096_Business_Event_Manager_Action_ListTest"
	public final String A096_CHK_MULTI = "//label[text()='Multiple']/../input[1]";
	public final String A096_SUBS_CHAR = "//input[starts-with(@name,'SUB-CHR_')]";
	public final String A096_MSGLN1 = "//div/input[starts-with(@name,'MSG-TEXT_')][1]";
	public final String A096_MSGLN2 = "//div/input[starts-with(@name,'MSG-TEXT_')][2]";

	// Page Objects for "A097_Stock_TypesTest"
	public final String A097_STK = "//input[starts-with(@name,'STOCK_')]";

	// Page Objects for "A098_Item_CreationTest" & "A098A_Item_CreationTest"
	public final String A098_ITM = "//input[starts-with(@name,'ITEM_')]";
	public final String A098_CHK_STK_ITM = "//label[text()='Stock Item']/../input[1]";
	public final String A098_CHK_GENER_ITM = "//label[text()='Generic Item']/../input[1]";
	public final String A098_CHK_SRVIC_ITM = "//label[text()='Service Item']/../input[1]";
	public final String A098_STK_TYP = "//input[starts-with(@name,'STOCK_')]";
	public final String A098_UNIT = "//input[starts-with(@name,'UOM-STD_')]";
	public final String A098_ISSU_UOM = "//input[starts-with(@name,'UOM-ISSUE_')]";
	public final String A098_RCPT_CNTRL = "//input[starts-with(@name,'RCPT-CNTRL_')]";
	public final String A098_CHK_PUR_PRZ = "//label[text()='Purchase Price']/../input[1]";
	public final String A098_PPV_ACCT_GRP = "//input[starts-with(@name,'PPV-ACCT-GRP_')]";

	public final String A098_ACC = "//div/input[starts-with(@name,'subfield_60_0')]";
	public final String A098_CST = "//div/input[starts-with(@name,'subfield_60_1')]";
	public final String A098_LOC = "//div/input[starts-with(@name,'subfield_60_2')]";
	public final String A098_USAGE = "//select[starts-with(@name,'USG-IND_')]";
	public final String A098_ACC1 = "//div/input[starts-with(@name,'subfield_76_0')]";
	public final String A098_CST1 = "//div/input[starts-with(@name,'subfield_76_1')]";
	public final String A098_LOC1 = "//div/input[starts-with(@name,'subfield_76_2')]";
	public final String A098_ITM1 = "//label[@name='action_0'][1]";

	public final String A098_MANUF_CD = "//input[starts-with(@name,'MANUF_')]";
	public final String A098_MANUF_NM_ = "//input[starts-with(@name,'MANUF-NAME_')]";
	public final String A098_PART_NO = "//input[starts-with(@name,'PART-NO_')]";
	public final String A098_EFF_DT = "//input[starts-with(@name,'datefield_0_5')]";
	public final String A098_CHK_DEF = "//label[text()='Default']/../input[1]";

	// Page Objects for "A099_Items_Supplier_RelationshipTest"
	public final String A099_CATLG_DESCR = "//input[starts-with(@name,'CATLG-DESCR_')]";
	public final String A099_MAX_QTY_LIMIT = "//input[starts-with(@name,'MAX-QTY-LIMIT_')]";
	public final String A099_AVRG_LEAD_DD = "//input[starts-with(@name,'AVRG-LEAD-DD_')]";

	// Page Objects for "A100_Item_PricesTest"
	public final String A100_PRC_TYPE = "//input[starts-with(@name,'PRC-TYPE_')]";
	public final String A100_PRC = "//input[starts-with(@name,'PRC_')]";
	public final String A100_QTY = "//input[starts-with(@name,'QTY_')]";
	public final String A100_PUOM = "//input[starts-with(@name,'PUOM_')]";
	public final String A100_QUOM = "//input[starts-with(@name,'QUOM_')]";
	public final String A100_TAX_CODE = "//input[starts-with(@name,'TAX-CODE_')]";
	public final String A100_EFF_DT_FRM = "//input[starts-with(@name,'datefield_0_10')]";
	public final String A100_EXP_DT = "//input[starts-with(@name,'datefield_0_11')]";

	// Page Objects for "A102_ICA_Default_Trading_RelationshipsTest"
	public final String A102_GEN_LEDG_ACC = "//input[starts-with(@name,'subfield_5_0')]";
	public final String A102_GEN_LEDG_CST = "//input[starts-with(@name,'subfield_5_1')]";
	public final String A102_ACC_PAY_ACC = "//input[starts-with(@name,'subfield_6_0')]";
	public final String A102_ACC_PAY_CST = "//input[starts-with(@name,'subfield_6_1')]";
	public final String A102_ACC_REC_ACC = "//input[starts-with(@name,'subfield_7_0')]";
	public final String A102_ACC_REC_CST = "//input[starts-with(@name,'subfield_7_1')]";
	public final String A102_COM_PUR_ACC = "//input[starts-with(@name,'subfield_8_0')]";
	public final String A102_COM_PUR_CST = "//input[starts-with(@name,'subfield_8_1')]";
	public final String A102_PUR_MNGT_ACC = "//input[starts-with(@name,'subfield_9_0')]";
	public final String A102_PUR_MNGT_CST = "//input[starts-with(@name,'subfield_9_1')]";
	public final String A102_FXD__ASST_ACC = "//input[starts-with(@name,'subfield_10_0')]";
	public final String A102_FXD__ASST_CST = "//input[starts-with(@name,'subfield_10_1')]";
	public final String A102_INV_MNGT_ACC = "//input[starts-with(@name,'subfield_11_0')]";
	public final String A102_INV_MNGT_CST = "//input[starts-with(@name,'subfield_11_1')]";
	public final String A102_CASH_REC_ACC = "//input[starts-with(@name,'subfield_12_0')]";
	public final String A102_CASH_REC_CST = "//input[starts-with(@name,'subfield_12_1')]";

	// Page Objects for "A103_IM_AccountsTest"
	public final String A103_ACC_CD = "//input[starts-with(@name,'CNTRL-CODE-LST_')]";
	public final String A103_CD_DESC = "//input[starts-with(@name,'CNTRL-CODE-DESCR_')]";
	public final String A103_STK_ACC = "//input[starts-with(@name,'subfield_3_0')]";
	public final String A103_STK_CST = "//input[starts-with(@name,'subfield_3_1')]";
	public final String A103_REVCST_ACC = "//input[starts-with(@name,'subfield_4_0')]";
	public final String A103_REVCST_CST = "//input[starts-with(@name,'subfield_4_1')]";
	public final String A103_REV_ACC = "//input[starts-with(@name,'subfield_5_0')]";
	public final String A103_REV_CST = "//input[starts-with(@name,'subfield_5_1')]";
	public final String A103_SUNDEB_ACC = "//input[starts-with(@name,'subfield_6_0')]";
	public final String A103_SUNDEB_CST = "//input[starts-with(@name,'subfield_6_1')]";
	public final String A103_STKREV_ACC = "//input[starts-with(@name,'subfield_7_0')]";
	public final String A103_STKREV_CST = "//input[starts-with(@name,'subfield_7_1')]";
	public final String A103_RETSUPP_ACC = "//input[starts-with(@name,'subfield_8_0')]";
	public final String A103_RETSUPP_CST = "//input[starts-with(@name,'subfield_8_1')]";
	public final String A103_MATISS_ACC = "//input[starts-with(@name,'subfield_10_0')]";
	public final String A103_MATISS_CST = "//input[starts-with(@name,'subfield_10_1')]";
	public final String A103_STKADJ_ACC = "//input[starts-with(@name,'subfield_11_0')]";
	public final String A103_STKADJ_CST = "//input[starts-with(@name,'subfield_11_1')]";
	public final String A103_STKDIS_ACC = "//input[starts-with(@name,'subfield_12_0')]";
	public final String A103_STKDIS_CST = "//input[starts-with(@name,'subfield_12_1')]";
	public final String A103_RETSTR_ACC = "//input[starts-with(@name,'subfield_13_0')]";
	public final String A103_RETSTR_CST = "//input[starts-with(@name,'subfield_13_1')]";

	// Page Objects for "A104_Inventory_Company_ControlsTest"
	public final String A104_GL_PER = "//input[starts-with(@name,'GL-PER_')]";

	public final String A104_GL_YY = "//input[starts-with(@name,'GL-YY_')]";
	public final String A104_ACC_CD = "//input[starts-with(@name,'CNTRL-CODE_')]";

	public final String A104_DEF_BTCH_TYPE = "//input[starts-with(@name,'DFLT-GL-BTCH-TYPE_')]";
	public final String A104_RETAIN_TRAN = "//input[starts-with(@name,'TRAN-RETAIN-PER_')]";
	public final String A104_UOM = "//input[starts-with(@name,'TRAN-RETAIN-UOM_')]";
	public final String A104_RETAIN_DOC = "//input[starts-with(@name,'DOC-RETAIN-PER_')]";
	public final String A104_UOM1 = "//input[starts-with(@name,'DOC-RETAIN-UOM_')]";
	public final String A104_PER_ISSUE = "//input[starts-with(@name,'OC-PERC_')]";
	public final String A104_FXD_AMT = "//input[starts-with(@name,'OC-AMT_')]";
	public final String A104_CHK_ALLWISS_PRCOVR = "//label[text()='Allow Issue Price Override']/../input[1]";
	public final String A104_FIFO = "//div/input[@name='CSTNG-MTHD-IND_1'][@value='First in First Out']";
	public final String A104_LOP = "//div/input[@name='DFLT-PRC-IND_1'][@value='Last Order Price']";
	public final String A104_CHK_US_REQ = "//label[text()='Use Requisitions']/../input[1]";
	public final String A104_CHK_US_PICLST = "//label[text()='Use Picking Lists']/../input[1]";
	public final String A104_CHK_COM_NUM = "//label[text()='Company Numbering']/../input[1]";
	public final String A104_NUM_LEN = "//input[starts-with(@name,'DOC-LEN_')]";
	public final String A104_NXT_NUM = "//input[starts-with(@name,'NEXT-NUM_')]";

	public final String A104_MAT_ISSUE = "//select[starts-with(@name,'ISSUE-NUM-IND_')]";
	public final String A104_ADJ_IN = "//select[starts-with(@name,'ADJMT-NUM-IND_')]";
	public final String A104_ADJ_OUT = "//select[starts-with(@name,'ADJMT-O-NUM-IND_')]";
	public final String A104_STK_DISP = "//select[starts-with(@name,'DISPL-NUM-IND_')]";
	public final String A104_RET_STOR = "//select[starts-with(@name,'RETN-NUM-IND_')]";
	public final String A104_STOR_TRANSF = "//select[starts-with(@name,'STRF-NUM-IND_')]";
	public final String A104_BIN_TRANSF = "//select[starts-with(@name,'BTRF-NUM-IND_')]";
	public final String A104_PICK_LIST = "//select[starts-with(@name,'PICK-LST-NUM-IND_')]";
	public final String A104_STK_TK = "//select[starts-with(@name,'STCK-TAKE-NUM-IND_')]";

	public final String A104_MAT_ISSUE1 = "//input[starts-with(@name,'ISSUE-BTCH-TYPE_')]";
	public final String A104_ADJ_IN1 = "//input[starts-with(@name,'ADJMT-BTCH-TYPE_')]";
	public final String A104_ADJ_OUT1 = "//input[starts-with(@name,'ADJMT-O-BTCH-TYPE_')]";
	public final String A104_STK_DISP1 = "//input[starts-with(@name,'DISPL-BTCH-TYPE_')]";
	public final String A104_RET_STOR1 = "//input[starts-with(@name,'RETN-BTCH-TYPE_')]";
	public final String A104_STOR_TRANSF1 = "//input[starts-with(@name,'STRF-BTCH-TYPE_')]";
	public final String A104_RET_SUPP = "//input[starts-with(@name,'SRETN-BTCH-TYPE_')]";
	public final String A104_RCOST_VAR = "//input[starts-with(@name,'RCOST-BTCH-TYPE_')]";
	public final String A104_SCOST_REV = "//input[starts-with(@name,'SCOST-BTCH-TYPE_')]";

	// Page Objects for "A106_Inventory_Store_ControlTest"
	public final String A106_STORE = "//input[starts-with(@name,'STORE_')]";
	public final String A106_STD_STORE = "//div/input[@name='STORE-IND'][@value='Standard Store']";
	public final String A106_IN_TRNST = "//div/input[@name='STORE-IND'][@value='In Transit Store']";

	public final String A106_FIFO1 = "//div/input[@name='Radio Button group'][@value='FIFO']";
	public final String A106_SUP_FRM_PUR = "//div/input[@name='SUPP-MTHD_1'][@value='Supply from Purchasing']";
	public final String A106_CHK_ISS_PRCOVR = "//label[text()='Issue Price Override']/../input[1]";

	public final String A106_MAT_ISSUE = "//input[starts-with(@name,'ISSUE-CIRC_')]";
	public final String A106_ADJ_IN = "//input[starts-with(@name,'ADJMT-CIRC_')]";
	public final String A106_ADJ_OUT = "//input[starts-with(@name,'ADJMT-O-CIRC_')]";
	public final String A106_STK_DISP = "//input[starts-with(@name,'DISPL-CIRC_')]";
	public final String A106_RET_STOR = "//input[starts-with(@name,'RETN-CIRC_')]";
	public final String A106_STOR_TRANSF = "//input[starts-with(@name,'STRF-CIRC_')]";
	public final String A106_BIN_TRANSF = "//input[starts-with(@name,'BTRF-CIRC_')]";
	public final String A106_PICK_LIST = "//input[starts-with(@name,'PICK-LST-CIRC_')]";
	public final String A106_STK_TK = "//input[starts-with(@name,'STCK-TAKE-CIRC_')]";
	public final String A106_LOT_CNT_ALL = "//input[starts-with(@name,'LOT-ALLOC-CIRC_')]";

	public final String A106_CHK_MAT_ISSUE = "//div/label[text()='Imm']/../div/input[starts-with(@name,'ISSUE-PRT-FLAG_')]/..";
	public final String A106_CHK_ADJ_IN = "//div/label[text()='Imm']/../div/input[starts-with(@name,'ADJMT-PRT-FLAG_')]/..";
	public final String A106_CHK_ADJ_OUT = "//div/label[text()='Imm']/../div/input[starts-with(@name,'ADJMT-O-PRT-FLAG_')]/..";
	public final String A106_CHK_STK_DISP = "//div/label[text()='Imm']/../div/input[starts-with(@name,'DISPL-PRT-FLAG_')]/..";
	public final String A106_CHK_RET_STOR = "//div/label[text()='Imm']/../div/input[starts-with(@name,'RETN-PRT-FLAG_')]/..";
	public final String A106_CHK_STOR_TRANSF = "//div/label[text()='Imm']/../div/input[starts-with(@name,'STRF-PRT-FLAG_')]/..";
	public final String A106_CHK_BIN_TRANSF = "//div/label[text()='Imm']/../div/input[starts-with(@name,'BTRF-PRT-FLAG_')]/..";
	public final String A106_CHK_LOT_CNT_ALL = "//div/label[text()='Imm']/../div/input[starts-with(@name,'LOT-ALLOC-PRT-FLAG_')]/..";

	// Page Objects for "A107_Stores_HierarchyTest"
	public final String A107_NW_PAR = "//input[starts-with(@name,'PRNT-STORE_')]";
	public final String A107_LD_TM = "//input[starts-with(@name,'LEAD-TIME_')]";
	public final String A107_LD_TM_UOM = "//input[starts-with(@name,'LEAD-TIME-UOM_')]";

	// Page Objects for "A108_Item_Store_Controls_Manual_Store_HierarchyTest"
	public final String A108_DFLT_BIN = "//input[starts-with(@name,'DFLT-BIN_')]";
	public final String A108_FD_CST = "//input[starts-with(@name,'OC-VAL_')]";
	public final String A108_SUP_FRM_PUR = "//input[@name='SUPP-MTHD_1'][@value='Supply From Purchasing']";
	public final String A108_REORDR_LVL = "//input[starts-with(@name,'REORDR-LVL_')]";
	public final String A108_REORDR_QTY = "//input[starts-with(@name,'REORDR-QTY_')]";
	public final String A108_FIFO = "//div/input[@name='CSTNG-MTHD-IND_1'][@value='First in First out']";
	public final String A108_LIP = "//div/input[@name='DFLT-PRC-IND_1'][@value='Last Invoice Price']";

	// Page Objects for "A109_Element_Control_AccountsTest
	public final String A109_ACC_APY = "//input[starts-with(@name,'PL-CNTRL_')]";
	public final String A109_COM_PUR = "//input[starts-with(@name,'CP-CNTRL_')]";
	public final String A109_PUR_MNGT = "//input[starts-with(@name,'PO-CNTRL_')]";
	public final String A109_INV_MNGT = "//input[starts-with(@name,'IM-CNTRL_')]";

	// Page Objects for "A110_Security_Range_ListsTest"
	public final String A110_RNGE_LST = "//input[starts-with(@name,'RNGE_')]";
	public final String A110_SYS = "//select[starts-with(@name,'SYS_')]";
	public final String A110_ID = "//input[starts-with(@name,'ID_')]";
	public final String A110_SYS_SEAR = "//select[starts-with(@name,'PARAM-SYS_')]";

	// Page Objects for "A111_Security_GroupsTest"
	public final String A111_CHK_DEN_Al = "//div/label[text()=' Deny All']/../input[1]";

	// Page Objects for "A113_Security_Access_CodesTest"
	public final String A113_ACCS_CD = "//input[starts-with(@name,'ACCS_')]";
	public final String A113_ACCS_DATA = "//input[starts-with(@name,'ACCS-DATA_')]/../input[1]";

	// Page Objects for "A114
	public final String A114_UPDT_ACCS = "//input[starts-with(@name,'ACCS-UPDT_')]";
	public final String A114_ENQ_ACCS = "//input[starts-with(@name,'ACCS-ENQRY_')]";

	// Page Objects for "A115
	public final String A115_ROLE = "//input[starts-with(@name,'ROLE_')]";
	public final String A115_FUNC_SCTY_GRP = "//input[starts-with(@name,'FUNC-SCTY-GRP_')]";
	public final String A115_DATA_SCTY_GRP = "//input[starts-with(@name,'DATA-SCTY-GRP_')]";
	public final String A115_CHK_DEF_ROL = "//label[contains(text(),'Elected Default Role')]/../input[1]";

	// Page Objects for "A116
	public final String A116_SEC_ELE = "//div[text()='Security Element']";
	public final String A116_DESC = "//div[text()='Description']";
	public final String A116_PAR_ELE = "//div[text()='Parent Element']";
	public final String A116_SEC_ELE_TBLE = "//div/table/tbody/tr/td[2]";

	// Page Objects for "A118

	public final String A118_CONFM_SUBMIT = "//div[contains(@class,'roundedCorners')]/button[@id='1_3']";
	public final String A118_HOLD = "//input[@id='chk_1_6']";
	public final String A118_GLSTRUCT = "//div[contains(@class,'licol')]";

	// Page Objects for "AD01008
	public final String AD01008_PERID = "//select[starts-with(@name,'PARM-PERIOD_')]";
	public final String AD01008_SYSTEM = "//select[starts-with(@name,'PARM-SYSTEM_')]";
	public final String AD01008_CALENDAR = "//select[starts-with(@name,'PARM-CALENDAR_')]";

	// Page Objects for "AD02001
	public final String AD02001_STORE = "//input[starts-with(@name,'PARAM-STORE_')]";
	public final String AD02001_ITEM = "//input[starts-with(@name,'PARAM-ITEM_')]";
	public final String AD02001_PHYS_QTY = "//input[starts-with(@name,'PHYS-QTY_')]";

	public final String AD02001_AVL_QTY = "//label[(text()='Available')]/../label[@name='action_0'][1]";
	public final String AD02001_NOTNL_QTY = "//label[(text()='Available')]/../label[@name='action_0'][2]";
	public final String AD02001_RE_ORDR_LVL = "//label[(text()='Re-order Level')]/../label[@name='action_0'][1]";
	public final String AD02001_RE_ORDR_QTY = "//label[(text()='Re-order Level')]/../label[@name='action_0'][1]";
	public final String AD02001_ITMTTL_PHYS_QTY = "//label[(text()='Physical Quantity')]/../label[@name='action_0'][2]";
	public final String AD02001_ITMTTL_AVL_QTY = "//label[(text()='Available Quantity')]/../label[@name='action_0'][4]";
	public final String AD02001_ITMTTL_NOTNL_QTY = "//label[(text()='Notional Quantity')]/../label[@name='action_0'][10]";

	public final String AD02001_JRNL_NUM = "//div[contains(@class,'dojoxGridColCaption') and (text()='Number')]";
	public final String AD02001_JRNL_ACC = "//th[@id='0_3Hdr4']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Account')]";
	public final String AD02001_JRNL_COST = "//th[@id='0_3Hdr5']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Cost')]";
	public final String AD02001_JRNL_DESC = "//th[@id='0_3Hdr12']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Description')]";
	public final String AD02001_JRNL_BS_VAL = "//th[@id='0_3Hdr13']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Base Value')]";
	public final String AD02001_JRNL_QNTY = "//th[@id='0_3Hdr14']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Quantity')]";
	public final String AD02001_JRNL_REF = "//th[@id='0_3Hdr14']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Reference')]";
	public final String AD02001_TL_STK_VAL = "//label[(text()='Total Stock Value')]/../label[@name='action_0']";
	public final String AD02001_ITMSTKVAL_ITM = "//th[@id='0_7Hdr0']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Item')]";
	public final String AD02001_ITMSTKVAL_PHY = "//th[@id='0_7Hdr1']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Physical')]";
	public final String AD02001_ITMSTKVAL_REQ_OUT = "//th[@id='0_7Hdr2']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Reqs Out')]";
	public final String AD02001_ITMSTKVAL_PHY_AVL = "//th[@id='0_7Hdr3']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Physical Avail')]";
	public final String AD02001_ITMSTKVAL_STK_VAL = "//th[@id='0_7Hdr6']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Stock Value')]";
	public final String AD02001_ITMSTKVAL_REQIN = "//th[@id='0_7Hdr3']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Reqs/Orders In')]";
	public final String AD02001_STRITMVAL_GEN = "//th[@id='0_4Hdr0']/..//div[contains(@class,'dojoxGridColCaption') and (text()='GRN')]";
	public final String AD02001_STRITMVAL_RECDT = "//th[@id='0_4Hdr1']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Receipt Date')]";
	public final String AD02001_STRITMVAL_REMQTY = "//th[@id='0_4Hdr2']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Remained Quantity')]";
	public final String AD02001_STRITMVAL_RECPRZ = "//th[@id='0_4Hdr3']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Receipt Price')]";
	public final String AD02001_STRITMVAL_ORGVAl = "//th[@id='0_4Hdr4']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Original Value')]";
	public final String AD02001_STRITMVAL_STRVAL = "//th[@id='0_4Hdr5']/..//div[contains(@class,'dojoxGridColCaption') and (text()='Source')]";

	// Page Objects for "AD02009

	public final String AD02009_ADDR_NUM = "//input[starts-with(@name,'ADDR-NUM_')]";
	public final String AD02009_INVCE_SITE = "//input[starts-with(@name,'INVCE-SITE_')]";
	public final String AD02009_DSTRM_1 = "//input[starts-with(@name,'DSCNT-TERMS-1')]";
	public final String AD02009_SEAUT_STR = "//input[starts-with(@name,'PARAM-AUTH-STRUC_')]";
	public final String AD02009_SEAUT_DOCREF = "//input[starts-with(@name,'PARAM-DOC-REF_')]";

	public final String AD02009_ADV_NT = "//input[starts-with(@name,'ADVC-NOTE_')]";

	public final String AD02009_DELV = "//input[starts-with(@name,'DLVRY_')]";

}
