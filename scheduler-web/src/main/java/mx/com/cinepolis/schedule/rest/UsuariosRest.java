package mx.com.cinepolis.schedule.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import mx.com.cinepolis.scheduler.commons.to.ResponseTO;
import mx.com.cinepolis.scheduler.commons.to.UsuariosTO;
import mx.com.cinepolis.scheduler.facade.UsuariosFacadeEJB;

@Path("/api/v1")
public class UsuariosRest {
	
	@EJB
	private UsuariosFacadeEJB usuariosFacadeEJB;
       
	   @GET
	   @Produces("application/json")
	   @Path("/login")
	   public Response login(@Context UriInfo ui) {
		   MultivaluedMap<String, String> queryParam= ui.getQueryParameters();
	        String user = queryParam.getFirst("user");
	        String pass = queryParam.getFirst("pass");
		    
		    ResponseTO response = usuariosFacadeEJB.login(user, pass);
		    return Response.ok().entity(response).build();
	   }
	
	   @POST
	   @Produces("application/json")
	   @Path("/register")
	   public Response registraUsuario(UsuariosTO usuariosTO) {
		ResponseTO response= usuariosFacadeEJB.ragistrarUsuario(usuariosTO);
		return Response.ok().entity(response).build();
		
	}
	   
	   @GET
	   @Produces("application/json")
	   @Path("/allUsers")
	   public Response getAllUsuarios() {
		   List<UsuariosTO> usuariosTOList=usuariosFacadeEJB.getAllUsuarios();
		   GenericEntity<List<UsuariosTO>> entity= new GenericEntity<List<UsuariosTO>>(usuariosTOList) {};
		   return Response.ok().entity(entity).build();
		   
	   }
	   
	   @PUT
	   @Produces("application/json")
	   @Path("/update")
	   public Response actualizaUsuarios(UsuariosTO usuariosTO) {
		   ResponseTO response = usuariosFacadeEJB.actualizaUsuarios(usuariosTO);
		   return Response.ok().entity(response).build();
	   }
	   
	   @DELETE
	   @Produces("application/json")
	   @Path("/delete/{id}")
  	   public Response eliminaUsuarios(@PathParam("id") Long id) {
		   ResponseTO response= usuariosFacadeEJB.eliminaUsuarios(id);
		   return Response.ok().entity(response).build();
	   }
	   
	   
	
}
