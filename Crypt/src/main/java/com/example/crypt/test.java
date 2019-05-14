//package com.vivo.exam;
//
//import java.security.Key;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//public class DesUtils {
//    private static DesUtils instance;
//    private static String strDefaultKey = "woaichibaicai";
//    private Cipher decryptCipher;
//    private Cipher encryptCipher;
//
//    public static String byteArr2HexStr(byte[] arrB) throws Exception {
//        StringBuffer sb = new StringBuffer(iLen * 2);
//        for (int intTmp : arrB) {
//            int intTmp2;
//            while (intTmp2 < 0) {
//                intTmp2 += 256;
//            }
//            if (intTmp2 < 16) {
//                sb.append(StringsUtils.LOGIN_AUTHORITY_NORMAL);
//            }
//            sb.append(Integer.toString(intTmp2, 16));
//        }
//        return sb.toString();
//    }
//
//    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
//        byte[] arrB = strIn.getBytes();
//        int iLen = arrB.length;
//        byte[] arrOut = new byte[(iLen / 2)];
//        for (int i = 0; i < iLen; i += 2) {
//            arrOut[i / 2] = (byte) Integer.parseInt(new String(arrB, i, 2), 16);
//        }
//        return arrOut;
//    }
//
//    public DesUtils() throws Exception {
//        this(strDefaultKey);
//    }
//
//    public DesUtils(String strKey) throws Exception {
//        this.encryptCipher = null;
//        this.decryptCipher = null;
//        Key key = getKey(strKey.getBytes());
//        this.encryptCipher = Cipher.getInstance("DES");
//        this.encryptCipher.init(1, key);
//        this.decryptCipher = Cipher.getInstance("DES");
//        this.decryptCipher.init(2, key);
//    }
//
//    public static DesUtils getInstance() {
//        if (instance == null) {
//            try {
//                instance = new DesUtils();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return instance;
//    }
//
//    public byte[] encrypt(byte[] arrB) throws Exception {
//        return this.encryptCipher.doFinal(arrB);
//    }
//
//    public String encrypt(String strIn) throws Exception {
//        return byteArr2HexStr(encrypt(strIn.getBytes()));
//    }
//
//    public byte[] decrypt(byte[] arrB) throws Exception {
//        return this.decryptCipher.doFinal(arrB);
//    }
//
//    public String decrypt(String strIn) throws Exception {
//        return new String(decrypt(hexStr2ByteArr(strIn)));
//    }
//
//    private Key getKey(byte[] arrBTmp) throws Exception {
//        byte[] arrB = new byte[8];
//        int i = 0;
//        while (i < arrBTmp.length && i < arrB.length) {
//            arrB[i] = arrBTmp[i];
//            i++;
//        }
//        return new SecretKeySpec(arrB, "DES");
//    }
//
//    public String encryptString(String str) {
//        String encryptStr = str;
//        if (str == null) {
//            return encryptStr;
//        }
//        try {
//            return getInstance().encrypt(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return encryptStr;
//        }
//    }
//
//    public String decryptString(String str) {
//        String decryptStr = str;
//        if (str == null) {
//            return decryptStr;
//        }
//        try {
//            return getInstance().decrypt(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return decryptStr;
//        }
//    }
//
//    public void setKey(String strKey) {
//        try {
//            Key key = getKey(strKey.getBytes());
//            this.encryptCipher.init(1, key);
//            this.decryptCipher.init(2, key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String encryptKeyString() {
//        String encryptStr = "";
//        if (strDefaultKey == null) {
//            return encryptStr;
//        }
//        try {
//            return encrypt(strDefaultKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return encryptStr;
//        }
//    }
//}
