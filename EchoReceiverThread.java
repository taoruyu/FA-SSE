import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//�ͻ��˵Ľ����̣߳����ڽ��ܷ���˷��͵�Echo��Ϣ������ʾ  
class EchoReceiverThread extends Thread {  
      
    public DatagramSocket theSocket;  
    //public static int type = 0;  
    public String[] t ={"",""};
	public String sa = "";
	public byte[] des = {};
	public String id ="";
	//public static String keywordfind_result;
 public EchoReceiverThread()
 {
	 try {
			DatagramSocket socket = new DatagramSocket(Receive.DEFAULT_PORT,InetAddress.getByName(Receive.DEFAULT_HOSTNAME));
			theSocket = socket;	
	 } catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 }
    
    public void run() {
    	 
    	byte[] data = new byte[65536];  
        DatagramPacket dp = new DatagramPacket(data, 0, data.length); 
        int i = 0;	
        String t0 ="";
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        String t5="";
        String tr ="";
        String tn = "";
        while (true) {      	
 
            try {       	 
                //����ʽ�������ݰ�  
                theSocket.receive(dp);  
                //��ȡ���ݰ������ݲ���ӡ  
                
                String content = new String(dp.getData(), 0, dp.getLength()); 
               
                if(content!="")
                {
                	System.out.println("package from " + dp.getAddress().getHostName() + "/" + dp.getPort() + " : " + content);
                	//char flag  = content.charAt(content.length()-1);

                	 if(content=="llset")
                	 {
                		 System.out.println("�����Ƿ�����");
                		 System.out.println("���ڿ�ʼ����LLset");
	            		 System.out.println("---------------");
	            		 //new Login().table.repaint();
	            		//new Login().table.updateUI();
                	 }
                if(content=="")
                {
                	
                }
            }
                //���Ϊover���˳�  
                if (Send.END_FLAG.equalsIgnoreCase(content)) {  
                    break;  
                }  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        
     //   }  
    }
        System.out.println("EchoReceiverThread end : " + theSocket.getInetAddress());  
    }
//	private void set_keywordfind_result(String readFileToString) {
//		// TODO Auto-generated method stub
//		//this.keywordfind_result=readFileToString;
//	}  
//	public static String get_keywordfind_result(){
//		return keywordfind_result;
//	}
      
}  