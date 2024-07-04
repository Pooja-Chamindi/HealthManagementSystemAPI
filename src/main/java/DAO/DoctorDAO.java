/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Pooja Malagala 
 */
import java.util.ArrayList;
import java.util.List;
import Entities.Doctor;

public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();
    
    static {
        doctors.add(new Doctor("D000", "Amila Perera", 0711112223, "120/1, Temple Road, Piliyandala", "Cardiology"));
        doctors.add(new Doctor("D001", "Kasun Weerasinghe", 0733312313, "138/B, Kottawa Road, Maharagama","Dermatology"));
        doctors.add(new Doctor("D002", "Ravindu Artigala", 0733312313, "203/1, Beach Road, Kaluthara","Orthopedist"));
    }
    
    //Geting the information of all the doctors in the sysetm
    public List<Doctor> getAllDoctors() {
        return doctors;
    }
    
    
    //Geting the information of one specific doctor using their ID
    public Doctor getDoctorById(String id) {
        for (Doctor doctor: doctors) {
            if (doctor.getId().equalsIgnoreCase(id)) {
                return doctor;
            }
        }
        return null;
    }
    
    
    //Adding a new doctor to the system
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    
    //Deleting one specific doctor from the system using their ID
    public void deleteDoctorById(String id) {
        doctors.removeIf(doctor -> doctor.getId().equalsIgnoreCase(id));
    }
    
    
    //Replacing a doctor's outdated details with new details using their ID
    public void updateDoctor(Doctor updatedDoctor) {
        for(int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if(doctor.getId().equalsIgnoreCase(updatedDoctor.getId())) {
                doctors.set(i, updatedDoctor);
                return;
            }
        }
    }
    
    
}
