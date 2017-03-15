import java.util.Arrays;
import java.util.Scanner;


public class DegeneratedTriangle {
	
	public static int[] getLongMaxSide(int[] val) throws Exception{
		int[] result = new int[3];
		Arrays.sort(val);
		
		int longSideIndex = val.length-1;
		int shortSideIndex = val.length - 3;
		boolean isFound = false;
		while (longSideIndex >= 2 && !isFound){
			shortSideIndex = longSideIndex - 2;
			while (shortSideIndex >= 0 && !isFound){
				if (val[longSideIndex] < val[shortSideIndex+1] + val[shortSideIndex]){
					result[0] = val[shortSideIndex];
					result[1] = val[shortSideIndex+1];
					result[2] = val[longSideIndex];
					isFound = true;				
				}
				shortSideIndex--;
			}
			longSideIndex--;
		}
		if (!isFound){
			throw new Exception("not found");
		}
		return result;
	}

	public static void main(String[] args) {
		  int testNum;
	      
		// TODO Auto-generated method stub
		  int[] testCases = {9,2015,5294,58768,285,477,72,13867,97,22445,48,36318,764,8573,183,3270,81,1251,59,95094};
//		 int[] testCases; 
		 Scanner in = new Scanner(System.in);
		 testNum = in.nextInt();
		 
		 testCases = new int[testNum];

	       int i = 0;

	       while(i < testNum && in.hasNextInt()) {
	           testCases[i] = in.nextInt();
	           i++;
	       }
		  try {
	      int[] res =  getLongMaxSide(testCases);
	      for (int val : res){
	    	  System.out.print(val + " ");
	      }}
		  catch (Exception e){
			  System.out.println("-1");
		  }
	}

}
