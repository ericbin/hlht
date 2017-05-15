//import seven.AESUtil;
//import seven.HMacMD5;

import password.BCryptHasher;

public class Main {


    public static void main2(String[] args) {
        String test_passwd = "seven-helloworld-password";

        String computed_hash = BCryptHasher.hashPassword(test_passwd);
        System.out.println(computed_hash);

        boolean compare_test = BCryptHasher.checkPassword(computed_hash, test_passwd);
        System.out.println(compare_test);

        System.out.println(BCryptHasher.checkPassword("$2a$08$JWvzp.V8ky2wXeP7M9TB4ezcXfiM2HDmfK3AK/Se8qlcT.THD75ay", "123456"));
    }

    public static void main(String[] args) throws Exception {

        String seven = "09000176-";
        System.out.println(seven.split("-").length);
//      signKey : EiKKGv9jW7edfD
//      encryKey: Y>3/[#3(q:Wv;]{(
//      encryIV:  4/#L)[.D,V.e3>[{

        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */

        //
        String cKey = "1234567890abcdef";
        String sIV = "1234567890abcdef";
        String cSrc ="";
        String enString = "";
//        // 需要加密的字串
//        cSrc = "{\"equipAuthSeq\":398496746201601011010101234,\"connectorID\":252154592962289681}";
//        System.out.println(cSrc);
//        enString = AESUtil.Encrypt(cSrc, cKey, sIV);
//        System.out.println("加密后的字串是1：" + enString);
//
//        // 获取token需要加密的字串
//
//        cKey = "Y>3/[#3(q:Wv;]{(";// 'Y>3/[#3(q:Wv;]{(';
//        sIV  = "4/#L)[.D,V.e3>[{";//'4/#L)[.D,V.e3>[{';
////        $this->platformTokenSecret       = '.(k]#9>>8:mW(m)?';//'.(k]#9>>8:mW(m)?';
//
//        cSrc = "{\"OperatorID\":\"GMSP12345\",\"OperatorSecret\":\".(k]#9>>8:mW(m)?\"}";
//        System.out.println(cSrc);
//        enString = AESUtil.Encrypt(cSrc, cKey, sIV);
//        System.out.println("加密后的字串是1：" + enString);
//
//
//        // 获取token需要加密的字串
//        cSrc = "{\"LastQueryTime\":\"2016-01-01 10:10:10\",\"PageNo\":1,\"PageSize\":100}";
//        System.out.println(cSrc);
//        enString = AESUtil.Encrypt(cSrc, cKey, sIV);
//        System.out.println("加密后的字串是1：" + enString);

        // 需要加密的字串
//        cSrc = "{\"equipBizSeq\":252154592962289681好1}";
//        System.out.println(cSrc);
//        enString = AESUtil.Encrypt(cSrc, cKey, sIV);
//        System.out.println("加密后的字串是1：" + enString);

//        cKey = "1234567890abcdef";
//        sIV = "1234567890abcdef";
//        enString = "Uxi6kQ6/4+l7iINZD1FJXvggAAm1jaBicGMpWfm6P7Psd9P6PJrzlNQampkeH/XJ";
//        String DeString = AESUtil.Decrypt(enString, cKey, sIV);
//        System.out.println(enString + "\n解密后的字串是：\n" + DeString);
//
//        // lUseTime = System.currentTimeMillis() - lStart;
//        // System.out.println("解密耗时：" + lUseTime + "毫秒");
//
//        System.out.println(HMacMD5.getHmacMd5Str("EiKKGv9jW7edfD", "www.chargerlink.com" + enString + "20160729032255"));

        System.out.println(HMacMD5.getHmacMd5Str("1234567890abcdef", "mcWREe9KhOVn19yheI8qIvNhvM+Zx8U\/c+GPCtqc3PlRfeUpkCjystXpAnSae5\/G7ImdrxygkObYQ2zMLatOGg=="));
//        System.out.println(HMacMD5.getHmacMd5Str("1234567890abcdee", "589179428uQExW7UhWPpjAqUNhoIdSSeUiFOmoHdt2HqMKjtaL5Fjhy4FasGsSp5BLJnkwS0W1F9fJ8X0R0GS\r\n" +
//                "NtXnrZToPQ==201703271500010001"));
    }
}
