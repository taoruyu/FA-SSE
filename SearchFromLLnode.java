
public class SearchFromLLnode {
//public static int oneaddrstart(int addr,String [] FMF,String[] FML,int len,String [] SEARCHF,String SEARCHL,String[] llset,int type)
//{
////	System.out.println("addr is��"+addr);   //String search = BwtEncode.StringFilter(BwtEncode.replaceBlank(Login.textField.getText().toLowerCase()));
////	System.out.println("FMF[addr] is��"+FMF[addr]);
////  System.out.println("FML[addr] is��"+FML[addr]);
//
//	//System.out.println("F LEN is��"+FMF.length);
//	 String search =""; 
//	 if(type==0)
//	 {
//	   search = BwtEncode.StringfuzzyFilter(BwtEncode.replaceBlank(Login.textField.getText().toLowerCase()));
//	 }else{
//	   search = BwtEncode.StringfuzzyFilter(BwtEncode.replaceBlank(Login.str.toLowerCase()));
//	 }
//	 int maxerronum = 0;
//	 int erronum = 0;
////	 System.out.println(search.length()==SEARCHF.length);
//	 int i =0;
//	 String Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
//	 String Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//	 String Fkfrlcl = FML[addr].split("bob")[1];
//	 System.out.println("Fkfrfcf is : "+Fkfrfcf);
//	 System.out.println("Fkfcl is : "+Fkfcl);
//	 System.out.println("Fkfrlcl is : "+Fkfrlcl);
////	 System.out.println("Xor.twoStrXor(Fkfrfcf, FML[addr]) is: "+Xor.twoStrXor(Fkfrfcf, FML[addr]));
////	 System.out.println("SEARCHF[len-i-1] is: "+SEARCHF[len-i-1]);
//	 i=1;
//     while(i<=len-1) 
//     {
//    	if( Fkfcl.equals(SEARCHF[len-i-1]))
//    	{
//    		//System.out.println("++++Xor.twoStrXor(Fkfcl,Fkfrlcl) : "+Xor.twoStrXor(Fkfcl,Fkfrlcl));
//	    	addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
//	    	System.out.println("++++here addr is : "+addr);	
//		    if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
//		    {
//		        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
//		        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//		   	    Fkfrlcl = FML[addr].split("bob")[1];
//		    }
//		    else
//		    {
//		    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
//		    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//		   	    Fkfrlcl = FML[addr].split("bob")[1];
//		    }
//		    	System.out.println("Fkfrfcf : "+Fkfrfcf);
//		    	i++;
//    	}else{
//    		
// 
//    		
//    		if(search.charAt(len-i-1)=='*')
//    		{
//	    		addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
//	    		if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
//			    {
//			        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
//			        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//			   	    Fkfrlcl = FML[addr].split("bob")[1];
//			    }
//			    else
//			    {
//			    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
//			    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//			   	    Fkfrlcl = FML[addr].split("bob")[1];
//			    }
//	 
//			    	i++;
//	    		} 
//    		else if(search.charAt(len-i-1)!='*'&& !Fkfcl.equals(SEARCHF[len-i-1]))
//	    		{
//    			addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
//	    		if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
//			    {
//			        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
//			        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//			   	    Fkfrlcl = FML[addr].split("bob")[1];
//			    }
//			    else
//			    {
//			    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
//			    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
//			   	    Fkfrlcl = FML[addr].split("bob")[1];
//			    }
//	 
//			    	i++;
//			    	erronum ++;
//			    	if(erronum>maxerronum)
//			    	{
//			    		return -1;
//			    	}
//	    		}
//    	}
//	   
//     }
//     //System.out.println("i is"+i);
//
//     if(i==len)
//     {
//       //  System.out.println(addr);
//    	 return addr;
//     }
//     else{
//    	 return -1;
//     }
//}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
