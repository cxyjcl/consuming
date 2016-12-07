package cn.whpu.management.exception;

/**
 * Created by Fiona on 2016/10/21.
 */
public enum Message {
    _10000(10000,"正确"),
    _10001(10001,"验证码错误"),
    _10002(10002,"系统繁忙，请稍后再试"),
    _10003(10003,"用户名不存在"),
    _10004(10004,"找不到地址"),
    _10005(10005,"用户或者密码不正确"),
    _10006(10006,"已发送"),
    _10007(10007,"修改成功");

    private int code;
    private String message;

    Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }


}
