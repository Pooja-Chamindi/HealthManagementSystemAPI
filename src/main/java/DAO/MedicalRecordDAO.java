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
import Entities.MedicalRecord;

public class MedicalRecordDAO {
     private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    static {
        medicalRecords.add(new MedicalRecord("P000", "Much better now", "Severe Migraine"));        
        medicalRecords.add(new MedicalRecord("P001", "Need treatments", "Gastritis"));
        medicalRecords.add(new MedicalRecord("P002","Update medicine","Back Pain"));
    }
    
    //Getting the information of all the Medical Records in the system
    public List<MedicalRecord> getAllMedicals() {
        return medicalRecords;
    }
    
    
    //Getting the information of one specific Medical Record using the Patient Number
    public MedicalRecord getMedicalByPatient(String patientId) {
        for(MedicalRecord medical : medicalRecords) {
            if(medical.getPatientNo().equals(patientId)) {
                return medical;
            }
        }
        return null;
    }
    
    
    //Adding a new Medical to the system
    public void addMedical(MedicalRecord medical) {
        medicalRecords.add(medical);
    }
    
    
    //Removing a medical Record from the system using the patient ID
    public void deleteMedical(String id) {
        medicalRecords.removeIf(medical -> medical.getPatientNo().equals(id));
    }
    
    
    //Updating the details of a Medical Record
    public void updateMedical(MedicalRecord updatedMedical) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medical = medicalRecords.get(i);
            if(medical.getPatientNo().equals(updatedMedical.getPatientNo())) {
                medicalRecords.set(i, updatedMedical);
            }
        }
    }
    
    
    
}
