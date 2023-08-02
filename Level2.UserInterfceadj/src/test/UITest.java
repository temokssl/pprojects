package test;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import aquality.selenium.core.utilities.JsonSettingsFile;
import main.java.PO.AcceptCookiesPage;
import main.java.PO.FirstCardPage;
import main.java.PO.HideHelpPage;
import main.java.PO.HomePage;
import main.java.PO.SecondCardPage;
import main.java.PO.ThirdCardPage;
import main.java.PO.TimerStartsPage;
import main.java.Utilities.LoginDataUtil;
import main.java.Utilities.UploadFileUtil;

public class UITest extends BaseTest {
	
	
	
	private JsonSettingsFile testData = new JsonSettingsFile("testdata.json");
	private HomePage homePage = new HomePage();
	
	private int EMAIL_LENGTH = Integer.parseInt(testData.getValue("/EMAIL_LENGTH").toString());
	private int ALPHABETIC_CHARACTER_RANGE_SIZE = Integer.parseInt(testData.getValue("/ALPHABETIC_CHARACTER_RANGE_SIZE").toString());
	private int NUMBER_OF_CYRILIC_CHARS = Integer.parseInt(testData.getValue("/NUMBER_OF_CYRILIC_CHARS").toString());
	private int NUMBER_OF_ALPHABETIC_CHARS = Integer.parseInt(testData.getValue("/NUMBER_OF_ALPHABETIC_CHARS").toString());
	private int NUMBER_OF_INTERESTS = Integer.parseInt(testData.getValue("/NUMBER_OF_INTERESTS").toString());
	private int ROBOT_DELAY = Integer.parseInt(testData.getValue("/ROBOT_DELAY").toString());
	private int RANGE_OF_INTEGERS = Integer.parseInt(testData.getValue("/RANGE_OF_INTEGERS").toString());
	private String FILE_TO_UPLOAD = "/PICTURE";
	private String EMAIL = LoginDataUtil.getEmail(EMAIL_LENGTH,ALPHABETIC_CHARACTER_RANGE_SIZE);
	private String PASSWORD = LoginDataUtil.getPassword(EMAIL,ALPHABETIC_CHARACTER_RANGE_SIZE,NUMBER_OF_ALPHABETIC_CHARS,NUMBER_OF_CYRILIC_CHARS,RANGE_OF_INTEGERS);
	private String RANDOM_DOMAIN = LoginDataUtil.getRandomElementOfAList("DOMAINS");
	
	@Test
	public void TestCase1(){		
		
		
		FirstCardPage firstCardPage = new FirstCardPage();
		assertTrue(homePage.state().waitForDisplayed(), "Home Page is not being displayed");
		homePage.clickHeretoGoButton();
		assertTrue(firstCardPage.state().waitForDisplayed(), "Card 1 is not open");
		
		SecondCardPage secondCardPage = new SecondCardPage();
		secondCardPage.inputValidPassword(PASSWORD);
		secondCardPage.inputEmail(EMAIL);
		secondCardPage.inputDomain(RANDOM_DOMAIN);
		secondCardPage.inputTLDDomain();
		secondCardPage.unselectTermsandConditionsCheckBox();
		secondCardPage.clickNextButton();
		assertTrue(secondCardPage.state().waitForDisplayed(), "Card 2 is not open");
		
		ThirdCardPage thirdCardPage = new ThirdCardPage();
		thirdCardPage.unselectAll();
		thirdCardPage.selectInterests(NUMBER_OF_INTERESTS);
		thirdCardPage.clickUploadButton();
		UploadFileUtil.uploadFile(FILE_TO_UPLOAD,ROBOT_DELAY);
		thirdCardPage.clickNextButton();
		assertTrue(thirdCardPage.state().waitForDisplayed(), "Card 3 is not open");
	}
	@Test
	public void TestCase2() {
		
		HideHelpPage hideHelpPage = new HideHelpPage();
		assertTrue(homePage.state().isDisplayed(), "Home Page is not being displayed");
		homePage.clickHeretoGoButton();
		hideHelpPage.clickSendToBottomButton();
		assertTrue(hideHelpPage.state().waitForNotDisplayed(), "Help Form has not been hidden");
	}
	@Test
	public void TestCase3() {
		
		AcceptCookiesPage acceptCookiesPage = new AcceptCookiesPage();
		assertTrue(homePage.state().isDisplayed(), "Home Page is not being displayed");
		homePage.clickHeretoGoButton();
		acceptCookiesPage.state().waitForDisplayed();
		acceptCookiesPage.clickAcceptCookies();
		assertFalse(acceptCookiesPage.state().isDisplayed(), "Cookies Banner is open");
	}	
	@Test
	public void TestCase4() {
		
		TimerStartsPage timerStartsPage = new TimerStartsPage();
		assertTrue(homePage.state().isDisplayed(), "Home Page is not being displayed");
		homePage.clickHeretoGoButton();
		assertTrue(timerStartsPage.state().waitForDisplayed(), "Timer does not start from 0");
	}
}
