package printer;

/**
 * 墨盒接口
 */
public interface Ink {
    /**
     * 定义打印机采用的颜色值
     * @param r
     * @param g
     * @param b
     * @return
     */
    public String getColor(int r,int g,int b);
}
