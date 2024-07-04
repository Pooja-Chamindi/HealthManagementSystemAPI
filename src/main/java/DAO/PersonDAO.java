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
import Entities.Person;

public class PersonDAO {
    private static List<Person> people = new ArrayList<>();
    
    static {
        people.add(new Person("000", "Gimhani Karunarathne", 0711234567, "124/1, Kahathuduwa Road, Bandaragama"));
        people.add(new Person("001", "Tharindu Hewage", 0711234567, "130, Kandawaththa Road, Horana"));
        people.add(new Person("002", "Amandi Hettiarachchi", 0711112223, "320/80, Main Road, Narahenpita"));
        people.add(new Person("003", "Sahan Liyanage", 0733312313, "322/3, Colombo Road, Raththanapitiya"));
        
    }
    
    //Geting the information of all the people include Doctors and Patients
    public List<Person> getAllPeople() {
        return people;
    }
    
    
    //Geting the information of one person using their ID
    public Person getPersonById(String id) {
        for (Person person: people) {
            if (person.getId().equalsIgnoreCase(id)) {
                return person;
            }
        }
        return null;
    }
    
    
    //Adding a new person to the system
    public void addPerson(Person person) {
        people.add(person);
    }
    
    
    //Deleting one specific person from the system using their ID
    public void deletePersonById(String id) {
        people.removeIf(person -> person.getId().equalsIgnoreCase(id));
    }
    
    
    //Replacing a person's details with new details using their ID
    public void updatePerson(Person updatedPerson) {
        for(int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if(person.getId().equalsIgnoreCase(updatedPerson.getId())) {
                people.set(i, updatedPerson);
                return;
            }
        }
    }
    
    
    
    
}
