/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */
import DAO.PrescriptionDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Entities.Prescription;
import javax.ws.rs.core.Response;

@Path("/getprescriptionlist")

public class PrescriptionResources {
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    
    //Getting all the information of the Prescriptions in the System
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        try {
            return prescriptionDAO.getAllPrescriptions();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all prescriptions", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Getting one specific prescription using the Prescription ID
    @GET
    @Path("/{presId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionByID(@PathParam("presId") String id){
        try {
            return prescriptionDAO.getPrescriptionByID(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting prescription by ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Getting all the Prescriptions of a single patient using their ID
    @GET
    @Path("/getpatientlist/{patientNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getPrescriptionsByPatient(@PathParam("patientNo") String id) {
        try {
            return prescriptionDAO.getPrescriptionsByPatient(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting prescriptions for patient with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new Prescription to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding prescription").build();
        }
    }
        
    //Deleting a prescription from the system
    @DELETE
    @Path("/{presId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePrescription(@PathParam("presId") String id) {
        try {
            prescriptionDAO.deletePrescription(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting prescription").build();
        }
    }
    
    
    //Updating a prescription in the system
    @PUT
    @Path("/{presId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("presId") String id, Prescription updatedPrescription) {
        try {
            Prescription existingPrescription = prescriptionDAO.getPrescriptionByID(id);

            if (existingPrescription != null) {
                updatedPrescription.setPrescriptionId(id);
                prescriptionDAO.updatePrescription(updatedPrescription);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found for ID: " + id).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating prescription").build();
        }
    }
    
    
}
