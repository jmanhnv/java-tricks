/*
 * FILENAME FilenameFilterExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.File;
import java.io.FilenameFilter;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * How to find/delete files of certain extension : FilenameFilter Example. Many times we need to traverse and find all
 * files with a certain extension only any do some operations on those files such as deleting them. This is more often
 * required when you want to delete all log files from your log folder after certain time using your application program
 * (if such requirement exist).
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/21/how-to-finddelete-files-of-certain- extension-filenamefilter-example/
 * @author manhnv
 * @version 0.1
 **/
public class FilenameFilterExample {
	public static void main(String[] args) {
		// Delete all files from this directory
		String targetDirectory = "c:\\temp";
		File dir = new File(targetDirectory);

		// Filter out all log files
		String[] logFiles = dir.list(new LogFilterFilter());

		// If no log file found; no need to go further
		if (logFiles.length == 0) return;

		// This code will delete all log files one by one
		for (String log : logFiles) {
			String tempLogFile = new StringBuffer(targetDirectory).append(File.separator).append(log).toString();
			File fileDelete = new File(tempLogFile);
			boolean isdeleted = fileDelete.delete();
			System.out.println("file : " + tempLogFile + " is deleted : " + isdeleted);
		}
	}
}

// This filter will be used to check for all files if a file is log file
class LogFilterFilter implements FilenameFilter {
	public boolean accept(File dir, String fileName) {
		return (fileName.endsWith(".log"));
	}
}
