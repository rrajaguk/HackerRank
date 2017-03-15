
public class CamelCase {

	public static int getWords(String val){
		int result = 1;
		char[] p = val.toCharArray();
		for (int i = 0;i<val.length();i++){
			if (p[i]>='A' && p[i] <= 'Z'){
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getWords("saveChangesInTheEditor"));
	}

}
