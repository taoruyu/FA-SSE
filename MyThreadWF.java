import java.io.FileWriter;
import java.io.IOException;

public class MyThreadWF extends Thread {
	public String content;
	public FileWriter fw;
	public MyThreadWF(String c,FileWriter f)
	{
		content = c;
		fw = f;
	}
   public void run(){
     try {
		fw.write(EncDec.parseByte2HexStr(EncDec.AESEncode("alicelovebob", content)));
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return;
   }
}
