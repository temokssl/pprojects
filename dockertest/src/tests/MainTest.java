package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import kong.unirest.HttpResponse;
import main.java.PO.AddProjectPage;
import main.java.PO.AllTestsPage;
import main.java.PO.NewTestPage;
import main.java.PO.ProjectsPage;
import main.java.Utilities.CookieUtil;
import main.java.Utilities.RandomUtil;
import main.java.api.RestResponses;
import main.java.api.RestUtil;
import main.java.setupdata.TestData;
public class MainTest extends BaseTest{

	@Test
	public void test(){
		
		HttpResponse<String> accessToken = RestResponses.getAccessToken();
		Assert.assertTrue(accessToken.isSuccess(),"Access token was not gotten");
		CookieUtil.setToken(accessToken.getBody().toString());
		browser.refresh();
		
		ProjectsPage projectsPage = new ProjectsPage();
		Assert.assertTrue(projectsPage.state().waitForDisplayed(),"Projects page is not being displayed");
		Assert.assertTrue(projectsPage.isVariantFooter(),"Version "+TestData.variant+" is not being displayed");
		projectsPage.clickProjectButton();
		
		AllTestsPage allTestsPage = new AllTestsPage();
		Assert.assertTrue(allTestsPage.state().waitForDisplayed(),TestData.projectName+" page has not been opened");
		Assert.assertTrue(allTestsPage.isSorted(),"Date times are not in descending order");
		Assert.assertTrue(allTestsPage.pageTestsEqualToApis(),"Tests fetched from API do not match page tests data");
		
		browser.goBack();
		projectsPage.clickAddButton();
		String newProjectName = RandomUtil.getRandomString(TestData.charactersRange);
		AddProjectPage addProjectPage = new AddProjectPage();
		addProjectPage.enterProjectName(newProjectName);
		addProjectPage.clickSaveProjectButton();
		Assert.assertTrue(addProjectPage.wasSuccesfullySaved(newProjectName),"Project was not saved succesfully");
		addProjectPage.quitAddProjectWindow();
		browser.refresh();
		Assert.assertTrue(projectsPage.appearsNewProject(newProjectName),"Project is not in main page");
		
		projectsPage.goToCreatedProjectPage(newProjectName);
		RestUtil.addTestDataFromApi(newProjectName);
		NewTestPage newTestPage = new NewTestPage();
		Assert.assertTrue(newTestPage.state().waitForDisplayed(),"Unsuccessfully test adding from API");
				
	}
	
}