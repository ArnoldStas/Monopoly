package com.monopoly;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

import com.monopoly.Player.actorPlay;
import com.monopoly.Table.monopolyTable;

public class Play {
    public void playTime(Scanner scanner, Settings settings, Queue<actorPlay> playerQueue, LinkedList<monopolyTable> MNPN) 
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        playerTurn(playerQueue, MNPN, scanner, settings);

        

    }

    public void playerTurn(Queue<actorPlay> playerQueue, LinkedList<monopolyTable> MNPN, Scanner scanner, Settings settings)
    {

        System.out.print("\033\143");
        Logo.logoPrint();

        System.out.println();
        System.out.println(Color.CYAN  + "| GAME |" + Color.RESET);
        System.out.println();

        System.out.print(Color.PURPLE + "Player turn: " + Color.RESET);

        String playerName = null;

        actorPlay player = playerQueue.poll();
        playerName = player.getname();
        System.out.print(playerName);
        playerQueue.add(player);

        System.out.println("\n");
        System.out.println(Color.GREEN + playerName + "'s current box ID: " + Color.RESET + player.getboxId());
        System.out.println(Color.YELLOW + "Title: " + Color.RESET + MNPN.get(player.getboxId()).title + Color.RED + " [" + MNPN.get(player.getboxId()).gettype() + "]" + Color.RESET);

        Integer diceNumber = dice(scanner, settings);

        player.boxId = player.boxId + 1;
        player.boxId = player.boxId % MNPN.size();

        System.out.println();
        System.out.println(Color.GREEN + playerName + " moved to box ID: " + Color.RESET + player.getboxId());
        System.out.println(Color.YELLOW + "Title: " + Color.RESET + MNPN.get(player.getboxId()).title + Color.RED + " [" + MNPN.get(player.getboxId()).gettype() + "]" + Color.RESET);

        if (MNPN.get(player.getboxId()).type.equals("Lottery")) {
            Lottery(player, MNPN);
        }

        if (MNPN.get(player.getboxId()).type.equals("Prison")) {
            Jail(player, MNPN);
        }

        if (MNPN.get(player.getboxId()).type.equals("Fine")) {
            FineForParking(player, MNPN);
        }

        if (MNPN.get(player.getboxId()).type.equals("Start")) {
            Beggining(player, MNPN);
        }

        if (MNPN.get(player.getboxId()).type.equals("Street")) {
            Street(player, MNPN, scanner);
        }

    }

    public Integer dice(Scanner scanner, Settings settings)
    {
        System.out.println();

        char symbol;
        do
        {

            System.out.print(Color.YELLOW + "To throw dice - (T): " + Color.RESET);
        
            String input = scanner.next();
            symbol = input.charAt(0);

            System.out.print("\033[F\033[2K"); //To delete row

        } while(symbol != 'T' && symbol != 't');

        System.out.println("\033[F\033[2K");

        if (settings.diceCount == 2) {

            Integer diceRoll_1 = null;
            Integer diceRoll_2 = null;
            Integer diceRoll_12 = null;

            System.out.println(Color.RED + "Rolling the 1'st dice..." + Color.RESET);
            sleep();
            diceRoll_1 = (int)(Math.random() * 6) + 1;
            System.out.println(Color.GREEN + "1'st dice: " + Color.RESET + diceRoll_1);

            System.out.println(Color.RED + "Rolling the 2'nd dice..." + Color.RESET);
            sleep();
            diceRoll_2 = (int)(Math.random() * 6) + 1;
            System.out.println(Color.GREEN + "2'nd dice: " + Color.RESET + diceRoll_2);

            diceRoll_12 = diceRoll_1 + diceRoll_2;

            System.out.println();
            System.out.println(Color.YELLOW + "Dice: " + Color.RESET + diceRoll_12);

            return diceRoll_12;

        } else {

            Integer diceRoll = null;

            System.out.println(Color.RED + "Rolling the dice..." + Color.RESET);
            sleep();
            diceRoll = (int)(Math.random() * 6) + 1;

            System.out.println();
            System.out.println(Color.YELLOW + "Dice: " + Color.RESET + diceRoll);

            return diceRoll;
        }

    }

    public void Lottery(actorPlay player, LinkedList<monopolyTable> MNPN)
    {

        System.out.println();
        System.out.println(Color.YELLOW + "Congratulations! The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "] landed on the lottery box and have won:" + Color.GREEN + " +" + MNPN.get(player.boxId).win + "$" + Color.RESET);

        player.Money = player.Money + MNPN.get(player.boxId).win;
        playerStats(player);

    }

    public void Jail(actorPlay player, LinkedList<monopolyTable> MNPN)
    {

        System.out.println();
        System.out.println(Color.YELLOW + "The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "]  went straight to jail! Moves to skip -" + Color.RESET + " " + Color.RED + MNPN.get(player.boxId).skip + Color.RESET);

        player.skipMove = MNPN.get(player.boxId).skip;
        playerStats(player);

    }

    public void FineForParking(actorPlay player, LinkedList<monopolyTable> MNPN)
    {

        System.out.println();
        System.out.println(Color.YELLOW + "The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "] received a parking fine! Amount to pay:" + Color.RED + " -" + MNPN.get(player.boxId).fine + "$" + Color.RESET);

        player.Money = player.Money - MNPN.get(player.boxId).fine;
        playerStats(player);

    }

    public void Beggining(actorPlay player, LinkedList<monopolyTable> MNPN)
    {

        System.out.println();
        System.out.println(Color.YELLOW + "The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "] landed on the starting box and received:" + Color.GREEN + " +" + MNPN.get(player.boxId).win + "$" + Color.RESET);

        player.Money = player.Money + MNPN.get(player.boxId).win;
        playerStats(player);

    }

    public void Street(actorPlay player, LinkedList<monopolyTable> MNPN, Scanner scanner)
    {

        System.out.println();
        System.out.println(Color.YELLOW + "The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "] landed on the street - " + Color.CYAN + "'" + MNPN.get(player.boxId).title + "'" + Color.RESET);
        System.out.println();

        if (MNPN.get(player.boxId).owner == null) {
            System.out.println(Color.YELLOW + "The street: " + Color.CYAN + MNPN.get(player.boxId).title + Color.YELLOW + " is available in the shop!" + Color.RESET);
            System.out.println(Color.RED + "The price is: " + Color.GREEN + MNPN.get(player.boxId).price + "$" + Color.RESET);
            char symbol;
            do
            {

                System.out.print(Color.YELLOW + "Do you want to buy this? (Y/N): " + Color.RESET);
        
                String input = scanner.next();
                symbol = input.charAt(0);

                System.out.print("\033[F\033[2K"); //To delete row

            } while(symbol != 'Y' && symbol != 'y' && symbol != 'N' && symbol != 'n');

            if (symbol == 'Y' || symbol == 'y') {
                System.out.print("\033[F\033[2K");
                System.out.print("\033[F\033[2K");
                System.out.println(Color.YELLOW + "The player [" + Color.PURPLE + player.getname() + Color.YELLOW + "] succesfully bought one of available streets: " + Color.CYAN + MNPN.get(player.boxId).title + Color.YELLOW + "!" + Color.RED + " [-" + MNPN.get(player.boxId).price + "$]" + Color.RESET);
                player.Money = player.Money - MNPN.get(player.boxId).price;
                player.Streets.add(MNPN.get(player.boxId).title);
                player.countStreets = player.countStreets + 1;
            }

        } else {

        }

        playerStats(player);

    }

    public void playerStats(actorPlay player)
    {

        System.out.println();
        System.out.println(Color.BACKGROUND_RED + player.getname() + "'s STATS" + Color.RESET);
        System.out.println(Color.BLUE + "Current money: " + Color.GREEN + player.Money + "$" + Color.RESET);
        System.out.println(Color.BLUE + "Streets (" + Color.PURPLE + player.countStreets + Color.BLUE + "): " + Color.YELLOW + Arrays.toString(player.getStreets()) + Color.RESET);
        if (player.skipMove > 0) {
            System.out.println(Color.BLUE + "In jail? -" + Color.RED + " YES" + Color.RESET);
            System.out.println(Color.BLUE + "Moves to skip left: " + Color.YELLOW + player.skipMove + Color.RESET);
        } else {
            System.out.println(Color.BLUE + "In jail? -" + Color.GREEN + " NO" + Color.RESET);
        }
        sleep();

    }

    public static void sleep()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
