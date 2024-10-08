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
        String userInput = scanner.nextLine();
        return ( userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("YES"));

    }

    public static short PromptForShort(String prompt){
        System.out.print(prompt);
        short userInput = scanner.nextShort();
        scanner.nextLine(); //takes the data from the cursor up to the CRLF then return the data and throws away the CRLF
        return  userInput;
    }

    public static byte PromptForByte(String prompt){
        System.out.print(prompt);
        byte userInput =scanner.nextByte();
        return userInput;
    }



}