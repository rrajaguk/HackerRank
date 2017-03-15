import javax.xml.bind.DatatypeConverter;


public class insertA5 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] fci= DatatypeConverter.parseHexBinary("6F1F8407A0000000041010A514500A4D617374657243617264BF0C059F4D020B0A0000000000000000000000000000000000000000000000000000000000");
		byte[] newA5= DatatypeConverter.parseHexBinary("8407BBBBBBBBBBBBCC");		
		insertA5(fci,newA5);		
		System.out.println(DatatypeConverter.printHexBinary(fci));

		byte[] fci2= DatatypeConverter.parseHexBinary("6F1F8407A0000000041010A514500A4D617374657243617264BF0C059F4D020B0A0000000000000000000000000000000000000000000000000000000000");
		byte[] newA52= DatatypeConverter.parseHexBinary("8408AABBBBBBBBBBBBCC");		
		insertA5(fci2,newA52);		
		System.out.println(DatatypeConverter.printHexBinary(fci2));
		
		byte[] fci3= DatatypeConverter.parseHexBinary("6F1F8407A0000000041010A514500A4D617374657243617264BF0C059F4D020B0A0000000000000000000000000000000000000000000000000000000000");
		byte[] newA53= DatatypeConverter.parseHexBinary("8406BBBBBBBBBBCC");		
		insertA5(fci3,newA53);		
		System.out.println(DatatypeConverter.printHexBinary(fci3));
		
	}

	private static void insertA5(byte[] fci, byte[] newA5) {
	
		int lengthAIDPos = 3;
		if (fci[1] == (byte)0x80){
			lengthAIDPos = 4;
		}
		if (newA5.length == (short)(fci[lengthAIDPos] + 2)){
			for (int i= 0;i<newA5.length;i++){
				fci[lengthAIDPos-1 + i] = newA5[i];
			}
    	}else {
    		short A5Pos = (short)(lengthAIDPos + fci[lengthAIDPos] + 1);
    		short A5Length = (short) ((short)0x00FF & fci[(short)A5Pos + 1]);
    		if (A5Length == (short)0x80){
    			A5Length = (short) ((short)0x00FF & fci[(short)A5Pos + 2]);
    		}
    		short newA5Pos = (short) ((short)(fci[lengthAIDPos] + 2) - newA5.length);
    		newA5Pos += A5Pos;
    		for (int i= 0;i<A5Length;i++){
				fci[newA5Pos+i] = fci[A5Pos + i];
			}
    	    
    	}
		
	}

}
