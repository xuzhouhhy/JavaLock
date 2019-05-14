package com.example.crypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class MyClass {

    static final String EncryptedString = "2227fe19f2846fab63e8f2ef55c33501";

    static final String EncryptedString = "2227fe19f2846fab63e8f2ef55c33501";

    static final String KEY = "woaichibaicai";

    static final String CRYPT_METHOD = "DES";

    private Cipher cipher;

    public MyClass() {
        try {
            this.cipher = Cipher.getInstance(CRYPT_METHOD);
            cipher.init(2, getKey(KEY.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private Key getKey(byte[] arrBTmp) {
        byte[] arrB = new byte[8];
        int i = 0;
        while (i < arrBTmp.length && i < arrB.length) {
            arrB[i] = arrBTmp[i];
            i++;
        }
        return new SecretKeySpec(arrB, CRYPT_METHOD);
    }

    public byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        System.out.println(arrB);
        int iLen = arrB.length;
        byte[] arrOut = new byte[(iLen / 2)];
        for (int i = 0; i < iLen; i += 2) {
            arrOut[i / 2] = (byte) Integer.parseInt(new String(arrB, i, 2), 16);
        }
        return arrOut;
    }

    public static void main(String... args) {
        try {
            MyClass myClass = new MyClass();
            byte[] byteArr = myClass.hexStr2ByteArr(EncryptedString);
            System.out.println(byteArr);
            System.out.println(myClass.decrypt(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String decrypt(byte[] byteArr) {
        String result = null;
        if (cipher != null) {
            try {
                result = new String(cipher.doFinal(byteArr));
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
