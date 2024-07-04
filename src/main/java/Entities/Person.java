/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Pooja Malagala
 */
public class Person {
    private String id;
    private String name;
    private int contactNo;
    private String address;
    
    //Constructors
    public Person() {
        
    }
    
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String id, String name, int contactNo) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
    }

    public Person(String id, String name, int contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }
    
    
    //Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
