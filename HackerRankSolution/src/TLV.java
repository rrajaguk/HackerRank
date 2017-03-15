import java.util.LinkedList;


public class TLV {
	public String Tag;
	public int Length;
	public String Value;
	public LinkedList<TLV> Childs;
	public int TotalConsumedSpace=0;
	public TLV(){
		Childs = new LinkedList<>();
	}
	public String getLengthInString(){
		
		if (Length > 127 && Length <= 255){
			return "81" + Integer.toHexString(Length).toUpperCase();
		}
		if (Length > 255){
			return "82" + Integer.toHexString(Length).toUpperCase();
		}
		if (Length < 15){
			return "0" + Integer.toHexString(Length).toUpperCase();
		}
		return Integer.toHexString(Length).toUpperCase();
	}
	private static int GetLength(String value, int starting){
		String ValIndicator = value.substring(starting,starting+2);
		int result = 0;
		switch (ValIndicator){
		case "81":
			result = Integer.parseInt(value.substring(starting+2,starting+4),16);
			break;
		case "82":
			result = Integer.parseInt(value.substring(starting+2,starting+6),16);
			break;
		default :
			result = Integer.parseInt(ValIndicator,16);
			break;				
		}
		
		return result;
		
	}
	public boolean populate(String value){
		
		this.Tag = value.substring(0,2);
		TotalConsumedSpace = 2;
		if (this.Tag.equals("9F")){
			this.Tag = value.substring(0,4);
			this.Length = GetLength(value,4);
			TotalConsumedSpace += 2;
		}else {
			this.Length = GetLength(value,2);
		}
		TotalConsumedSpace += getLengthInString().length();
		
		if (TotalConsumedSpace + this.Length *2 > value.length()){
			return false;
		}
		
		this.Value = value.substring(TotalConsumedSpace,TotalConsumedSpace+ this.Length* 2);
		TotalConsumedSpace+= this.Value.length();
		
		return true;
		
	}
}
