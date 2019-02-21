import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PureReadtxt {
  public static String Prue(String path)
  {
	  FileInputStream inputStream = null;
	    Scanner sc = null;
	    String lines = "";
	    	int i=0;
	        String id0 = "";
	        try {
				inputStream = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sc = new Scanner(inputStream, "UTF-8");
	        lines="";
	        while (sc.hasNextLine()) {
	        	String line="";
	        	if (i==0){
	            id0 = sc.nextLine();
	            line = id0;i++;
	            }else{
	          
	        	line = sc.nextLine();
	            }
	            lines+= line;  
	        }
	        return lines;
  }
}
