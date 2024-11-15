package com.monopoly;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.monopoly.Table.monopolyTable;

public class Json {
    public static void readJson(LinkedList<monopolyTable> MNPN)
    {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("monopoly\\src\\json\\Monopolis_laukeliai.json")) {
            Type MonopolyListType = new TypeToken<List<monopolyTable>>() {}.getType();
        
            List<monopolyTable> MNP = gson.fromJson(reader, MonopolyListType);

            MNPN.clear();
            MNPN.addAll(MNP);

        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }
    } 
}
