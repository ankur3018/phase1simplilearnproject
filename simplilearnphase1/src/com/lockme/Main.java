package com.lockme;

public class Main {

	public static void main(String[] args) {
		FileOperations.createMainFolderIfNotPresent("main");
		DisplayOption.printWelcome();
		InputOption.manageWelcomeScreenInput();
	}

}
