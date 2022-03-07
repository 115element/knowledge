package test.cloud.chang;

import com.cloud.chang.util.secure.Base64Decoder;
import com.cloud.chang.util.secure.DesUtil;

public class Test1 {

	public static void main(String[] args) {

		String encodeStr = "OoEaAnwZKSZxtAXtIXIkq8IWS7cruOUulR1b3G2Tc5iYjYiDE7/Kx6LJuyViDKDfWgu0RposgZ5RAd4Uulcx9fCHej9ytDcyrFqIkEMnOiPxrq6vpPYp0Ik4FM06Z1BCiX5yqoR1QLFesb1g59fHjdb3ZxBRmd3+YWCadjxD32V+NVYE7J+HEvWzdOryX2O/U/zQt3bxQjYoIgzDY5GX32OGm1ZUbBWOpyRwlZkFiGQ=";
		String key = "xr$@kdjf";
		String iv = "salt#&@!";

		byte[] bs = Base64Decoder.decodeToBytes(encodeStr);

		String decodeStr = new String(DesUtil.decrypt(bs, key.getBytes(), iv.getBytes(), DesUtil.DES));
		System.out.println(decodeStr);
	}

}
