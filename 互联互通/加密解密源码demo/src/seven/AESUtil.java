package seven;



import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*******************************************************************************
 * AES加解密算法
 * 2016.07.22
 * @author  王学明
 * aes 128位 cbc 算法
 * HTML的&lt; &gt;&amp;&quot;&copy;&nbsp;分别是<，>，&，"，©;空格的转义字符
 */

public class AESUtil {

    // 加密
    public static String Encrypt(String sSrc, String sKey, String sIv) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(sIv.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度1234567890123456
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        sSrc= escapeChar(sSrc);
//        System.out.println(sSrc);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());

        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey, String sIv) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(sIv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                originalString= unEscapeChar(originalString);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }



    /*
     * escapeChar 字符转换
     * 加密前分别把<，>，&，"，© 的转义字符 转换成 &lt; &gt;&amp;&quot;&copy;
     *
     * */
    private static String  escapeChar(String beforeEncryptString ){
        String escapeStr=beforeEncryptString;
        return escapeStr;
//        escapeStr=escapeStr.replaceAll("<", "&lt;");
//        escapeStr=escapeStr.replaceAll(">", "&gt;");
//        escapeStr=escapeStr.replaceAll("&", "&amp;");
//        escapeStr=escapeStr.replaceAll("\"", "&quot;");
//        escapeStr=escapeStr.replaceAll("©", "&copy;");
//        escapeStr=escapeStr.replaceAll(" ", "&nbsp;");
//
//        return escapeStr;

    }

    /*
     * unEscapeChar 反向字符转换
     * 解密前分别把&lt; &gt;&amp;&quot;&copy; 的转义字符 转换成  <，>，&，"，©
     *
     * */
    private static String  unEscapeChar(String beforeDecryptString ){
        String unEscapeStr=beforeDecryptString;
//        unEscapeStr=unEscapeStr.replaceAll( "&lt;","<");
//        unEscapeStr=unEscapeStr.replaceAll( "&gt;",">");
//        unEscapeStr=unEscapeStr.replaceAll( "&amp;","&");
//        unEscapeStr=unEscapeStr.replaceAll( "&quot;","\"");
//        unEscapeStr=unEscapeStr.replaceAll( "&copy;","©");
//        unEscapeStr=unEscapeStr.replaceAll( "&nbsp;"," ");

        return unEscapeStr;

    }


}
