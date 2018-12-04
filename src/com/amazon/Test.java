package com.amazon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy zzz");
        df.setTimeZone(TimeZone.getTimeZone("EST"));
        System.out.println(df.format(new Date(1522209600000L)));

     /*   SimpleDateFormat ft = new SimpleDateFormat ("MM-dd-yyyy");
        ft.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        try {
            System.out.println(ft.format("01-24-2018"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
