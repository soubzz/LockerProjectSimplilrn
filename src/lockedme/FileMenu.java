package lockedme;

import java.io.File;
import java.util.Scanner;

public class FileMenu {
	private static Scanner INPUT = new Scanner(System.in);
	private static String PATH = "D:/practice"; 
	public static void main(String[] args) {
		try {
			int choice = 5; // for executing default case
			do {
				System.out.println();
				System.out.println("############################################################");
				System.out.println("\t\tCOMPANY LOCKERS PVT. LTD., ");
				System.out.println("############################################################");
				System.out.println("\n\t\t~`~`~` LockedMe.com `~`~`~\n\n\nDeveloped by : Soubarnica R\n ");
				System.out.println("==================================================");
				System.out.println("\t\tFILE MENU");
				System.out.println("==================================================");
				System.out.println("1. Display the files in the folder");
				System.out.println("2. Manage files in the folder");
				System.out.println("3. Exit");
				System.out.println("==================================================");
				
				System.out.println("Enter your choice....\r\n");
				var inputVal = INPUT.nextLine();
				
				// Validate input
				if(inputVal!=null && !inputVal.isEmpty() && inputVal.matches("[1-3]"))
					choice = Integer.parseInt(inputVal);
	
				switch(choice) {
				case 1:
					displayFilesinFolder();
					break;
				
				case 2:
					manageFilesinFolder();
					break;
	
				case 3:
					exit();
					break;
					
				default:
					System.out.println("Sorry...The choice entered cannot be found on the menu !!");
					System.out.println("Please try again...\n");
				}
			} while(choice > 0 || choice < 6);
		} catch(Exception e) {
		System.out.println("There is an exception :"+e);
	}
}
	// This method displays the files in the current directory and sub-directory
	public static void displayFilesinFolder() {
		System.out.println("******* DISPLAYING THE FILES ********");
		System.out.println("Enter the path where the file needs to be created....\r\n");
		String userPath = INPUT.nextLine();
		File folder;
		
		if(userPath != null && !userPath.isEmpty()) {
			folder = new File(userPath);
			System.out.println("\nDisplaying the files in the folder "+userPath+"...\n");
    	} else {
			folder = new File(FileMenu.PATH);
			System.out.println("\nDisplaying the files in the folder "+FileMenu.PATH+"...\n");
    	}
		FileManager.listFilesinFolder(folder);
	}
	
	public static void manageFilesinFolder() {
		int choice = 5;  // for executing default case
		do {
			System.out.println();
			System.out.println("****** MANAGE FILES IN THE FOLDER ********");
			System.out.println("==================================================");
			System.out.println("1. Create a new file");
			System.out.println("2. Delete a file");
			System.out.println("3. Search for a file");
			System.out.println("4. Back to the Main Menu");
			System.out.println("==================================================");
			
			System.out.println("Enter your choice....\r\n");
			var inputVal = INPUT.nextLine();
			
			// Validate input
			if(inputVal!=null && !inputVal.isEmpty() && inputVal.matches("[1234]"))
				choice = Integer.parseInt(inputVal);
	
			switch(choice) {
			case 1:
				createFileinFolder();
				break;
			
			case 2:
				deleteFilefromFolder();
				break;
			
			case 3:
				searchFileinFolder();
				break;
				
			case 4:
				main(null);
				break;
	
			default:
				System.out.println("Sorry...The choice entered cannot be found on the menu !!");
				System.out.println("Please try again...\n");
			}
		} while(choice != 4);
	}
	
	// This method is used to set the path for the folder
	private static File getPath() {
		String userPath = INPUT.nextLine();
		File folder;
		if(userPath != null && !userPath.isEmpty()) {
			folder = new File(userPath);
			System.out.println("\nSearching the file from the folder "+userPath+"...\n");
    	} else {
			folder = new File(FileMenu.PATH);
			System.out.println("\nSearching the file from the folder "+FileMenu.PATH+"...\n");
    	}
		return folder;
	}
	
	// This method is used to create a file in the folder 
	public static void createFileinFolder() {
		System.out.println("++++++++++ CREATING A FILE ++++++++++");
		System.out.println("Enter the path where the file needs to be created....\r\n");
		File folder = getPath();
		System.out.println("Enter the file name to be created...\n");
		String filename = INPUT.nextLine();
		System.out.println("Enter the content of the file, if you want...");
		String content = INPUT.nextLine();
		FileManager.createFileinFolder(folder,filename+".txt",content);
	}
	
	// This method deletes the file from the specified folder
    public static void deleteFilefromFolder() {
    	System.out.println("++++++++++ DELETE A FILE FROM THE FOLDER ++++++++++");
    	System.out.println("Enter the path where the file needs to be deleted....\r\n");
		File folder = getPath();
		System.out.println("Enter the file name to be deleted...\n");
		String filename = INPUT.nextLine();
		FileManager.deleteFilefromFolder(folder,filename+".txt");
	}
    
    // This method searches the files in the current directory and sub-directory
    public static void searchFileinFolder() {
    	System.out.println("++++++++++ SEARCHING A FILE IN THE DIRECTORY AND SUB-DIRECTORIES ++++++++++");
    	System.out.println("Enter the path where the file needs to be searched....\r\n");
		File folder = getPath();
		System.out.println("Enter the file name to be searched...\n");
		String filename = INPUT.nextLine();
		
		int fileFound = FileManager.searchFileinFolder(folder,filename+".txt");
		
		if(fileFound == 0)
			System.out.println("Please check your file path!");

		if(fileFound == 2)
			System.out.println("File cannot be found!");
	}
    
    // This method exits the application
    public static void exit() {
		System.out.println("Exiting the menu...!!!\n");
		System.exit(0);
	}

}
