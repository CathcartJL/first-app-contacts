package com.example.contact;

public class ContactApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // For loop, iterate through args array
        for (int i = 0; i <args.length; i++) {
            System.out.println("For loop: Arg " + (i + 1) + " is " + args[i]);
        }

        System.out.println("\n");

        //While loop, iterate through args array
        int counter = 0;
        while (counter < args.length) {
            System.out.println("While loop: Arg " + (counter + 1) + " is " + args[counter]);
            counter++;
        }

        //Improved for loop
        for (String arg : args) {
            System.out.println("Improved for loop: " + arg);
        }
    }


}
