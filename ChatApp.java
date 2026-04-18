/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 * 
 * @author mongi
 */
import java.util.Scanner;
public class ChatApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
       
        

//Login system lets the user choose an option
     
     boolean registered = false;
     int choice;
     while (true) {
      System.out.println("--------LOGIN SYSTEM--------");
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Exit");
      System.out.print(" Choose option:");
      
       choice = input.nextInt();
      input.nextLine();
      
      
       if (choice == 1) { //if they pick 1 take to the registration
           register();
           registered = true;
       }else if (choice == 2) {
           if(!registered) {
           System.out.println("You cannot login without first registering");
        }else if (choice == 3) {
            System.out.println("GOODBYE!!");
            break;
        }else{
            System.out.println("INVALID INPUT");
        }
    }
     }
    
    }
      public static void register() {
          Scanner input = new Scanner(System.in);
      System.out.println("\n --------REGISTRATION---------");
      
      String Username;
      String Password;
      String cell;
      String firstName;
      String lastName;
      
      
   
     System.out.print("Enter first name: ");
      firstName = input.nextLine();
           
        System.out.print("Enter last name: ");
        lastName = input.nextLine();

        //input Username
        //Use a while loop so the user can reenter the details until true
        System.out.println("\n Username should be less than 5 characters and contain and underscore(_)");
        while (true) {
        System.out.print("Enter username: ");
        Username = input.nextLine();
    
        // Check if the username has an underscore and has 5 characters or less
        if (Username.length() <= 5 && Username.contains("_")) {
            System.out.println("Username successfully captured");
            break;
        }else{
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        } 
        }
        
         //input Pasword 
         System.out.println("\n Password contain at least 8 characters, contain a capital letter, a digit and a special character");
         
        while (true) {
        System.out.print("Enter password:");
        Password = input.nextLine();
        
        boolean capitalLetter = false;
        boolean digit = false;
        boolean specialCharacter = false;
        
         //Check if password meets the requirements
        //use a for loop then an if statement 
        for(int i = 0; i < Password.length(); i++) {
            char ch = Password.charAt(i); //Checks each character one by one
        
        if (Character.isUpperCase(ch)) {
            capitalLetter = true;
        }else if(Character.isDigit(ch)){
            digit = true;
        }else if (!Character.isLetterOrDigit(ch)){
            specialCharacter = true;
        }
        }
        
        if(Password.length() >= 8 && capitalLetter && digit && specialCharacter) {
            System.out.println("Password succefully captured:");
            break;
             } else {
            System.out.println("Password is not correcctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
        }
        }
        // }
        //Enter cellphone number
      System.out.println("\n Cellnumber should start with (+27) and contain 9 digits after");
        while(true) {
       System.out.print("Enter cellphone number: ");
       cell = input.nextLine();
       
       
       boolean digits = true;
       
       for(int i = 3; i < cell.length(); i++) {
            char ch = cell.charAt(i);
           
           if(!Character.isDigit(ch)){
           digits = false;
           break;
           }
       }
           if (cell.length() == 12 && digits && cell.startsWith("+27")) {
               System.out.println("Cell number added succesfully");
               break;
           } else {
               System.out.println("Cellphone number incorrectly formatted or does not contain international code");
           }
        }

        System.out.println("Registration successful");
           
           String loginUsername;
           String loginPassword;
           
           System.out.println("\n---------LOGIN----------");
           
           while(true) {
           System.out.print("Enter username: ");
           loginUsername = input.nextLine();
           
           
           System.out.print("Enter password: ");
           loginPassword = input.nextLine();
           
           if (loginUsername.equals(Username) && loginPassword.equals(Password)) {
             System.out.println("Welcome back " + firstName + " " + lastName + " " + "It's great to see you again");
            break;
           } else {
               System.out.println("Wrong username or password entered");
           }
       }
        }
}

           
         

          
    


    



       
       
    
        
    

