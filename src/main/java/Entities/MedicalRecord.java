/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */
public class MedicalRecord {
    private String patientNo;
    private String healthStatus;
    private String MedicalHistory;

    //Constructors       
    public MedicalRecord() {
        
    }
    
    public MedicalRecord(String patientNo, String healthStatus) {
        this.patientNo = patientNo;
        this.healthStatus = healthStatus;
    }

    public MedicalRecord(String patientNo, String healthStatus, String MedicalHistory) {
        this.patientNo = patientNo;
        this.healthStatus = healthStatus;
        this.MedicalHistory = MedicalHistory;
    }
    

    //Getters and Setters       
    public String getPatientNo() {
        return patientNo;
    }
    
    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }
    
    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getMedicalRecordHistory() {
        return MedicalHistory;
    }

    public void setMedicalHistory(String MedicalHistory) {
        this.MedicalHistory = MedicalHistory;
    }
    
    
}
