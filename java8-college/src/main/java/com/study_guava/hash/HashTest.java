package com.study_guava.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.junit.jupiter.api.Test;


public class HashTest {
    //MD5算法
    @Test
    public void _0() {
        //已废弃
        HashFunction hf0 = Hashing.md5();

        HashFunction hf = Hashing.md5();
        HashCode name = hf.newHasher()
                .putLong(1L)
                .putString("name", Charsets.UTF_8)
                //.putObject(new Object(),)
                .hash();
        System.out.println(name);
    }

    @Test
    public void _1(){
        String s = Hashing.sha256()
                .newHasher()
                .putString("ssss", Charsets.UTF_8)
                .hash()
                .toString();
        System.out.println(s);
    }
}
