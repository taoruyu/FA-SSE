import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Readtxt {
    /**
     * ï¿½ï¿½È¡txtï¿½Ä¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
     * @param file ï¿½ï¿½Òªï¿½ï¿½È¡ï¿½ï¿½ï¿½Ä¼ï¿½ï¿½ï¿½ï¿½ï¿½
     * @return ï¿½ï¿½ï¿½ï¿½ï¿½Ä¼ï¿½ï¿½ï¿½ï¿½ï¿½
     * @throws IOException 
     */
	
	
	
    public static List<String[]> keywordString(File file,String k) throws IOException{
            //StringBuilder result = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));//ï¿½ï¿½ï¿½ï¿½Ò»ï¿½ï¿½BufferedReaderï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½Ä¼ï¿½
            String s = null;
            int flag =0;
            
            List<String[]> other =new ArrayList<>();
            while((s = br.readLine())!=null){//Ê¹ï¿½ï¿½readLineï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ò»ï¿½Î¶ï¿½Ò»ï¿½ï¿½

                String [] r = s.split("keyword");
                for (int i = 0; i < r.length-1; i++) {
                
                	if(r[i].equals(k))
                	{
                		//System.out.println(r[i]+"   "+k);
                		flag++;
                		other.add(r[r.length-1].split("alice"));
                		//break;
                	}
				}
                //System.out.println("===============");
            }
            br.close(); 
//            for (int i = 0; i < other.size(); i++) {
//				
//					System.out.println(other.get(i)[0]+"**"+other.get(i)[1]+"**"+other.get(i)[2]+"**"+other.get(i)[3]);
//				
//			}
            if(flag==0)
            {
            	JOptionPane.showMessageDialog(null, "¶Ô²»Æð×ÖµäÖÐ²¢ÎÞ¸Ã¹Ø¼ü´Ê¼ÇÂ¼£¡£¡£¡Çë³¢ÊÔÊ¹ÓÃÔöÇ¿ËÑË÷", "Sorry", JOptionPane.ERROR_MESSAGE);
            	Login.buttonre.setEnabled(true);
            }
            
            
            return other;
       // return result.toString();
        
    }
	
    
    
    public static List<String[]> idString(File file,String id, int relativity) throws IOException{
        // StringBuilder result = new StringBuilder();
        
             BufferedReader br = new BufferedReader(new FileReader(file));//ï¿½ï¿½ï¿½ï¿½Ò»ï¿½ï¿½BufferedReaderï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½Ä¼ï¿½
             String s = null;
             //int flag =0;
             //String [][] other={};
             List<String[]> other =new ArrayList<>();
             //Vector<String> v =  new Vector<>();
             while((s = br.readLine())!=null){//Ê¹ï¿½ï¿½readLineï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ò»ï¿½Î¶ï¿½Ò»ï¿½ï¿½

                 String [] r = s.split("keyword");
                 String ID = r[r.length-1].split("alice")[0];
                 
                 
                 	if(ID.equals(id))
                 	{
                 	//	System.out.println("ï¿½ï¿½ï¿½Öµï¿½ï¿½ï¿½ï¿½Òµï¿½ï¿½ï¿½ï¿½ï¿½Ó¦ï¿½Ä¼ï¿½Â¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½");
                 		//flag++;
                 		String[] tem = new String[5];
                 		//String keyword = r[0]+","+r[1]+","+r[2]+","+r[3]+","+r[4];
                 		tem[2] = Login.textField.getText();
                 		tem[0] = ID;
                 		tem[1] = new String (EncDec.AESDncode("alicelovebob", EncDec.parseHexStr2Byte(r[r.length-1].split("alice")[1])));
                 		//System.out.println("========="+tem[1]);
                 		tem[3] = r[r.length-1].split("alice")[2];
                 		tem[4] = relativity+"";
                 		other.add(tem);
                 		//continue;
                 	}
 				
                 //System.out.println("===============");
             }
             br.close(); 
             
        
             
             
             return other;
        // return result.toString();
         
     }
    
    
    public static String txt2String(File file) throws FileNotFoundException{
    	StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//ï¿½ï¿½ï¿½ï¿½Ò»ï¿½ï¿½BufferedReaderï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½Ä¼ï¿½
            String s = null;
            while((s = br.readLine())!=null){//Ê¹ï¿½ï¿½readLineï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ò»ï¿½Î¶ï¿½Ò»ï¿½ï¿½
                result.append(s+System.lineSeparator());
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    
    public static void main(String[] args){
        
       File file = new File("z");
     
    }
}



