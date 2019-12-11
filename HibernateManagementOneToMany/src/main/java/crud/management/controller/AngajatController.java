package crud.management.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RestController;

import crud.management.persistence.model.Angajat;

@RestController
@Path("/users")
public class AngajatController {
	
	   /*---get all angajati---*/
		@GET
		@Path("/list")
		@Produces(MediaType.APPLICATION_JSON)
	   public Angajat de_sters_la_un_moment_dat() {
	      return new Angajat();
	   }
/*
		@GET
		@Path("/get3/{alternativ}")
		@Produces(MediaType.APPLICATION_JSON)
	   public SomeResponse de_sters_la_un_moment_dat(@PathParam("alternativ") String alternativ) {
	      return new SomeResponse(alternativ);
	   }
*/
}
