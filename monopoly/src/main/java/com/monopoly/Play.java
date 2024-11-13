package com.monopoly;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.monopoly.Player.actorPlay;
import com.monopoly.Table.monopolyTable;

public class Play {
    public void playTime(Scanner scanner, Settings settings, Queue<actorPlay> playerQueue, LinkedList<monopolyTable> MNPN) 
    {
        System.out.print("\033\143");
        Logo.logoPrint();

        /*System.out.println(MNPN.get(1).getowner());
        monopolyTable block = MNPN.get(1);
        block.owner = "Augustas";
        System.out.println(MNPN.get(1).getowner());*/

        playerTurn(playerQueue, MNPN);
        dice(scanner, settings);

        playerTurn(playerQueue, MNPN);
        dice(scanner, settings);

    }

    public void playerTurn(Queue<actorPlay> playerQueue, LinkedList<monopolyTable> MNPN)
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

    }

    public void dice(Scanner scanner, Settings settings)
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

        //System.out.println(Color.RED + "Rolling the dice..." + Color.RESET);
        //sleep();

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

        } else {

            Integer diceRoll = null;

            System.out.println(Color.RED + "Rolling the dice..." + Color.RESET);
            sleep();
            diceRoll = (int)(Math.random() * 6) + 1;

            System.out.println();
            System.out.println(Color.YELLOW + "Dice: " + Color.RESET + diceRoll);

        }

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
