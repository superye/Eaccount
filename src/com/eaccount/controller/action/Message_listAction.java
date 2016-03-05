package com.eaccount.controller.action;

import com.eaccount.dao.IMessageDAO;
import com.eaccount.domain.Message_list;
import com.eaccount.service.GetMessageService;
import com.eaccount.service.IGetMessageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/5.
 */
public class Message_listAction extends SuperAction {
    public String GetMessageById() throws IOException{
        String id = request.getParameter("id");
        List<Message_list> list = new ArrayList<>();
        IGetMessageService iGetMessageService = new GetMessageService();
        list = iGetMessageService.GetMessageById(id);

        JSONArray jsonArray = new JSONArray();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message_title", list.get(i).getMessage_title());
            jsonObject.put("message_sender", list.get(i).getMessage_sender());
            jsonArray.add(jsonObject);
        }
        byte[] jsonBytes = jsonArray.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return null;

    }
}
