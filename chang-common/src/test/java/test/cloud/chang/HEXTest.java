package test.cloud.chang;

import java.nio.ByteBuffer;

public class HEXTest {

  public static void main(String[] args) {
    String str = "0f30d465";
    System.out.println(Long.parseLong(str, 16));

  }

  public static int bytesToInt(byte[] bRefArr) {
    int iOutcome = 0;
    byte bLoop;
    for (int i = 0; i < bRefArr.length; i++) {
      bLoop = bRefArr[i];
      iOutcome += (bLoop & 0xFF) << (8 * i);
    }
    return iOutcome;
  }


  public static long bytesToLong(byte[] bytes) {
    ByteBuffer buffer = ByteBuffer.allocate(8);
    buffer.put(bytes, 0, bytes.length);
    buffer.flip();// need flip
    return buffer.getLong();
  }
}
