package Algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(isValid( (in.nextLine())));
		System.out.println(isValid("aabbcd"));
	}
	
	

	private static String isValid(String string) {
		HashMap<Character, Integer> HM = new HashMap<Character, Integer>();
		HashMap<Integer, Integer> HM2 = new HashMap<Integer, Integer>();
		
		
		// count each character occurence
		for (char p : string.toCharArray()){
			if (HM.containsKey(p)){
				HM.put(p, HM.get(p) + 1);
			}else {
				HM.put(p, 1);
			}
		}
		
		Iterator it = HM.entrySet().iterator();
		int[] counting = new int[HM.size()];
		int countPos = 0;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	        counting[countPos++] = (int)pair.getValue();
	        
	        if (HM2.containsKey(pair.getValue())){
	        	HM2.put((int)pair.getValue(), HM2.get(pair.getValue())+1);
	        }else {
	        	HM2.put((int)pair.getValue(), 1);	        	
	        }
	    }

	    if (HM2.size() >2){
	    	return "NO";
	    }else if (HM2.size() == 1){
	    	return "YES";
	    }
		it = HM2.entrySet().iterator();	    
		Boolean isFoundOne  = false;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	        if ((int)pair.getValue() == 1){
	        	isFoundOne = true;
	        }
	    }
	    
	    if (isFoundOne){
	    	return "YES";
	    }else {
	    	return "NO";
	    }
	
	}

}
