package com.mjc.school.repository.util;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {
    private static final AtomicLong sequence = new AtomicLong(1);

    public static Long getNextSequence() {
        return sequence.getAndIncrement();
    }
}
