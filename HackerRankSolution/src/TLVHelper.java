import java.util.LinkedList;


public class TLVHelper {

	
	public static TLV parse(String value, TLV parent){
		if (value== null || value.length() < 4 )
		{
			return null;
		}
		TLV current = new TLV();
		boolean isTlv = current.populate(value);
		if (!isTlv){
			return null;
		}
		if (parent == null){
			parent = current;			
		}else {
			parent.Childs.add(current);
		}
		parse(current.Value, current);
		if (current.TotalConsumedSpace < value.length()){
			parse(value.substring(current.TotalConsumedSpace), parent );
		}
		return current;
		
	}
	
	public static void print(TLV val, int level){
		if (val == null){
			return;
		}
		StringBuilder SB = new StringBuilder();
		for (int i = 0; i< level;i++){
			SB.append(" ");
		}
		SB.append(val.Tag);
		SB.append(" ");
		SB.append(val.getLengthInString());
		SB.append(" ");
		level = SB.length() ;
		SB.append( val.Value );
		System.out.println(SB.toString());
		
		LinkedList<TLV> pooper = (LinkedList<TLV>) val.Childs.clone();
		TLV child = pooper.peek();
		while (child != null){
			print(pooper.pop(), level);
			child = pooper.peek();
		}
	}
}
