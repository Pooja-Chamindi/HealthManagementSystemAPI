/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */
public class Billing {
     private Patient patient;
    private String billNo;
    private double totalPaid;
    private double balance;

    //Constructor        
    public Billing() {
        
    }

    public Billing(Patient patient, String billNo, double totalPaid, double balance) {
        this.patient = patient;
        this.billNo = billNo;
        this.totalPaid = totalPaid;
        this.balance = balance;
    }
    

    //Getters and Setters       
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
