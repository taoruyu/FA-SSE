
public class Xor {

	/**
	 * @param args
	 */
	
	  public static String twoStrXor(String str1, String str2) {
//        byte b1[] = str1.getBytes();
//        byte b2[] = str2.getBytes();
//        byte longbytes[],shortbytes[];
//        if(b1.length>=b2.length){
//            longbytes = b1;
//            shortbytes = b2;
//        }else{
//            longbytes = b2;
//            shortbytes = b1;
//        }
//        byte xorstr[] = new byte[longbytes.length];
//        int i = 0;
//        for (; i < shortbytes.length; i++) {
//            xorstr[i] = (byte)(shortbytes[i]^longbytes[i]);
//        }
//        for (;i<longbytes.length;i++){
//            xorstr[i] = longbytes[i];
//        }
//        return new String(xorstr);

    	if(str1.contains(str2)||str2.contains(str1))
    	{
    		if(str1.contains(str2))
    		{
    			//str1 = str1.substring(3,str1.length());
    			return str1.replaceFirst("XOR","").replaceFirst(str2, "");
    		}
    		if(str2.contains(str1))
    		{
    			//str2 = str2.substring(3,str2.length());
    			return str2.replaceFirst("XOR","").replaceFirst(str1, "");
    		}
    	}
    	return str1+"XOR"+str2;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
