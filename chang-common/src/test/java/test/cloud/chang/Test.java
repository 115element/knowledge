package test.cloud.chang;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.cloud.chang.util.secure.Coding;
import com.cloud.chang.util.secure.MDUtil;



public class Test {

  public static void main(String[] args) {

    String head = "01ffffe5961f6304d330cd";
    String body = "66ce447a9465f8a52a3480503ef14c06";

    String hexVer = head.substring(0, 2);
    String hexKeyVer = head.substring(2, 6);
    String hexNonce = head.substring(6, 14);
    String hexNonce2 = head.substring(14, 22);

    // System.out.println(hexVer + "," + hexKeyVer + "," + hexNonce + "," + hexNonce2);
    int ver = Integer.parseInt(hexVer, 16);
    System.out.println(ver);
    long keyVer = Long.parseLong(hexKeyVer, 16);
    System.out.println(keyVer);
    long nonce = Long.parseLong(hexNonce, 16);
    long nonce2 = Long.parseLong(hexNonce2, 16);
    String aKey =
        MDUtil.encryptByMD5("wx23fb4aaf04b8491e" + "_" + nonce + "_" + nonce2 + "_"
            + "key_for_test_sample");
    
    System.out.println("aKey=" + aKey);
    byte[] bodyBs = Coding.hex2byte(body);
    
    byte[] keyBs = Coding.hex2byte(aKey);
    
    byte[] bs = decrypt(bodyBs, keyBs);

    String decodedStr = Coding.byte2hex(bs);
    System.out.println("decodedStr=" + decodedStr);

    int magic = Integer.parseInt(decodedStr.substring(0, 2), 16);
    System.out.println(magic);
    long reverse = Long.parseLong(decodedStr.substring(2, 6), 16);
    System.out.println(reverse);
    int mobilelen = Integer.parseInt(decodedStr.substring(6, 8), 16);
    System.out.println(mobilelen);
    byte[] mobileBs = Coding.hex2byte(decodedStr.substring(8, 8 + 2 * mobilelen));
    System.out.println(new String(mobileBs));
  }

  public static byte[] decrypt(byte[] encoded, byte[] key) {
    try {
      SecretKeySpec keyspec = new SecretKeySpec(key, "AES");
      IvParameterSpec ivspec = new IvParameterSpec(key);

      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
      return cipher.doFinal(encoded);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
