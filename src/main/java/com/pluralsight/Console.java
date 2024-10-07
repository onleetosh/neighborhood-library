package com.pluralsight;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static String PromptForString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    //overload PromptForString method to accept single character input
    public static String PromptForString(){
        return scanner.nextLine().trim();
    }

    public static boolean PromptForYesNo(String prompt){
        System.out.print(prompt + " ( Y for Yes, N for No ) ?");
        String userinput = scanner.nextLine();

        return
                (
                        userinput.equalsIgnoreCase("Y")
                                ||
                                userinput.equalsIgnoreCase("YES")
                );

    }

    public static short PromptForShort(String prompt){
        System.out.print(prompt);
        short userinput = scanner.nextShort();
        scanner.nextLine();
        return  userinput;
    }

    public static byte PromptForByte(String prompt){
        System.out.print(prompt);
        byte userinput =scanner.nextByte();
        return userinput;
    }
}