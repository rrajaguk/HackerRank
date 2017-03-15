
public class MaximizingXOR {
    static int maxXor(int l, int r) {
    	int result = Integer.MIN_VALUE;
    	
    	for (int i= l ;i<=r;i++){
    		for (int j = i;j<=r;j++){
    			result = Math.max(result, i ^ j );
    		}
    	}
    	
    	return result;

    }
	public static void main(String[] args) {
		
		
		System.out.println(maxXor(10,15));
	}
}
