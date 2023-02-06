package com.mjc.school.controller.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageHelper {
    private MessageHelper() {}

    private static final BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static long readLong() {
        try {
            return Long.parseLong(reader.readLine());
        }
        catch (NumberFormatException e) {
            printMessage("Wrong input. Try again.");
            return readLong();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return readLong();
    }

    public static String readString() {
        try {
            return reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return readString();
    }
}
