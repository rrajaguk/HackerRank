package SynchronousShopping;
import java.util.Scanner;


public class SynchronousShopping {

	public static boolean isVisited(int pos, int[] visited){
		if (visited[pos] == 1){
			return true;
		}else {
			return false;
		}
	}
	public static void setVisited(int pos, int[] visited){
		visited[pos] = 1;		
	}
	public static boolean isAllFishBought(int[] fishBought){
		for (int i = 0;i<fishBought.length; i++){
			if (fishBought[i] == 0){
				return false;
			}
		}
		return true;
	}
	public static boolean needToBuyFromThisStore(int[] fishBough, ShoppingCenter sc){
		boolean result = false;
		
		for (int fish : sc.fishSell){
			if (fishBough[fish-1] == 0){
				result = true;
			}
		}
		
		return result;
	}
	
	public static void interleave(int[] source, int[] target){
		for (int i = 0;i< source.length;i++){
			if (source[i] == 1 && target[i] == 1){
				target[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int numShoppingCenter = in.nextInt();
        int numRoad = in.nextInt();
        int numFish = in.nextInt();
        
        int[] visitedShoppingCenterBySmall = new int[numShoppingCenter];
        int[] visitedShoppingCenterByBig = new int[numShoppingCenter];
        int[] visitedShoppingCenterTogether = new int[numShoppingCenter];
        int[] boughtFish	= new int[numFish];
        
        ShoppingCenter[] listOfShoppingCenter = new ShoppingCenter[numShoppingCenter];
        for (int i = 0; i<numShoppingCenter;i++){
        	int numOfFishSold = in.nextInt();
        	for (int j = 0;j<numOfFishSold;j++){
        		listOfShoppingCenter[i] = new ShoppingCenter(i+1);
        		listOfShoppingCenter[i].fishSell.add(in.nextInt());
        	}
        }
        
        for (int i=0; i< numRoad;i++){
        	int origin = in.nextInt();
        	int destination = in.nextInt();
        	int distance = in.nextInt();
        	Road curRoad= new Road(origin,destination,distance);
        	listOfShoppingCenter[origin-1].Neighbor.add(curRoad);
        	listOfShoppingCenter[destination-1].Neighbor.add(curRoad);
        }

        int posSmal = 0;
        int posBig = 0;
        
        int timeA = 0;
        int timeB = 0;
        setVisited(posSmal, visitedShoppingCenterBySmall);
        setVisited(posBig, visitedShoppingCenterByBig);
        setVisited(posBig, visitedShoppingCenterTogether);
        for (int fish : listOfShoppingCenter[posSmal].fishSell){
			boughtFish[fish-1] = 1;
		}
        while (posSmal != numShoppingCenter-1 || posBig != numShoppingCenter-1){
        	if (posSmal!= numShoppingCenter-1){
        		int nextNode = 0;
        		int minDistance = Integer.MAX_VALUE;
        		for (Road r : listOfShoppingCenter[posSmal].Neighbor)
        		{
        			int targetNode = 0;
        			if (r.destination-1 != posSmal){
        				targetNode= r.destination-1;
        			}else {
        				targetNode = r.origin-1;
        			}
        			if (minDistance> r.distance && !isVisited(targetNode, visitedShoppingCenterTogether)){
        				minDistance = r.distance;
        				nextNode = targetNode;
        				//timeA += r.distance;
        				
        				System.out.println("small go from " + (posSmal + 1) +" to "+ (nextNode+1) + (needToBuyFromThisStore(boughtFish, listOfShoppingCenter[targetNode])?" and buy":" but just passed"));
        			}
        		}
        		
        		posSmal = nextNode;
        		for (int fish : listOfShoppingCenter[posSmal].fishSell){
        			boughtFish[fish-1] = 1;
        		}
        		setVisited(posSmal, visitedShoppingCenterTogether);
        		setVisited(posSmal, visitedShoppingCenterBySmall);
        		if (posSmal == numShoppingCenter -1){
        			interleave(visitedShoppingCenterBySmall, visitedShoppingCenterTogether);
        		}
        	}
        	if (posBig!= numShoppingCenter-1){
        		int nextNode = 0;
        		int minDistance = Integer.MAX_VALUE;
        		for (Road r : listOfShoppingCenter[posBig].Neighbor)
        		{
        			int targetNode = 0;
        			if (r.destination-1 != posBig){
        				targetNode= r.destination-1;
        			}else {
        				targetNode = r.origin-1;
        			}
        			if (minDistance> r.distance && !isVisited(targetNode, visitedShoppingCenterTogether)){
        				minDistance = r.distance;
        				nextNode = targetNode;
        				//timeB += r.distance;
        				System.out.println("big go from " + (posBig +1) +" to "+ (nextNode+1)+ (needToBuyFromThisStore(boughtFish, listOfShoppingCenter[targetNode])?" and buy":" but just passed"));
        			}
        		}
        		
        		posBig= nextNode;
        		for (int fish : listOfShoppingCenter[posBig].fishSell){
        			boughtFish[fish-1] = 1;
        		}
        		setVisited(posBig, visitedShoppingCenterByBig);
        		setVisited(posBig, visitedShoppingCenterTogether);
        		if (posBig == numShoppingCenter -1){
        			interleave(visitedShoppingCenterByBig, visitedShoppingCenterTogether);
        		}
        	}
        }
        
        System.out.println("Total Time = " + Math.max(timeA,timeB));
        System.out.println("End");
        
	}

}
