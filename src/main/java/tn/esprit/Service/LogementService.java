package tn.esprit.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.Logement;

@Path("leg")
public class LogementService {
	
	 LogementBusiness r = new LogementBusiness();
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response Getlog() {
		r.getLogements();
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogements()).type(MediaType.APPLICATION_JSON)
			      .build();
	}
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/logements")
	public Response getathing(@QueryParam("reference") int reference,@QueryParam("deleguation") String deleguation,
			@QueryParam("gouvernorat") String gouvernorat,
			@QueryParam("type") Logement.Type type,
			@QueryParam("prix") Float prix) {
		if ((reference) != 0 ) {
		r.getLogementsByReference(reference);
		System.out.println("done reference");
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByReference(reference)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	
	if ((deleguation) != null ) {
		System.out.println("done deleguation");
		r.getLogementsByDeleguation(deleguation);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByDeleguation(deleguation)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	if ((gouvernorat) != null ) {
		r.getLogementsByGouvernorat(gouvernorat);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByGouvernorat(gouvernorat)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	if ((type) != null ) {
		r.getLogementsByType(type);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByType(type)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	if ((prix) != -1 ) {
		System.out.println("prix");
		r.getLogementsByPrix(prix);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByPrix(prix)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	return Response
		      .status(Response.Status.NOT_FOUND)	 
		      .build();
	}
	/*
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/logma")
	public Response getrendwithref(@QueryParam("deleguation") String deleguation) {
		r.getLogementsByDeleguation(deleguation);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByDeleguation(deleguation)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/logmz")
	public Response getLogementsByGouvernorat(@QueryParam("gouvernorat") String gouvernorat) {
		r.getLogementsByGouvernorat(gouvernorat);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByGouvernorat(gouvernorat)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	
	@GET
	@Path("/logme")
	public Response getLogementsByType(@QueryParam("type") Logement.Type type) {
		r.getLogementsByType(type);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByType(type)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/logmr")
	public Response getLogementsByPrix(@QueryParam("prix") Float prix) {
		r.getLogementsByPrix(prix);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByPrix(prix)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/logm")
	public Response getLogementsByReference(@QueryParam("reference") int reference) {
		r.getLogementsByReference(reference);
		return Response
			      .status(Response.Status.OK)
			      .entity(r.getLogementsByReference(reference)).type(MediaType.APPLICATION_JSON)
			      .build();
		}
	*/
	
	
	
	
}
