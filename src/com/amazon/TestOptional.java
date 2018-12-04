package com.amazon;

import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        System.out.println(getLong());

    }
    private static Long getLong() {
        Long l = 0l;
        Optional<Long> mystr = Optional.of(new Long(50));
        return mystr.orElse(l);
    }
}
