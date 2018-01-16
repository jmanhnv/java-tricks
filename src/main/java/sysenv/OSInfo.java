package sysenv;

public class OSInfo {
	// The key for getting operating system name
	static final String OS_NAME = "os.name";
	// The key for getting operating system version
	static final String OS_VERSION = "os.version";
	// The key for getting operating system architecture
	static final String OS_ARCHITECTURE = "os.arch";

	//
	static final String OS = System.getProperty(OS_NAME).toLowerCase();

	public static void main(String[] args) {
		System.out.println("Name: " + System.getProperty(OS_NAME));
		System.out.println("Version: " + System.getProperty(OS_VERSION));
		System.out.println("Architecture: " + System.getProperty(OS_ARCHITECTURE));

		System.out.println("\n+++ " + OS + " +++");
		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
}
