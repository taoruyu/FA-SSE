
public class SearchLLset {

	public static int searchllsetgetloc(String[] llset,String SEARCHF,String Fkfm)
	{
		for (int j = 0; j < llset.length; j++)
		{
			String llsetchar = llset[j].split("==>")[0];
			if(llsetchar.equals(Xor.twoStrXor(SEARCHF,Fkfm)))
			{
				return j;
			}
		
		}
		return -1;
	}
	
	public static int searchllsetgetloc(String[] llset,String SEARCHL)
	{
		for (int j = 0; j < llset.length; j++)
		{
			String llsetchar = llset[j].split("==>")[0];
			if(llsetchar.equals(SEARCHL))
			{
				return j;
			}
		
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
