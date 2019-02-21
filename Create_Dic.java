import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Create_Dic {
	static int count=0;
	static String dic_path ="E:/workspace/code/code/Dictionary/dics.txt";
	public static void Create_Dic(String id, String tit,String EDad,String EAFMad,String path) throws IOException {
		 
		 String[] a = path.split("/");
		 String name = a[a.length-1].split(".txt")[0];
		 String [] title_keyword = name.split("%");
		 String[] keys=new String[5];
		 int klen = title_keyword.length-1;
//		System.out.println("len "+title_keyword.length);
//		for (int i = 0; i < title_keyword.length; i++) {
//			System.out.println("=="+title_keyword[i]);
//		}
         if(klen<=5)
         {
        	 for (int i = 0; i < klen; i++) {
        		 keys[i] = BwtEncode.StringFilter(BwtEncode.replaceBlank(title_keyword[i+1].toLowerCase()));
			}
        	 for (int j = klen; j < 5; j++) {
        		 keys[j] = "";
			}
        	
         }else
         {
        	 for (int i = 0; i < 5; i++) {
        		 keys[i] = BwtEncode.StringFilter(BwtEncode.replaceBlank(title_keyword[i+1].toLowerCase()));
			}
         }
         
//         for (int i = 0; i < keys.length; i++) {
//			System.out.println("===="+keys[i]);
//		}
		 //File oldFile = new File(path); 
		// oldFile.getParent()+title_keyword[0];
		 
		FileWriter fwdp =new FileWriter(dic_path,true);
		
		//for(int i=0;i<5;i++){
			//dics[i]=new Dic();
			//String title=tit;
			//byte[] title=Des.DES(tit);
			//String EEAFMad=EEAFMad;
			//byte[] EAFMad=Des.DES(AFMad);
			//byte[] EEDad=EDad.getBytes();
			//byte[] EEDad=Des.DES(EDad);
//		System.out.println("k0"+keys[0].toLowerCase());
//		System.out.println("k1"+keys[1].toLowerCase());
//		System.out.println("k2"+keys[2].toLowerCase());
//		System.out.println("k3"+keys[3].toLowerCase());
//		System.out.println("k4"+keys[4].toLowerCase());
			fwdp.write(SHAR_1.bcSHA1(keys[0].toLowerCase(),1)+"keyword"+SHAR_1.bcSHA1(keys[1].toLowerCase(),1)+"keyword"+SHAR_1.bcSHA1(keys[2].toLowerCase(),1)+"keyword"+SHAR_1.bcSHA1(keys[3].toLowerCase(),1)+"keyword"+SHAR_1.bcSHA1(keys[4].toLowerCase(),1)+"keyword"+id+"alice"+EncDec.parseByte2HexStr(EncDec.AESEncode("alicelovebob", title_keyword[0]))+"alice"+EDad+"alice"+EAFMad+"\r\n");
		//}
		fwdp.close();
	}
	
//	private void create_list(Dic[] dics) {
//		// TODO Auto-generated method stub
//		List resultList = new ArrayList<>(dics.length);
//		for (Object o : dics) {
//		    resultList.add(o);
//		}
//	}
//	private static Dic[] DeserializeSet_nodes(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(path)));
//		Dic[] set_nodes=(Dic[])ois.readObject();
//		return set_nodes;
//	}
//	public static void SerializeSet_dics(	Dic[] dics,String filepath) throws FileNotFoundException, IOException {
//		// TODO Auto-generated method stub
//		ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(filepath));
//		oo.writeObject(dics);
//		oo.close();
//	}
}
