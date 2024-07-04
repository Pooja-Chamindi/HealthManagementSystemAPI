/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExceptionHandling;

/**
 *
 * @author Pooja Malagala
 */
public class UserNotFoundException extends RuntimeException {
    // Constructor to create a new UserNotFoundException with a specific message.
     
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
