package org.bitbucket.lcleite.desafioandroid.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by leandro on 22/12/2017.
 */

public class DateUtils {

    private static final String GITHUB_DATE_FORMAT = "YYYY-MM-DDTHH:MM:SSZ";
    private static final String APP_LIST_DATE_FORMAT = "MM dd yyyy";

    public static Date createDateFromString(String dateString) {
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat(GITHUB_DATE_FORMAT, Locale.getDefault());

        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String getStringFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(APP_LIST_DATE_FORMAT, Locale.getDefault());
        return dateFormat.format(date);
    }
}