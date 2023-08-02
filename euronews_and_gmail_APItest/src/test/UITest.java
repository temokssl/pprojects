package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import aquality.selenium.browser.AqualityServices;
import main.java.PO.EuronewsAPIPage;
import main.java.PO.HomePage;
import main.java.PO.NewslettersPage;
import main.java.PO.SubscribePage;
import main.java.PO.UnsubscribePage;

public class UITest extends BaseTest{

	private static String EMAIL = testDataFile.getValue("/EMAIL").toString();
	
	@Test
	public void testCase(){		
		
		HomePage homePage = new HomePage();
		homePage.clickAgreeButton();
		Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page is not being displayed");
		
		NewslettersPage newslettersPage = new NewslettersPage();
		newslettersPage.clickNewslettersButton();
		Assert.assertTrue(newslettersPage.state().waitForDisplayed(), "Newsletters Page is not being displayed");
		
		SubscribePage subscribePage = new SubscribePage();
		subscribePage.clickRandomNewsletterSubsButton();
		Assert.assertTrue(subscribePage.isSubmitFormUp(), "Submit form is not being displayed");
		newslettersPage.inputEmail(EMAIL);
		subscribePage.clickSubmitButton();
		Assert.assertTrue(newslettersPage.isAdditionalFormUp(), "Additional information Form is not being displayed");
		newslettersPage.clickCloseAdditionalForm();

		EuronewsAPIPage euronewsAPIPage = new EuronewsAPIPage();
		Assert.assertTrue(euronewsAPIPage.doesSubEmailExist(), "Subs not confirmed");
		AqualityServices.getBrowser().goTo(euronewsAPIPage.getConfirmSubsLink());		
		Assert.assertTrue(subscribePage.state().isDisplayed(), "Subs not confirmed");
		subscribePage.clickBackToTheSiteButton();
		Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page is not being displayed");
		
		UnsubscribePage unsubscribePage = new UnsubscribePage();
		newslettersPage.clickNewslettersButton();
		subscribePage.clickRandomNewsletterPreviewButton();
		AqualityServices.getBrowser().goTo(unsubscribePage.getUnsubsLink());		

		Assert.assertTrue(unsubscribePage.state().isDisplayed(),"Unsubs page is not being displayed");
		unsubscribePage.inputUnsubsEmail(EMAIL);
		unsubscribePage.clickUnsubsConfirmButton();
		Assert.assertTrue(unsubscribePage.isUnsubsMessageUp(), "No unsubscribed message displayed");
		Assert.assertTrue(euronewsAPIPage.doesUnsubEmailExist(), "Unsubs message received");
	
	}
}