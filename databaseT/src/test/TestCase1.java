package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.Utilities.ConnectDBUtil;
import main.java.Utilities.RandomValuesUtil;
import main.java.Utilities.repositories.TestRepoUtil;
import main.java.models.TestDTO;

public class TestCase1 extends BaseTest{
	
	private static String GET_TEST_DATA_QUERY = SQL_QUERIES_FILE.getValue("/GET_TEST_DATA_QUERY").toString();
	
	private static int MANUAL_PROJECT_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/MANUAL_PROJECT_ID").toString());
	private static int MANUAL_SESSION_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/MANUAL_SESSION_ID").toString());
	private static int INITIAL_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/INITIAL_ID").toString());
	private static String ENVIRONMENT = TEST_DATA_FILE.getValue("/ENVIRONMENT").toString();
	
	private static SimpleDateFormat dateFormat;
	private static String startTime;
	
	@BeforeMethod
	public void setup() {
		 dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 startTime = dateFormat.format(new Date());
	}
	
	@Test
	public void test() {	
		Assert.assertTrue(RandomValuesUtil.getRandomNumber(0, 1)==0, "Test failed");	
	}
	@AfterMethod
	public void addTestDataToDb(ITestResult result) {
		
	     int testStatus = result.getStatus(); 
	     String testName = result.getName();  
	     String testMethodName = result.getMethod().getMethodName();
	     String browserName = browser.getBrowserName().toString();
	     String endTime = dateFormat.format(new Date());
		 
	     TestDTO testData = new TestDTO(INITIAL_ID,testName,testStatus,testMethodName,MANUAL_PROJECT_ID,MANUAL_SESSION_ID, startTime,endTime,ENVIRONMENT,browserName,null);  
	     TestRepoUtil.create(testData);
	     TestDTO testDto = TestRepoUtil.read(GET_TEST_DATA_QUERY);
	     ConnectDBUtil.getSession().close();
	     Assert.assertEquals(testData,testDto,"Test info was not added.");
	}
}