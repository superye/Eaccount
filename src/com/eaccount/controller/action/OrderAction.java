package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.eaccount.service.*;
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

    //买方通过用户id获取已收，未收，全部的订单信息
    public String BuyerGetOrderMessage() throws IOException {
        //获取订单信息
        List<Order> list = new ArrayList<>();
        IGetOrderService getOrderService = new GetOrderService();
        String id = request.getParameter("user_id_buyer");
        String type = request.getParameter("type");
        System.out.println(id + " + " + type);
        list = getOrderService.GetOrderByUserIdBuyer(id, type);

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

    //通过订单Id和卖方用户Id修改订单
    public String UpdateOrderSellerId() {
        String order_id = request.getParameter("order_id");
        String user_seller_id = request.getParameter("user_seller_id");
        IUpdateOrderService updateOrderService = new UpdateOrderService();
        updateOrderService.UpdateOrderSellerId(order_id, user_seller_id);
        return null;
    }

    //通过订单Id删除订单及订单详细信息
    public String DeleteOrderInfoByOrderId() {
        String order_id = request.getParameter("order_id");
        IDeleteOrderService deleteOrderService = new DeleteOrderService();
        deleteOrderService.DeleteOrderInfoByOrderId(order_id);
        return null;
    }

    public String GetNoPaidOrderByUserId() throws IOException {
        String id = request.getParameter("user_id_buyer");
        List<Order> list = new ArrayList<>();

        IGetOrderService getOrderService = new GetOrderService();
        list = getOrderService.GetNoPaidOrderByUserId(id);

        JSONArray jsonArray = new JSONArray();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no_paid_order_number", list.get(i).getNo_paid_order_number());
            jsonObject.put("no_paid_money", list.get(i).getNo_paid_money());
            jsonObject.put("company_id_seller", list.get(i).getCompany_id_seller());
            jsonObject.put("company_logo", list.get(i).getCompany_logo());
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

    public String GetReconciliationInfo() throws IOException {
        String user_id = request.getParameter("user_id");
        String company_id = request.getParameter("company_id");
        String type = request.getParameter("type");
        IGetOrderService getOrderService = new GetOrderService();
        int CMO = getOrderService.GetCountMattrOrder(user_id, company_id, type);
        int CP = getOrderService.GetCountPayment(user_id,company_id, type);


        JSONObject json = new JSONObject();
        json.put("user_id", user_id);
        json.put("company_id", company_id);
        json.put("CMO", CMO);
        json.put("CP", CP);
        byte[] jsonBytes = json.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return null;
    }

    @Override
    public Order getModel() {
        return order;
    }
}
