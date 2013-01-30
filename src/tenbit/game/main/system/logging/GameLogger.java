package tenbit.game.main.system.logging;

import java.io.File;
import java.io.IOException;

import tenbit.game.main.system.DateAndTime;

public class GameLogger {
	private static String osVer = System.getProperty("os.name");
	private static String userHome = System.getProperty("user.home");
	private static String dirE = "Reduc/logs/errorlogs/";
	private static String dirS = "Reduc/logs/systemlogs/";
	
	public GameLogger() {
		
	}
	
	public static String getDocsFolder() {
		if(osVer.contains("Windows XP")) {
			return "\\My Documents\\";
		}
		else if((osVer.contains("Windows Vista")) || (osVer.contains("Windows 7")) || (osVer.contains("Windows 8"))) {
			return "\\Documents\\";
		}
		return "";
	}
	
	public static void createNewDir(String eOrS) {
		try {	
			if(eOrS == "e") {
				new File(userHome + getDocsFolder() + dirE).mkdirs();
			}
			else if(eOrS == "s") {
				new File(userHome + getDocsFolder() + dirS).mkdirs();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createNewLog(String eOrS) {
		try {
			if(eOrS == "e") {
				String dir = userHome + getDocsFolder() + dirE;
				String logName = "errlog" + DateAndTime.getDate() + " " + DateAndTime.getTime();
				new File(dir, logName).createNewFile();
			}
			else if(eOrS == "s") {
				String dir = userHome + getDocsFolder() + dirS;
				String logName = "syslog" + DateAndTime.getDate() + " " + DateAndTime.getTime();
				new File(dir, logName).createNewFile();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logAction(String s1) {
		try {
			if(!(new File(userHome + getDocsFolder() + dirS).exists())) {
				createNewDir("s");
			}
			
			createNewLog("s");
			
			//log
			File f = new File(userHome + getDocsFolder() + dirS + "syslog" + DateAndTime.getDate() + " " + DateAndTime.getTime());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logAction(Exception e) {
		try {
			if(!(new File(userHome + getDocsFolder() + dirE).exists())) {
				createNewDir("e");
			}
			
			createNewLog("e");
			
			//log
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GameLogger.logAction("S");
		GameLogger.logAction(new IOException());
	}
}
