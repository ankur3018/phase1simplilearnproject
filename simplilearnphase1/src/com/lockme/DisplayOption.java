package com.lockme;

import java.util.Scanner;

public class DisplayOption {
	public static String name = null;
	static Scanner scnn = new Scanner(System.in);
     public static void printWelcome() {
    	 
		  System.out.println("Hey there, What's your name?");
    	  name = scnn.nextLine();
    	 System.out.println("           Welcome," + name +" to LockMe.com. \n"
    	 		          + "               Developed by Ankur Kumar          "
    	 		          + "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");
     }
     public static void displayMenu() {
    	 String menu = "\n\nSelect a valid  option  from below and then press Enter \n\n"
    	 + "1) Retrieve all the  files inside \"main\" folder\n" + "2) Display menu for File operations\n"
    	 + "3) Exit program\n";
    	 System.out.println(menu);
    	 }
     public static void displayFileMenuOptions() {
    	 String fileMenu = "\n\nSelect a valid option  from below and press Enter\n\n"
    	 + "1) Add a file to the\"main\" folder\n" 
    	 + "2) Delete a file from the\"main\" folder\n"
    	 + "3) Search for a file from the\"main\" folder\n" 
    	 + "4) Go to Previous Menu\n" 
    	 + "5) Exit program\n";
    	 System.out.println(fileMenu);
    	 }
}
