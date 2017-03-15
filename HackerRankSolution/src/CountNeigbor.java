import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;


public class CountNeigbor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] valArr = new int[4][];
		int[]  node1 = {1,2};
		int[] node2 = {3,2};
		int[] node3 = {4,2};
		int[] node4 = {4,3};
		valArr[0] = node1;
		valArr[1] = node2;
		valArr[2] = node3;
		valArr[3] = node4;
		//valArr[1] = new int 
		
		int[] parent = new int[5];
		for (int i =0;i<parent.length;i++){
			parent[i] = -1;
		}
		HashMap<Integer, Integer> headFriends = new HashMap<Integer,Integer>();
		int countVal = 0;
		for (int[] node : valArr){
			int[] nodeSwap = swap(node);
			int firstNode =nodeSwap[0] -1;
			int secondNode = nodeSwap[1] -1;
			
			// first time case both orphand
			if (parent[firstNode] == -1 && parent[secondNode ] == -1){
				parent[firstNode ] = firstNode;
				parent[secondNode] = parent[firstNode ];
				headFriends.put(firstNode, 1);
			}else 	
			
			// left has parent and right no
			if (parent[firstNode] > -1  && parent[secondNode ] == -1){
				parent[secondNode ] = parent[firstNode];
				headFriends.put(parent[firstNode], headFriends.get(parent[firstNode]) + 1);
			}else
			
			// right has parent and left no
			if (parent[secondNode] > -1 && parent[firstNode ] == -1){
				parent[firstNode ] = parent[secondNode];
					headFriends.put(parent[secondNode], headFriends.get(parent[secondNode]) + 1);
			}else
			
			// both already has a parent and different
			if (parent[firstNode] !=  parent[secondNode ] ){
				parent[secondNode ] = parent[firstNode];
				headFriends.put(parent[firstNode], headFriends.get(parent[firstNode]) + headFriends.get(parent[secondNode]) );
			}
			
			// 
						
			for (int parentVal : parent){
				if (headFriends.containsKey(parentVal)){
					countVal += headFriends.get(parentVal);
				}
			}
		}
		
		System.err.println(countVal);
	}
	
	public static int[] swap(int[] node){
		int[] result= node.clone();
		Arrays.sort(result);
		return result;
	}

}
