package com.eaccount.util;

/**
 * Created by spzn on 16-3-14.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNo {

    public String GetPhotoId(String user_id) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String Time = df.format(new Date());
        int randNum = (int) (Math.random()*9999+1000);
        String randString = String.valueOf(randNum);
        return user_id + Time + randString;
    }

    public String GetOrderId() {
        //IGetOrderService getOrderService = new GetOrderService();
        //String NewestId = getOrderService.GetNewestOrderId();
        //String NewestDate = NewestId.substring(0, 8);
        //String NewestNo = NewestId.substring(8, 12);

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String ThisDate = df.format(new Date());
        return ThisDate;
        /*String ThisNo = null;

        if (NewestDate.equals(ThisDate)) {
            int temp = Integer.parseInt(NewestNo);
            temp++;
            ThisNo = String.format("%04d", temp);
        } else {
            ThisNo = "0001";
        }

        return ThisDate + ThisNo;
        */
    }
}
