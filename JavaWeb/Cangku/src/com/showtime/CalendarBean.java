package com.showtime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarBean
{
	Calendar calendar = null;
	public CalendarBean()
	{
		calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
		Date trialTime = new Date();
		calendar.setTime(trialTime);
	}
	public int getYear()
	{
		return calendar.get(Calendar.YEAR);
	}
	public int getMonth()
	{
                int m=Integer.parseInt(getMonthInt());
		//int m = getMonthInt();
		String months[] = new String[]
	{"January","February","March","April","May","June","July","August","September","October","November","December"};
		//if(m>12)
		//{return "Unknown to Month";}
		//return months[m-1];
		return m;
	}
	public String getMonthInt()
	{
          String y="";
          int x=calendar.get(Calendar.MONTH)+1;
          if(x<10)
          {
            return y="0"+String.valueOf(x);
          }
          else
          {
              return String.valueOf(x);
          }
		//return calendar.get(Calendar.MONTH)+1;
	}
	public String getDay()
	{
		int x = getDayOfWeek();
		String[] days = new String[]
		{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		if(x>7)
		{return "Unknown to Day";}
		return days[x-1];
	}
	public int getDayOfWeek()
	{
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	public String getDate()
	{
		return getYear()+"-"+getMonthInt()+"-"+getDayOfMonth();
	}
	public String getDayOfMonth()
	{
          String y="";
          int x=calendar.get(Calendar.DAY_OF_MONTH);
          if(x<10)
          {
            y="0"+String.valueOf(x);
            return y;
          }
          else
          {
              return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
          }
	}
	public String getTime()
	{
		return getHour()+":"+getMinute()+":"+getSecond();
	}
	public int getHour()
	{
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinute()
	{
		return calendar.get(Calendar.MINUTE);
	}
	public String getSecond()
	{
          String y="";
          int x=calendar.get(Calendar.SECOND);
          if(x<10)
          {
            y="0"+String.valueOf(x);
            return  y;
          }
          else
          {
              return String.valueOf(x);
          }
	}
        public String getDateString()
        {
          return getYear()+getMonthInt()+getDayOfMonth();
        }
}
