package tn.esprit.Service;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;


@Path("rendez-vous")
public class RendVouService {

		static RendezVousBusiness r =new RendezVousBusiness();
		
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public Response AddRendezVou(RendezVous v) {
			if(r.addRendezVous(v)) {
			return Response
				      .status(Response.Status.CREATED)
				      .entity("done")
				      .build();
		}
			return Response
				      .status(Response.Status.NOT_FOUND)
				      .entity("done")
				      .build();
		}
		
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		
		public  Response GetRendezVous() {
			r.getListeRendezVous();
			return Response
				      .status(Response.Status.OK)
				      .entity(r.getListeRendezVous()).type(MediaType.APPLICATION_JSON)
				      .build();
		}
		

		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/rendezvous")
		public Response getrendwithref(@QueryParam("refLogement") int refLogement) {
			if(r.getListeRendezVousByLogementReference(refLogement).size() !=0) {
			return Response
				      .status(Response.Status.OK)
				      .entity(r.getListeRendezVousByLogementReference(refLogement)).type(MediaType.APPLICATION_JSON)
				      .build();
			}
			return Response
				      .status(Response.Status.NOT_FOUND)
				      .build();
		}
		
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/one/{id}")
		public Response getrendwitid(@PathParam("id") int id) {
			if (r.getRendezVousById(id)!=(null)) {
			return Response
				      .status(Response.Status.OK)
				      .entity(r.getRendezVousById(id)).type(MediaType.APPLICATION_JSON)
				      .build();
			}
			return Response
				      .status(Response.Status.NOT_FOUND)				  
				      .build();
			
		}
		
		@DELETE
		@Path("/delete/{id}")
		public Response delete(@PathParam("id") int id) {
			if (r.deleteRendezVous(id)) {
			return Response
				      .status(Response.Status.OK)
				      .build();
			}
			return Response
				      .status(Response.Status.NOT_FOUND)
				      .build();
		}
		
		@PUT
		@Path("/update/{id}")
		public Response updtae(@PathParam("id") int id,RendezVous ren) {
			if (r. updateRendezVous(id, ren)) {
			return Response
				      .status(Response.Status.OK)
				      .entity(r.getRendezVousById(id)).type(MediaType.APPLICATION_JSON)
				      .build();
			}
			return Response
				      .status(Response.Status.NOT_FOUND)
				      .build();
		}
		
		
		
		
}
