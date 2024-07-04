/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */
import DAO.MedicalRecordDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Entities.MedicalRecord;

@Path("/getmedicallist")

public class MedicalRecordResources {
    private MedicalRecordDAO medicalDAO = new MedicalRecordDAO();
    
    //Getting the information of all the Medical Records in the system
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicals() {
        try {
            return medicalDAO.getAllMedicals();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all medical records", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Getting the information of one specific Medical Record using the Patient Number
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalByPatient(@PathParam("patientId") String id) {
        try {
            return medicalDAO.getMedicalByPatient(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting medical record for patient with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new Medical Record to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedical(MedicalRecord medical) {
        try {
            medicalDAO.addMedical(medical);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding medical record").build();
        }
    }
    
    
    //Removing a medical Record from the system using the patient ID
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedical(@PathParam("patientId") String id) {
        try {
            medicalDAO.deleteMedical(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting medical record").build();
        }
    }
    
    
    //Updating the details of a Medical Record
    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedical(@PathParam("patientId") String id, MedicalRecord updatedMedical) {
        try {
            MedicalRecord existingMedical = medicalDAO.getMedicalByPatient(id);

            if (existingMedical != null) {
                updatedMedical.setPatientNo(id);
                medicalDAO.updateMedical(updatedMedical);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found for patient with ID: " + id).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating medical record").build();
        }
    }
   
    
}
