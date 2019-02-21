public class Fuzzyset {
    public static String findc_replace(String str,int endith ,int type)
    {
        int k =0;
        String t ="";
        for (int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)=='*')
            {
                k++;
                if (k==endith) {
                    if(type==0) {
                       t = str.substring(0, i) + str.substring(i + 1, str.length());return t;
                    }
                    else if (type==1) {
                        t = str.substring(0, i) +"?"+ str.substring(i + 1, str.length());return t;
                    }
                    else
                    {
                       t =  str.substring(0, i) +"??"+ str.substring(i + 1, str.length());return t;
                    }
                }
            }
        }
        return "";
    }

    public static String[] fuzzyset(String  s) {
        //String s = "abc*df*e";
        int count=0;
        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)=='*')
            {
                count++;
            }
        }

        String[] searchfuzzy = null;
        if(count==0)
        {
            return  searchfuzzy;
        }
        else if (count==1) {
            searchfuzzy = new String[3];
            searchfuzzy[0] = findc_replace(s, 1, 0);
            searchfuzzy[1] = findc_replace(s, 1, 1);
            searchfuzzy[2] = findc_replace(s, 1, 2);
            return  searchfuzzy;
        }
       else {
            searchfuzzy = new String[12];
            searchfuzzy[0] = findc_replace(s, 1, 0);
            searchfuzzy[1] = findc_replace(s, 1, 1);
            searchfuzzy[2] = findc_replace(s, 1, 2);
            searchfuzzy[3] = findc_replace(findc_replace(s, 2, 0), 1, 0);
            searchfuzzy[4] = findc_replace(findc_replace(s, 2, 0), 1, 1);
            searchfuzzy[5] = findc_replace(findc_replace(s, 2, 0), 1, 2);
            searchfuzzy[6] = findc_replace(findc_replace(s, 2, 1), 1, 0);
            searchfuzzy[7] = findc_replace(findc_replace(s, 2, 1), 1, 1);
            searchfuzzy[8] = findc_replace(findc_replace(s, 2, 1), 1, 2);
            searchfuzzy[9] = findc_replace(findc_replace(s, 2, 2), 1, 0);
            searchfuzzy[10] = findc_replace(findc_replace(s, 2, 2), 1, 1);
            searchfuzzy[11] = findc_replace(findc_replace(s, 2, 2), 1, 2);
            return  searchfuzzy;
        }

    }

    public static void main(String[] args) {
        String[] tt = fuzzyset("crowded");
        if(tt==null)
        {System.out.println("HAHA");}
    }
}
