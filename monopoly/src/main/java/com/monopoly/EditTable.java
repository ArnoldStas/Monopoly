package com.monopoly;

import java.util.LinkedList;
import java.util.Scanner;
import com.monopoly.Table.monopolyTable;

public class EditTable {
    public void currentTable(Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| Current Table |" + Color.RESET);
        System.out.println();

        //System.out.println(MNPN.getFirst());
        
        for (int i = 0; i < MNPN.size(); i++) {
            System.out.print(Color.YELLOW + i + Color.BLUE + " ");
            currentIndex = Table.getNextMonopolyBlock(MNPN, currentIndex);
            System.out.println(Color.RESET);
        }
    }
}
