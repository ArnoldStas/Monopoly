package com.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.monopoly.Table.monopolyTable;

public class Player {
    public static class actorPlay 
{
    public Integer Money;
    public Integer countStreets;
    public List<String> Streets;
    public Integer skipMove;
    public Integer boxId;
    public String name;

    actorPlay(String name) {
        Money = 1500;
        countStreets = 0;
        Streets = new ArrayList<>();
        skipMove = 0;
        boxId = 0;
        this.name = name;
    }

    public Integer getMoney()
    {
        return Money;
    }

    public Integer getcountStreets()
    {
        return countStreets;
    }

    public String[] getStreets()
    {
        return Streets.toArray(new String[0]);
    }

    public Integer getskipMove()
    {
        return skipMove;
    }

    public Integer getboxId()
    {
        return boxId;
    }

    public String getname()
    {
        return name;
    }
  }

    static void getPlayers(Scanner scanner, Settings settings, LinkedList<monopolyTable> MNPN)
    {
        Queue<actorPlay> playerQueue = new LinkedList<>();
        System.out.print("\033\143");
        Logo.logoPrint();

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        System.out.println();
        System.out.println(Color.CYAN + "| Create name |" + Color.RESET);
        System.out.println();

        if (settings.playerCount == 2) {
            String Player1 = getPlayerName(scanner, "1-st Player name: ");
            String Player2 = getPlayerName(scanner, "2-nd Player name: ");

            if (Player1.equals(Player2)) {

                do
                {

                    if (Player1.equals(Player2)) {
                        System.out.println(Color.RED + "The name '" + Player1 + "' already exists!" + Color.RESET);
                    }
                    Player2 = getPlayerName(scanner, "2-nd Player name: ");

                } while(Player1.equals(Player2));

            }

            actorPlay Actor1 = new actorPlay(Player1);
            actorPlay Actor2 = new actorPlay(Player2);

            playerQueue.add(Actor1);
            playerQueue.add(Actor2);
        }
        else {
            String Player1 = getPlayerName(scanner, "1-st Player name: ");
            String Player2 = getPlayerName(scanner, "2-nd Player name: ");

            if (Player1.equals(Player2)) {

                do
                {

                    if (Player1.equals(Player2)) {
                        System.out.println(Color.RED + "The name '" + Player1 + "' already exists!" + Color.RESET);
                    }
                    Player2 = getPlayerName(scanner, "2-nd Player name: ");

                } while(Player1.equals(Player2));

            }

            String Player3 = getPlayerName(scanner, "3-th Player name: ");

            if (Player3.equals(Player2) || Player3.equals(Player1)) {

                do
                {

                    if (Player3.equals(Player2)) {
                        System.out.println(Color.RED + "The name '" + Player2 + "' already exists!" + Color.RESET);
                    }
                    if (Player3.equals(Player1)) {
                        System.out.println(Color.RED + "The name '" + Player1 + "' already exists!" + Color.RESET);
                    }
                    Player3 = getPlayerName(scanner, "3-th Player name: ");

                } while(Player3.equals(Player2) || Player3.equals(Player1));

            }

            actorPlay Actor1 = new actorPlay(Player1);
            actorPlay Actor2 = new actorPlay(Player2);
            actorPlay Actor3 = new actorPlay(Player3);

            playerQueue.add(Actor1);
            playerQueue.add(Actor2);
            playerQueue.add(Actor3);
        }

        displayPlayers(playerQueue, settings, scanner, MNPN);
    }

    private static String getPlayerName(Scanner scanner, String message)
    {
        String name;
        System.out.print(Color.BLUE + message + Color.RESET);
        name = scanner.nextLine().trim();
        return name;
    }

    static void displayPlayers(Queue<actorPlay> playerQueue, Settings settings, Scanner scanner, LinkedList<monopolyTable> MNPN) 
    {

        char symbol;

        do
        {
            System.out.print("\033\143");
            Logo.logoPrint();

            Integer playerCount = settings.playerCount;
            Boolean playerCountEqual3 = false;
            if (playerCount == 3) playerCountEqual3 = true;

            System.out.println(Color.CYAN + "| Players in game |" + Color.RESET);
            System.out.println();

            for (actorPlay player : playerQueue) {
                if (playerCountEqual3) {
                    if (playerCount == 3) {
                        System.out.print(Color.RED + "1'st player name: " + Color.RESET);
                        playerCount--;
                    }
                    else if (playerCount == 2) {
                        System.out.print(Color.RED + "2'nd player name: " + Color.RESET);
                        playerCount--;
                    }
                    else {
                        System.out.print(Color.RED + "3'th player name: " + Color.RESET);
                        playerCount--;
                    }
                }
                else {
                    if (playerCount == 2) {
                        System.out.print(Color.RED + "1'st player name: " + Color.RESET);
                        playerCount--;
                    }
                    else {
                        System.out.print(Color.RED + "2'nd player name: " + Color.RESET);
                        playerCount--;
                    }
                }
                System.out.println(player.getname());

                System.out.print(Color.GREEN + "Money: " + Color.RESET);
                System.out.println(player.getMoney());

                System.out.print(Color.GREEN + "Count of own streets: " + Color.RESET);
                System.out.println(player.getcountStreets());

                System.out.print(Color.GREEN + "The streets: " + Color.RESET);
                System.out.println("null");

                System.out.print(Color.GREEN + "In jail? (skip moves): " + Color.RESET);
                System.out.println(player.getskipMove());

                System.out.print(Color.GREEN + "Current box ID: " + Color.RESET);
                System.out.println(player.getboxId());

                System.out.println();

            }

                System.out.print(Color.YELLOW + "Do you want to continue? (Y/N): " + Color.RESET);
                String input = scanner.next();
                symbol = input.charAt(0);

        } while (symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

        if (symbol == 'Y' || symbol == 'y') {
            Play game = new Play();
            game.playTime(scanner, settings, playerQueue, MNPN);
        }
        else
        {
            Main.Menu(scanner);
        }

    }
    
}
