package tenbit.game.main.system.logging;

import java.io.File;
import java.lang.System;

public class SystemLogger {
	
	public SystemLogger() {
		
	}
	
	public static void createNewDir() {
		try {
			String osVer = System.getProperty("os.name");
			String userHome = System.getProperty("user.home");
			
			if(osVer.contains("Windows XP")) {
				userHome += "\\My Documents\\";
			}
			else if((osVer.contains("Windows Vista")) || (osVer.contains("Windows 7")) || (osVer.contains("Windows 8"))) {
				userHome += "\\Documents\\";
			}
			else {
				System.out.println("Uh-oh :(");
			}
			System.out.println(userHome + "Reduc/");
			//new File(userHome + "").mkdirs();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createNewLog() {
		//File dir = new File("");
		//http://stackoverflow.com/questions/6656565/create-a-text-file-in-a-folder
	}
	
	public static void logAction() {
		
	}
	
	public static void main(String[] args) {
		SystemLogger.createNewDir();
	}
}
