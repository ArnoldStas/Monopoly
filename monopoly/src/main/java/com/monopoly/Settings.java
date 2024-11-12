package com.monopoly;

import java.util.Scanner;

public class Settings {
    public Integer playerCount;
    public Integer diceCount;
    public Integer moneyToWin;
    public Boolean changeSettings;

    public Boolean changedPlayerCount;
    public Boolean changedDiceCount;
    public Boolean changedAmountOfMoney;

    private Integer defaultPlayerCount;
    private Integer defaultDiceCount;
    private Integer defaultMoneyToWin;

    //Konstruktorius
    Settings() {
        playerCount = 3;
        diceCount = 1;
        moneyToWin = 1500;
        changeSettings = false;
        changedPlayerCount = false;
        changedDiceCount = false;
        changedAmountOfMoney= false;

        saveDefaults();
    }

    //Kopijavimo konstruktorius
    Settings(Settings other) {
        this.playerCount = other.playerCount;
        this.diceCount = other.diceCount;
        this.moneyToWin = other.moneyToWin;
        this.changeSettings = other.changeSettings;
        this.changedPlayerCount = other.changedPlayerCount;
        this.changedDiceCount = other.changedDiceCount;
        this.changedAmountOfMoney = other.changedAmountOfMoney;

        this.defaultPlayerCount = other.defaultPlayerCount;
        this.defaultDiceCount = other.defaultDiceCount;
        this.defaultMoneyToWin = other.defaultMoneyToWin;
    }

    public void saveDefaults() {
        defaultPlayerCount = playerCount;
        defaultDiceCount = diceCount;
        defaultMoneyToWin = moneyToWin;
    }

    public void restoreDefaults(Scanner scanner) {
        playerCount = defaultPlayerCount;
        diceCount = defaultDiceCount;
        moneyToWin = defaultMoneyToWin;

        changedPlayerCount = false;
        changedDiceCount = false;
        changedAmountOfMoney = false;

        currentSettings(scanner);
    }

    public void currentSettings(Scanner scanner)
    {

        char symbol;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();
 
            System.out.println();
            System.out.println(Color.CYAN + "| Current settings |" + Color.RESET);
            System.out.println();

            if (changedPlayerCount == false || playerCount == 3) {
                System.out.println(Color.RED + "(Default)" + Color.BLUE + " Max player count: " + Color.RESET + playerCount);
            }
            else
            {
                System.out.println(Color.GREEN + "(Changed)" + Color.BLUE + " Max player count: " + Color.RESET + playerCount);
            }
            
            if (changedDiceCount == false || diceCount == 1) {
                System.out.println(Color.RED + "(Default)" + Color.BLUE + " Dice count: " + Color.RESET + diceCount);
            }
            else
            {
                System.out.println(Color.GREEN + "(Changed)" + Color.BLUE + " Dice count: " + Color.RESET + diceCount);
            }
            
            if (changedAmountOfMoney == false || moneyToWin == 1500) {
                System.out.println(Color.RED + "(Default)" + Color.BLUE + " Amount of money to win: " + Color.RESET + moneyToWin);
            }
            else
            {
                System.out.println(Color.GREEN + "(Changed)" + Color.BLUE + " Amount of money to win: " + Color.RESET + moneyToWin);
            }

            System.out.println();
            System.out.print(Color.YELLOW + "Do you want to change the settings? (Y/N): " + Color.RESET);

            String input = scanner.next();
            symbol = input.charAt(0);

        } while (symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

        if (symbol == 'Y' || symbol == 'y') {
            changeCurrentSettings(scanner);
            changeSettings = true;
        }
        else
        {
            Main.Menu(scanner);
        }
    }

    public void changeCurrentSettings(Scanner scanner)
    {
        int choice = 0;

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();
 
            System.out.println();
            System.out.println(Color.CYAN + "| Change settings |" + Color.RESET);
            System.out.println();

            System.out.println(Color.BLUE + "1. Change max player count" + Color.RESET);
            System.out.println(Color.BLUE + "2. Change dice count" + Color.RESET);
            System.out.println(Color.BLUE + "3. Change amount of money to win the game" + Color.RESET);
            System.out.println(Color.BLUE + "4. Restore default settings" + Color.RESET);
            System.out.println(Color.YELLOW + "5. Back" + Color.RESET);

            System.out.println();
            System.out.print(Color.RED + "Choice: " + Color.RESET);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(choice < 1 || choice > 5);

        if (choice == 1)
        {
            changeMaxPlayerCount(scanner);
        }
        else if (choice == 2)
        {
            changePDiceCount(scanner);
        }
        else if (choice == 3)
        {
            changeAmountOfMoney(scanner);
        }
        else if (choice == 4)
        {
            restoreDefaults(scanner);
        }
        else
        {
            currentSettings(scanner);
        }
    }

    public void changeMaxPlayerCount(Scanner scanner)
    {
        int changePlayerCount = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();
 
            System.out.println();
            System.out.println(Color.CYAN + "| Change settings |" + Color.YELLOW + "- Max player count" + Color.RESET);
            System.out.println();
            System.out.println(Color.BLUE + "Possible changes are 3 or 2, " + Color.GREEN + "|CURRENT| - " + Color.RED + playerCount + Color.RESET);

            System.out.print(Color.RED + "Change to: " + Color.RESET);

            if (scanner.hasNextInt()) {
                changePlayerCount = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(changePlayerCount <= 1 || changePlayerCount >= 4 || changePlayerCount == playerCount);

        playerCount = changePlayerCount;
        changedPlayerCount = true;
        currentSettings(scanner);

    }

    public void changePDiceCount(Scanner scanner)
    {
        int changeDiceCount = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();
 
            System.out.println();
            System.out.println(Color.CYAN + "| Change settings |" + Color.YELLOW + "- Dice count" + Color.RESET);
            System.out.println();
            System.out.println(Color.BLUE + "Possible changes are 1 or 2, " + Color.GREEN + "|CURRENT| - " + Color.RED + diceCount + Color.RESET);

            System.out.print(Color.RED + "Change to: " + Color.RESET);

            if (scanner.hasNextInt()) {
                changeDiceCount = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(changeDiceCount < 1 || changeDiceCount >= 3 || changeDiceCount == diceCount);

        diceCount = changeDiceCount;
        changedDiceCount = true;
        currentSettings(scanner);
    }

    public void changeAmountOfMoney(Scanner scanner)
    {
        int changeMoney = 0;

        do
        {

            System.out.print("\033\143");
            Logo.logoPrint();
 
            System.out.println();
            System.out.println(Color.CYAN + "| Change settings |" + Color.YELLOW + "- Amount of money to win the game" + Color.RESET);
            System.out.println();
            System.out.println(Color.BLUE + "Possible changes are above 1500, " + Color.GREEN + "|CURRENT| - " + Color.RED + moneyToWin + Color.RESET);

            System.out.print(Color.RED + "Change to: " + Color.RESET);

            if (scanner.hasNextInt()) {
                changeMoney = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(changeMoney < 1500 || changeMoney == moneyToWin);

        moneyToWin = changeMoney;
        changedAmountOfMoney = true;
        currentSettings(scanner);
    }
}
