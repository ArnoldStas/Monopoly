package com.monopoly;

import java.util.LinkedList;
import java.util.Scanner;
import com.monopoly.Table.monopolyTable;

public class EditTable {
    public void currentTable(Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        int choice = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| Current Table |" + Color.RESET);
            System.out.println();
        
            for (int i = 0; i < MNPN.size(); i++) {
                System.out.print(Color.YELLOW + i + Color.PURPLE + " ");
                currentIndex = Table.getNextMonopolyBlock(MNPN, currentIndex);
                System.out.print(Color.RESET);
            }

            System.out.println();

            System.out.println(Color.BLUE + "1. Create a box" + Color.RESET);
            System.out.println(Color.BLUE + "2. Delete a box" + Color.RESET);
            System.out.println(Color.YELLOW + "3. Back" + Color.RESET);

            System.out.println();
            System.out.print(Color.RED + "Choice: " + Color.RESET);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(choice < 1 || choice > 3);

        if (choice == 1) {
            createBox(MNPN, scanner);
        }
        else if (choice == 2) {

        }
        else {
            Main.Menu(scanner);
        }

    }

    public void createBox(LinkedList<monopolyTable> MNPN, Scanner scanner)
    {

        Integer newBoxId = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX |" + Color.YELLOW + " - Create a box" + Color.RESET);
            System.out.println();

            System.out.print(Color.RED + "Position {Interval - " + Color.YELLOW + "[0, " + MNPN.size() + "]" + Color.RED + "} (ID): " + Color.RESET);

            if (scanner.hasNextInt()) {
                newBoxId = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while (newBoxId <= 0 || newBoxId >= MNPN.size() + 1);

        parametersBox(newBoxId, scanner);

    }

    public void parametersBox(int newBoxId, Scanner scanner)
    {

        Integer id = newBoxId;
        String title = null;
        String type = null;
        String color = null;
        String owner = null;
        Integer price = 0;
        Integer rent = 0;
        Integer fine = 0;
        Integer skip = 0;
        Integer win = 0;
        String info = null;

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner);

    }

    public void addParameters(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner)
    {

        int choice = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - Create a box" + Color.RESET);
            System.out.println();

            System.out.println(Color.YELLOW + "{Box ID: " + id + "}" + Color.RESET);
            System.out.println("1. Box TITLE: " + title);
            System.out.println("2. Box TYPE: " + type);
            System.out.println("3. Box COLOR: " + color);
            System.out.println("4. Box OWNER: " + owner);
            System.out.println("5. Box PRICE: " + price);
            System.out.println("6. Box RENT: " + rent);
            System.out.println("7. Box FINE: " + fine);
            System.out.println("8. Box SKIP: " + skip);
            System.out.println("9. Box WIN: " + win);
            System.out.println("10. Box INFO: " + info);
            System.out.println("11. DONE");

            System.out.println();
            System.out.print(Color.RED + "Choice: " + Color.RESET);

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(choice < 1 || choice > 11);

        if (choice == 1) {
            TITLE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner);
        }

        if (choice == 2) {
            TYPE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner);
        }


    }

    private static String getStr(Scanner scanner)
    {

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String str;
        str = scanner.nextLine().trim();
        return str;
    }

    public void TITLE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - TITLE" + Color.RESET);
        System.out.println();

        System.out.print("TITLE: ");

        title = getStr(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner);
    }

    public void TYPE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - TYPE" + Color.RESET);
        System.out.println();

        System.out.print("TYPE: ");

        type = getStr(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner);
    }
}
