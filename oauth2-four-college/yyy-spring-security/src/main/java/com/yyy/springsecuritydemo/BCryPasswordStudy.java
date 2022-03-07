package com.yyy.springsecuritydemo;

import lombok.val;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCryptPasswordEncoder 自带加盐功能，省去了密码加盐的烦恼。 encode()方法每次生成的结果都是不一样的。
 *
 * 相信用过Spring Security的伙伴们，应该对这个BCryptPasswordEncoder 都有好奇。
 * 为啥好奇， 这个家伙的加密方法encode每次生成的密后密码都不一样，但是校验方法matches却能准确地去检验匹配。
 *
 * 没错，这个加密算法其实是 强哈希+盐+密钥（默认用密码）。 因为使用到了哈希，所以是不可逆。
 * 这也就能初步明白matches 为什么只能用来做校验匹配，而不是直接解密。 这点意味着就算你加密后的密码泄露了，别人想直接得到明文几乎是不可能的。
 */

public class BCryPasswordStudy {


    public static void main(String[] args) {
        final BCryptPasswordEncoder cry = new BCryptPasswordEncoder();
        String encodeStr = cry.encode("123456");
        System.out.println("已经加过盐的密码："+encodeStr);


        val flag = cry.matches("123456", encodeStr);
        System.out.println("是否匹配："+flag);
    }

    /**
     * 可以看到，每次输出的encode都不一样，但是最终的flag都是TRUE，匹配成功。
     * 查看encode源码可以看到，其实每次的随机盐，都保存在encodeStr中.在执行matches时，再把盐取出。
     *
     * 例如：
     * 假定一次encodeStr为：$2a$10$AxafsyVqK51p.s9WAEYWYeIY9TKEoG83LTEOSB3KUkoLtGsBKhCwe
     * 随机盐即为 AxafsyVqK51p.s9WAEYWYe（salt = BCrypt.gensalt();中有描述），可见，随机盐（AxafsyVqK51p.s9WAEYWYe），会在比较的时候，重新被取出。
     * 即，加密的encodeStr中，前部分已经包含了盐信息。
     */
}
