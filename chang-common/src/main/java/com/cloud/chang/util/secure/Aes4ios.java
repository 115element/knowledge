package com.cloud.chang.util.secure;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class Aes4ios {

	private final String password;

	public Aes4ios(String password) {
		this.password = password;
	}

	public String encode(String plainText) {
		try {
			return Base64Encoder.encode(encrypt(plainText.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String decode(String base64String) {
		try {
			byte[] decodeByte = decrypt(Base64Decoder
					.decodeToBytes(base64String));
			return new String(decodeByte, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public byte[] encrypt(byte[] plainText) throws Exception {
		return transform(true, plainText);
	}

	public byte[] decrypt(byte[] cipherText) throws Exception {
		return transform(false, cipherText);
	}

	private byte[] transform(boolean encrypt, byte[] inputBytes)
			throws Exception {
		byte[] key = DigestUtils.md5(password.getBytes("UTF-8"));

		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CBCBlockCipher(new AESFastEngine()));
		cipher.init(encrypt, new KeyParameter(key));

		ByteArrayInputStream input = new ByteArrayInputStream(inputBytes);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		int inputLen;
		int outputLen;

		byte[] inputBuffer = new byte[1024];
		byte[] outputBuffer = new byte[cipher.getOutputSize(inputBuffer.length)];

		while ((inputLen = input.read(inputBuffer)) > -1) {
			outputLen = cipher.processBytes(inputBuffer, 0, inputLen,
					outputBuffer, 0);
			if (outputLen > 0) {
				output.write(outputBuffer, 0, outputLen);
			}
		}

		outputLen = cipher.doFinal(outputBuffer, 0);
		if (outputLen > 0) {
			output.write(outputBuffer, 0, outputLen);
		}

		return output.toByteArray();
	}
}
