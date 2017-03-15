package WeekOfCode30;

public class FindTheMinimumNumber {

	public static String printMinimum(int num){
		StringBuilder SB = new StringBuilder();
		
		SB.append("min(int, int)");
		
		for (int i = 2; i<num;i++){
			SB.insert(0,"min(int, ");
			SB.append(")");
		}
		return SB.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printMinimum(50));
		
	}

}
