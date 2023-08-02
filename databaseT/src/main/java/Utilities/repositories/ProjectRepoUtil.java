package main.java.Utilities.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import main.java.Utilities.ConnectDBUtil;
import main.java.models.ProjectDTO;

public class ProjectRepoUtil {
	
	private static Session session = ConnectDBUtil.getSession();
	
	public static <R> TypedQuery<R> getQuery(String queryQuote, Class<R> resultClass){
		return session.createNativeQuery(queryQuote, resultClass);
	}
	public static void create(ProjectDTO ProjectDTO) {
		session.save(ProjectDTO);	
		session.beginTransaction().commit();
	}
	public static ProjectDTO read(String queryCommand) {
		return ProjectRepoUtil.getQuery(queryCommand,ProjectDTO.class).getSingleResult();
	}
	public static <T> void update(ProjectDTO ProjectDTO) {
		session.update(ProjectDTO);
		session.beginTransaction().commit();
	}
	public static void delete(ProjectDTO ProjectDTO) {
		session.delete(ProjectDTO);
		session.beginTransaction().commit();
	}
	public static List<ProjectDTO> getList(String queryCommand){
		return ProjectRepoUtil.getQuery(queryCommand,ProjectDTO.class).getResultList();
	}
}