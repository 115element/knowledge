package test.cloud.chang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cloud.chang.util.secure.Coding;

public class TempTest {

	public static void main(String[] args) throws Exception {

		String chal = "ccc7c776f919cb1ac1104f7fc3ec0077";
		String uamSecert = "change-me";
		String passwd = "123456&";
		// System.out.println(hex2bin(chal));
		// byte[] encodeChal = md5(Coding.hex2byte(chal), uamSecert.getBytes());

		// System.out.println(Coding.byte2hex(encodeChal));

		String chapChal = "f1751fa6633a4e75c0a70eafc09be9c1";
		byte[] chalBytes = Coding.hex2byte(chapChal);

		byte[] encodePwd = md5(new byte[] { new Byte("0") }, passwd.getBytes(), chalBytes);

		System.out.println(Coding.byte2hex(encodePwd));
	}

	private static byte[] md5(byte[]... data) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			for (byte[] bs : data) {
				md.update(bs, 0, bs.length);
			}
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
