package com.eaccount.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by spzn on 16-3-3.
 */
public class GetNowTime {
    public String GetTime(int type) {
        DateFormat dateFormat = null;
        if (type == 1) {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        } else if (type == 2) {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
        String date = dateFormat.format(new Date());
        return date;
    }
}
