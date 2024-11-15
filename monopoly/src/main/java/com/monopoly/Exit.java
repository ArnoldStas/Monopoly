package com.monopoly;

public class Exit {
    public static void exitGame()
    {
        System.out.print("\033\143");
        Logo.logoPrint();
        System.out.println();

        System.out.println(Color.CYAN + "| EXIT |" + Color.RESET);

        System.out.println();
        System.out.println(Color.YELLOW + "The game was - " + Color.RED + "STOPPED" + Color.YELLOW + "!" + Color.RESET);

        System.exit(0);
    }
}
