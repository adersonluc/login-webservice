package br.edu.aokikouji.service;


import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import br.edu.aokikouji.model.LoginEntry;
import br.edu.aokikouji.model.UserModel;

@Path("Login")
public class LoginService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String loginCheck(LoginEntry loginEntry){
		
		
		UserModel loginResultCheck = new UserModel();
		String loginCheckResult = "false";
		
			try{
				EntityManager loginServiceEntity = Persistence.createEntityManagerFactory("loginService").createEntityManager();
				loginServiceEntity.getTransaction().begin();
				loginResultCheck = loginServiceEntity
					.createQuery("select a from loginservice a where a.userName = :usr and a.password = :pwrd", UserModel.class)
					.setParameter("usr", loginEntry.getUsername())
					.setParameter("pwrd", loginEntry.getPassword())
					.getSingleResult();
				loginServiceEntity.getTransaction().commit();
				loginServiceEntity.close();	
				if(loginResultCheck != null)
					loginCheckResult = "true";				
			}
			catch(Exception getSingleResultError){
				loginCheckResult = "false";
			}		
		
		return loginCheckResult;
			
	}
	
}
