package tenbit.game.main.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAndTime {
	public static final String dateTimeFormat = "MM-dd-yyyy HH:mm:ss";
	
	public DateAndTime() {
		
	}
	
	public static String getDate() {
		String[] s = getDateAndTime().split(" ");
		return s[0];
	}
	
	public static String getTime() {
		String[] s = getDateAndTime().split(" ");
		return s[1];
	}
	
	public static String getDateAndTime() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
		return df.format(c.getTime());
	}
}
