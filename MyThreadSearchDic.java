import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MyThreadSearchDic extends Thread {
//public String [] searchf;
//public String [] searchl;
public String search;
public int type = 0;
public String []id; 


public MyThreadSearchDic(String search,int type) {
//	this.searchf = searchf;
//	this.searchl = searchl;
	this.search = search;
	this.type = type;
	
}
//public String kfkeyword(String kf)
//{
//	return S
//}
@Override
public void run() {
	// TODO Auto-generated method stub
	File file = new File("E:\\workspace\\code\\code\\Dictionary\\dics.txt");
	
	//String[] tem=null;
		try {
			List<String[]> other  = Readtxt.keywordString(file,SHAR_1.bcSHA1(search,1));
			
			
			
			if(type==0)
			{
				for (String[] strings : other) {
					 Vector<String> row = new Vector<>(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
					
						 row.add(strings[0]);
						//System.out.println(strings[0]);
						
						row.add(new String(EncDec.AESDncode("alicelovebob",EncDec.parseHexStr2Byte(strings[1]))));
						row.add(Login.textField.getText());
						row.add(strings[2]);
						//System.out.println(strings[2]);
						row.add("Max");
						Login.rowdata.add(row);
					
					
				}
			}
			else{
				for (int i = 0; i < id.length; i++) {
			   
				for (String[] strings : other) {
					 Vector<String> row = new Vector<>(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
					 if(strings[0].equals(id[i]))
							{
								 row.add(strings[0]);
								//System.out.println(strings[0]);
								row.add(new String (EncDec.AESDncode("alicelovebob",EncDec.parseHexStr2Byte(strings[1]))));
								row.add(Login.str);
								row.add(strings[2]);
								row.add("Max");
								Login.rowdata.add(row);
							}
						}
					}
				}
			Login.table.updateUI();

			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
