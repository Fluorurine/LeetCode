/* (C)2024 */
package com.fluorurine;

import java.util.Arrays;

public class App {
    public String getGreeting() {
        return "This is from Truong 2";
    }

    public static void main(String[] args) {
        // System.out.println(new App().getGreeting());
        String[] s = new String[] { "a3", "d", "a1", "a2222", "b", "c" };
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
    }
}
