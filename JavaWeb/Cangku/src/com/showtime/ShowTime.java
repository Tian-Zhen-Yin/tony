package com.showtime;

import java.util.Date;

public class ShowTime
{
	CalendarBean cb = new CalendarBean();
  private Date date=null;
  private int yy; //������Date����getYear()�������ص�������ֵ
  private int mm;//������Date����getMonth()�������ص�������ֵ
  private int dd;//������Date����getDate()�������ص�������ֵ
  private String sy;
  private String sm;
  private String sd;
  public ShowTime(){
    date=new Date();
    yy=cb.getYear();//ֻ�м���1900����ϵͳ��ǰ�����
    mm=cb.getMonth();//ֻ�м���1��ʶϵͳ��ǰ���·�
    sd=cb.getDayOfMonth();
    sy=String.valueOf(yy);//������YYת��Ϊ�ַ�������
    sm=String.valueOf(mm);//������mmת��Ϊ�ַ�������
    //sd=String.valueOf(dd);������ddת��Ϊ�ַ�������
    if(sm.length()==1){//����·���1λ����ǰ�����"0",�������1�·���ô��ʾ�ľ���"01"
      sm="0"+sm;
    }
    if(sd.length()==1){
      sd="0"+sd;
    }
  }
  public String getDateString(){

    return sy+sm+sd;
  }
  public String getDate(){
    return sy+"-"+sm+"-"+sd;
  }  


}
