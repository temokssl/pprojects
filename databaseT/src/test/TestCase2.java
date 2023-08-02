package test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.Utilities.ConnectDBUtil;
import main.java.Utilities.QueryBuilderUtil;
import main.java.Utilities.repositories.AuthorRepoUtil;
import main.java.Utilities.repositories.ProjectRepoUtil;
import main.java.Utilities.repositories.TestRepoUtil;
import main.java.models.AuthorDTO;
import main.java.models.ProjectDTO;
import main.java.models.TestDTO;

public class TestCase2 extends BaseTest{

	private static String GET_PREC_TESTS_QUERY = SQL_QUERIES_FILE.getValue("/GET_PREC_TESTS_QUERY").toString();
	private static String GET_TESTS_QUERY_BASE = SQL_QUERIES_FILE.getValue("/GET_TESTS_QUERY").toString();
	private static String GET_AUTHOR_DATA_QUERY = SQL_QUERIES_FILE.getValue("/GET AUTHOR_DATA_QUERY").toString();
	private static String GET_PROJECT_DATA_QUERY = SQL_QUERIES_FILE.getValue("/GET_PROJECT_DATA_QUERY").toString();
	
	private static int NEW_STATUS_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/NEW_STATUS_ID").toString());
	private static int INITIAL_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/INITIAL_ID").toString());
	private static int NUMBER_OF_TESTS = Integer.parseInt(TEST_DATA_FILE.getValue("/NUMBER_OF_TESTS").toString());
	private static String PROJECT_NAME = TEST_DATA_FILE.getValue("/PROJECT_NAME").toString();
	private static String AUTHOR_NAME = TEST_DATA_FILE.getValue("/AUTHOR_NAME").toString();
	private static String AUTHOR_LOGIN = TEST_DATA_FILE.getValue("/AUTHOR_LOGIN").toString();
	private static String AUTHOR_EMAIL = TEST_DATA_FILE.getValue("/AUTHOR_EMAIL").toString();
	
	private static List<TestDTO> testsList;
	private static List<TestDTO> copyOfTests;
	private static ProjectDTO project;
	private static AuthorDTO author;
	private static String testsQuery;
	
	@BeforeMethod
	public void retrieveTestsFromDb() {
		List<Integer> testsIds = TestRepoUtil.getListOfRepeatingNumbers(NUMBER_OF_TESTS);
		testsQuery = QueryBuilderUtil.getInRangeQueryQuote(GET_TESTS_QUERY_BASE, testsIds);
		testsList = TestRepoUtil.getList(testsQuery);
		copyOfTests = new ArrayList<>();
		project = new ProjectDTO(INITIAL_ID,PROJECT_NAME);
		author = new AuthorDTO(INITIAL_ID,AUTHOR_NAME,AUTHOR_LOGIN,AUTHOR_EMAIL);
		
		ProjectRepoUtil.create(project);
		AuthorRepoUtil.create(author);
		for(TestDTO dto:testsList) {
			TestDTO row = new TestDTO(INITIAL_ID,dto.getTestName(),dto.getTestStatus(),dto.getTestMethodName(),dto.getProjectId()
		    		 ,dto.getSessionId(), dto.getStartTime(),dto.getEndTime(),dto.getEnv(),dto.getBrowser(),null);
			copyOfTests.add(row);
		}
		for (TestDTO dto :copyOfTests) {
			dto.setProjectId(project.getId());
			dto.setSessionId(author.getId());
        }
		for (TestDTO dto : copyOfTests) {
			TestRepoUtil.create(dto);
		}
	}
	@Test
	public void test() {
		for (TestDTO dto :testsList){
			dto.setTestStatus(NEW_STATUS_ID);
			TestRepoUtil.update(dto);
		}
		List<TestDTO> updatedTests = TestRepoUtil.getList(testsQuery);
		Assert.assertEquals(testsList, updatedTests,"The tests were not updated");
	}
	@AfterMethod
	public void deletePrecondFromDb() {
		String getCopiedTest = QueryBuilderUtil.getSimpleQueryQuote(GET_PREC_TESTS_QUERY, project.getId(), author.getId());
		
		for (TestDTO dto :copyOfTests) {
			TestRepoUtil.delete(dto);
        }
		ProjectRepoUtil.delete(project);
		AuthorRepoUtil.delete(author);
		ConnectDBUtil.getSession().close();
		Assert.assertTrue(TestRepoUtil.getList(getCopiedTest).isEmpty()&&
				ProjectRepoUtil.getList(GET_PROJECT_DATA_QUERY).isEmpty()
				&&AuthorRepoUtil.getList(GET_AUTHOR_DATA_QUERY).isEmpty(),"The precondition data was not deleted");
	}
}