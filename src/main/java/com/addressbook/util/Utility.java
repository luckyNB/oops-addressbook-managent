package com.addressbook.util;

import com.addressbook.exception.AddressBookException;
import com.addressbook.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static final String resourcePath = "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/";
    public static final String FilePath = "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json";
    static Pattern pattern = null;
    List<Person> personList = new ArrayList<>();
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader(FilePath));
    //convert the json string back to object
    Person[] personDetails = gson.fromJson(br, Person[].class);

    public Utility() throws FileNotFoundException {
    }


    public static void readingAddressBook(String filePath) {
        try {
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Person[] peoples = gson.fromJson(bufferedReader, Person[].class);
            for (int i = 0; i < peoples.length; i++) {
                System.out.println(peoples[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> getDummyRecord() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Laxman", "Bhosale", "70304960255", "Hingoli", "431513", "MH"));
        personList.add(new Person("Krishna", "Bhosale", "7046660255", "Nanded", "432513", "GJ"));
        personList.add(new Person("Yogesh", "Mane", "46613260255", "Satara", "43153413", "KA"));
        return personList;
    }

    public static boolean writingAddressBookRecord(String fileName, List<Person> personList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //  personList.add(persons);
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(json);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public  boolean validatePersonInfoDetails(Person person) throws AddressBookException {
        int patternFlag=0;
        pattern = pattern.compile("[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$");
        Matcher matcher = pattern.matcher(person.getFirstName());
        if (!matcher.matches()) {
           patternFlag=1;
           throw  new AddressBookException("Person validation error");
        }
        pattern = pattern.compile("[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$");
         matcher = pattern.matcher(person.getLastName());
        if (!matcher.matches()) {
            patternFlag=1;
            throw  new AddressBookException("Person validation error");
        }
        pattern = pattern.compile("^[0-9]{10}");
         matcher = pattern.matcher(person.getPhoneNumber());
        if (!matcher.matches()) {
            patternFlag=1;
            throw  new AddressBookException("Person validation error");
        }
        pattern = pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
        matcher = pattern.matcher(person.getCity());
        if (!matcher.matches()) {
            patternFlag=1;
            throw  new AddressBookException("Person validation error");
        }
        pattern = pattern.compile("[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$");
        matcher = pattern.matcher(person.getState());
        if (!matcher.matches()) {
            patternFlag=1;
            throw  new AddressBookException("Person validation error");
        }
        pattern = pattern.compile("^[1-9]{6}");
        matcher = pattern.matcher(person.getZip());
        if (!matcher.matches()) {
            patternFlag=1;
            throw  new AddressBookException("Person validation error");
        }

        return true;

    }

    public boolean writingPersonDetailsIntoJsonFile(Person person) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        readList();
        personList.add(person);
        //  personList.add(persons);
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FilePath);
            fileWriter.write(json);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean writingPersonDetailsIntoJsonFile(List<Person> personList) throws AddressBookException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FilePath);
            fileWriter.write(json);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw new AddressBookException("Problem occured while writing into file");
        }
    }

    public boolean readList() {

        for (int index = 0; index < personDetails.length; index++) {
            personList.add(personDetails[index]);
            System.out.println(personDetails[index]);
        }
        return true;
    }

    public List<Person> readAllPersonsAddressList() {

        for (int index = 0; index < personDetails.length; index++) {
            personList.add(personDetails[index]);
            System.out.println(personDetails[index]);
        }
        return personList;
    }

}
