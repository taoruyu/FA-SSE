import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BwtEncode{ 
	public static String F ="";
	public static String L = "";
	public static  int rank[];
    public static String[] BWTFM(String str)
    {       
    	String F,L;
    	
        F = enCodeLineF(str);
        L = enCodeLineL(str);  
        String tmp1 = "";
        String[] t={"",""};
        int[] tmp2 = sortWithRank(F);
        int lenf = F.length();
        int lenl = L.length();

        for(int i=0;i<lenf;i++)
        {
//        	tmp1 = tmp1+Xor.twoStrXor(SHAR_1.bcSHA1(F.charAt(i)+"",1) , 
//        		   SHAR_1.bcSHA1(F.charAt(i)+""+tmp2[i]+"",1))+"alice";    //  F中的twoxor操作需要加括号
        	
        	tmp1 = tmp1+SHAR_1.bcSHA1(F.charAt(i)+"",1) +"XOR" +
         		   SHAR_1.bcSHA1(F.charAt(i)+""+tmp2[i]+"",1)+"alice";
        	// System.out.println("=========");
        	//F中的twoxor不操作需要加括号
        }
       
        t[0]= tmp1;
        int[] tmp3 = sortWithRank(L);


        tmp1="";
        for(int i=0;i<lenl;i++)
        {

//        	tmp1 = tmp1+Xor.twoStrXor(SHAR_1.bcSHA1(L.charAt(i)+"",1), 
//         		   SHAR_1.bcSHA1(F.charAt(i)+""+tmp2[i]+"",1))+"bob"+
//        		   SHAR_1.bcSHA1(L.charAt(i)+""+tmp3[i]+"",1)+"alice";
        	
        	tmp1 = tmp1+SHAR_1.bcSHA1(L.charAt(i)+"",1)+"XOR"+ 
          		   SHAR_1.bcSHA1(F.charAt(i)+""+tmp2[i]+"",1)+"bob"+
         		   SHAR_1.bcSHA1(L.charAt(i)+""+tmp3[i]+"",1)+"alice";
        }
       // System.out.println("*********");
        t[1]= tmp1;
        // System.out.println(tmp1);     
        return t; 
    }

//    public static String readFileToString(String fileName) throws IOException{
//        File file = new File(fileName);
//        FileReader reader = new FileReader(file);
//        BufferedReader bReader = new BufferedReader(reader);
//        StringBuilder sb = new StringBuilder();
//        String s = "";
//        while ((s = bReader.readLine()) != null){
//            sb.append(s.trim() + "\n");
//        }
//        bReader.close();
//        String str = sb.toString();
//        return str;
//    }

//    public static void outPutFile(String fileName,String content)throws IOException{
//        File writename = new File(fileName);
//        writename.createNewFile(); // 鍒涘缓鏂版枃浠?
//        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
//        out.write(content);
//        out.flush();
//        out.close();
//    }

    public static String enCodeLineF(String str) {
    	
        String sorted;
        char tempChar;
        int len = str.length();
        String[] round = new String[len];
        char[] first = new char[len];
        for (int i = 0; i < len; i++) {
            StringBuffer buffer = new StringBuffer(str);
            tempChar = str.charAt(len-1);
            buffer.deleteCharAt(len - 1);
            buffer.insert(0,tempChar);
            str = buffer.toString();
            round[i] = str;
        }
        Arrays.sort(round);
        for(int i = 0; i < round.length; i++){
            //System.out.println(round[i]);
            first[i] = round[i].charAt(0);
        }
        sorted = String.valueOf(first);
        //sorted =  sortWithRank(sorted);
        return sorted;
    }

    
  
    
    public static  String enCodeLineL(String str) {
        
        String sorted;
        char tempChar;
        int len = str.length();
        String[] round = new String[len];
        char[] last = new char[len];
        for (int i = 0; i < len; i++) {
            StringBuffer buffer = new StringBuffer(str);
            tempChar = str.charAt(len-1);
            buffer.deleteCharAt(len - 1);
            buffer.insert(0,tempChar);
            str = buffer.toString();
            round[i] = str;
        }
        Arrays.sort(round);
        for(int i = 0; i < round.length; i++){
            //System.out.println(round[i]);
            last[i] = round[i].charAt(len - 1);
        }
        sorted = String.valueOf(last);
        //sorted =
        //        sortWithRank(sorted);
       // System.out.println("*****"+sorted);
        return sorted;
    }

    public static int[] sortWithRank(String str){

        int[] rank1 = new int[str.length()];
        char[] stringAtChar = str.toCharArray();
        for(int i = 0;i < stringAtChar.length; i++){
            int count = 1;
            for(int j = 0; j < i; j++){
                if(stringAtChar[i] == stringAtChar[j])
                    {count++;}
            }
            rank1[i] = count;
            
        }
        rank = rank1;

        return rank1;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String StringFilter(String   str)
    {
    	String regEx="[-1234567890`~!@#%^&*()+=|{}':;',\\[\\].<>\\\\/?~！\"@#￥%……&*（） ——+|{}【】‘；：”“’。，、？]";  
        Pattern   p   =   Pattern.compile(regEx);
        Matcher   m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }
    
    public static String StringfuzzyFilter(String   str){
    	String regEx="[-1234567890`~!@#%^&()+=|{}':;',\\[\\].<>\\\\/~！\"@#￥%……&（） ——+|{}【】‘；：”“’。，、]";
        Pattern   p   =   Pattern.compile(regEx);
        Matcher   m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }
    
}