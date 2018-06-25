package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controls.JpaEM;
import model.User;

@Path("/users/")
@Produces(MediaType.APPLICATION_JSON)

public class UserService {

	private static EntityManager em;
	
	public UserService() {
		
	}
	
	@GET
	@Path("/get/")
	public List<User> getUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestService");
        em = emf.createEntityManager();
		System.out.println("USERS GET");
		List<User> r = em.createNamedQuery("User.findAll").getResultList();
		return r;
	}
}
