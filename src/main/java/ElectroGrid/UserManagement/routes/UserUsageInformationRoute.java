package ElectroGrid.UserManagement.routes;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ElectroGrid.UserManagement.controller.UserUsageInformationController;
import ElectroGrid.UserManagement.modal.UserUsageInformation;

@Path("usageInformation")
public class UserUsageInformationRoute {
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUserUsageInformation() throws ClassNotFoundException, SQLException{
    	
    	if(UserUsageInformationController.getUserUsageInformation().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No User Usage Informations found").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(UserUsageInformationController.getUserUsageInformation()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUserUsageInformation(UserUsageInformation usageInformation) throws ClassNotFoundException, SQLException {
    	 System.out.println(usageInformation);
    	 UserUsageInformation createUsageInformation = UserUsageInformationController.createUserUsageInformation(usageInformation);
    	 if(createUsageInformation  != null) {
    		 return Response.status(Status.CREATED).entity(createUsageInformation ).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUserUsageInformationByID(@PathParam("id") int infId) throws ClassNotFoundException, SQLException{
    	
    	if(UserUsageInformationController.getUserUsageInformationByID(infId) != null) {
    		return Response.status(Status.OK).entity(UserUsageInformationController.getUserUsageInformationByID(infId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related User Usage Informations found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserUsageInformation(UserUsageInformation usageInformation,@PathParam("id") int infId) throws ClassNotFoundException, SQLException {
		
		if(usageInformation != null) {
			if(UserUsageInformationController.updateUserUsageInformation(usageInformation,infId) != null) {
				return Response.status(Status.OK).entity(UserUsageInformationController.updateUserUsageInformation(usageInformation,infId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related User Usage Informations found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserUsageInformation(@PathParam("id") int infId) throws ClassNotFoundException, SQLException{
		 
		if(!UserUsageInformationController.deleteUserUsageInformation(infId)) {
			return Response.status(Status.OK).entity(infId).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}


}
