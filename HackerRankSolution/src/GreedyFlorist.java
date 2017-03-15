import java.util.Arrays;


public class GreedyFlorist {

	public static int getMinimumPayment(int[] prices, int buyer){
		int result = 0;
		Arrays.sort(prices);
		int counter = 1;
		int numBuyer = buyer;
		for (int i = prices.length-1;i > -1;i--){
			result += counter*  prices[i] ;
			numBuyer--;
			if (numBuyer == 0){
				counter++;
				numBuyer= buyer;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] flowerPrice = {2,5,6};
		
		System.out.println(getMinimumPayment(flowerPrice, 3));
	}

}
