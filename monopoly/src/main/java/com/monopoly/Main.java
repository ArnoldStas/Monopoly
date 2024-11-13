package com.monopoly;
import java.util.*;

import com.monopoly.Table.monopolyTable;

public class Main {
    public static LinkedList<monopolyTable> MNPN = new LinkedList<>();
    public static Settings parametrai = new Settings();
    public static EditTable lenta = new EditTable();
    public static int currentIndex = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Json.readJson(MNPN);
        Menu(scanner);
        
        scanner.close();
    }

    public static void Menu(Scanner scanner)
    {
        Integer Choose = Menu.menu(scanner);

        if (Choose == 1)
        {
            Player.getPlayers(scanner, parametrai, MNPN);
        }
        else if (Choose == 2)
        {
            parametrai.currentSettings(scanner);
        }
        else if (Choose == 3)
        {
            lenta.currentTable(scanner, MNPN, currentIndex);
        }
        else
        {
            return;
        }
    }
}
