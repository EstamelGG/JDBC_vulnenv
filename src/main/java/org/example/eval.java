package org.example;

import java.io.IOException;

public class eval {
    public static void main(String[] args) {
        try {
            // 执行open -a Calculator命令
            // javac -source 8 -target 8 eval.java
            Process process = Runtime.getRuntime().exec("open -a Calculator");
            process.waitFor();
            System.out.println("Calculator launched successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
