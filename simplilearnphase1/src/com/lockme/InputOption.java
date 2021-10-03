package com.lockme;
import java.util.List;
import java.util.Scanner;
public class InputOption {
	public static void manageWelcomeScreenInput() {
		boolean isrunning = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				DisplayOption.displayMenu();
				int inp= sc.nextInt();

				switch (inp) {
				case 1:
					FileOperations.displayAllFiles("main");
					break;
				case 2:
					InputOption.manageFileMenuOptions();
					break;
				case 3:
					System.out.println("Program terminated successfully.");
					isrunning = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please choose avalid option. ");
				}
			} catch (Exception h) {
				System.out.println(h.getClass().getName());
				manageWelcomeScreenInput();
			} 
		} while (isrunning == true);
	}
	
	public static void manageFileMenuOptions() {
		boolean isrunning = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				DisplayOption.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("main");
				
				int inp= sc.nextInt();
				switch (inp) {
				case 1:
					// adding file
					System.out.println("Enter the name of the file you want to add to the \"main\" folder");
					String fileToBeAdded = sc.next();
					
					FileOperations.createFile(fileToBeAdded, sc);
					
					break;
				case 2:
					// delete folder
					System.out.println("Enter the name of the file youn want to delete from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					List<String> filesToBeDeleted = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nChoose  index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int toi = sc.nextInt();
					
					if (toi != 0) {
						FileOperations.deleteFileRecursively(filesToBeDeleted.get(toi - 1));
					} else {
						
						// If toi == 0, delete all files displayed for the name
						for (String path : filesToBeDeleted) {
							FileOperations.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File folder search
					System.out.println("Enter the name of the file you want to  search from \"main\" folder");
					String fileName = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					FileOperations.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program terminated successfully.");
					isrunning = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option .");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				manageFileMenuOptions();
			}
		} while (isrunning == true);
	}
}
