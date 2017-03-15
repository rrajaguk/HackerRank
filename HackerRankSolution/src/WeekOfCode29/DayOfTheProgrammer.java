package WeekOfCode29;

import java.util.Scanner;

public class DayOfTheProgrammer {
	
	public static String normalGregorianCalendar = "13.09.";
	public static String leapGregorianCalendar = "12.09.";
	public static String normalJulianCalendar = "13.09.";
	public static String leapJulianCalendar = "12.09.";
	public static String specialDayInRussia = "26.09.";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int y = in.nextInt();
	    
	    if (y >= 1919 ){
	    	if (y% 400 == 0 || (y % 4 == 0 && y % 100 != 0)){
	    		System.out.println(leapGregorianCalendar+y);
	    	}else {
	    		System.out.println(normalGregorianCalendar+y);
	    	}
	    }else if (y >= 1700 && y <= 1917){
	    	if (y% 4 == 0 ){
	    		System.out.println(leapJulianCalendar+y);
	    	}else {
	    		System.out.println(normalJulianCalendar+y);
	    	}
	    }else {
	    	System.out.println(specialDayInRussia+y);
	    }
	}

}
