package com.addressbook.service;

import com.addressbook.exception.AddressBookException;
import com.addressbook.model.Person;
import com.addressbook.util.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
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
        utility.writingPersonDetailsIntoJsonFile(person);
        return true;
    }

    @Override
    public boolean editPerson(Person person, String mobileNo) throws AddressBookException {
        int flag = 0;
        List<Person> personList = utility.readAllPersonsAddressList();
        for (Person editingPerson : personList) {
            if (editingPerson.getPhoneNumber().equals(mobileNo)) {
                editingPerson.setFirstName(person.getFirstName());
                editingPerson.setLastName(person.getLastName());
                editingPerson.setPhoneNumber(person.getPhoneNumber());
                editingPerson.setCity(person.getCity());
                editingPerson.setZip(person.getZip());
                personList.add(editingPerson);
                utility.writingPersonDetailsIntoJsonFile(personList);
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean deletePerson(String mobileNumber) throws AddressBookException {
        int deletedFlag = 0;
        try {
            List<Person> personList = utility.readAllPersonsAddressList();
            for (Person person : personList) {
                if (person.getPhoneNumber().equals(mobileNumber)) {
                    personList.remove(person);
                    utility.writingPersonDetailsIntoJsonFile(personList);
                    deletedFlag = 1;
                    break;
                }
            }
        } catch (AddressBookException e) {
            e.printStackTrace();
            throw new AddressBookException("Problem occured while removing person from list");
        }
        if (deletedFlag == 1)
            return true;
        return false;
    }

    @Override
    public boolean sortingAddressBook(String fieldName) throws AddressBookException {
        List<Person> personList = utility.readAllPersonsAddressList();
        int sortedFlag = 0;
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                try {
                    Field stateCensusField = Person.class.getDeclaredField(fieldName);
                    stateCensusField.setAccessible(true);
                    Comparable stateCensusFieldValue1 = (Comparable) stateCensusField.get(o1);
                    Comparable stateCensusFieldValue2 = (Comparable) stateCensusField.get(o2);
                    return stateCensusFieldValue1.compareTo(stateCensusFieldValue2);
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                    // when proper field is not entered sorting or any exception occurs
                    return 0;
                }
            }
        });
        utility.writingPersonDetailsIntoJsonFile(personList);
        return true;
    }

    @Override
    public boolean printingAddressBook() {
        List<Person> personList = utility.readAllPersonsAddressList();
        personList.forEach(System.out::println);
        return true;
    }

    @Override
    public boolean createEmptyFile(String fileName) throws AddressBookException {
        try {
            File file = new File(Utility.resourcePath + fileName + ".json");
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new AddressBookException("Problem occured while creating file");
        }

    }

    @Override
    public boolean openingExistingFile(String fileName) {
        File file = new File(Utility.resourcePath + fileName);

        if (file.exists()) {
            Utility.readingAddressBook(Utility.resourcePath + fileName);
            return true;
        }
        return false;
    }
}
