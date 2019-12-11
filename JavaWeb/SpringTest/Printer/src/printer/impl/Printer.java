package printer.impl;

import printer.Ink;
import printer.Paper;

public class Printer {
    //����ӿڱ�̣�����ink�ӿڱ���
    private Ink ink;
    //����ӿڱ�̣�����paper�ӿڱ���
    private Paper paper;

    /**
     * �ṩsetter��������������ע��
     * @param ink
     */
    public void setInk(Ink ink) {
        this.ink = ink;
    }
    /**
     * �ṩsetter��������������ע��
     * @param paper
     */
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    /**
     * ��ӡ�������鿴��ӡ���õ���ɫ������
     * @param str
     */
    public void print(String str)
    {
        System.out.println("ʹ��"+ink.getColor(225,200,0)+"��ɫ��ӡ\n");
       for(int i=0;i<str.length();i++){
           paper.putInChar(str.charAt(i));
       }
       System.out.println(paper.getContent());

    }

}
