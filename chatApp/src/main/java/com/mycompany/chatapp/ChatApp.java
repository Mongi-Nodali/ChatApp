/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 * 
 * @author mongi
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//JSON file imports
import java.io.FileWriter;    //Allows writing to files
import java.io.IOException;   //Handles file errors
import java.nio.file.Files;   //Reads files
import java.nio.file.Paths;   //Gets file path
import org.json.JSONArray;    //Store lists of messages in JSON format
import org.json.JSONObject;   //Stores string message in JSON format

public class ChatApp {
  
    //static so all methods can use the variables 
static String Username;
static String Password;
static String cell;
static String firstName;
static String lastName;
//Part2 variables
static int messageLimit= 0;
static int messageCount = 0;
static String message;
static String recipientsCell;
static String hash;
static String disregard;
static int choice2;
static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        
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
           }else{
               login();
               break;
           }
        }else if (choice == 3) {
            System.out.println("GOODBYE!!");
            break;
        }else{
            System.out.println("INVALID INPUT");
        }
    }
     //Part 2 choice system
     System.out.println("\nWelcome to QuickChat");
     
     System.out.println("How many messages do you want to send?: ");
     messageLimit = input.nextInt();
     input.nextLine();
     
     
    System.out.println("\n Cellnumber should start with (+27)");
    while(true) {
        System.out.println("Enter recipients cellphone number: ");
        recipientsCell = input.nextLine();
        input.nextLine();
        
       // REGEX Pattern
        String regex = "^\\+27[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(recipientsCell);
        
        if (matcher.matches()) {
            System.out.println("Cell number added successfully");
            break;
            
        } else {
            System.out.println("Cellphone number incorrectly formatted. Must start with +27 followed by 9 digits");
        }
        
    }
     while(true) {
         System.out.println("-------QUICKCHAT MENU-------");
         System.out.println("1. Send messages");
      System.out.println("2. Show recently sent messages");
      System.out.println("3. Quit");
      System.out.print(" Choose option:");
      
      choice2 = input.nextInt();
      input.nextLine();
      
      if (choice2 == 1){
          messages();
          
      }else if (choice2 == 2){
          System.out.println("Coming Soon");
          } else if (choice2 == 3) {
              System.out.println("Total messages sent: " + messageCount);
              System.out.println("GOODBYE!!");
              break;
          }else {
              System.out.println("INVALID OPTION");
          }
      
     }
     }
    

      public static void register() {
         // Scanner input = new Scanner(System.in);
      System.out.println("\n --------REGISTRATION---------");
      
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
            System.out.println("Password succefully captured");
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
      
        System.out.println("\nRegistration successful");
      }  
           //String loginUsername;
          // String loginPassword;
           
            public static void login() {
           System.out.println("\n---------LOGIN----------");
           
           while(true) {
           System.out.print("Enter username: ");
          String loginUsername = input.nextLine();
           
           
           System.out.print("Enter password: ");
          String loginPassword = input.nextLine(); 
           
           if (loginUsername.equals(Username) && loginPassword.equals(Password)) {
             System.out.println("Welcome back " + firstName + " " + lastName + " " + "It's great to see you again");
            break;
           } else {
               System.out.println("Wrong username or password entered");
           }
       }
           System.out.println("\nLogin successful");
        }
          public static void messages() throws Exception{
              System.out.println("\n------MESSAGES------");
              
             if(messageCount >= messageLimit) {
                 System.out.println("You have reached your message limit of " + messageLimit + " messages");
                  return;
              }
              
              for (int i = messageCount; i < messageLimit; i++){
                  
                  System.out.println("\nEnter your message (MAX 250 characters): ");
                  message = input.nextLine();
                  input.nextLine(); 
              
              if (message.length() <= 250) {
                  
                  //options
                  System.out.println("\nChoose whether to:");
                  System.out.println("1. Send the Message");
                  System.out.println("2.Disregard Message(Delete message)");
                  System.out.println("3. Store Message or send later");
                  System.out.println("Enter choice: ");
                  
                  int messageChoice = input.nextInt();
                  input.nextLine();
                  
                  if(messageChoice == 1){
                      
                  //messageID
                  //source for the messageID: https://www.baeldung.com/java-generate-random-long-float-integer-double
                  //used long because int is too small and can't store a 10 digit number
                  long messageId = 1000000000L + (long)(Math.random() * 9000000000L);
                
                  //Get the first 2 digits of the message ID
                  //source for using substrings: https://www.geeksforgeeks.org/java/substring-in-java/?utm_source=chatgpt.com
                  String firstTwo = String.valueOf(messageId).substring(0,2);
                  
                  //get first and last words from a message
                  //sources used for getting first and last word:https://stackoverflow.com/questions/4672806/java-simplest-way-to-get-last-word-in-a-string
                  // and:https://codebun.com/write-a-java-program-to-find-the-first-and-last-word-in-the-sentence/
                  String[] words = message.split(" ");
                  String firstWord = words[0];
                  String lastWord = words[words.length - 1];
                  
                  //firstTwo:messageCount:fistwordlastWord
                  //also coverts to uppercase
                   hash = (firstTwo + ":" + messageCount + ":" + firstWord + lastWord).toUpperCase();
                  
                  //Display message details
                  System.out.println("------------MESSSAGE SENT---------");
                  System.out.println("Message ID: " + messageId);
                  System.out.println("Message Hash: " + hash);
                  System.out.println("Recipient: " + recipientsCell);
                  System.out.println("Message: " + message);
                  System.out.println("Message was successfully sent");
                  
                  messageCount++;
                  storeMessageToJSON(messageId, hash, recipientsCell, message, messageCount);

              
                  
                  if (messageCount == messageLimit){
                      System.out.println("Message sent (" + messageCount  + "/" + messageLimit + ")");
                      System.out.println("\nAll " + messageLimit + " messages have been sent!");
                     // System.out.println("Total messages sent: " + messageCount );
                     break; 
                  } else {
                      System.out.println("Message sent (" + messageCount  + "/" + messageLimit + ")");
                      
                  }
                  //Ask if user wants to continue or return to menu
                  if (messageCount < messageLimit) {
                  System.out.println("\nSend another message? (1 for yes, 0 to return to menu): ");
                  int continueChoice = input.nextInt();
                  input.nextLine();
                  
                  if (continueChoice == 0) {
                      break; // exit loop, return to the menu
                  }
                  }
                  
                  
                  }else if (messageChoice == 2) {
                      System.out.println("Press 0 to delete the message");
                      disregard = input.nextLine();
                      System.out.println("Message is deleted");
                    
                    i--;
                      
                  } else if (messageChoice == 3) {
                      long storedId = System.currentTimeMillis();
                      storeMessageToJSON(storedId, hash, recipientsCell, message, messageCount + 1);
                      
                      System.out.println("Message successfully stored");
                  
                   i--;
                  } else {
                      System.out.println("INVALID OPTION");
                  }
                  
              } else {
                  System.out.println("Please enter a message of less than 250 characters");
                  
                  i--;
              }
                  
              }
          }
          //sources used for JSON file: https://blogs.oracle.com/javamagazine/java-json-serialization-jackson/
          //https://www.baeldung.com/gson-save-file
            public static void storeMessageToJSON (long messageId,String hash, String recipient, String message, int count) throws Exception {
                 JSONArray messageArray = new JSONArray();
                      
                      //reads existing messages if file already exists
                      try {
                          String existingContent = new String(Files.readAllBytes(Paths.get("messages.txt")));
                          messageArray = new JSONArray(existingContent);
                      }catch (IOException e) {
                          // if file doesn't exist it will create a new one
                      }
                      //Create JSON object for the new file
                      JSONObject messageObj = new JSONObject();
                      messageObj.put("messageID",messageId);
                      messageObj.put("Message Hash",hash);
                      messageObj.put("Recipient",recipient);
                      messageObj.put("content", message);
                      messageObj.put("messageNumber", count);
                      
                      //Add to array
                      messageArray.put(messageObj);
                      
                      //saves to file
                      try (FileWriter file =new FileWriter("messages.txt")) {
                          file.write(messageArray.toString(4));
                          System.out.println("Message saved to JSON text file");
                      }catch (IOException e) {
                          System.out.println("ERROR: " + e.getMessage());
                
                      
                      
                     
                      }
}
}

