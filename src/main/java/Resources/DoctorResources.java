/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */
import DAO.DoctorDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Entities.Doctor;
        
@Path("/getdoctorlist")

public class DoctorResources {
     private DoctorDAO doctorDAO = new DoctorDAO();
    
    
    @GET //Getting the information of all the doctors in the system
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        try {
            return doctorDAO.getAllDoctors();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all doctors", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @GET //Getting the information of one specific patient using Doctor's ID
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") String id){
        try {
            return doctorDAO.getDoctorById(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting doctor by ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @POST //Adding a new doctor to the system
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDAO.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding doctor").build();
        }
    }
    
    @DELETE //Deleting one specific doctor from the system using doctor's ID
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDoctorById(@PathParam("doctorId") String id) {
        try {
            doctorDAO.deleteDoctorById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting doctor").build();
        }
    }
    
    @PUT //Replacing a doctor's details with new details using doctor's ID
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") String id, Doctor updatedDoctor) {
        try {
            Doctor existingDoctor = doctorDAO.getDoctorById(id);

            if (existingDoctor != null) {
                updatedDoctor.setId(id);
                doctorDAO.updateDoctor(updatedDoctor);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating doctor").build();
        }
    }
    
    
    
}
