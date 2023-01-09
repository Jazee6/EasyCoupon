package cn.jmzzz.easycoupon.controller.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class R {
    private int code;
    private String message;
    private Object data;

    public R(Code code, Msg msg, Object data) {
        this.code = code.getValue();
        this.message = msg.getValue();
        this.data = data;
    }

    public R(Code code, Msg msg) {
        this.code = code.getValue();
        this.message = msg.getValue();
    }

    public R(Object data) {
        this.code = Code.SUCCESS.getValue();
        this.message = Msg.SUCCESS.getValue();
        this.data = data;
    }
}
