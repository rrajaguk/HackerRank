import java.util.LinkedList;


public class Trie {

	public static TrieData checkChild(LinkedList<TrieData> childs, char val){
		for (TrieData child : childs){
			if (child.val == val){
				return child;
			}
		}
		return null;
	}
	public static void add(TrieData head, String val){
		if (val.length() > 0){
			char curChar = val.charAt(0);
			if (head.val != curChar ){
				TrieData targetChild = checkChild(head.child, curChar);
				if (targetChild == null){
					TrieData newTrie = new TrieData();
					newTrie.val = curChar;
					head.child.add(newTrie);
					add(newTrie,val.substring(1));
				}else {
					add(targetChild,val.substring(1));
				}
			}else {
				TrieData newTrie = new TrieData();
				newTrie.val = curChar;
				head.child.add(newTrie);
				add(newTrie,val.substring(1));
			}
		}else {
			// add end marker
			TrieData endNode = new TrieData();
			endNode.val = '*';
			head.child.add(endNode);
		}
	}

	public static int findStar(TrieData head){
		if (head.val == '*'){
			return 1;
		}else{
			int result = 0;
			for (TrieData child : head.child){
				result += findStar(child);
			}
			return result;
		}
	}
	public static int find(TrieData head, String val){
		if (val.length() == 0 && head!= null){
			return findStar(head);
		}
		if (head == null){
			return 0;
		}
		char curChar = val.charAt(0);
		int result= 0;
		if (head.val == curChar){
			for (TrieData child : head.child){
				result += find(child, val.substring(1));
			}
			return result;
		}else {
			if (head.val != '*'){
				return 0;
			}
			for (TrieData child : head.child){
				result += find(child, val);
			}			 
			return result;
		}
	}

	public static void main(String[] args) {
		TrieData head = new TrieData();
		head.val ='*';

		add(head,"hack");
		add(head,"hackerrank");
		System.out.println(find(head,"hac"));
		System.out.println(find(head,"hak"));
		System.out.println(find(head,"hacker"));

	}
}
