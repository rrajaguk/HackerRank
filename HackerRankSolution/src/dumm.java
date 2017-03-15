import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;



public class dumm {

	private static List<Integer> listOfInteger = new LinkedList<Integer>();
	private static HashMap<String,Integer> storagePath = new HashMap<String,Integer>();
	private static HashMap<Integer,Integer> calRes = new HashMap<Integer,Integer>();
	static int min = Integer.MAX_VALUE; 
	static int max = Integer.MIN_VALUE;
	static boolean useHash = true;
	public static void main(String[] args) {
		System.out.println(numberNeeded("abc", "cde"));
		System.out.println(numberNeeded("bugexikjevtubidpulaelsbcqlupwetzyzdvjphn", "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk"));
	}
	public static int numberNeeded(String first, String second) {
		String temp;
		if (first.length() < second.length()){
			temp = first;
			first = second;
			second = temp;
		}
		int NumOfChanges = 0;

			
		StringBuffer sb = new StringBuffer(second);
		for (int i = 0;i<first.length();i++){
			StringBuilder sbmm = new StringBuilder();
			sbmm.append(first.charAt(i));
			int index = sb.indexOf(sbmm.toString());
			if (index >= 0){
				sb.deleteCharAt(index);
			}else {
				NumOfChanges++;
			}
		}
		
	      return NumOfChanges + sb.length();
	    }
	static int numCAll = 0;
	public static long fibo(long a, HashMap<Long, Long> hash){
		if (hash.containsKey(a) && useHash){
			return hash.get(a).longValue();
		}
		numCAll++;
		if (a == 0){
			return 0;
		}
		if (a== 1){
			return 1;
		}
		if (a == 2){
			return 2;
		}
		long result = fibo(a-2,hash) + fibo(a-1,hash) ;
		hash.put(a, result);
		return result;
	}
	
	public static long change(int dollars, int[] coins) {
        //"Degenerate" cases
        if (dollars == 0) { return 1; }
        if (coins.length == 0) { return 0; }
        
        long[] store = new long[dollars+1];
        store[0] = 1;       //There's always 1 way to make $0
        
        for (int coin : coins) {
            for (int i = 0; i < store.length-coin; i++) {
                store[i+coin] += store[i];
            }
        }
        return store[dollars];
    }
	 public static long numWays(int n, int [] coins) {
	        if (n < 0) {
	            return 0;
	        }
	        return numWays(n, coins, 0, new HashMap<String, Long>());
	    }
	    
	    public static long numWays(int n, int [] coins, int coinNumber, HashMap<String, Long> cache) {
	    	System.out.println("Look for "+ n +" with "+ coins[coinNumber]);
	        /* Check our cache */
	        String key = n + "," + coinNumber;
	        if (cache.containsKey(key)) {
	        	System.out.println("\t\t Find 1");
	            return cache.get(key);
	        }
	        /* Base case */
	        if (coinNumber == coins.length - 1) {
	            if (n % coins[coinNumber] == 0) {
		        	System.out.println("\t\t put Find 1");
	                cache.put(key, 1L);
	                return 1;
	            } else {
	                cache.put(key, 0L);
	                return 0;
	            }
	        }
	        /* Recursive case */
	        long ways = 0;
	        for (int i = 0; i <= n; i += coins[coinNumber]) {
	            ways += numWays(n - i, coins, coinNumber + 1, cache);
	        }
	        /* Cache and return solution */
	        cache.put(key, ways);
	        return ways;
	    }
	public static void printStack(Stack<Integer> sol, int level){
		StringBuilder SB = new StringBuilder();
    	for (int path : sol)
    	{
    		SB.append(path);
    	}
    	for (int i = 0 ; i <level;i++){
    		System.out.print("\t");
    	}
    	System.out.print("stack = " + SB.toString());
    	System.out.println("");	
	}
	 public static long makeChange(int[] coins, int money, Stack<Integer> sol, int level) {
		 	if (calRes.containsKey(money)){
		 		int val = calRes.get(money).intValue();
		 		//val +=1;
		 		//return val;
		 	}
	        if (money == 0){
	        	Stack<Integer> rep = new Stack<Integer>();
	        	rep.addAll(sol);
	        	Collections.sort(rep);
	        	StringBuilder SB = new StringBuilder();
	        	for (int path : rep)
	        	{
	        		SB.append(path);
	        	}
	        	if (storagePath.containsKey(SB.toString())){
	        		storagePath.put(SB.toString(), storagePath.get(SB.toString()).intValue() +  1);	        		
	        		return 0;
	        	}else {
	        		System.out.println(SB.toString());
	        		System.out.println("**************okeh bebeh");	        	
	        		storagePath.put(SB.toString(), 1);
		        	return 1;
	        	}
	        	//return 1;
	            
	        }
	        long result = 0;
//	        System.out.println("===========================");
//	        for (int i = 0 ; i <level;i++){
//	    		System.out.print("\t");
//	    	}
//	        System.out.println(" Money = " + money +" ");
//	        System.out.println("===========================");
	        for (int coin : coins){
	            if (money - coin >= 0){
//	            	for (int i = 0 ; i <level;i++){
//	            		System.out.print("\t");
//	            	}
//	            	System.out.println("Push To Stack " + coin);
	            	sol.push(coin);
//	            	for (int i = 0 ; i <level;i++){
//	            		System.out.print("\t");
//	            	}
//	            	System.out.println("Money = " + money +" coin = "+ coin + " level = " + level);
//	            	printStack(sol,level);
	                result += makeChange(coins, money - coin,sol,level+1);
	                
//	                for (int i = 0 ; i <level;i++){
//	            		System.out.print("\t");
//	            	}
//	            	System.out.println("Pop From Stack " + sol.peek());
	                sol.remove(sol.size() -1);
	            	//sol.push(coin);;
	            	//printStack(sol,level);
	            }
	            //else {
	            	//System.out.println("value = "+ money);
	            //}
	        }
	         
	        if (result > 0){
	        	calRes.put(money, (int) result);
	        	System.out.println(" for "+ money + " there are " + result +" ways");
	        }
	        return result;
	    }
	 
	public static boolean traverse(TreeNode root, int level){
		if (root == null){
			return true;
		}
		boolean result = true;
		if (root.Left != null){
			result &= traverse(root.Left, level+1);
		}
		if (root.Right != null){
			result &= traverse(root.Right,level+1);
		}
		if (root.Right == null && root.Left == null){
			listOfInteger.add(level++);
			min = Math.min(min, level);
			max = Math.max(max, level);

			System.out.println("min = "+min+" max = "+max);
			result &=(max-min <= 1);
		}
		return result;
	}

	private static void TlvTested() {
		String value = "77319F2701009F360200019F26080F370E9B605CAA4C9F101A1110880103220006000000000000000000FF00000000000000FF";
		TLV res = TLVHelper.parse(value, null);
		TLVHelper.print(res, 0);


		/*String value2 = "BB05AA03BB092255";
		TLV res2 = TLVHelper.parse(value2, null);
		TLVHelper.print(res2, 0);

		String value3 = "BB02AA00";
		TLV res3 = TLVHelper.parse(value3, null);
		TLVHelper.print(res3, 0);*/
	}

	private static void tree() {
		TreeNode head = generateNode2();
		TreeNode toAdd = new TreeNode(16);
		TreeNode toAdd2 = new TreeNode(15);

		printBFS(head);

		addNode(head, toAdd);

		System.out.println("");
		printBFS(head);

		addNode(head, toAdd2);

		System.out.println("");
		printBFS(head);
	}

	private static void addNode(TreeNode head, TreeNode node){

		if (head == null){
			return;
		}
		if (head.Value > node.Value){
			if (head.Left != null){
				addNode(head.Left, node);
			}else {
				head.Left = node;
			}			
		}else if (head.Value < node.Value){
			if (head.Right != null){
				addNode(head.Right,node);
			}else {
				head.Right = node;
			}
		}

	}

	private static void printDFS(TreeNode node){
		if (node != null ){
			if (node.Left != null){
				printDFS(node.Left);
			}
			if (node.Right != null){
				printDFS(node.Right);
			}
			System.out.print(node.Value + " ");
		}

	}

	private static void printBFS(TreeNode node){
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		if (node != null ){
			queue.add(node);
			while (!queue.isEmpty()){
				TreeNode tempNode = queue.remove();
				System.out.print(tempNode.Value + " ");
				if (tempNode.Left != null){
					queue.add(tempNode.Left);
				}
				if (tempNode.Right!= null){
					queue.add(tempNode.Right);
				}
			}
		}

	}

	private static TreeNode generateNonBalanced(){
		TreeNode head = new TreeNode(1);

		TreeNode child1 = new TreeNode(3);
		TreeNode child2 = new TreeNode(4);



		TreeNode grandChild1 = new TreeNode(5);
		TreeNode grandChild2 = new TreeNode(6);

		TreeNode grand2Child1 = new TreeNode(7);

		head.Left = child1;
		head.Right = child2;

		child1.Left = grandChild1;
		child1.Right = grandChild2;

		grandChild1.Left = grand2Child1;


		return head;

	}
	private static TreeNode generateNode2(){
		TreeNode head = new TreeNode(30);

		TreeNode child1 = new TreeNode(20);
		TreeNode child2 = new TreeNode(50);



		TreeNode grandChild1 = new TreeNode(10);
		TreeNode grandChild3 = new TreeNode(40);
		TreeNode grandChild4 = new TreeNode(60);


		head.Left = child1;
		head.Right = child2;

		child1.Left = grandChild1;

		child2.Left = grandChild3;
		child2.Right = grandChild4;

		return head;
	}

	private static TreeNode generateNode(){
		TreeNode head = new TreeNode(1);

		TreeNode child1 = new TreeNode(7);
		TreeNode child2 = new TreeNode(9);



		TreeNode grandChild1 = new TreeNode(12);
		TreeNode grandChild2 = new TreeNode(4);
		TreeNode grandChild3 = new TreeNode(11);
		TreeNode grandChild4 = new TreeNode(2);


		head.Left = child1;
		head.Right = child2;

		child1.Left = grandChild1;
		child1.Right = grandChild2;

		child2.Left = grandChild3;
		child2.Right = grandChild4;

		return head;
	}

	private static void highInt() {
		int res = getHighestNumber("0062832");
		System.out.println(res == 8632200);

		int resLow = getNextHighest("423862");
		System.out.println(resLow == 426238);
	}

	public static int getNextHighest(String val){

		int[] listOfInteger = parseStringToIntList(val);

		int smallestInt = listOfInteger[listOfInteger.length - 1];		
		int nextSmallest = listOfInteger[listOfInteger.length- 2];
		int nextSmallestPos = listOfInteger.length - 2;

		// change to while
		for (int i = listOfInteger.length - 3;i>0;i--){
			if (listOfInteger[i] < nextSmallest){
				nextSmallest = listOfInteger[i];
				nextSmallestPos = i;
				break;
			}
		}

		int p = getMinPos(listOfInteger, nextSmallestPos, listOfInteger.length, nextSmallest);

		int Temp = listOfInteger[p];
		listOfInteger[p] = listOfInteger[nextSmallestPos];
		listOfInteger[nextSmallestPos] = Temp;

		sortOff(listOfInteger, nextSmallestPos + 1, listOfInteger.length);

		return countIntList(listOfInteger);
	}

	public static void sortOff(int[] listOfInteger, int startingPoint, int endPoint){

		for (int i = startingPoint;i < endPoint;i++){
			for (int j = i+1; j < endPoint;j++){
				if (listOfInteger[i] > listOfInteger[j]){
					int temp = listOfInteger[i];
					listOfInteger[i] = listOfInteger[j];
					listOfInteger[j] = temp;
				}
			}
		}

	}
	public static int getMinPos(int[] listOfInteger, int startingPoint, int endPoint, int min){

		int minVal = Integer.MAX_VALUE;
		int minValPos = startingPoint;
		for (int i = startingPoint;i<endPoint; i++)
		{
			if (listOfInteger[i] > min && listOfInteger[i]<minVal){
				minVal = listOfInteger[ i];
				minValPos = i;
			}
		}

		return minValPos;
	}

	public static int[] parseStringToIntList(String val){

		int[] listOfInt = new int[val.length()];
		for(int i =0;i<val.length();i++){
			listOfInt[i] = Integer.parseInt(val.substring(i,i+1));
		}
		return listOfInt;
	}

	public static int countIntList(int[] listOfInt ){
		int result = 0;
		for (int i = listOfInt.length -1 ;i >=0 ;i--){
			result += listOfInt[i] *  Math.pow(10,listOfInt.length -i - 1);
		}
		return result;
	}
	public static int getHighestNumber(String val){
		int result = 0;
		int[] listOfInt =parseStringToIntList(val);

		for (int i = 0;i < listOfInt.length;i++){
			for (int j = i+1; j < listOfInt.length;j++){
				if (listOfInt[i] < listOfInt[j]){
					int temp = listOfInt[i];
					listOfInt[i] = listOfInt[j];
					listOfInt[j] = temp;
				}
			}
		}

		result = countIntList(listOfInt);

		return result;
	}

	private static void maxStreakkk() {
		int[] listOfInteger = new int[]{1,3,2,3,4,8,7,9};
		int maxStreak1 = getMaxStreak(listOfInteger);
		System.out.println(maxStreak1);
		int maxStreak2 = getMaxStreak2(listOfInteger);
		System.out.println(maxStreak2);
	}


	private static int  getMaxStreak2(int[] listOfInteger){
		int start = 0;
		int end = 1;
		int maxLen = 1;
		while (end < listOfInteger.length){
			if (listOfInteger[end] > listOfInteger[end-1]){
				maxLen = end-start +1;
			}else {
				start = end;
			}
			end++;
		}

		return maxLen;
	}

	private static int  getMaxStreak(int[] listOfInteger){
		int result = 0;
		int max = result;

		for (int i = 0;i<listOfInteger.length -1;i++){
			if (listOfInteger[i] < listOfInteger[i+1]){
				result += 1;
			}else {
				max = Math.max(result, max);
				result = 1;
			}
		}

		return max;
	}
	private static void biggestRegion() {
		int[][] matrix = new int[8][9];
		matrix[0] = new int[]{0,1,0,0,0,0,1,1,0};
		matrix[1] = new int[]{1,1,0,0,1,0,0,0,1};
		matrix[2] = new int[]{0,0,0,0,1,0,1,0,0};
		matrix[3] = new int[]{0,1,1,1,0,1,0,1,1};
		matrix[4] = new int[]{0,1,1,1,0,0,1,1,0};
		matrix[5] = new int[]{0,1,0,1,1,0,1,1,0};
		matrix[6] = new int[]{0,1,0,0,1,1,0,1,1};
		matrix[7] = new int[]{1,0,1,1,1,1,0,0,0};

		int max = 0;
		for (int row = 0;row<matrix.length;row++){
			for (int column = 0; column < matrix[0].length; column++){
				if (matrix[row][column] ==1){
					int currentSize = getBiggestRegion(matrix,row,column); 
					max= Math.max(max, currentSize);
				}
			}
		}

		System.out.println(max);
	}

	public static int getBiggestRegion(int[][] matrix,int row, int column) {
		int result = 0;
		if (matrix[row][column] == 1){
			result += 1;
			matrix[row][column] = -1;
		}else {
			return 0;
		}
		// right
		if (column +1 < matrix[0].length){
			result += getBiggestRegion(matrix, row, column + 1);
			// right + bottom
			if (row+1 < matrix.length){
				result += getBiggestRegion(matrix, row+ 1, column+1);
			}
		}
		// bottom
		if (row+1 < matrix.length){
			result += getBiggestRegion(matrix, row+ 1, column);
			// left + bottom
			if (column-1 >= 0){
				result += getBiggestRegion(matrix, row+ 1, column-1);
			}
		}    	

		// left
		if (column-1 >= 0){
			result += getBiggestRegion(matrix, row, column - 1);
			// left  + top
			if (row-1 >= 0){
				result += getBiggestRegion(matrix, row- 1, column-1);
			}
		}
		// top
		if (row-1 >= 0){
			result += getBiggestRegion(matrix, row - 1, column);
		}

		return result;

	}
	private static void chekNode() {
		node head = new node(1);
		node n2 = new node(2);
		node n3 = new node (3);
		node n4 = new node (4);

		head.next = n2;
		n2.next = n3;
		n3.next = null;
		n4.next = n3;



		if (!hasCycle(head)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	static ArrayList<node> listOfVisitedNode = new ArrayList<node>();
	static boolean hasCycle(node head) {
		if (head == null){
			return true;		
		}
		if (!listOfVisitedNode.contains(head)){
			listOfVisitedNode.add(head);
			return true & hasCycle(head.next);
		}
		return false;
	}

	public static void doArray(){
		int a[] =  {1,2,3,4,5,6,7};
		int num = a.length;
		int move =6;

		printArray(a);
		int modPos = 0;
		for (int i = 0;i<num-1;i++){
			int temp;
			int newPos = modPos - move;
			if (newPos < 0)
			{
				newPos = num + newPos;
			}
			temp = a[newPos];
			a[newPos] = a[0];
			a[0] = temp;
			modPos = newPos;
		}

		printArray(a);
	}
	public static char getOpposite(char p){
		char res = ' ';
		switch (p) {
		case '(':
			res = ')';
			break;
		case '{':
			res = '}';
			break;
		case '[':
			res = ']';
			break;
		default:
			break;
		}
		return res;
	}
	public static boolean isBalanced(String expression) {
		boolean result = true;
		if (expression.length() %2 != 0){
			result = false;
		}
		int center = expression.length()/2;
		for (int i = 0 ;i<center;i++){
			char current =getOpposite( expression.charAt(i));
			char opposite = expression.charAt(expression.length()-1-i);
			if (current != opposite){
				result = false;
			}					
		}
		return result;
	}

	public static void printArray(int[] a){
		for (int p : a){
			System.out.print(p);
			System.out.print(" ");
		}
		System.out.println();

	}

}
