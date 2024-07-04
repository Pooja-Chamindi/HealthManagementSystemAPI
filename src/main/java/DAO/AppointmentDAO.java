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
import Entities.Appointment;
import Entities.Doctor;
import Entities.Patient;

public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();
    
    static {
        Doctor doc1 = new Doctor("D000", "Amila Perera", 0711112223, "120/1, Temple Road, Piliyandala","Neurologist");
        Doctor doc2 = new Doctor("D001", "Kasun Weerasinghe", 0733312313, "138/B, Kottawa Road, Maharagama","Physician");
        Doctor doc3 = new Doctor("D002", "Ravindu Artigala", 0733312313,"203/1, Beach Road, Kaluthara","Orthopedist" );
        
        Patient pat1 = new Patient("P000", "Malithma Gunasekara", 0711234567, "156, Pagoda Road, Nugegoda");
        Patient pat2 = new Patient("P001", "Yomal Silva", 0711234567, "122/1, School Lane, Panadura");
        Patient pat3 = new Patient("P002", "Sanuvi Senanayake", 0711234567, "122/1, Church Avenue, Pannipitiya");
        
        
        appointments.add(new Appointment("A001", "02-04-24", "16:30", doc1, pat1));        
        appointments.add(new Appointment("A002", "05-05-24", "10:00", doc2, pat2));
        appointments.add(new Appointment("A003", "12-05-24", "14:30", doc3, pat3));
        
           }
    
    //Getting the information of one specific appointment using its ID
    public Appointment getAppointmentById(String id) {
        for(Appointment appointment : appointments) {
            if(appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }
    
    
    //Getting the information of all the appointments of a specific doctor using Doctor ID    
    public List<Appointment> getDoctorsAppointments(String doctorId) {
        List<Appointment> newAppointments = new ArrayList<>();
        for(Appointment appointment : appointments) {
            if(appointment.getDoctor().getId().equals(doctorId)) {
                newAppointments.add(appointment);
            }
        }
        return newAppointments;
    }
    

    //Getting the information of all the appointments of a specific patient using Patient ID    
    public List<Appointment> getPatientsAppointments(String patientId) {
        List<Appointment> newAppointments = new ArrayList<>();
        for(Appointment appointment : appointments) {
            if(appointment.getPatient().getId().equals(patientId)) {
                newAppointments.add(appointment);
            }
        }
        return newAppointments;
    }
    
    
    
    //Getting the information an appointment of a specific doctor on a specific day on a specific time
    public Appointment getDoctorsTimeAppointment(String doctorId, String date, String time) {
        for(Appointment appointment : appointments) {
            if(appointment.getDoctor().getId().equals(doctorId)) {
                if(appointment.getDate().equals(date)) {
                    if(appointment.getTime().equals(time)) {
                        return appointment;
                    }
                }
            }
        }
        return null;
    }
    

    //Adding a new Appointment to the system
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    
    
    //Cancelling an Appointment using its ID
    public void cancelAppointment(String appointmentId) {
        appointments.removeIf(appoinment -> appoinment.getAppointmentId().equals(appointmentId));
    }
    
    
    //Updating the details of an Appointment using its ID
    public void updateAppointment(Appointment updatedAppointment) {
        for(int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if(appointment.getAppointmentId().equals(updatedAppointment.getAppointmentId())) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }
    
    
    
}
