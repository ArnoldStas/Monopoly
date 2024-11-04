package com.monopoly;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

class Item {
    private int id;
    private String title;
    private String color;

    public String toString() {
        return "Item{id=" + id + ", title='" + title + "', color='" + color + "'}";
    }
}

public class Test {
    public static void main(String[] args) {

        /*Gson gson = new Gson();
        Item testas = new Item();
        try (FileReader reader = new FileReader("test/src/main/test.json")) {
            testas = gson.fromJson(reader, Item.class);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(testas.toString());*/
        
        System.out.println("ėęčėčė");

        Gson gson = new Gson();
        Item testas = new Item();

        try (FileReader reader = new FileReader("monopoly/src/json/test.json")) {
            // Define the type for List<Person>
            Type personListType = new TypeToken<List<Item>>() {}.getType();
        
            // Parse the JSON array into a List of Person objects
            List<Item> testukas = gson.fromJson(reader, personListType);
        
            // Iterate over the list and print each person's details
            for (Item test : testukas) {
                System.out.println(test.toString());
            }
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }
    }
}
