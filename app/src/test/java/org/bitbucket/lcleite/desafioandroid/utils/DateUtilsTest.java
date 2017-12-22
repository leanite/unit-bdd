package org.bitbucket.lcleite.desafioandroid.utils;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Created by leandro on 22/12/2017.
 */

public class DateUtilsTest {

    @Test
    public void itShould_convertDateStringToDateObject(){
        Date date = DateUtils.createDateFromString("2017-12-22T11:08:41Z");

        assertEquals(date.compareTo(getExpectedDate()), 0);
    }

    private Date getExpectedDate(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE,8);
        calendar.set(Calendar.SECOND,41);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();
    }
}
