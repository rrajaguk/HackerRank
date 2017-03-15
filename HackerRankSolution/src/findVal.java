
public class findVal {
	static boolean findValDiv(int[] vals,int start, int end, int targetDiv){
		int numDiv = 0;
		for (int i=start;i<end;i++){
				if (vals[i]% targetDiv== 0){
					numDiv++;
				}
			}
			if (numDiv == vals.length -1){
				return true;
			}
		return false;
	}
	public static void main(String[] args) {
		int[] val = {4,7,21,28};
		
		int dim = 2;
		while (!findValDiv(val, 0, val.length, dim)){
			dim++;
		}
		System.out.println(dim);
		
	}
}
