package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.obj.Account;

@Path("/accountservice/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountService 
{
	 public Map<String, Account> accounts = new HashMap<String, Account>();
	 
	 public void init() 
	 {
			Account newAccount0 = new Account();
			newAccount0.setId(0);
			newAccount0.setName("Jane Doe");

			Account newAccount1 = new Account();
			newAccount1.setId(1);
			newAccount1.setName("John Doe");

			accounts.put("0", newAccount0);
			accounts.put("1", newAccount1);
	}

	public AccountService() 
	{
		init();
	}
	
	@GET
	@Path("/accounts/{id}")
	public String getAccount(@PathParam("id") String id) 
	{
		Account c = accounts.get(id);
		return c.getName();
	}
	
	@GET
	@Path("/message/{name}")
	public String yoName(@PathParam("name") String ime)
	{
		return "yo, " + ime +"!";
	}
	
	@GET
	@Path("/getall/list")
	public String random()
	{
		String index = "";
		String names = "";
		for(int i = 0; i < accounts.size(); i++)
		{
			index = String.valueOf(i);
			if(i == accounts.size()-1)
			{
				names += accounts.get(index).getName();
			} else
			{
				names += accounts.get(index).getName() + ", ";
			}
			
			
		
		}
		return names;
	}
	

	
	 
}
