package com.learn.demo.optional;

import java.util.Objects;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/3/11 8:56 下午
 **/
public class Optional<T> {

    private final T value;
    private static final Optional<?> EMPTY = new Optional<>();

    private Optional() {
        this.value = null;
    }

    private Optional(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> Optional<T> ofNullable(T value) {
            return value == null ? empty() : of(value);
    }
    public static <T> Optional<T> ofNullableMark(T value) {
        try{
            return value == null ? empty() : of(value);
        } catch (NullPointerException npe){
            return empty();
        }
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    public static<T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;
        return t;
    }
}
