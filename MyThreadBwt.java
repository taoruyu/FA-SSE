import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;

public class MyThreadBwt extends Thread {
	public String[] bwt = {"",""};
	
	public String lines;
	public FileWriter fw1;
	public FileWriter fw2;
	public MyThreadBwt(String lines,FileWriter fw1,FileWriter fw2)
	{
		
		this.lines = lines;
		
		this.fw1 = fw1;
		this.fw2 = fw2;
	}
   public void run(){
	   
	   bwt = BwtEncode.BWTFM(BwtEncode.StringFilter(BwtEncode.replaceBlank(this.lines.toLowerCase())));
	 
			try {
				this.fw1.write(bwt[0]);
				this.fw2.write(bwt[1]);
//				Date day=new Date();    
//			    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//			    System.out.println("Bwtï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ï¿½"+df.format(day)); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
	  
			
		
	   try {
		fw1.close();
		fw2.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	//   System.out.println("Bwt½áÊø");
   }
}
