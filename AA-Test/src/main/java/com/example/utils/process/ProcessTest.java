package com.example.utils.process;


import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * {@link Process}测试.
 *
 */
public class ProcessTest {

    @Test
    public void ls() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        String cmd = "ls -l";
        Process process = runtime.exec(cmd);
        int value = process.waitFor();
    }

}
