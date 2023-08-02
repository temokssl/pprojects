package main.java.Utilities.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import main.java.Utilities.ConnectDBUtil;
import main.java.models.AuthorDTO;

public class AuthorRepoUtil {
	
	private static Session session = ConnectDBUtil.getSession();
	
	public static <R> TypedQuery<R> getQuery(String queryQuote, Class<R> resultClass){
		return session.createNativeQuery(queryQuote, resultClass);
	}
	public static void create(AuthorDTO AuthorDTO) {
		session.save(AuthorDTO);	
		session.beginTransaction().commit();
	}
	public static AuthorDTO read(String queryCommand) {
		return AuthorRepoUtil.getQuery(queryCommand,AuthorDTO.class).getSingleResult();
	}
	public static <T> void update(AuthorDTO AuthorDTO) {
		session.update(AuthorDTO);
		session.beginTransaction().commit();
	}
	public static void delete(AuthorDTO AuthorDTO) {
		session.delete(AuthorDTO);
		session.beginTransaction().commit();
	}
	public static List<AuthorDTO> getList(String queryCommand){
		return AuthorRepoUtil.getQuery(queryCommand,AuthorDTO.class).getResultList();
	}
}