/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author Pooja Malagala
 */

import DAO.PersonDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Entities.Person;

@Path("/getpeoplelist")

public class PersonResources {
    private PersonDAO personDAO = new PersonDAO();
    
    //Getting the information of all the people in the system
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() {
        try {
            return personDAO.getAllPeople();
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting all people", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Getting the information of one specific person using their ID
    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personId") String id){
        try {
            return personDAO.getPersonById(id);
        } catch (Exception ex) {
            throw new WebApplicationException("Error occurred while getting person by ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Adding a new person to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        try {
            personDAO.addPerson(person);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding person").build();
        }
    }
    
    
    //Deleting one specific person from the system using their ID
    @DELETE
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePersonById(@PathParam("personId") String id) {
        try {
            personDAO.deletePersonById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting person").build();
        }
    }
    
    
    //Replacing a person's details with new details using their ID
    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("personId") String id, Person updatedPerson) {
        try {
            Person existingPerson = personDAO.getPersonById(id);

            if (existingPerson != null) {
                updatedPerson.setId(id);
                personDAO.updatePerson(updatedPerson);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person not found").build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating person").build();
        }
    }
    
    
}
