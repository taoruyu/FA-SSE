import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class MyThreadSearchLLsettoFM extends Thread {
public String[] pathcontent;
public String[] contentsearch;
public String[] llset;
public String[] FMF;
public String[] FML;
public String[] FMSA;
public String FklTm;
public int type = 0;
public MyThreadSearchLLsettoFM(String[] pathcontent,String[] contentsearch,String FklTm,int type) {
	// TODO Auto-generated constructor stub
	this.pathcontent = pathcontent;
	this.contentsearch = contentsearch;
	this.FklTm = FklTm;
	this.type = type;
}

public static int oneaddrstart(int addr,String [] FMF,String[] FML,int len,String [] SEARCHF,String SEARCHL,String[] llset,int type)
{
//	System.out.println("addr is��"+addr);   //String search = BwtEncode.StringFilter(BwtEncode.replaceBlank(Login.textField.getText().toLowerCase()));
//	System.out.println("FMF[addr] is��"+FMF[addr]);
//  System.out.println("FML[addr] is��"+FML[addr]);

	//System.out.println("F LEN is��"+FMF.length);
	 String search =""; 
	 
	 if(type==0)
	 {
	   search = BwtEncode.StringfuzzyFilter(BwtEncode.replaceBlank(Login.textField.getText().toLowerCase()));
	 }else{
	   search = BwtEncode.StringfuzzyFilter(BwtEncode.replaceBlank(Login.str.toLowerCase()));

	 }
	 int maxerronum = 0;
	 int erronum = 0;
//	 System.out.println(search.length()==SEARCHF.length);
	 int i =0;
	 String Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
	 String Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
	 String Fkfrlcl = FML[addr].split("bob")[1];
//	 System.out.println("Fkfrfcf is : "+Fkfrfcf);
//	 System.out.println("Fkfcl is : "+Fkfcl);
//	 System.out.println("Fkfrlcl is : "+Fkfrlcl);
//	 System.out.println("Xor.twoStrXor(Fkfrfcf, FML[addr]) is: "+Xor.twoStrXor(Fkfrfcf, FML[addr]));
//	 System.out.println("SEARCHF[len-i-1] is: "+SEARCHF[len-i-1]);
	 i=1;
     while(i<=len-1) 
     {
    	if( Fkfcl.equals(SEARCHF[len-i-1]))
    	{
    		//System.out.println("++++Xor.twoStrXor(Fkfcl,Fkfrlcl) : "+Xor.twoStrXor(Fkfcl,Fkfrlcl));
	    	addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
	    //	System.out.println("++++here addr is : "+addr);	
		    if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
		    {
		        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
		        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
		   	    Fkfrlcl = FML[addr].split("bob")[1];
		    }
		    else
		    {
		    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
		    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
		   	    Fkfrlcl = FML[addr].split("bob")[1];
		    }
		 //   	System.out.println("Fkfrfcf : "+Fkfrfcf);
		    	i++;
    	}else{
    		
 
    		
    		if(search.charAt(len-i-1)=='?')
    		{
	    		addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
	    		if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
			    {
			        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
			        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
			   	    Fkfrlcl = FML[addr].split("bob")[1];
			    }
			    else
			    {
			    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
			    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
			   	    Fkfrlcl = FML[addr].split("bob")[1];
			    }
	 
			    	i++;
	    		} 
    		else if(search.charAt(len-i-1)!='?'&& !Fkfcl.equals(SEARCHF[len-i-1]))
	    		{
    			addr =  SearchFgetaddr.Search_F_getaddr(Fkfcl+"XOR"+Fkfrlcl,FMF);
	    		if(!Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]).contains("XOR"))
			    {
			        Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
			        Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
			   	    Fkfrlcl = FML[addr].split("bob")[1];
			    }
			    else
			    {
			    	Fkfrfcf = Xor.twoStrXor(Fkfcl,FMF[addr]);
			    	Fkfcl = Xor.twoStrXor(Fkfrfcf, FML[addr].split("bob")[0]);
			   	    Fkfrlcl = FML[addr].split("bob")[1];
			    }
	 
			    	i++;
			    	erronum ++;
			    	if(erronum>maxerronum)
			    	{
			    		return -1;
			    	}
	    		}
    	}
	   
     }
     //System.out.println("i is"+i);

     if(i==len)
     {
       //  System.out.println(addr);
    	 return addr;
     }
     else{
    	 return -1;
     }
}

@Override
	public void run() {
	int len = contentsearch.length;
	String[] SEARCHF = contentsearch;
	for (int a = 0; a < pathcontent.length; a++) 
	{
		int llnodeend_flag = 0;
		File file1 = new File(pathcontent[a]);
		String p = pathcontent[a].substring(0,pathcontent[a].length()-9);
		String FP = p+"F.txt";
		String LP = p+"L.txt";
		String SAP = p+"SA.txt";
	
	//System.out.println(p);
	
	try {
		llset = Readtxt.txt2String(file1).split("\r\n");
		 //FMF = Readtxt.txt2String(file2).split("alice");
		FMF = PureReadtxt.Prue(FP).split("alice");
	    // FML = Readtxt.txt2String(file3).split("alice");
		FML = PureReadtxt.Prue(LP).split("alice");
	    // FMSA = Readtxt.txt2String(file4).split("alice");
		FMSA = PureReadtxt.Prue(SAP).split("alice");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


//	for (int i = 0; i < contentsearch[0].length; i++) {
//		System.out.println("====="+i+"=====");
//		System.out.println(contentsearch[0][i]);
//		System.out.println(contentsearch[1][i]);
//		System.out.println("===========");
//	}
	
	int i =0 ;
	int addr =-1;
	//Vector addrsa = new Vector();
	int relativity = 0;
	int locllset = SearchLLset.searchllsetgetloc(llset, SEARCHF[len-i-1], FklTm);
	if(locllset==-1)
	{
		System.out.println(pathcontent[a]+"��û���ҵ�");
	}
	else
	{
		//String llsetchar = llset[locllset].split("==>")[0];
		String [] llsetnode = llset[locllset].split("==>")[1].split("==");
		for (int j = 0; j < llsetnode.length; j++) {
		     addr = Integer.parseInt(Xor.twoStrXor(FklTm,llsetnode[j]));//LLnode��ÿ����ַ
		   //if(Integer.parseInt(new String (EncDec.AESDncode("alicelovebob",EncDec.parseHexStr2Byte(FMSA[addr]))))<0){ llnodeend_flag=1;break;}
		      int endaddr = oneaddrstart(addr,FMF,FML,len,SEARCHF,FklTm,llset,type);
		     if(endaddr!=-1) //
		     {
		    	// addrsa.add(endaddr);  //�����addr�õ���SA����������
		    	String saend =  new String (EncDec.AESDncode("alicelovebob",EncDec.parseHexStr2Byte(FMSA[endaddr]))); 
		    	
		    	int sa_end = Integer.parseInt(saend);
		    	//System.out.println("end addr: "+endaddr);
		    	//System.out.println("first addr: "+addr);
		    	if(sa_end>=0)
		    	{
		    		String safirst =  new String (EncDec.AESDncode("alicelovebob",EncDec.parseHexStr2Byte(FMSA[addr]))); 
			    	int sa_first = Integer.parseInt(safirst);
		    		if(sa_first>=0)
		    		{
		    		// System.out.println(pathcontent[a]+"�е�LLnode�ĵ�"+j+"��node�ҵ���"+Login.textField.getText());
		    		 relativity++;
		    		}else{
		    		//	System.out.println(pathcontent[a]+"�е�LLnode�ĵ�"+j+"��node�ҵ���"+Login.textField.getText()+"���ǲ���������");
		    		}
		    	}
		    	else{
		    		//System.out.println(pathcontent[a]+"�е�LLnode�ĵ�"+j+"��node�ҵ���"+Login.textField.getText()+"����������");
		    	}
		     }else{
		    	// System.out.println(pathcontent[a]+"�е�LLnode�ĵ�"+j+"��nodeû���ҵ�"+Login.textField.getText());
		     }
		}
	}
	
	if(relativity>0)
	{
		//System.out.println(pathcontent[0].split("/")[pathcontent[0].split("/").length-2]);
		SearchDicbyid.Search_Dic_by_id(pathcontent[a].split("/")[pathcontent[a].split("/").length-2], relativity,type);
	}
	
	
////	for (int i = len-1; i > 0; i--)
////	{
//		for (int j = 0; j < llset.length; j++)
//		{
//			String llsetchar = llset[j].split("==>")[0];
//
//			if(llsetchar.equals(Xor.twoStrXor(SEARCHF[len-i-1],SEARCHL[len-i-1])))
//			{
//				matchchar++;
//				String[] llsetnode = llset[j].split("==>")[1].split("==");
//				for (int k = 0; k < llsetnode.length; k++)
//				{
//					int addr = Integer.parseInt(Xor.twoStrXor(SEARCHL[len-i-1],llsetnode[k]));//LLnode��ÿ����ַ
//					String Fkfrfcf = Xor.twoStrXor(FMF[addr],SEARCHF[len-i-1]);
//					while(Xor.twoStrXor(Fkfrfcf, FML[addr]).split("bob")[0].equals(SEARCHF[len-i-1]))
//					{ 	
//						if(len-i-1>0)
//					    {
//						   i++;
//						   matchchar++;
//					    }
//						
//						
//					}
//
//				}
//			}
//
//			
//		//}
//		if(matchchar==0)
//		{
//			System.out.println(pathcontent[a]+"��û�иùؼ���");
//			break;
//		}
//		if(matchchar==len)
//		{
//			System.out.println(pathcontent[a]+"�иùؼ���");
//			matchword ++;
//			//return sa;
//			break;
//		}
//	}

	}
	Date day = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println( "over end" + df.format(day));
	
	}



}
