package WeekOfCode30;

import java.util.Scanner;

public class CandyReplenishingRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
//	        int n = in.nextInt();
//	        int t = in.nextInt();
//	        int[] c = new int[t];
//	        for(int c_i=0; c_i < t; c_i++){
//	            c[c_i] = in.nextInt();
//	        }
	        // your code goes here
	        
		 int[] tester = {3,1,7,5};
		 int n= 8;
	        int NumOfRefill = refillCandy(tester,n);
	        System.out.println(NumOfRefill);
	}

	private static int refillCandy(int[] c,int maxCandy) {
		
		int numOfRefill = 0;
		int currentCandy = maxCandy;
		
		for (int i=0;i<c.length -1;i++){
			currentCandy -= c[i];
			if (currentCandy<5){
				numOfRefill += maxCandy - currentCandy;
				currentCandy = maxCandy;
			}
		}
		
		
		return numOfRefill;
	}

}
