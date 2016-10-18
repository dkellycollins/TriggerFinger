package com.dkellycollins.triggerfinger.util.qa;

public class Assert {

    /**
     * Asserts the provided value is not null.
     * @param value The value to check.
     * @param name The argument name of the value.
     */
    public static <T> void isNotNull(T value, String name) {
        if(value == null) {
            throw new IllegalArgumentException(String.format("Value [%1] cannot be null.", name));
        }
    }

    /**
     * Asserts the provided value is not null or empty.
     * @param value The value to check.
     * @param name The argument name of the value.
     */
    public static void isNotNullOrEmpty(String value, String name) {
        isNotNull(value, name);
        if(value.length() == 0) {
            throw new IllegalArgumentException(String.format("Value [%1] cannot be empty.", name));
        }
    }
}
