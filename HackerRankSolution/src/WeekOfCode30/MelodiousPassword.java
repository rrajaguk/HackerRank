package WeekOfCode30;

import java.util.HashSet;
import java.util.Scanner;

public class MelodiousPassword {

	public static void append(String SB,boolean lastVocal,int pos, int max){
		if (pos == max){
			System.out.println(SB);
			return;
		}
		if (pos == 0){
			for (int i = 0;i<p.length;i++){
				if (HS.contains(p[i])){
					append(""+p[i],true,pos+1,max);
				}else{
					append(""+p[i],false,pos+1,max);						
				}
			}
			return;
		}
		if (lastVocal){
			for (int i=0;i<nor.length;i++){
				append(SB+nor[i], false, pos+1, max);
			}
		}else {
			for (int i=0;i<vow.length;i++){
				append(SB+vow[i], true, pos+1, max);
			}
		}
	}
	


static char[] p = {'w','t','v','g','l','o','h','i','x','q','j','r','k','p','a','m','d','e','z','c','n','u','b','f','s'};
static char[] nor = {'w','t','v','g','l','h','x','q','j','r','k','p','m','d','z','c','n','b','f','s'};
static char[] vow = {'o','i','a','e','u'};
static HashSet<Character> HS = new HashSet<>();

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	HS.add('a');
	HS.add('e');
	HS.add('o');
	HS.add('i');
	HS.add('u');
	append("", true, 0, n);
	int j = in.nextInt();
}
}
