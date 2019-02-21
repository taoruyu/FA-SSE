import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

public class SHAR_1 {
//    //private static String src = "";
//    private static String key = "alicelovebob";

    public static String bcSHA1(String src,int type) {
        Digest digest = new SHA1Digest();
        if(type==1){ 
        src = "alicelovebob" + src;}  //kf
        if(type==2){
        src = "boblovealice" + src;}  //kl
 
        digest.update(src.getBytes(), 0, src.length());
        
        byte[] shaBytes = new byte[digest.getDigestSize()];
        digest.doFinal(shaBytes, 0);
//        System.out.println("bc SHA 1: " + org.bouncycastle.util.encoders.Hex.toHexString(shaBytes));
        return org.bouncycastle.util.encoders.Hex.toHexString(shaBytes);


//    	if(type==1)
//    	{
////    		return "(Fkf"+src+")"; //F�е�twoxor����
//    		return "Fkf"+src;
//    	}else
//    	{
////    		return "(Fkl"+src+")";
//    		return "Fkl"+src;
//    	}
    }
    
}