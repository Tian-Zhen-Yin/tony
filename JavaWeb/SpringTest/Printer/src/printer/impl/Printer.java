package printer.impl;

import printer.Ink;
import printer.Paper;

public class Printer {
    //面向接口编程，定义ink接口变量
    private Ink ink;
    //面向接口编程，定义paper接口变量
    private Paper paper;

    /**
     * 提供setter方法，进行设置注入
     * @param ink
     */
    public void setInk(Ink ink) {
        this.ink = ink;
    }
    /**
     * 提供setter方法，进行设置注入
     * @param paper
     */
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    /**
     * 打印方法，查看打印采用的颜色和内容
     * @param str
     */
    public void print(String str)
    {
        System.out.println("使用"+ink.getColor(225,200,0)+"颜色打印\n");
       for(int i=0;i<str.length();i++){
           paper.putInChar(str.charAt(i));
       }
       System.out.println(paper.getContent());

    }

}
