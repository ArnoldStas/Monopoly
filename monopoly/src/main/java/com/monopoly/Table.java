package com.monopoly;

public class Table {
    public static class monopolyTable
{
    private Integer id;
    private String title;
    private String type;
    private String color;
    private String owner;
    private Integer price;
    private Integer rent;
    private Integer fine;
    private Integer skip;
    private Integer win;
    private String info;

    public String toString() {
        return "Block: {id = " + id + ", title = " + title + ", type = " + type + ", color = " + color + ", owner = " + owner + ", price = " + price + ", rent = " + rent + ", fine = " + fine + ", skip = " + skip + ", win = " + win + ", info = " + info + "}";
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
}
