package fileio;

import java.io.File;

/**
 * Contains some methods to list files and folders from a directory
 *
 * @author Loiane Groner http://loiane.com (Portuguese) http://loianegroner.com (English)
 */
public class ListFilesUtil {
	/**
	 * List all the files and folders from a directory
	 * 
	 * @param dirName
	 *            current directory to be listed
	 */
	public static void listFilesAndFoldersInDirectory(String dirName) {
		File directory = new File(dirName);
		// get all the files and folder from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			System.out.println(file.getName());
		}

		System.out.println();
	}

	/**
	 * List all the files under a directory
	 * 
	 * @param dirName
	 *            current directory to be listed
	 */
	public static void listFilesOnlyInDirectory(String dirName) {
		File directory = new File(dirName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) { // check has a file
				System.out.println(file.getName());
			}
		}

		System.out.println();
	}

	/**
	 * List all the folder under a directory
	 * 
	 * @param dirName
	 *            current directory to be listed
	 */
	public static void listFoldersOnlyInDirectory(String dirName) {
		File directory = new File(dirName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isDirectory()) { // check has a directory
				System.out.println(file.getName());
			}
		}

		System.out.println();
	}

	/**
	 * List all files from a directory and its in sub-directories
	 * 
	 * @param dirName
	 *            current directory to be listed
	 */
	public static void listFilesInDirectoryAndSubDirectories(String dirName) {
		File directory = new File(dirName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) { // check has a file
				System.out.println(file.getAbsolutePath());
			} else if (file.isDirectory()) { // check has a directory then recursive loop file again
				listFilesInDirectoryAndSubDirectories(file.getAbsolutePath());
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		// Windows directory example
		final String currentDirName = "C:\\Users\\Johny\\Desktop\\avatar";
		listFilesOnlyInDirectory(currentDirName);
		listFoldersOnlyInDirectory(currentDirName);
		listFilesAndFoldersInDirectory(currentDirName);
		listFilesInDirectoryAndSubDirectories(currentDirName);
	}

}
