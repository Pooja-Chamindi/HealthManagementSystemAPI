/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import DAO.BillingDAO;
import Entities.Billing;
import javax.ws.rs.core.Response;

@Path("/getbillinglist")

public class BillingResources {
    private BillingDAO billingDAO = new BillingDAO();

    //Getting all the information of the Bills in the System   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBills() {
        try {
            return billingDAO.getAllBills();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all bills", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    

    //Getting one specific Bill using the Bill number    
    @GET
    @Path("/{billNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillByBillNo(@PathParam("billNo") String id){
        try {
            return billingDAO.getBillByBillNo(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting bill by bill number: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    

    //Getting all the Bills of a single patient using their ID   
    @GET
    @Path("/getpatientlist/{patientNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getBillsByPatient(@PathParam("patientNo") String id) {
        try {
            return billingDAO.getBillsByPatient(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting bills for patient with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new Billing to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        try {
            billingDAO.addBilling(billing);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding billing").build();
        }
    }
    
    
    //Deleting a Bill from the system
    @DELETE
    @Path("/{billNo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBilling(@PathParam("billNo") String id) {
        try {
            billingDAO.deleteBillling(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting billing").build();
        }
    }
    
    
    //Updating a Bill in the system
    @PUT
    @Path("/{billNo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billNo") String id, Billing updatedBilling) {
        try {
            Billing existingBilling = billingDAO.getBillByBillNo(id);

            if (existingBilling != null) {
                updatedBilling.setBillNo(id);
                billingDAO.updateBilling(updatedBilling);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found for bill number: " + id).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating billing").build();
        }
    }
   
    
    
}
