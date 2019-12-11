package printer.impl;

import printer.Paper;

public class TextPaper implements Paper {
    //ÿһ����������ַ���
    private int charPerLine=16;
    //ÿҳ������
    private int linePage=8;
    //��ǰ�ĺ���λ�ã���0��charPerLinr-1
    private int posx=0;
    //��ǰ�к�
    private int posy=0;
    //��ǰҳ��
    private int posp=1;
    //ֽ���е�����
    private String content="";


    /**
     * ����ע�������setter������ע��charPerLine��ֵ
     * @param charPerLine
     */
    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }


    /**
     * ����ע������Ҫ��setter������ע��linePerPageֵ
     * @param linePage
     */
    public void setLinePage(int linePage) {
        this.linePage = linePage;
    }
    @Override
    public void putInChar(char c) {
        content+=c;
        ++posx;
        //�ж��Ƿ���
        if(posx==charPerLine){
            //����
            content+=Paper.newLine;
            //����λ����0
            posx=0;
            ++posy;
        }
        //�ж��Ƿ�ҳ
        if(posy==linePage){
            content+="==��"+posp+"ҳ==";
            content+=Paper.newLine+Paper.newLine;
            //������0
            posy=0;
            ++posp;
        }
    }

    @Override
    public String getContent() {
        String ret=content;
        if(!(posx==0&&posy==0)){
            //��ǰ�к�
            int count=linePage-posy;
            for(int i=0;i<count;i++){
                ret+=Paper.newLine;
            }
            ret+="==��"+posp+"ҳ==";
        }
        return ret;
    }
}
