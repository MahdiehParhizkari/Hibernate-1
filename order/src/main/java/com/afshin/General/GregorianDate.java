package com.afshin.General;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 28
 * @Time 9:16 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import java.util.Date;

public class GregorianDate {

    public static final ULocale PERSIAN_LOCALE = new ULocale("fa@calendar=persian");
    public static final ULocale GREGORIAN_LOCALE = new ULocale("en@calendar=gregorian");

    public static Date miladi2shamsi (Date miladiDate) {
        if(miladiDate==null) return null;
        Calendar gregorianCalendar = Calendar.getInstance(GREGORIAN_LOCALE);
        gregorianCalendar.setLenient(true);
        gregorianCalendar.clear();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));
        gregorianCalendar.set(miladiDate.getYear()+1900,miladiDate.getMonth(),miladiDate.getDate());
        return gregorianCalendar.getTime();
    }
    public static String shamsiStr(Date shamsidate){
        if(shamsidate==null) return null;
        SimpleDateFormat df1 = new SimpleDateFormat ("yyyy-MM-dd", PERSIAN_LOCALE );
        return df1.format(shamsidate);
    }

    public static Date shamsi2miladi (Integer year,Integer month,Integer day) {
        Calendar gregorianCalendar = Calendar.getInstance(PERSIAN_LOCALE);
        gregorianCalendar.clear();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));
        gregorianCalendar.set(year,month,day);
        return gregorianCalendar.getTime();
    }
    public static Date picker2miladi (String shamsidate) {
        int year=Integer.parseInt(shamsidate.substring(0,4));
        int month=Integer.parseInt(shamsidate.substring(5,7))-1;
        int day=Integer.parseInt(shamsidate.substring(8,10));
        return shamsi2miladi (year,month,day);
    }
    public static String miladiStr(Date miladidate){
        if(miladidate==null) return null;
        SimpleDateFormat df1 = new SimpleDateFormat ("yyyy-MM-dd", GREGORIAN_LOCALE );
        return df1.format(miladidate);
    }
}