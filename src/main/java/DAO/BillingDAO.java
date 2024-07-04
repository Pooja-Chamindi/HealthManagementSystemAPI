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
import Entities.Billing;
import Entities.Patient;

public class BillingDAO {
    private static List<Billing> bills = new ArrayList<>();
    
    static {
        Patient pat1 = new Patient("P000", "Malithma Gunasekara", 0711234567, "156, Pagoda Road, Nugegoda");
        Patient pat2 = new Patient("P001", "Yomal Silva", 0711234567, "122/1, School Lane, Panadura");
        Patient pat3 = new Patient("P002", "Sanuvi Senanayake", 0711234567, "122/1, Church Avenue, Pannipitiy");
        
        
        bills.add(new Billing(pat1, "B001", 8000, 2500));        
        bills.add(new Billing(pat2, "B002", 7500, 1000));
        bills.add(new Billing(pat3, "B003", 10500, 2000));
        
    }
    
    //Getting all the information of the Bills in the System
    public List<Billing> getAllBills() {
        return bills;
    }
    

    //Getting one specific Bill using the Bill number
    public Billing getBillByBillNo(String billNo) {
        for(Billing bill : bills) {
            if(bill.getBillNo().equals(billNo)) {
                return bill;
            }
        }
        return null;
    }
    
    
    //Getting all the Bills of the patient using their ID
    public List<Billing> getBillsByPatient(String patientId) {
        List <Billing> patientsBills = new ArrayList<>();
        for(Billing bill : bills) {
            if(bill.getPatient().getId().equals(patientId)) {
                patientsBills.add(bill);
            }
        }
        return patientsBills;
    }
    
    
    //Adding a new Billing to the system
    public void addBilling(Billing bill) {
        bills.add(bill);
    }
    
    
    //Deleting a Bill from the system
    public void deleteBillling(String billNo) {
        bills.removeIf(bill -> bill.getBillNo().equals(billNo));
    }
    
    
    //Updating a Bill in the system
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < bills.size(); i++) {
            Billing bill = bills.get(i);
            if(bill.getBillNo().equals(updatedBilling.getBillNo())) {
                bills.set(i, updatedBilling);
            }
        }
    }
    
    
    
}
