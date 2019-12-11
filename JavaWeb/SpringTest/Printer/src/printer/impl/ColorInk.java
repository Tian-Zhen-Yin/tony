package printer.impl;

import printer.Ink;

import java.awt.*;

public class ColorInk implements Ink {
    /**
     * 打印采用彩色墨盒，实现ink接口
     * @param r
     * @param g
     * @param b
     * @return
     */
    @Override
    public String getColor(int r, int g, int b) {
        Color color=new Color(r,g,b);
        return "#"+Integer.toHexString(color.getRGB()).substring(2);

    }
}
