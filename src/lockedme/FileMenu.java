package lockedme;

import java.io.File;
import java.util.Scanner;

public class FileMenu {
	private static Scanner INPUT = new Scanner(System.in);
	private static String PATH = "D:/practice"; 
	public static void main(String[] args) {
		try {
		int choice;
		do {
			System.out.println();
			System.out.println("###################################################");
			System.out.println("\t\tCOMPANY LOCKERS PVT. LTD., ");
			System.out.println("###################################################");
			System.out.println("==================================================");
			System.out.println("\t\tLockedMe.com\nFILE MENU ");
			System.out.println("==================================================");
			System.out.println("1. Display the files in the folder");
			System.out.println("2. Add a file to the folder");
			System.out.println("3. Delete a file from the folder");
			System.out.println("4. Search a file in the folder");
			System.out.println("5. Exit");
			System.out.println("==================================================");
			System.out.println("Enter your choice....\r\n");
			choice = Integer.parseInt(INPUT.nextLine());
			switch(choice) {
			case 1:
				displayFilesinFolder();
				break;
			
			case 2:
				createFileinFolder();
				break;
			
			case 3:
				deleteFilefromFolder();
				break;
				
			case 4:
				searchFileinFolder();
				break;
				
			case 5:
				exit();
				break;
				
			default:
				System.out.println("Sorry...The choice entered cannot be found on the menu !!");
				System.out.println("Please try again...\n");
			}
		}while(choice > 0 || choice < 5);
	} catch(Exception e) {
		System.out.println("There is an exception :"+e);
	}
}
	
	public static void displayFilesinFolder() {
		System.out.println("\nDisplaying the files in the folder "+FileMenu.PATH+"...\n");
		File folder = new File(FileMenu.PATH);
		FileManager.listFilesinFolder(folder);
	}
	
	public static void createFileinFolder() {
		System.out.println("CREATING A FILE...");
		System.out.println("Enter the path where the file needs to be created....\r\n");
		String userPath = INPUT.nextLine();
		
		if(userPath != null && !userPath.isEmpty())
			FileMenu.PATH = userPath;

		System.out.println("\nCreating the file in the folder "+FileMenu.PATH+"...\n");
		File folder = new File(FileMenu.PATH);
		System.out.println("Enter the file name to be created...\n");
		String filename = INPUT.nextLine();
		System.out.println("Enter the content of the file, if you want...");
		String content = INPUT.nextLine();
		FileManager.createFileinFolder(folder,filename+".txt",content);
	}
	
    public static void deleteFilefromFolder() {
    	System.out.println("Enter the path where the file needs to be created....\r\n");
		String userPath = INPUT.nextLine();
		
		if(userPath == null)
			FileMenu.PATH = userPath;

    	System.out.println("\nDeleting the file from the folder "+FileMenu.PATH+"...\n");
		File folder = new File(FileMenu.PATH);
		System.out.println("Enter the file name to be deleted...\n");
		String filename = INPUT.nextLine();
		FileManager.deleteFilefromFolder(folder,filename+".txt");
	}
    
    public static void searchFileinFolder() {
		System.out.println("\nSearching the file in the folder "+FileMenu.PATH+"...\n");
		File folder = new File(FileMenu.PATH);
		System.out.println("Enter the file name to be searched...\n");
		String filename = INPUT.nextLine();
		boolean fileFound = FileManager.searchFileinFolder(folder,filename+".txt");
		if(!fileFound)
			System.out.println("File is not found in the folder!");
	}
    
    public static void exit() {
		System.out.println("Exiting the menu...");
		System.exit(0);
	}


}
