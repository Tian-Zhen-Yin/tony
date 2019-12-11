package printer.impl;

import printer.Paper;

public class TextPaper implements Paper {
    //每一行能输入的字符数
    private int charPerLine=16;
    //每页的行数
    private int linePage=8;
    //当前的横向位置，从0到charPerLinr-1
    private int posx=0;
    //当前行号
    private int posy=0;
    //当前页号
    private int posp=1;
    //纸张中的内容
    private String content="";


    /**
     * 设置注入所需的setter方法，注入charPerLine的值
     * @param charPerLine
     */
    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }


    /**
     * 设置注入所需要的setter方法，注入linePerPage值
     * @param linePage
     */
    public void setLinePage(int linePage) {
        this.linePage = linePage;
    }
    @Override
    public void putInChar(char c) {
        content+=c;
        ++posx;
        //判断是否换行
        if(posx==charPerLine){
            //换行
            content+=Paper.newLine;
            //横向位置置0
            posx=0;
            ++posy;
        }
        //判断是否换页
        if(posy==linePage){
            content+="==第"+posp+"页==";
            content+=Paper.newLine+Paper.newLine;
            //行数置0
            posy=0;
            ++posp;
        }
    }

    @Override
    public String getContent() {
        String ret=content;
        if(!(posx==0&&posy==0)){
            //当前行号
            int count=linePage-posy;
            for(int i=0;i<count;i++){
                ret+=Paper.newLine;
            }
            ret+="==第"+posp+"页==";
        }
        return ret;
    }
}
