package com.monopoly;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import com.monopoly.Player.actorPlay;
import com.monopoly.Table.monopolyTable;

public class Main {
    private static LinkedList<monopolyTable> MNPN = new LinkedList<>();
    private static int currentIndex = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<actorPlay> playerQueue = new LinkedList<>();
        Integer Choose = Menu.menu(scanner);
        dfdf

        if (Choose == 1)
        {
            Player.getPlayers(scanner, playerQueue);
        }

        Gson gson = new Gson();

        //LinkedList<Monopoly> MNPN = null;

        try (FileReader reader = new FileReader("monopoly/src/json/Monopolis_laukeliai.json")) {
            Type MonopolyListType = new TypeToken<List<monopolyTable>>() {}.getType();
        
            List<monopolyTable> MNP = gson.fromJson(reader, MonopolyListType);
        
            MNPN = new LinkedList<>(MNP);

            //System.out.println(MNPN.getFirst());
            
            /*for (Monopoly printmnp : MNP) {
                System.out.println(printmnp.toString());
            }*/

            System.out.println("\nSimulating circular traversal:");
            for (int i = 0; i < 20; i++) {
                monopolyTable block = getNextMonopolyBlock();
                System.out.println(block.getinfo());
            }

        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Players in queue:");
        for (actorPlay player : playerQueue) {
            System.out.println(player.getname());
        }

        scanner.close();
    }

    // Get the next Monopoly block, with circular behavior
    static monopolyTable getNextMonopolyBlock() 
    {
        if (MNPN.isEmpty()) {
            return null; // Return null if list is empty
        }
        
        // Get the current block
        monopolyTable currentBlock = MNPN.get(currentIndex);

        // Move to the next index
        currentIndex = (currentIndex + 1) % MNPN.size(); // Wrap around to the start if at the end
        
        return currentBlock;
    }
}
