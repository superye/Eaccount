package com.eaccount.controller.action;

import com.eaccount.domain.User_profile;
import com.eaccount.service.GetProfileService;
import com.eaccount.service.IGetProfileService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public class UserAction extends SuperAction{
    public String GetUserInfoByUserId() throws IOException {
        //获取和该用户同公司的用户的信息
        List<User_profile> list = new ArrayList<>();
        IGetProfileService getProfileService = new GetProfileService();
        String id = request.getParameter("user_id");
        list = getProfileService.GetUserInfoByUserId(id);

        //将用户信息转化为json格式
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = new JSONObject();
            jsonObject.put("id", list.get(i).getId());
            jsonObject.put("user_name", list.get(i).getUser_name());
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
