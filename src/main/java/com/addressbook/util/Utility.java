package com.addressbook.util;

import com.addressbook.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer getIntegerValue(String message) {
        return (Integer.parseInt(scanner.nextLine()));
    }

    public static String getStringValue(String message) {
        return scanner.nextLine();
    }
    public static boolean writingStateCensusDataIntoJsonFile(Person person, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
