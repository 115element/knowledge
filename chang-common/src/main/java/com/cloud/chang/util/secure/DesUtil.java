package com.cloud.chang.util.secure;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {

	// public static final String DES_KEY = "20110606";
	public static final String DEFAULT = "DES";
	public static final String DES = "DES";// length:8byte
	public static final String DESEDE = "DESede";// length:24byte
	public static final String AES = "AES";// 密钥长度 可以是128, 192或256位

	/**
	 * 
	 * @param src
	 *            要加密的对象
	 * @param desKey
	 *            加密的密钥
	 * @param algorithm
	 *            加密算法,有"DESede","AES","DES" and etc.
	 * @return
	 */
	private static byte[] encrypt(byte[] src, String desKey, String algorithm) {

		try {
			SecretKey deskey = new SecretKeySpec(initKey(desKey.getBytes("UTF-8"), algorithm), algorithm);
			Cipher c = Cipher.getInstance(algorithm);
			c.init(Cipher.ENCRYPT_MODE, deskey);
			return c.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param src
	 * @param desKey
	 * @param algorithm
	 * @return
	 */
	public static byte[] decrypt(byte[] src, String desKey, String algorithm) {
		try {
			SecretKey deskey = new SecretKeySpec(initKey(desKey.getBytes("UTF-8"), algorithm), algorithm);
			Cipher c = Cipher.getInstance(algorithm);
			c.init(Cipher.DECRYPT_MODE, deskey);
			return c.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] src, byte[] desKey, byte[] ivBs, String algorithm) {
		try {
			SecretKey deskey = new SecretKeySpec(desKey, algorithm);
			IvParameterSpec iv = new IvParameterSpec(ivBs);
			Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, deskey, iv);
			return c.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] src, byte[] desKey, String algorithm) {
		try {
			SecretKey deskey = new SecretKeySpec(desKey, algorithm);
			Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, deskey);
			return c.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param code
	 *            需要解密的字符串
	 * @param desKey
	 *            DES密钥
	 * @param algorithm
	 *            DES算法
	 * @return
	 */
	public static String deCode(String code, String desKey, String algorithm) {

		String result = null;
		try {
			byte[] t = decrypt(Coding.hex2byte(code, ""), desKey, algorithm);
			result = new String(t, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 加密
	 * 
	 * @param code
	 *            需要加密的字符串
	 * @param desKey
	 *            DES密钥
	 * @param algorithm
	 *            DES算法
	 * @return
	 */
	public static String enCode(String code, String desKey, String algorithm) {
		String result = null;
		try {
			byte[] src = code.getBytes("UTF-8");
			byte[] output = encrypt(src, desKey, algorithm);
			result = Coding.byte2hex(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static byte[] initKey(byte[] key, String algorithm) throws Exception {

		byte[] newkey = null;

		if (algorithm.equals(DES)) {
			newkey = new byte[8];
			int length = key.length;
			for (int i = 0; i < 8; i++) {
				if (i + 1 > length) {
					newkey[i] = new Byte("0");
				} else {
					newkey[i] = key[i];
				}
			}
		} else if (algorithm.equals(DESEDE)) {
			newkey = new byte[24];
			int length = key.length;
			for (int i = 0; i < 24; i++) {
				if (i + 1 > length) {
					newkey[i] = new Byte("0");
				} else {
					newkey[i] = key[i];
				}
			}
		} else if (algorithm.equals(AES)) {
			newkey = new byte[16];
			int length = key.length;
			for (int i = 0; i < 16; i++) {
				if (i + 1 > length) {
					newkey[i] = new Byte("0");
				} else {
					newkey[i] = key[i];
				}
			}
		} else {

		}
		return newkey;
	}
}
