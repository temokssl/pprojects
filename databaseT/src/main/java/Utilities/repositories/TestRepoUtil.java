package main.java.Utilities.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import main.java.Utilities.ConnectDBUtil;
import main.java.Utilities.RandomValuesUtil;
import main.java.models.TestDTO;

public class TestRepoUtil {
	
	private static Session session = ConnectDBUtil.getSession();

	public static <R> TypedQuery<R> getQuery(String queryQuote, Class<R> resultClass){
		return session.createNativeQuery(queryQuote, resultClass);
	}
	public static void create(TestDTO testdto) {
		session.save(testdto);	
		session.beginTransaction().commit();
	}
	public static TestDTO read(String queryCommand) {
		return TestRepoUtil.getQuery(queryCommand,TestDTO.class).getSingleResult();
	}
	public static <T> void update(TestDTO testdto) {
		session.update(testdto);
		session.beginTransaction().commit();
	}
	public static void delete(TestDTO testdto) {
		session.delete(testdto);
		session.beginTransaction().commit();
	}
	public static List<TestDTO> getList(String queryCommand){
		return TestRepoUtil.getQuery(queryCommand,TestDTO.class).getResultList();
	}
	public static List<Integer> getListOfRepeatingNumbers(int NUMBER_OF_TESTS){
		int number;
		List<Integer> testsIds = new ArrayList<>();
		do {
			number = RandomValuesUtil.generateRepeatingNumbers();
			if(!testsIds.contains(number)) {
				testsIds.add(number);
			}
		}while(testsIds.size()<NUMBER_OF_TESTS);
		return testsIds;
	}
}