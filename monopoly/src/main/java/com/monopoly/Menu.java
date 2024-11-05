package com.monopoly;

import java.util.Scanner;

public class Menu {
    public static int menu(Scanner scanner)
    {

        Integer Choose = 0;

        do
        {
            System.out.print("\033\143");

            Logo.logoPrint();

            System.out.println();
            System.out.println(Color.GREEN + "                                | Menu |" + Color.RESET);
            System.out.println();
            System.out.println("                               1. Play");
            System.out.println("                               2. Settings");
            System.out.println("                               3. Exit");

            System.out.print(Color.RED + "Choice: " + Color.RESET);
            if (scanner.hasNextInt()) {
                Choose = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }
            System.out.println();

        } while(Choose < 1 || Choose > 3);

        return Choose;
    }
}
