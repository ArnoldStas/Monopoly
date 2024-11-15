package com.monopoly;

import com.monopoly.Player.actorPlay;

public class Winner {
    public static void playerWin(actorPlay player) {

        System.out.print("\033\143");
        Logo.logoPrint();
        System.out.println();

        System.out.println(Color.CYAN + "| WINNER |" + Color.RESET);
        System.out.println();

        System.out.println(Color.GREEN + "Congratulations!" + Color.YELLOW + " The winner is {" + Color.PURPLE + player.getname() + Color.YELLOW + "}!" + Color.RESET);
    }
}
