/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */

import Entities.Doctor;
import Entities.Patient; 

public class Appointment {
    private String appointmentId;
    private String date;    
    private String time;
    private Doctor doctor;
    private Patient patient;

    //Constructor
    public Appointment() {
        
    }

    public Appointment(String appointmentId, String date, String time, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }
    

    //Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(String appointId) {
        this.appointmentId = appointId;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatientNo(Patient patient) {
        this.patient = patient;
    }
    
    
}
