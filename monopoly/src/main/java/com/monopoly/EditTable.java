package com.monopoly;

import java.util.ArrayList;
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
            createBox(MNPN, scanner, currentIndex);
        }
        else if (choice == 2) {
            deleteBox(MNPN, scanner, currentIndex);
        }
        else {
            Main.Menu(scanner);
        }

    }

    public void createBox(LinkedList<monopolyTable> MNPN, Scanner scanner, int currentIndex)
    {

        Integer newBoxId = null;

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
                if (newBoxId < 0 || newBoxId > MNPN.size()) {
                    newBoxId = null;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println();

        } while (newBoxId == null);

        parametersBox(newBoxId, scanner, MNPN, currentIndex);

    }
    
    public void deleteBox(LinkedList<monopolyTable> MNPN, Scanner scanner, int currentIndex)
    {
        int choice = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| Delete a box |" + Color.RESET);
            System.out.println();

            System.out.println(Color.BLUE + "1. By position {ID}" + Color.RESET);
            System.out.println(Color.BLUE + "2. By title" + Color.RESET);
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
            deleteByID(MNPN, scanner, currentIndex);
        }
        else if (choice == 2) {
            deleteByTitle(MNPN, scanner, currentIndex);
        }
        else {
            currentTable(scanner, MNPN, currentIndex);
        }
    }

    public void deleteByID(LinkedList<monopolyTable> MNPN, Scanner scanner, int currentIndex)
    {
        Integer deleteBoxId = null;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| Delete BOX |" + Color.YELLOW + " - By position {ID}" + Color.RESET);
            System.out.println();

            int size = MNPN.size() - 1;

            System.out.print(Color.RED + "Position {Interval - " + Color.YELLOW + "[0, " + size + "]" + Color.RED + "} (ID): " + Color.RESET);

            if (scanner.hasNextInt()) {
                deleteBoxId = scanner.nextInt();
                if (deleteBoxId < 0 || deleteBoxId > size) {
                    deleteBoxId = null;
                }
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while (deleteBoxId == null);

        System.out.println(Color.RED + "DELETE - " + Color.YELLOW + deleteBoxId + " " + Color.PURPLE + MNPN.get(deleteBoxId) + Color.RESET);

        char symbol;

        do
        {

            System.out.print(Color.YELLOW + "Do you want to proceed? (Y/N): " + Color.RESET);
        
            String input = scanner.next();
            symbol = input.charAt(0);

            System.out.print("\033[F\033[2K"); //To delete row

        } while(symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

        if (symbol == 'Y' || symbol == 'y') {
            System.out.println(Color.GREEN + "The action was confirmed - " + Color.RED + "DELETE" + Color.RESET);
            Play.sleep();
            MNPN.remove((int) deleteBoxId);

            for (int i = 0; i < MNPN.size(); i++) {
                MNPN.get(i).id = i;
            }

            currentTable(scanner, MNPN, currentIndex);

        } else {
            deleteBox(MNPN, scanner, currentIndex);
        }
    }

    public void deleteByTitle(LinkedList<monopolyTable> MNPN, Scanner scanner, int currentIndex)
    {
        String title = null;
        boolean titleFound = false;
        ArrayList<Integer> indicatesToDelete = new ArrayList<>();

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| Delete BOX |" + Color.YELLOW + " - By title" + Color.RESET);
            System.out.println();

            System.out.print(Color.RED + "TITLE: " + Color.RESET);

            if (title == null) {
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            title = getStr(scanner);

            for (int i = 0; i < MNPN.size(); i++) {
                if (MNPN.get(i).gettitle().equalsIgnoreCase(title)) {
                    titleFound = true;
                    indicatesToDelete.add(i);
                }
            }

            if (!titleFound && title != null) {
                System.out.println(Color.RED + "The box with title {" + Color.PURPLE + title + Color.RED + "} was not found!" + Color.RESET);
                Play.sleep();
                System.out.print("\033[F\033[2K"); //To delete row
            }

        } while (!titleFound);

        System.out.println();

        if (indicatesToDelete.size() > 1) {

            System.out.println(Color.YELLOW + "There are more than one block:" + Color.RESET);
            for (int i = 0; i < indicatesToDelete.size(); i++) {
                System.out.println(Color.YELLOW + indicatesToDelete.get(i) + " " + Color.PURPLE + MNPN.get(indicatesToDelete.get(i)) + Color.RESET);
            }

            System.out.println();
            
            Boolean validID = false;
            int index = -1;
            
            do
            {

                System.out.print(Color.RED + "Which block to delete {ID}: " + Color.RESET);
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt();
                    for (int i = 0; i < indicatesToDelete.size(); i++) {
                        if (index == indicatesToDelete.get(i)) {
                            validID = true;
                            break;
                        }
                    }
                } else {
                    scanner.nextLine();
                }
                System.out.print("\033[F\033[2K"); //To delete row

            } while (!validID);

            System.out.println(Color.RED + "DELETE - " + Color.YELLOW + indicatesToDelete.get(index) + " " + Color.PURPLE + MNPN.get(indicatesToDelete.get(0)) + Color.RESET);

            char symbol;

            do
            {

                System.out.print(Color.YELLOW + "Do you want to proceed? (Y/N): " + Color.RESET);
        
                String input = scanner.next();
                symbol = input.charAt(0);

                System.out.print("\033[F\033[2K"); //To delete row

            } while(symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

            if (symbol == 'Y' || symbol == 'y') {
                System.out.println(Color.GREEN + "The action was confirmed - " + Color.RED + "DELETE" + Color.RESET);
                Play.sleep();
                MNPN.remove((int) indicatesToDelete.get(index));

                for (int i = 0; i < MNPN.size(); i++) {
                    MNPN.get(i).id = i;
                }

                currentTable(scanner, MNPN, currentIndex);
            } else {
                deleteBox(MNPN, scanner, currentIndex);
            }

        } else {

            System.out.println(Color.RED + "DELETE - " + Color.YELLOW + indicatesToDelete.get(0) + " " + Color.PURPLE + MNPN.get(indicatesToDelete.get(0)) + Color.RESET);

            char symbol;

            do
            {

                System.out.print(Color.YELLOW + "Do you want to proceed? (Y/N): " + Color.RESET);
        
                String input = scanner.next();
                symbol = input.charAt(0);

                System.out.print("\033[F\033[2K"); //To delete row

            } while(symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

            if (symbol == 'Y' || symbol == 'y') {
                System.out.println(Color.GREEN + "The action was confirmed - " + Color.RED + "DELETE" + Color.RESET);
                Play.sleep();
                MNPN.remove((int) indicatesToDelete.get(0));

                for (int i = 0; i < MNPN.size(); i++) {
                    MNPN.get(i).id = i;
                }

                currentTable(scanner, MNPN, currentIndex);
            } else {
                deleteBox(MNPN, scanner, currentIndex);
            }
        }
    }

    public void parametersBox(int newBoxId, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
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

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);

    }

    public void addParameters(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
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
            System.out.println(Color.BLUE + "1. Box TITLE: " + title + Color.RESET);
            System.out.println(Color.BLUE + "2. Box TYPE: " + type + Color.RESET);
            System.out.println(Color.BLUE + "3. Box COLOR: " + color + Color.RESET);
            System.out.println(Color.BLUE + "4. Box OWNER: " + owner + Color.RESET);
            System.out.println(Color.BLUE + "5. Box PRICE: " + price + Color.RESET);
            System.out.println(Color.BLUE + "6. Box RENT: " + rent + Color.RESET);
            System.out.println(Color.BLUE + "7. Box FINE: " + fine + Color.RESET);
            System.out.println(Color.BLUE + "8. Box SKIP: " + skip + Color.RESET);
            System.out.println(Color.BLUE + "9. Box WIN: " + win + Color.RESET);
            System.out.println(Color.BLUE + "10. Box INFO: " + info + Color.RESET);
            System.out.println(Color.YELLOW + "11. DONE" + Color.RESET);

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
            TITLE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 2) {
            TYPE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 3) {
            COLOR(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 4) {
            OWNER(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 5) {
            PRICE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 6) {
            RENT(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 7) {
            FINE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 8) {
            SKIP(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 9) {
            WIN(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 10) {
            INFO(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
        }

        if (choice == 11) {
            if (type == null) {
                System.out.println(Color.YELLOW + "To be done, you must set {" + Color.RED + "TYPE" + Color.YELLOW + "} option!" + Color.RESET);
                Play.sleep();
                addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
            } else {
                DONE(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
            }
        }
    }

    private static String getStr(Scanner scanner)
    {

        String str;
        str = scanner.nextLine().trim();
        return str;

    }

    private static String getStrInt(Scanner scanner)
    {

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String str;
        str = scanner.nextLine().trim();
        return str;

    }

    public void TITLE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - TITLE" + Color.RESET);
        System.out.println();

        System.out.print(Color.RED + "TITLE: " + Color.RESET);

        title = getStrInt(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void TYPE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - TYPE" + Color.RESET);
            System.out.println();
            System.out.println(Color.GREEN + "Available: " + Color.YELLOW + "{Street, Lottery, Prison, Fine, Start} - " + Color.RED + "Case sensitive!" + Color.RESET);
            System.out.print(Color.RED + "TYPE: " + Color.RESET);

            type = getStr(scanner);

        } while(!type.equals("Street") && !type.equals("Lottery") && !type.equals("Prison") && !type.equals("Fine") && !type.equals("Start"));

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void COLOR(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - COLOR" + Color.RESET);
        System.out.println();
        System.out.println(Color.GREEN + "Available: " + Color.YELLOW + "{Green, Orange, Red, Blue, Yellow}" + Color.RESET);
        System.out.print(Color.RED + "COLOR: " + Color.RESET);

        color = getStrInt(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void OWNER(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - OWNER" + Color.RESET);
        System.out.println();
        System.out.print(Color.RED + "OWNER: " + Color.RESET);

        owner = getStrInt(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void PRICE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        boolean validInput = false; 

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - PRICE" + Color.RESET);
            System.out.println();
            System.out.print(Color.RED + "PRICE: " + Color.RESET);

            if (scanner.hasNextInt()) {
                price = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (!validInput);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void RENT(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        boolean validInput = false; 

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - RENT" + Color.RESET);
            System.out.println();
            System.out.print(Color.RED + "RENT: " + Color.RESET);

            if (scanner.hasNextInt()) {
                rent = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (!validInput);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void FINE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        boolean validInput = false; 

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - FINE" + Color.RESET);
            System.out.println();
            System.out.print(Color.RED + "FINE: " + Color.RESET);

            if (scanner.hasNextInt()) {
                fine = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (!validInput);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void SKIP(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        boolean validInput = false; 

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - SKIP" + Color.RESET);
            System.out.println();
            System.out.print(Color.RED + "SKIP: " + Color.RESET);

            if (scanner.hasNextInt()) {
                skip = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (!validInput);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void WIN(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {

        boolean validInput = false; 

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - WIN" + Color.RESET);
            System.out.println();
            System.out.print(Color.RED + "WIN: " + Color.RESET);

            if (scanner.hasNextInt()) {
                win = scanner.nextInt();
                validInput = true;
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (!validInput);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void INFO(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN + "| BOX PARAMETERS |" + Color.YELLOW + " - INFO" + Color.RESET);
        System.out.println();

        System.out.print(Color.RED + "ADDITIONAL INFO: " + Color.RESET);

        info = getStrInt(scanner);

        addParameters(id, title, type, color, owner, price, rent, fine, skip, win, info, scanner, MNPN, currentIndex);
    }

    public void DONE(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info, Scanner scanner, LinkedList<monopolyTable> MNPN, int currentIndex)
    {
        monopolyTable newBox = new monopolyTable (
            id,
            title,
            type,
            color,
            owner,
            price,
            rent,
            fine,
            skip,
            win,
            info
        );
        MNPN.add(id, newBox);

        for (int i = 0; i < MNPN.size(); i++) {
            if (i == id){
                for (int j = i + 1; j < MNPN.size(); j++)
                {
                    MNPN.get(j).id = MNPN.get(j).id + 1;
                }
            }
        }
        
        currentTable(scanner, MNPN, currentIndex);
    }
}
