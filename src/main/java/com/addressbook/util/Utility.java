package com.addressbook.util;

import com.addressbook.model.Person;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer getIntegerValue(String message) {
        return (Integer.parseInt(scanner.nextLine()));
    }

    public static String getStringValue(String message) {
        return scanner.nextLine();
    }

    public static boolean writingPersonDetailsIntoJsonFile(Person person, String filePath) {
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

    public static JsonNode readingJsonFile() throws IOException {

//read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json"));

//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

//read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode idNode = rootNode.path("firstName");
        System.out.println("Person Details = " + rootNode);

        JsonNode phoneNosNode = rootNode.path("firstName");
        Iterator<JsonNode> elements = phoneNosNode.elements();
        while (elements.hasNext()) {
            JsonNode phone = elements.next();
        }
        return rootNode;
    }

}
