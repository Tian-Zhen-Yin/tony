package printer.impl;

import printer.Ink;

import java.awt.*;

public class ColorInk implements Ink {
    /**
     * ��ӡ���ò�ɫī�У�ʵ��ink�ӿ�
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
