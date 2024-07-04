/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExceptionHandling;

/**
 *
 * @author Pooja Malagala
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
     private static final Logger LOGGER = LoggerFactory.getLogger(UserNotFoundExceptionMapper.class);

    
     // Maps a UserNotFoundException to an HTTP response.
     
    @Override
    public Response toResponse(UserNotFoundException exception) {
        // Log the exception
        LOGGER.error("UserNotFoundException caught: {}", exception.getMessage(), exception);

        // Build and return the HTTP response
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage()) // Set the response entity to the exception message
                .type(MediaType.TEXT_PLAIN) // Set the response type to plain text
                .build();
    }
}
    

