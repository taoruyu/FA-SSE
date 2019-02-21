import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Receive{  
   
    //�������ӵ�UDP Socket  
    public static DatagramSocket serverSocket;  
    //Ĭ�ϵ�������ַ  
    public static String DEFAULT_HOSTNAME = "localhost";  
    //Ĭ�ϵĶ˿�  
    public static int DEFAULT_PORT = 10000;    
    public static void main(String[] args) throws SocketException {  
        //��������˵Ķ��� 
    	new EchoReceiverThread().start();      
    }  
  
    public DatagramSocket getServerSocket() {  
        return serverSocket;  
    }  
  
    public void setServerSocket(DatagramSocket serverSocket) {  
        this.serverSocket = serverSocket;  
    }  
  
}  
 
