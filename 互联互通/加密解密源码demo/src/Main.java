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

        cKey = "1234567890abcdef";
        sIV = "1234567890abcdef";
        enString = "X6j5yLBjFJIUuR/iC32nO9B05cUsNBby7FOwv1nfGUWGiq+Sj/GrnRaahYanSihydALbqnPNrsc8\nRZmfKKSU1vOZh2JrrOibvDGEuhgZ4zJEZ/oqD1N7QvPhyam5PqeGsJzbEsa0Q+MQDC2dKhBgxF2Q\n9Oe1S7VaZc599s3i93K0Om1OH+mvnH1e0hUB2itNnY/GO7qSREwmclfaplaEuvWjfg7vZkRtOtmA\ngoh9FW666q+AfG2X4KnjG19Ta9cpnXlWCuzbzqmEMOhdNnquWoOi9lHcghdgW2njReDV8WO+cItI\nODyBIlKJcBEJgtXIpv2i0KDBXeCv/zVYRvDXIKIznlQ1W3PzwYpyV6kEpGX131iaXnOpSY0E7HUC\nw3nAbb06JIRN6zPc1iBNoLlkdLNFBMdtq9/SEarXZqgayxcOpSp3teYlOdMIF4+MvRDPoM9Cjc3L\nwOfSM0IoyXLMDfoL5Ch9QU5Qtrxyq+GHx/3mUYMycRUzNa7e3p2lIpP9p/8qw95GfI1oj/qsPwZ5\nlQ==";
        String DeString = AESUtil.Decrypt(enString, cKey, sIV);
        System.out.println(enString + "\n解密后的字串是：\n" + DeString);
//
//        // lUseTime = System.currentTimeMillis() - lStart;
//        // System.out.println("解密耗时：" + lUseTime + "毫秒");
//
//        System.out.println(HMacMD5.getHmacMd5Str("EiKKGv9jW7edfD", "www.chargerlink.com" + enString + "20160729032255"));

//        System.out.println(HMacMD5.getHmacMd5Str("1234567890abcdef", "mcWREe9KhOVn19yheI8qIvNhvM+Zx8U\/c+GPCtqc3PlRfeUpkCjystXpAnSae5\/G7ImdrxygkObYQ2zMLatOGg=="));
//        System.out.println(HMacMD5.getHmacMd5Str("1234567890abcdee", "589179428uQExW7UhWPpjAqUNhoIdSSeUiFOmoHdt2HqMKjtaL5Fjhy4FasGsSp5BLJnkwS0W1F9fJ8X0R0GS\r\n" +
//                "NtXnrZToPQ==201703271500010001"));
    }
}
