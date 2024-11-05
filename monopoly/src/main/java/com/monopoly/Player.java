package com.monopoly;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Player {
    public static class actorPlay 
{
    private Integer Money;
    private Integer countStreets;
    private String Streets[];
    private Integer skipMove;
    private Integer boxId;
    public String name;

    actorPlay(String name) {
        Money = 1500;
        countStreets = 0;
        Streets = new String[0];
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
        return Streets;
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

    static void getPlayers(Scanner scanner)
    {
        Queue<actorPlay> playerQueue = new LinkedList<>();
        System.out.print("\033\143");
        Logo.logoPrint();

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String Player1 = getPlayerName(scanner, "1-st Player name: ");
        String Player2 = getPlayerName(scanner, "2-nd Player name: ");
        String Player3 = getPlayerName(scanner, "3-th Player name: ");

        actorPlay Actor1 = new actorPlay(Player1);
        actorPlay Actor2 = new actorPlay(Player2);
        actorPlay Actor3 = new actorPlay(Player3);

        playerQueue.add(Actor1);
        playerQueue.add(Actor2);
        playerQueue.add(Actor3);

        System.out.println();
        System.out.println("Players in queue:");
        for (actorPlay player : playerQueue) {
            System.out.println(player.getname());
        }
        System.out.println();
        System.out.print("Peek: ");
        displayPlayers(playerQueue);
    }

    private static String getPlayerName(Scanner scanner, String message)
    {
        String name;
        System.out.print(Color.BLUE + message + Color.RESET);
        name = scanner.nextLine().trim();
        return name;
    }

    static void displayPlayers(Queue<actorPlay> playerQueue) 
    {
        
        /*String tempName = null;
        String peekName = null;
    
        do 
        {
            actorPlay playerTemp = playerQueue.poll();
            actorPlay playerPeek = playerQueue.peek();
            
            if (playerTemp != null) {
                tempName = playerTemp.getname();
                System.out.println(tempName);
                playerQueue.add(playerTemp);
            }

            peekName = playerPeek.getname();
            
        } while (peekName != null && !tempName.equals(peekName));*/

        Queue<actorPlay> playerQueueTemp = new LinkedList<>();

        String playerPeekName = null;
        String playerTempName = null;

        actorPlay playerPeek = playerQueue.peek();
        playerPeekName = playerPeek.getname();

        actorPlay playerTemp = playerQueue.poll();
        playerTempName = playerTemp.getname();
        System.out.println(playerTemp.getname());
        playerQueueTemp.add(playerTemp);
        playerQueue.add(playerTemp);

        do
        {

            playerTemp = playerQueue.poll();
            playerTempName = playerTemp.getname();
            System.out.println(playerTemp.getname());
            playerQueueTemp.add(playerTemp);
            playerQueue.add(playerTemp);

        } while(!playerTempName.equals(playerPeekName));

    }
    
}
