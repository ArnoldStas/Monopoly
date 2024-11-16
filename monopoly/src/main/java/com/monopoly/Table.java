package com.monopoly;

import java.util.LinkedList;

public class Table {
    public static class monopolyTable
{
    public Integer id;
    public String title;
    public String type;
    public String color;
    public String owner;
    public Integer price;
    public Integer rent;
    public Integer fine;
    public Integer skip;
    public Integer win;
    public String info;

    public monopolyTable(int id, String title, String type, String color, String owner, int price, int rent, int fine, int skip, int win, String info) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.color = color;
        this.owner = owner;
        this.price = price;
        this.rent = rent;
        this.fine = fine;
        this.skip = skip;
        this.win = win;
        this.info = info;
    }

    public String toString() {
        return String.format(
            "Block: {%d, %s, %s, %s, %s, %d, %d, %d, %d, %d, - '%s'}",
            id, title, type, color, owner, price, rent, fine, skip, win, info
        );
    }

    public Integer getid()
    {
        return id;
    }

    public String gettitle()
    {
        return title;
    }

    public String gettype()
    {
        return type;
    }

    public String getcolor()
    {
        return color;
    }

    public String getowner()
    {
        return owner;
    }

    public Integer getprice()
    {
        return price;
    }

    public Integer getrent()
    {
        return rent;
    }

    public Integer getfine()
    {
        return fine;
    }

    public Integer getskip()
    {
        return skip;
    }

    public Integer getwin()
    {
        return win;
    }

    public String getinfo()
    {
        return info;
    }
  }
    public static int getNextMonopolyBlock(LinkedList<monopolyTable> MNPN, int currentIndex) {
    if (MNPN.isEmpty()) {
        return currentIndex;
    }

    monopolyTable currentBlock = MNPN.get(currentIndex);
    System.out.println(currentBlock.toString());
    return (currentIndex + 1) % MNPN.size();
  }
}
