package cn.ytcast.utils;



import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * String source 传进来字符串
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if(s==null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try{
            return df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }   return null;
    }
}
