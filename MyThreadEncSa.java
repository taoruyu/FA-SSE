import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
///import java.util.Date;

public class MyThreadEncSa extends Thread {
	public int[] sa;
	public FileWriter fw;
	public MyThreadEncSa(int[] sa,FileWriter fw)
	{
		this.sa = sa;
		this.fw = fw;
	}
   public void run(){

  
	try {
		
	     for(int j = 0; j < sa.length; j++) {
					//fw.write(EncDec.AESEncode("alicelovebob", String.valueOf(sa[j]))+"alice");
	    	fw.write(EncDec.parseByte2HexStr(EncDec.AESEncode("alicelovebob", sa[j]+""))+""+"alice");
		}
	     fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//     Date day=new Date();    
//	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	    System.out.println("锟斤拷锟斤拷SA锟斤拷锟斤拷锟斤拷时锟斤拷"+df.format(day)); 
     return;
   }
}
