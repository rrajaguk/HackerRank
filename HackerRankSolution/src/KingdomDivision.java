import java.util.LinkedList;
import java.util.List;


public class KingdomDivision {
	public static int getDivision(List<int[]> nodes, int size){
		int result = 0;
		int[] numberOfConnection = new int[size];
		for (int[] val : nodes){
			numberOfConnection[val[0] -1] += 1;
			numberOfConnection[val[1] -1] += 1;
		}
		int higherThanTwo = 0;
				for (int val : numberOfConnection){
			if (val >=2){
				higherThanTwo++;
			}
		}
		return (int) (higherThanTwo * 2 % (Math.pow(10, 9) + 7));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> val = new LinkedList<int[]>();
		int[] a = {1,2};
		val.add(a);
		int[] b = {1,3};
		val.add(b);
		int[] c = {3,4};
		val.add(c);
		int[] d = {3,5};
		val.add(d);
		
		System.out.println(getDivision(val, 5));
	}

}
