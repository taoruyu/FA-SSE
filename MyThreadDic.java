import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;


public class MyThreadDic extends Thread {
	public String id;
	public String name;
	public String EDad;
	public String EAFMad;
	public String path;
public MyThreadDic(String id,String name,String EDad,String EAFMad,String path) {
	// TODO Auto-generated constructor stub
	this.id = id;
	this.name = name;
	this.EAFMad = EAFMad;
	this.EDad = EDad;
	this.path = path;
}
@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
		//Create_Dic.Create_Dic(this.id, this.name, "E:/workspace/code/code/EncFile/"+id+".txt", "E:/workspace/code/code/FLSA/"+id+"/");

		Create_Dic.Create_Dic(this.id, this.name, this.EDad, this.EAFMad,this.path);

//		Date day=new Date();    
//	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	    System.out.println("�����ֵ�Dic��ʱ��"+df.format(day)); 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
