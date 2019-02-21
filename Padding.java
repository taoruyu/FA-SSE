/** 
 * ����ַ������ж������ַ�,�Լ�ÿ���ַ��ĸ���? 
 * @author С�� 
 * 
 */  
public class Padding {   
    public int num;   //ͳ���ַ��������  
    public  String temp1 = "";
	public  String temp2 = "";  
	public  String pad_str = "";
	public  int    Max_char_num = 0; 
    public Padding(String str){  
        this.num = str.length();  
    }  
      
    public int count(String str){  
        int leng = str.length();  
        if(leng == 0){  
            return num;  
        }else {  
            String a = str.substring(0, 1);  
            int charNum = 1;    //ͳ���ַ���������  
            //System.out.print("�ַ���"+a);  
            temp1 = temp1 + a;
            for (int i = 1; i < str.length(); i++) {  
                if(a.equals(str.substring(i, i+1))){  
                    num--;  
                    charNum++;  
                }  
            }  
            temp2 = temp2 + charNum + "bob";
            //System.out.println("  "+charNum);  
            if(charNum > Max_char_num){Max_char_num = charNum;}
            str = str.replace(a, "");  
            count(str);   //�õݹ�  
        }  
        return num;  
    }  
  
public void gen_pad()
{
	for(int i=0;i<num;i++)
    { 
    	for(int j =0;j<Max_char_num-(Integer.parseInt(temp2.split("bob")[i]));j++)
    	{
    		if(!(temp1.charAt(i)+"").equals("$"))
    		{
    			pad_str = pad_str +  temp1.charAt(i);
    		}
    		else{
    		break;
    		}
    	}
    }
   pad_str = BwtEncode.replaceBlank(pad_str);
   
}
    
}  