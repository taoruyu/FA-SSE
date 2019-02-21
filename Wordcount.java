import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Wordcount {
	private static String word;
//	public static List fenci(String path) throws IOException {
//
//		//��HashMap���<����:��Ƶ>����һ��ӳ���ϵ
//		HashMap<String, Integer> hashMap=new HashMap<String, Integer>();
//		//��������ʽ�������ַ����е����б�����
//		//String regex = "[������.��,\"!--;:?\'\\]]";
//		String regex ="[-1234567890`~!@#%^&*()+=|{}':;',\\[\\].<>\\\\/?~��\"@#��%����&*���� ����+|{}������������������������]";
//			//��ȡҪ������ļ�
//			BufferedReader br=new BufferedReader(new FileReader(path));
//			String value;
//			while((value=br.readLine())!=null){
//				value=value.replaceAll(regex, " ");
//				//ʹ��StringTokenizer���ִ�(StringTokenizer���JDK�ĵ�)
//				StringTokenizer tokenizer = new StringTokenizer(value);
//				while(tokenizer.hasMoreTokens()){
//					String word=tokenizer.nextToken();
//					if(!hashMap.containsKey(word)){
//	                    hashMap.put(word, new Integer(1));
//	                }else{
//	                    int k=hashMap.get(word).intValue()+1;
//	                    hashMap.put(word, new Integer(k));
//	                }
//				}
//			}
//			List list= count(hashMap);
//			List list_wu=wu(list);
////		     for(Object o:list_wu){
////	           System.out.println(o);
////	          }
////			//����HashMap,������
//		     return list_wu;
//	}
private static List wu(List list) {
		// TODO Auto-generated method stu
        for(int i = list.size() - 1; i >= 5; i--){
                list.remove(i);
            }
        return list;
	}
//public static void main(String[] args) throws IOException {
//	fenci("F:\\����\\1.txt");
//}
	public static List count(HashMap hashMap) throws IOException{
	    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
            //��������
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                //return o1.getValue().compareTo(o2.getValue());
            	return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
//        for(Map.Entry<String, Integer> mapping:list){ 
//               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
//          } 
        
		return chuting(list);
	}
	private static String[] getstopwords() throws IOException {
		String[] array =new String[1000];
		String str;
		int i = 0;
		FileReader word = new FileReader("E:\\workspace\\code\\code\\stopwords\\stopwords.txt");
		BufferedReader br = new BufferedReader(word);
		try {
			while((str = br.readLine()) != null){
			array[i] = str;
			i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	private static List chuting(List<Entry<String, Integer>> listMap) throws IOException {
		// TODO Auto-generated method stub
	        for(int i = listMap.size() - 1; i >= 0; i--){
	        	Entry<String, Integer> item = listMap.get(i);
	        	String[] stopwords=getstopwords();
	        	for (String stopword:stopwords) {
					if(item.getKey().equals(stopword)) {
						listMap.remove(item);
					}
				}
	        }
			return listMap;
	}
}
