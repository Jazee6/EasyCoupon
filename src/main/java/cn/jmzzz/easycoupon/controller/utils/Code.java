package cn.jmzzz.easycoupon.controller.utils;

public enum Code {
    SUCCESS(200),
    ERROR(500);

    private final int value;

    Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
