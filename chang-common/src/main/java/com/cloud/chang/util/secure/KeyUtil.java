package com.cloud.chang.util.secure;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class KeyUtil {

	public static String[] generateKeyPair() {

		KeyPairGenerator keygen = null;
		String[] keyPair = null;
		try {
			keygen = KeyPairGenerator.getInstance("RSA");
			SecureRandom secrand = new SecureRandom();

			keygen.initialize(1024, secrand);
			KeyPair keys = keygen.genKeyPair();
			PublicKey pubkey = keys.getPublic();
			PrivateKey prikey = keys.getPrivate();

			String publicKeyStr = Base64.encodeBase64String(pubkey.getEncoded());
			String privateKeyStr = Base64.encodeBase64String(prikey.getEncoded());

			keyPair = new String[2];
			keyPair[0] = publicKeyStr;
			keyPair[1] = privateKeyStr;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		return keyPair;
	}

	public static boolean verify(String pubKeyBase64Text, String plainText, String signBase64Text) {
		try {
			// 解密由base64编码的公钥,并构造X509EncodedKeySpec对象
			X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKeyBase64Text));
			// RSA对称加密算法
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// 取公钥匙对象
			PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
			// 解密由base64编码的数字签名
			byte[] signed = Base64.decodeBase64(signBase64Text);
			Signature signatureChecker = Signature.getInstance("MD5withRSA");
			signatureChecker.initVerify(pubKey);
			signatureChecker.update(plainText.getBytes());
			// 验证签名是否正常
			if (signatureChecker.verify(signed)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String sign(String priKeyText, String plainText) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKeyText));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey prikey = keyf.generatePrivate(priPKCS8);
			// 用私钥对信息生成数字签名
			Signature signet = Signature.getInstance("MD5withRSA");
			signet.initSign(prikey);
			signet.update(plainText.getBytes());
			return Base64.encodeBase64String(signet.sign());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encrypt(String pubKeyBase64Text, String plainText) {
		try {
			X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKeyBase64Text));
			// RSA对称加密算法
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// 取公钥匙对象
			PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);

			// 分段加密
			byte[] bytes = plainText.getBytes("utf-8");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int i = 0; i < bytes.length; i += 102) {
				byte[] subarray = Arrays.copyOfRange(bytes, i, i + 102);
				byte[] encodedData = cipher.doFinal(subarray);
				baos.write(encodedData);
			}
			//
			byte[] plainBytes = baos.toByteArray();
			return Base64.encodeBase64String(plainBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String decrypt(String priKeyText, String plainText) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKeyText));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey prikey = keyf.generatePrivate(priPKCS8);

			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, prikey);

			// 分段解密
			byte[] plainBytes = Base64.decodeBase64(plainText);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < plainBytes.length; i += 128) {
				byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(plainBytes, i, i + 128));
				sb.append(new String(doFinal, "UTF-8"));
			}
			return sb.toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		// String[] keyPair = generateKeyPair();
		// System.out.println(keyPair[0]);
		// System.out.println(keyPair[1]);
		String pk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/PHm6JH92Xz0e2TcIH7N1LmOfpgn4zqzwTDnIFa2BMolgcs8JaUuo3ucHsIDvIofgXnhfInm1O/JWDWoNfcIGfRwqg1adVSvvzrKDj9h0EkKekgoNo+qWf3sHxcrNHF3Vv1L5FsyWWrELWP7MaoblbeHnLhdO0o8ejxAbCIfngQIDAQAB";
		String prk = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL88ebokf3ZfPR7ZNwgfs3UuY5+mCfjOrPBMOcgVrYEyiWByzwlpS6je5wewgO8ih+BeeF8iebU78lYNag19wgZ9HCqDVp1VK+/OsoOP2HQSQp6SCg2j6pZ/ewfFys0cXdW/UvkWzJZasQtY/sxqhuVt4ecuF07Sjx6PEBsIh+eBAgMBAAECgYAR+kxzPFUjOqbTTJZI1DoZrQe+jWxokH1fhbr03VzXRXn2sDRYbSaotHPBnE0yretaI2drgiEw8XbBsjcjF4xyx/0rn6Ic1ip+V8PLzwrx+lissms9Ztom+9Q28qkKO+13PbcYmXMHSOi89LCY6YXcGhM4NcYIcF5OpqssCTETRQJBAO7Si51cJsPNQPslltsu6AsrhIboUd4BpkiAbKOiMZ4uBIzTvDeN1EQGCRsNe/waWZxNFeux1B2+QcTlxVXm+V8CQQDM/bjLEFdkevVe03SgxO2+w1+OOuE1FEiYk1v65IzTloalX5qXCzQb5w57X+ZYSVNvjCmugPpLfix8oyNHy2sfAkEA3PSbC1no25sZFcNvURaSxVLb6F0k8Tuhds6qtLIpKen1d72mE9f6nXzgC9Fr9pECe2OudkQutd4Cx4K2EoYCDQJACN4U51vem+8hvCdjjSzXp//lm056vYQSG9+MBA9s9B431uGK22vVpjtZiga8/Sa24EVs7CqSKT/dBss71Hg9OwJBAJis7gtPtBe/oePS3jlH0fcwkAiTVRD5rnpXE3iay2KmWu+dW1kv6L45iFRHC63FGvNTywgKDg6RQiHmY8RwrJk=";

		String txt = "1234567890";
		String encode = encrypt(pk, txt);
		System.out.println(encode);

		System.out.println(decrypt(prk,
				"kkEclbeZ2zp+nEPodmozVhYx8sQFS9gdIdNsPisiyu9sjo9CuKNB6q/1tMF86jo1folUDvVYp6GJcdGJR3nqZQ4KoyiTgHDcjNcO7pZMlUpW3GoT3Ymp6rYROUQ5z8m+6Yu7Gq56HxzDIvA+SPSd543mCiKyxSzzsk4Jk+JZb74="));
	}
}
