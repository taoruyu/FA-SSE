import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s = "tttrryzzryyz";
		int [] sa = SuffixArray_with_pad.generateSA(s, s.length());
		for (int i = 0; i < sa.length; i++) {
			System.out.print(sa[i]+" ");
		}
		
		}
	}


