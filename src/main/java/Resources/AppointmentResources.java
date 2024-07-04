/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */
import DAO.AppointmentDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Entities.Appointment;
import javax.ws.rs.core.Response;

@Path("/getappointmentlist")

public class AppointmentResources {
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    //Getting the information of one specific appointment using it's ID
    @GET
    @Path("/{appId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appId") String id) {
        try {
            return appointmentDAO.getAppointmentById(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting appointment by ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    

    //Getting the information of all the appointments of a specific doctor using their ID        
    @GET
    @Path("/getdoctorlist/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getDoctorsApponitments(@PathParam("doctorId") String id) {
        try {
            return appointmentDAO.getDoctorsAppointments(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting appointments for doctor with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    

    //Getting the information of all the appointments of a specific patient using Patient's ID       
    @GET
    @Path("/getpatientlist/{patientNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getPatientsApponitments(@PathParam("patientNo") String id) {
        try {
            return appointmentDAO.getPatientsAppointments(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting appointments for patient with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    

    //Getting the information an appointment of a specific doctor on a specific day on a specific time    
    @GET
    @Path("/getdoctorlist/{doctorId}/{day}/{time}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getDoctorsTimeAppointment(@PathParam("doctorId") String id, @PathParam("day") String day, @PathParam("time") String time) {
        try {
            return appointmentDAO.getDoctorsTimeAppointment(id, day, time);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting appointment for doctor with ID: " + id + " on day " + day + " at time " + time, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new Appointment to the system    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding appointment").build();
        }
    }
    
    
    //Cancelling an Appointment using its ID
    @DELETE
    @Path("/{appId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cancelAppointment(@PathParam("appId") String id) {
        try {
            appointmentDAO.cancelAppointment(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while canceling appointment").build();
        }
    }
    
    
    //Updating the details of an Appointment using its ID
    @PUT
    @Path("/{appId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appId") String id, Appointment updatedAppointment) {
        try {
            Appointment existingAppointment = appointmentDAO.getAppointmentById(id);

            if (existingAppointment != null) {
                updatedAppointment.setAppointmentId(id);
                appointmentDAO.updateAppointment(updatedAppointment);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found for ID: " + id).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating appointment").build();
        }
    }
    
    
    
    
}
