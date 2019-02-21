
public class SearchFgetaddr {
	 public static int Search_F_getaddr(String str,String[] FMF)
	 {
//		 System.out.println(Fkfclj);
//		 System.out.println(Fkfrljclj);
		 for (int i = 0; i < FMF.length; i++) {
			//System.out.println(Fkfclj+"****"+Fkfrljclj);
			 if(str.equals(FMF[i]))
			 {
				 return i;
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
