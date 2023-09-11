package a5;

import java.io.File;

class FileUtils {
	/*
	 * I am so sorry, for this half of the assignment I mainly focused on watching
	 * lectures and ended up not budgeting my time very well. I am willing to 
	 * accept the consequences of not getting points to this part of the assignment
	 * I still am going to keep working on it until I finish, but I just won't be 
	 * able to turn it in before the deadline. I think the skills applied here are 
	 * very important to learn so I will keep working at it until I understand them 
	 * to a point where I can apply the concepts below. Thank you.
	 */
	
	
	/**
	 * Returns a file (not directory) of the given name located at or within
	 * fileOrDirectory, according to the file's getName() method.
	 * If fileOrDirectory has the given name, it itself is returned.
	 * Returns null if no matching file is found.
	 * If multiple files match the given name, any of them may be returned.
	 *
	 * @param name the string name of the file to find (not including the file path)
	 * @param fileOrDirectory the file or directory to start searching from
	 * @return a File f located at or within fileOrDirectory that has
	 *         the provided input name, or null if no such file is found.
	 */
	public static File findFile(String name, File fileOrDirectory) {
		// base case
		if (fileOrDirectory.isFile()){
			
		}
		
		return fileOrDirectory;
		
	}
	/**
	 * Returns a file (not directory) located at or within fileOrDirectory
	 * that has been edited most recently, according to the file's lastModified() method.
	 * If fileOrDirectory does not contain any files, returns null
	 * If multiple files were last modified at the same time, any of them may
	 * be returned.
	 *
	 * @param fileOrDirectory the file or directory to start searching from
	 * @return a File f located at or within FileOrDirectory
	 *         which contains the largest value of f.lastModified()
	 */
	public static File findLatestFile(File fileOrDirectory) {
		
		return fileOrDirectory;
		
	}
}