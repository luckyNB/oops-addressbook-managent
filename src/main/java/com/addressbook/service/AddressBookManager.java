package com.addressbook.service;

import com.addressbook.model.Person;
import com.addressbook.util.Utility;
import com.google.gson.stream.MalformedJsonException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AddressBookManager implements Manager {
    Utility utility;
    {
        try {
            utility = new Utility();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addPerson(Person person, String path) {

        try {
            utility.writingPersonDetailsIntoJsonFile(person
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean editPerson(Person person, String mobileNo) throws FileNotFoundException {

        List<Person> personList=utility.readAllPersonsAddressList();
        for (Person editingPerson:personList){
            if (editingPerson.getPhoneNumber().equals(mobileNo)){
                editingPerson.setAddress(person.getAddress());
                editingPerson.setFirstName(person.getFirstName());
                editingPerson.setLastName(person.getLastName());
                editingPerson.setPhoneNumber(person.getPhoneNumber());
                personList.add(editingPerson);
                utility.writingPersonDetailsIntoJsonFile(personList);
                break;
            }
        }


        return false;
    }


}
