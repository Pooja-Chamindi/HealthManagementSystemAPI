/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */

import DAO.PatientDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Entities.Patient;
import javax.ws.rs.core.Response;

@Path("/getpatientlist")

public class PatientResources {
    private PatientDAO patientDAO = new PatientDAO();
    
    //Getting the information of all the patients in the system
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        try {
            return patientDAO.getAllPatients();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all patients", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Getting the information of one specific patient using Patient's ID
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") String id){
        try {
            return patientDAO.getPatientById(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting patient by ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new patient to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding patient").build();
        }
    }
    
    
    //Deleting one specific patient from the system using patient's ID
    @DELETE
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePatientById(@PathParam("patientId") String id) {
        try {
            patientDAO.deletePatientById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting patient").build();
        }
    }
    
    
    //Replacing a patient's details with new details using their ID
    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") String id, Patient updatedPatient) {
        try {
            Patient existingPatient = patientDAO.getPatientById(id);

            if (existingPatient != null) {
                updatedPatient.setId(id);
                patientDAO.updatePatient(updatedPatient);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating patient").build();
        }
    }
    
    
}
