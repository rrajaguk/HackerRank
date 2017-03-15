package DataStructures;

import java.util.Scanner;

public class LargestRectangle {
	class pointRes {
		pointRes(int pos, int val){
			this.position = pos;
			this.height = val;
		}
		public int position;
		public int height;
	}
	public pointRes findMinimumPos(int[] listOfValue, int start, int end){
		int result = Integer.MAX_VALUE;
		if (start == end){
			return new pointRes(start,listOfValue[start]);
		}
		pointRes finalRes = new pointRes(0, 0);
		for (int i = start;i<=end;i++){
			if (result > listOfValue[i]){
				finalRes.position = i;
				finalRes.height = listOfValue[i];
				result = listOfValue[i];
			}
		}
		return finalRes;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int numOfBuilding = in.nextInt();
	    int[] listOfBuilding = new int[numOfBuilding];
	    for (int i = 0; i<listOfBuilding.length ; i++){
	    	listOfBuilding[i] = in.nextInt();
	    }

	    LargestRectangle lr = new LargestRectangle();
	    System.out.println(lr.countConsecutive2(listOfBuilding,0,listOfBuilding.length-1));
	    System.out.println(numOfCall);
	}
	static int numOfCall = 0;
	private long countConsecutive2(int[] listOfBuilding, int start, int end) {
		if (start <= end){
			numOfCall++;
			pointRes lowestPoint =  findMinimumPos(listOfBuilding, start, end);
			long currentSize =( (end - start) + 1) * lowestPoint.height;
			if (lowestPoint.position == start){
				currentSize =  Math.max(currentSize, countConsecutive2(listOfBuilding, start+1, end));				
			}else if (lowestPoint.position == end){
				currentSize = Math.max(currentSize, countConsecutive2(listOfBuilding, start, end-1));				
			}else {				
				currentSize =Math.max(currentSize, countConsecutive2(listOfBuilding, start, lowestPoint.position -1));
				currentSize =Math.max(currentSize, countConsecutive2(listOfBuilding, lowestPoint.position +1,end));				
			}
			return currentSize;
		}else {
			
			return 0;
		}
	}
	
}
