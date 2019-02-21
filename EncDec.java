
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
/**
 * AES对称加密和解密
 * @author shefei007
 *
 */
public class EncDec {
 
	public static void main(String[] args) {
		String content = "test";
		String password = "12345678";
		//加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = AESEncode(content, password);
		String encryptResultStr = parseByte2HexStr(encryptResult);
		System.out.println("加密后：" + encryptResultStr);
		//解密
		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
		byte[] decryptResult = AESDncode(password,decryptFrom);
		System.out.println("解密后：" + new String(decryptResult));
	}
	
	/*
	   * 加密
	   * 1.构造密钥生成器KeyGenerator
	   * 2.根据ecnodeRules规则初始化密钥生成器
	   * 3.产生密钥
	   * 4.创建和初始化密码器
	   * 5.内容加密
	   * 6.返回字符串
	   */
	    
    /**
     * 加密
     * 
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] AESEncode(String password, String content) {
        try {           
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(128, new SecureRandom(password.getBytes()));
                SecretKey secretKey = kgen.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                byte[] byteContent = content.getBytes("utf-8");
                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
                byte[] result = cipher.doFinal(byteContent);
                return result; // 加密
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        } catch (NoSuchPaddingException e) {
                e.printStackTrace();
        } catch (InvalidKeyException e) {
                e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
        } catch (BadPaddingException e) {
                e.printStackTrace();
        }
        return null;
}
		

	   
	    /*
	     * 解密
	     * 解密过程：
	     * 1.同加密1-4步
	     * 2.将加密后的字符串反纺成byte[]数组
	     * 3.将加密内容解密
	     */
    public static byte[] AESDncode( String password,byte[] content) {
        try {
                 KeyGenerator kgen = KeyGenerator.getInstance("AES");
                 kgen.init(128, new SecureRandom(password.getBytes()));
                 SecretKey secretKey = kgen.generateKey();
                 byte[] enCodeFormat = secretKey.getEncoded();
                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");            
                 Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
                byte[] result = cipher.doFinal(content);
                return result; // 加密
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        } catch (NoSuchPaddingException e) {
                e.printStackTrace();
        } catch (InvalidKeyException e) {
                e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
        } catch (BadPaddingException e) {
                e.printStackTrace();
        }
        return null;
}
	    
	    /**将16进制转换为二进制
	     * @param hexStr
	     * @return
	     */
	    public static byte[] parseHexStr2Byte(String hexStr) {
	            if (hexStr.length() < 1)
	                    return null;
	            byte[] result = new byte[hexStr.length()/2];
	            for (int i = 0;i< hexStr.length()/2; i++) {
	                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
	                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
	                    result[i] = (byte) (high * 16 + low);
	            }
	            return result;
	    }
	    
	    /**将二进制转换成16进制 
	     * @param buf 
	     * @return 
	     */  
	    public static String parseByte2HexStr(byte buf[]) {
	    	StringBuffer sb = new StringBuffer();
	    	for (int i = 0; i < buf.length; i++) {  
	    		 String hex = Integer.toHexString(buf[i] & 0xFF);
	    		 if (hex.length() == 1) {  
	    			 hex = '0' + hex;  
	    		 }
	    		 sb.append(hex.toUpperCase());
	    		 }
	    	return sb.toString(); 
	    	}
	    
	    
	  
}
