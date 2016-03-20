package com.eaccount.controller.action;

import com.eaccount.domain.Message_list;
import com.eaccount.service.GetMessageService;
import com.eaccount.service.IGetMessageService;
import com.eaccount.service.ISendMessageService;
import com.eaccount.service.SendMessageService;
import com.eaccount.util.GetNowTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/5.
 */
public class Message_listAction extends SuperAction {
    public String GetMessageById() throws IOException{
        String callback = "callback";
        ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
        String id = request.getParameter("id");
        List<Message_list> list = new ArrayList<>();
        IGetMessageService iGetMessageService = new GetMessageService();
        list = iGetMessageService.GetMessageById(id);

        JSONArray jsonArray = new JSONArray();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list.get(i).getId());
            jsonObject.put("message_title", list.get(i).getMessage_title());
            jsonObject.put("message_sender", list.get(i).getMessage_sender());
            jsonObject.put("message_date", list.get(i).getMessage_date());
            jsonObject.put("message_state", list.get(i).getMessage_state());
            jsonObject.put("message_remark", list.get(i).getMessage_remark());
            jsonObject.put("message_type", list.get(i).getMessage_type());
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

    public String SendMessage() {
        String message_receiver = request.getParameter("message_receiver");
        String message_sender = request.getParameter("message_sender");
        String message_title = request.getParameter("message_title");
        String message_type = request.getParameter("message_type");
        String message_state = request.getParameter("message_state");
        String message_remark = request.getParameter("message_remark");

        GetNowTime getNowTime = new GetNowTime();
        String message_date = getNowTime.GetTime(2).toString();

        Message_list message_list = new Message_list();
        message_list.setMessage_receiver(message_receiver);
        message_list.setMessage_sender(message_sender);
        message_list.setMessage_title(message_title);
        message_list.setMessage_type(message_type);
        message_list.setMessage_state(message_state);
        message_list.setMessage_date(message_date);
        message_list.setMessage_remark(message_remark);

        ISendMessageService sendMessageService = new SendMessageService();
        sendMessageService.SendMessage(message_list);
        return null;
    }
}
