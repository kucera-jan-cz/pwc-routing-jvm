package com.example.pwc.commons;


public class Validations {


    public static <T> T notNull(T instance) {
        return notNull(instance, "Required value was null");
    }

    public static <T> T notNull(T instance, String message) {
        if (instance == null) throw new IllegalArgumentException(message);
        return instance;
    }

    public static void isTrue(boolean value) {
        isTrue(value, "Required value should be true");
    }

    public static void isTrue(boolean value, String message) {
        if (!value) throw new IllegalArgumentException(message);
    }
}
