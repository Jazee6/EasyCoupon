package cn.jmzzz.easycoupon.controller.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class R {
    private int code;
    private String msg;
    private Object data;

    public R(Code code, Msg msg, Object data) {
        this.code = code.getValue();
        this.msg = msg.getValue();
        this.data = data;
    }

    public R(Code code, Msg msg) {
        this.code = code.getValue();
        this.msg = msg.getValue();
    }
}
