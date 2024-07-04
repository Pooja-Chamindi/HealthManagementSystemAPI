/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */

import java.util.ArrayList;
import Entities.MedicalRecord;

public class Patient extends Person {
    
    private ArrayList<Prescription> prescriptions;
    
    //Constructors
    
    public Patient() {
        
    }
    
    public Patient(String id, String name, int phoneNo, String address) {
        super(id, name, phoneNo, address);
    }

    public Patient(String id, String name, int phoneNo, String address, MedicalRecord healthStatus, MedicalRecord medicalHistory) {
        super(id, name, phoneNo, address);
        
    }
    
    
    
    
    
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }
    
    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }
    
    public void removePrescription(Prescription prescription) {
        this.prescriptions.remove(prescription);
    }
    
    
}