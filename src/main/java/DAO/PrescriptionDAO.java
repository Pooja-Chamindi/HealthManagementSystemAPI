/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author pooja malagala
 */

import java.util.ArrayList;
import java.util.List;
import Entities.Patient;
import Entities.Prescription;

public class PrescriptionDAO {
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static {
        Patient pat1 = new Patient("P000", "Malithma Gunasekara", 0711234567, "156, Pagoda Road, Nugegoda");
        Patient pat2 = new Patient("P001", "Yomal Silva", 0711234567, "122/1, School Lane, Panadura");
        Patient pat3 =new Patient("P002", "Sanuvi Senanayake", 0711234567, "122/1, Church Avenue, Pannipitiya");
        
        
        prescriptions.add(new Prescription("PR001", pat1, "Triptans", 50, "Twice a day", 7));
        prescriptions.add(new Prescription("PR002", pat2, "Omeprazole", 120, "Thrice a day", 10));
        prescriptions.add(new Prescription("PR002", pat2, "Antidepressants", 120, "Twice a day", 5));
    }
    
    //Getting all the information of the PRescriptions in the System
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }
    

    //Getting one specific prescription using the Prescription ID
    public Prescription getPrescriptionByID(String presId) {
        for(Prescription prescription : prescriptions) {
            if(prescription.getPrescriptionId().equals(presId)) {
                return prescription;
            }
        }
        return null;
    }
    
    
    //Getting all the Prescriptions of a single patient using their ID
    public List<Prescription> getPrescriptionsByPatient(String patientId) {
        List <Prescription> patientsPrescriptions = new ArrayList<>();
        for(Prescription prescription : prescriptions) {
            if(prescription.getPatient().getId().equals(patientId)) {
                patientsPrescriptions.add(prescription);
            }
        }
        return patientsPrescriptions;
    }
    
    
    //Adding a new Prescription to the system
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }
    
    //Deleting a prescription from the system
    public void deletePrescription(String presId) {
        prescriptions.removeIf(prescription -> prescription.getPrescriptionId().equals(presId));
    }
    
    
    //Updating a prescription in the system
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if(prescription.getPrescriptionId().equals(updatedPrescription.getPrescriptionId())) {
                prescriptions.set(i, updatedPrescription);
            }
        }
    }
    
    
    
}
