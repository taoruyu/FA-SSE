import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;


public class MyThreadLLset extends Thread {
	public String id;
	public String F;
	public String lines;
	public FileWriter fw;
	public MyThreadLLset(String F,String id,String lines,FileWriter fw)
	{
		this.id = id;
		this.F = F;
		this.lines = lines;
		this.fw = fw;
	}
	
   public void run(){ 

	    F = BwtEncode.enCodeLineF(BwtEncode.StringFilter(BwtEncode.replaceBlank(lines.toLowerCase())));
	    //System.out.println("F IS:"+F);
		int index =0;
		for (int i = 0; i < F.length(); i++) {
			
			if(i==0)
			{
				try {
					this.fw.write(Xor.twoStrXor(SHAR_1.bcSHA1(F.charAt(i)+"",1),SHAR_1.bcSHA1(F.charAt(i)+"",2))+"==>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					this.fw.write(SHAR_1.bcSHA1(F.charAt(i)+"",2)+"XOR"+index+"");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;
				continue;
			}
			if(F.charAt(i)==F.charAt(i-1))
			{
				try {
					this.fw.write("==");
					this.fw.write(SHAR_1.bcSHA1(F.charAt(i)+"",2)+"XOR"+index+"");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;
//				if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
//				{
//					try {
//						this.fw.write("==");
//						this.fw.write(index+"");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}else
			{
				try {
					this.fw.write("\r\n"+Xor.twoStrXor(SHAR_1.bcSHA1(F.charAt(i)+"",1),SHAR_1.bcSHA1(F.charAt(i)+"",2))+"==>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					this.fw.write(SHAR_1.bcSHA1(F.charAt(i)+"",2)+"XOR"+index+"");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;
//				if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
//				{
//					try {
//						this.fw.write("==");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}
		

		}		try {
			this.fw.close();
			FileWriter fwp =new FileWriter("E:/workspace/code/code/LLsetPath/LLsetPath.txt",true);
			fwp.write("E:/workspace/code/code/FLSA/"+id+"/"+id+"LLset.txt"+"\r\n");
			fwp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Date day=new Date();    
//	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	    System.out.println("����LLset��ʱ��"+df.format(day)); 
   }

}
