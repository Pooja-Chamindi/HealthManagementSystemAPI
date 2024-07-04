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

public class PatientDAO {
    private static List<Patient> patients = new ArrayList<>();
    
    static {
        patients.add(new Patient("P000", "Malithma Gunasekara", 0711234567, "156, Pagoda Road, Nugegoda"));        
        patients.add(new Patient("P001", "Yomal Silva", 0711234567, "122/1, School Lane, Panadura"));
        patients.add(new Patient("P002", "Sanuvi Senanayake", 0711234567, "122/1, Church Avenue, Pannipitiya"));
        
    }
    
    //Getting the information of all the patients in the sysetm
    public List<Patient> getAllPatients() {
        return patients;
    }
    
    
    //Geting the information of one specific patient using their ID
    public Patient getPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equalsIgnoreCase(id)) {
                return patient;
            }
        }
        return null;
    }
    
    
    //Adding a new patient to the system
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    
    //Deleting one specific patient from the system using their ID
    public void deletePatientById(String id) {
        patients.removeIf(patient -> patient.getId().equals(id));
    }
    
    
    //Replacing a patient's details with new details using their ID
    public void updatePatient(Patient updatedPatient) {
        for(int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if(patient.getId().equalsIgnoreCase(updatedPatient.getId())) {
                patients.set(i, updatedPatient);
                return;
            }
        }
    }
    
    
    
    
    
}
