package com.addressbook.util;

import com.addressbook.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static final String FilePath = "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json";
    List<Person> personList = new ArrayList<>();
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader(FilePath));
    //convert the json string back to object
    Person[] personDetails = gson.fromJson(br, Person[].class);

    public Utility() throws FileNotFoundException {
    }


    public boolean writingPersonDetailsIntoJsonFile(Person person) throws FileNotFoundException {
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


    public boolean readList() throws FileNotFoundException {

        for (int index = 0; index < personDetails.length; index++) {
            personList.add(personDetails[index]);
            System.out.println(personDetails[index]);
        }
        return true;
    }

}
