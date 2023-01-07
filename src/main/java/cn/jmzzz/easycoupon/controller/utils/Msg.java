package cn.jmzzz.easycoupon.controller.utils;

public enum Msg {
    SUCCESS("success"),
    ERROR("error");

    private final String value;

    Msg(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
