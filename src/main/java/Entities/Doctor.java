/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */
public class Doctor extends Person {
     private String specialization;
    
    //Constructors    
    public Doctor() {
        
    }
    
    public Doctor(String id, String name, int contactNo, String address, String specialization) {
        super(id, name, contactNo, address);
        this.specialization = specialization;
    }
    
    
    //Getters and Setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    
    
}
