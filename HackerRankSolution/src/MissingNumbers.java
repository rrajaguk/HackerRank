import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MissingNumbers {
	public static void main(String[] args) {
		int[] sourceA = {203,204,205,206,207,208,203,204,205,206};
		int[] sourceB = {203,204,204,205,206,207,205,208,203,206,205,206,204};
		int[] result = findMissing(sourceB,sourceA);
		Arrays.sort(result);
		for (int i : result){
			System.out.print(i + " ");
		}
	}

	private static int[] findMissing(int[] sourceA, int[] sourceB) {
		int[] result = new int[sourceA.length - sourceB.length];
		
		HashMap<Integer, Integer> HM = new HashMap<Integer,Integer>();
		for (int valA : sourceA){
			if (HM.containsKey(valA)){
				HM.put(valA, HM.get(valA)+1);
			}else {
				HM.put(valA, 1);
			}
		}
		
		for (int valB : sourceB){
			int count = (int)HM.get(valB);
			if (count > 1){
				HM.put(valB, count-1);				
			}else {
				HM.remove(valB);
			}
		}
		 Iterator it = HM.entrySet().iterator();
		 int posInResult = 0;
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        //for (int i =0;i<(int)pair.getValue(); i++){
		        	result[posInResult] = (int) pair.getKey();
		        	posInResult++;
		        	
		        //}		        
		    }
		
		return result;
	}
}
