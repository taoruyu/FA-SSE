import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

//??????????????????????????????????UDP??????????  
class EchoSenderThread extends Thread {  
	public int type = -3;//a=0???????????
	public String[] fl ={"",""};
	public byte[] sa={};
	public byte[] des = {};
	public String id = "";
	//public Dic[] record=null;
	public String search = "";
	public String id0 = "";
	public String lines = "";
	//public String searchl = "";
    public EchoSenderThread(int type){//????????????????,??????????????????
       this.type=type;
    }  
    //?????UDP Socket  
    DatagramSocket theSocket;  
  
    public EchoSenderThread() throws SocketException {  
        this.theSocket = new DatagramSocket();  
        //
        theSocket.connect(new InetSocketAddress(Send.DEFAULT_HOSTNAME, Send.DEFAULT_PORT)); 
    }  
    
	
      
      
    public void run() {  
    	
            try {
    
            	if(type==-3)
            	{System.out.println("????????"); return; }
            	if(type==-2)   //-2????record
            	{
            		System.out.println("here is server,send search result to client .");
            		File dir = new File("D:\\java\\LoginDemo\\server_result");
					dir.mkdirs();
			
					File file=new File("D:\\java\\LoginDemo\\server_result\\result.txt");
					FileOutputStream foos =new FileOutputStream(file);
					if(!file.exists()){
						file.createNewFile();
					}
									String t ="n";
        		
        		    byte[] data  = t.getBytes(); 
        			DatagramPacket dp = new DatagramPacket(data, data.length, theSocket.getInetAddress(), theSocket.getPort());
        			theSocket.send(dp);
        			return;
            	}
            	if(type==-1) //
            	{
            	 System.out.println("?????????");
           		 System.out.println(search);
           	
                
                byte[] seardata  = (search+"k").toString().getBytes();
             
                DatagramPacket dop = new DatagramPacket(seardata, seardata.length, theSocket.getInetAddress(), theSocket.getPort());
                theSocket.send(dop);
           
            		return;
            	}
            	
            	if(type==0) //reinforce
            	{
            		 System.out.println("reinFore????");
            		 System.out.println(search);
            		 String [] searchchar = search.split("bob");

            		
            
            	}
            	
                if(type==1)//???
                {
                
            
                	
				   FileWriter fw = new FileWriter("E:/workspace/code/code/EncFile/"+id+".txt",false);
				   MyThreadWF mtw = new MyThreadWF(lines, fw);
				   mtw.run();
				   Date day=new Date();
				    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                   
				    System.out.println(id+".txt±£´æÍê±Ï"+df.format(day));
				   

//                   byte[] llset  = ("llset").getBytes();
//                   DatagramPacket dop = new DatagramPacket(llset, llset.length, theSocket.getInetAddress(), theSocket.getPort());
//                   theSocket.send(dop);
                   return;
                 }

                //}
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }   
        }  
      

    
    //???UDP Socket?????  
    public DatagramSocket getTheSocket() {  
        return theSocket;  
    }  
  
    public void setTheSocket(DatagramSocket theSocket) {  
        this.theSocket = theSocket;  
    }  
      
}  