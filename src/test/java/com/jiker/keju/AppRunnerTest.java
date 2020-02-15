package com.jiker.keju;

import org.junit.Test;

public class AppRunnerTest {

    @Test
    public void run() {
        AppRunner runner = new AppRunner();
        String[] args = {"testData.txt"};
        runner.main(args);
    }
}
