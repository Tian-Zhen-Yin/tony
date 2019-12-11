package printer;

/**
 * 打印采用的纸张接口
 */
public interface Paper {
    public static final String newLine="\r\n";

    /**
     * 往纸张里逐个输出内容
     * @param c
     */
    public void putInChar(char c);
    /**
     * 得到输出到纸张的内容
     */
    public String getContent();


}
