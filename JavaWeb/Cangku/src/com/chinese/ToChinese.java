package com.chinese;

public class ToChinese {
    public String trans(String chi){
        String result=null;
        byte temp[];
        try{
            temp=chi.getBytes("iso-8859-1");
            result=new String(temp);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
