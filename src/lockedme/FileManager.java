package lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	/**
	 * Checks if the given path is a directory, the method prints the files in the directory
	 * else the method prints the filename
	 * @param folder
	 */
	public static void listFilesinFolder(File folder) {
		File[] files = folder.listFiles();
		
		for(File file : files) {
			if(file.isDirectory()) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Inside "+file.getName());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				listFilesinFolder(file);
				System.out.println("---------------------------");
			}
			else if(file.isFile())
				System.out.println(file.getName());
		}
	}
	
	/**
	 * Creates a file in the folder
	 * @param folder
	 */
	public static void createFileinFolder(File folder, String filename, String content) {
		try {
				if(folder.getAbsoluteFile().exists()) {
					File newFile = new File(folder.getAbsoluteFile()+"/"+filename);
					boolean fileCreated = newFile.createNewFile();
					
					if(content != null) {
					FileWriter fw = new FileWriter(newFile);
					fw.write(content);
					fw.close();
					}
					
					if(fileCreated)
						System.out.println("File Created successfully...!");
					else
						System.out.println("There is a problem in creating a file...!");
					} else {
						System.out.println("The path entered does not exist...Please enter the existing path");
					}
			} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Deletes the file from the folder
	 * @param folder
	 * @param filename
	 */
	public static void deleteFilefromFolder(File folder, String filename) {
		if(folder.getAbsoluteFile().exists()) {
		File tempFile = new File(folder.getAbsoluteFile()+"/"+filename);
		boolean fileDeleted = tempFile.delete();
		if(fileDeleted)
			System.out.println("File deleted successfully...!");
		else
			System.out.println("The file to be deleted cannot be found...!");
		} else {
			System.out.println("Path does not exist!");
		}
	}
	
	/**
	 * Searches the file in the folder
	 * @param folder
	 * @param filename
	 */
	public static boolean searchFileinFolder(File folder, String filename) {
		boolean fileIsFound = false;
		File[] files = folder.listFiles();
		for(File file : files) {
			
			if(file.isDirectory()) {
				fileIsFound = searchFileinFolder(file,filename);
				if(fileIsFound)
					return true;
			}
			
			else if(file.isFile() && file.getName().equals(filename)) {
				System.out.println("File found at the path: "+file.getAbsolutePath());
				return true;
			}
			
		}
		if(fileIsFound)
			return true;
		else
			return false;	
	}
}
