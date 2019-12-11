package com.showtime;

public class TestTime {

	public static void main(String[] args) {
		CalendarBean cb = new CalendarBean();
		System.out.println(cb.getYear());
		System.out.println(cb.getDayOfMonth());
		System.out.println(cb.getMonth());
		System.out.println(cb.getMinute());
		System.out.println(cb.getSecond());
	}
}
