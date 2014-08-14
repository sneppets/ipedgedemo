package com.sneppets.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.sneppets.drools.DroolInitialiser;
import com.sneppets.model.Account;

@Path("/checkaccount")
public class AccountService {
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") int withdrawAmount) {
 
		DroolInitialiser di = new DroolInitialiser();
		di.initialiseDrools();
		Account account = new Account(200);
		account.withdraw(withdrawAmount);
		account = di.runRulesForAccount(account);
		String accountStatus = account.getStatus();
		return Response.status(200).entity(accountStatus).build();
		
	}
}

