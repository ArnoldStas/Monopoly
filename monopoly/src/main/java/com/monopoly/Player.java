package com.monopoly;

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

  static void getPlayers(Scanner scanner, Queue<actorPlay> playerQueue)
    {

        System.out.print("1-st Player name: ");
        String Player1 = scanner.next();
        //System.out.println();

        System.out.print("2-nd Player name: ");
        String Player2 = scanner.next();
        //System.out.println();

        System.out.print("3-th Player name: ");
        String Player3 = scanner.next();
        //System.out.println();

        System.out.print("4-th Player name: ");
        String Player4 = scanner.next();
        //System.out.println();

        actorPlay Actor1 = new actorPlay(Player1);
        actorPlay Actor2 = new actorPlay(Player2);
        actorPlay Actor3 = new actorPlay(Player3);
        actorPlay Actor4 = new actorPlay(Player4);

        playerQueue.add(Actor1);
        playerQueue.add(Actor2);
        playerQueue.add(Actor3);
        playerQueue.add(Actor4);
    }
}
