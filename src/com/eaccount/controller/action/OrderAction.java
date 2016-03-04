package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.eaccount.service.GetOrderService;
import com.eaccount.service.IGetOrderService;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderAction extends SuperAction implements ModelDriven<Order>{
    Order order = new Order();

    //卖方通过用户id获取已收，未收，全部的订单信息
    public String SellerGetOrderMessage() throws IOException {
        //获取订单信息
        List<Order> list = new ArrayList<>();
        IGetOrderService getOrderService = new GetOrderService();
        String id = request.getParameter("user_id_seller");
        String type = request.getParameter("type");
        System.out.println(id + " + " + type);
        list = getOrderService.GetOrderByUserIdSeller(id, type);

        //将订单信息转化为json格式
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = new JSONObject();
            jsonObject.put("order_id", list.get(i).getOrder_id());
            jsonObject.put("company_logo", list.get(i).getCompany_logo());
            jsonObject.put("company_name", list.get(i).getCompany_name());
            jsonObject.put("place_order_time", list.get(i).getPlace_order_time());
            jsonObject.put("receiving_time", list.get(i).getReceiving_time());
            jsonObject.put("type_number", list.get(i).getType_number());
            jsonObject.put("product_number", list.get(i).getProduct_number());
            jsonArray.add(jsonObject);
        }
//        System.out.println(jsonArray);
//        System.out.println( "!!" + jsonObject1);
        byte[] jsonBytes = jsonArray.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return null;
    }

    public String SellerGetOrderDetailInfo() {

        return null;
    }

    @Override
    public Order getModel() {
        return order;
    }
}
