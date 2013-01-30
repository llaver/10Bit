package tenbit.game.main.system.logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.System;

import tenbit.game.main.system.DateAndTime;

public class SystemLogger {
	private static String osVer = System.getProperty("os.name");
	private static String userHome = System.getProperty("user.home");
	
	public SystemLogger() {
		
	}
	
	public static void createNewDir() {
		try {	
			if(osVer.contains("Windows XP")) {
				userHome += "\\My Documents\\";
			}
			else if((osVer.contains("Windows Vista")) || (osVer.contains("Windows 7")) || (osVer.contains("Windows 8"))) {
				userHome += "\\Documents\\";
			}
			else {
				System.out.println("Uh-oh :(");
			}
			System.out.println(new File(userHome + "Reduc/logs/systemlogs/").mkdirs());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createNewLog() {
		try {
			String logName = "syslog " + DateAndTime.getDate();
			System.out.println(new File(userHome + "Reduc/logs/systemlogs/", logName + ".txt").createNewFile());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logAction(String s) {	
		try {
			BufferedReader b = new BufferedReader(new FileReader(userHome + "Reduc/logs/systemlogs/" + "syslog " + DateAndTime.getDate() + ".txt"));
			
			if(!(new File(userHome + "Reduc/logs/systemlogs/").exists())) {
				createNewDir();
			}
			if(!(new File(userHome + "Reduc/logs/systemlogs/" + "syslog " + DateAndTime.getDate() + ".txt").exists())) {
				createNewLog();
			}
			
			File f = new File(userHome + "Reduc/logs/systemlogs/" + "syslog " + DateAndTime.getDate() + ".txt");
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("[" + DateAndTime.getTime() + "]" + s);
			pw.close();
			pw.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SystemLogger.logAction("hi");
		SystemLogger.logAction("hi2");
		SystemLogger.logAction("h3i");
	}
}
