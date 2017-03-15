import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class PQueue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfCookies = in.nextInt();
		int targetCookiesSweetness = in.nextInt();
		
		
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(numOfCookies);
		
		for (int i = 0; i< numOfCookies;i++){
			integerPriorityQueue.add(in.nextInt());
		}
		
		int currentSweetness = integerPriorityQueue.peek();
		int numberOfMix = 0;
		while (currentSweetness< targetCookiesSweetness && integerPriorityQueue.size()>1){
			int leastSweetCookies = integerPriorityQueue.poll();
			int secondLeastSweetCookies  = integerPriorityQueue.poll();
			
			numberOfMix++;
			int newSweet = leastSweetCookies + 2*secondLeastSweetCookies;
			integerPriorityQueue.add(newSweet);
			
			currentSweetness = integerPriorityQueue.peek();
		}
		
		if (integerPriorityQueue.peek() < targetCookiesSweetness){
			numberOfMix = -1;
		}
		System.out.println(numberOfMix);
	}
}
