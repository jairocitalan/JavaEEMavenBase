package mx.com.cinepolis.schedule.rest;

import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LogeoTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.facade.CatalogFacadeEJB;
import mx.com.cinepolis.scheduler.facade.GitHubFacadeEJB;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.util.List;

/**
 * @author jrodriguez
 */
@Path("/catalog")
public class CatalogRest {

    @EJB
    private CatalogFacadeEJB catalogFacadeEJB;
    
    @EJB
    private GitHubFacadeEJB gitHubFacadeEJB;
    
    
    @GET
    @Produces("application/json")
    @Path("/user")
    public Response getSimpleCatalog()
    {
        UserTO userTO = catalogFacadeEJB.getSimpleUser();
        return Response.ok().entity(userTO).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/usersGit/{log}")
    public Response getGitHubUser(@PathParam("log") String log) {
    	GitHubUserTO gitHubUserTO = gitHubFacadeEJB.getGitHubUser(log);
    	return Response.ok().entity(gitHubUserTO).build();   
    			
    }
    
    @GET
    @Produces("application/json")
    @Path("/usersGit")
    public Response login(@Context UriInfo ui) {
    	MultivaluedMap<String, String> queryParam= ui.getQueryParameters();
        String user = queryParam.getFirst("user");
        String pass = queryParam.getFirst("pass");
    	
        LogeoTO logeoTO = gitHubFacadeEJB.logeo(user, pass);
    	
        return Response.ok().entity(logeoTO).build();
    	
    }
    
    @POST
    @Produces("application/json")
    @Path("/usersGit")
    public Response register(GitHubUserTO gitHubUserTO ) {
    	GitHubUserTO gitHubUser = gitHubFacadeEJB.register(gitHubUserTO);
    	return Response.ok().entity(gitHubUser).build();
    }
    
   @GET
    @Produces("application/json")
    @Path("/country/{pais}")
    public Response getEstados(@PathParam("pais") String pais) {
       List<CatalogsTO> catalogToList= catalogFacadeEJB.getEstadosList(pais);
       GenericEntity<List<CatalogsTO>> entity= new GenericEntity<List<CatalogsTO>>(catalogToList) {};
       return Response.ok().entity(entity).build();
    }
   
   @GET
   @Produces("application/json")
   @Path("/users")
   public Response getAllUser() {
      List<UserTO> userToList= catalogFacadeEJB.getAllUser();
      GenericEntity<List<UserTO>> entity= new GenericEntity<List<UserTO>>(userToList) {};
      return Response.ok().entity(entity).build();
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Path("/register")
   public void registarUser(UserTO userTO) {
	   catalogFacadeEJB.registerUser(userTO);
     
   }
    
    
   /* @GET
    @Produces("application/json")
    @Path("/country")
    public Response getEstados(@Context UriInfo ui) {
      MultivaluedMap<String, String> queryParam= ui.getQueryParameters();
      String pais = queryParam.getFirst("pais");
    	
       List<CatalogsTO> catalogToList= catalogFacadeEJB.getEstadosList(pais);
       GenericEntity<List<CatalogsTO>> entity= new GenericEntity<List<CatalogsTO>>(catalogToList) {};
       return Response.ok().entity(entity).build();
    }
    
    */
    
    

    
    
    
    
    
    
    
    
    
}
