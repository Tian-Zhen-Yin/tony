package cn.ytcast.exception;

/**
 * 自定异常类
 */
public class SysException extends  Exception {
    //存储提示信息
    private String message;
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
