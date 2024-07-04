/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */
public class Prescription {
    private String prescriptionId;
    private Patient patient;
    private String medication;
    private int dosage;
    private String instructions;
    private int duration;

    //Constructor       
    public Prescription() {
        
    }
    
    public Prescription(String prescriptionId, Patient patient, String medication, int dosage, String instructions, int duration) {
        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }
    

    //Getters and Setters        
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatientNo(Patient patient) {
        this.patient = patient;
    }
    
    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
}
