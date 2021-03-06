package com.eaccount.controller.action;

import com.eaccount.domain.*;
import com.eaccount.service.*;
import com.eaccount.util.GetNowTime;
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

    //通过订单Id和卖方或买方用户Id修改订单
    public String UpdateOrderUserId() {
        String order_id = request.getParameter("order_id");
        String user_id = request.getParameter("user_id");
        String type = request.getParameter("type");
        IUpdateOrderService updateOrderService = new UpdateOrderService();
        updateOrderService.UpdateOrderSellerId(order_id, user_id, type);
        return null;
    }

    //通过订单Id删除订单及订单详细信息
    public String DeleteOrderInfoByOrderId() {
        //删除订单信息
        String order_id = request.getParameter("order_id");
        IDeleteOrderService deleteOrderService = new DeleteOrderService();

        //发送拒收消息
        IGetOrderService getOrderService = new GetOrderService();
        List<Order> list = new ArrayList<>();
        list = getOrderService.GetOrderByOrderId(order_id, "2");

        Message_list message_list = new Message_list();
        message_list.setMessage_sender(list.get(0).getUser_id_buyer());
        message_list.setMessage_receiver(list.get(0).getUser_id_seller());
        message_list.setMessage_title(list.get(0).getUser_name() + "已拒收");
        message_list.setMessage_type("4");
        message_list.setMessage_date(new GetNowTime().GetTime(1));

        ISendMessageService sendMessageService = new SendMessageService();
        sendMessageService.SendMessage(message_list);

        //删除操作最后执行
        deleteOrderService.DeleteOrderInfoByOrderId(order_id);
        return null;
    }

    public String GetNoPaidOrderByUserId() throws IOException {
        String id = request.getParameter("user_id");
        String type = request.getParameter("type");
        List<Order> list = new ArrayList<>();
        if (type.equals("1")) {
            IGetOrderService getOrderService = new GetOrderService();
            list = getOrderService.GetNoPaidOrderByUserBuyerId(id);
        }else {
            IGetOrderService getOrderService = new GetOrderService();
            list = getOrderService.GetNoPaidOrderByUserSellerId(id);
        }

        JSONArray jsonArray = new JSONArray();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no_paid_order_number", list.get(i).getNo_paid_order_number());
            jsonObject.put("no_paid_money", list.get(i).getNo_paid_money());
            if (type.equals("1")) {
                jsonObject.put("company_id_seller", list.get(i).getCompany_id_seller());
            } else {
                jsonObject.put("company_id_buyer", list.get(i).getCompany_id_buyer());
            }
            jsonObject.put("company_name", list.get(i).getCompany_name());
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


    public String GetRecButNoPaidOrderByUserId() throws IOException {
        String id = request.getParameter("user_id");
        String type = request.getParameter("type");
        List<Order> list = new ArrayList<>();
        if (type.equals("1")) {
            IGetOrderService getOrderService = new GetOrderService();
            list = getOrderService.GetRecNoPaidOrderByUserBuyerId(id);
        }else {
            IGetOrderService getOrderService = new GetOrderService();
            list = getOrderService.GetRecNoPaidOrderByUserSellerId(id);
        }

        JSONArray jsonArray = new JSONArray();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no_paid_order_number", list.get(i).getNo_paid_order_number());
            jsonObject.put("no_paid_money", list.get(i).getNo_paid_money());
            if (type.equals("1")) {
                jsonObject.put("company_id_seller", list.get(i).getCompany_id_seller());
            } else {
                jsonObject.put("company_id_buyer", list.get(i).getCompany_id_buyer());
            }
            jsonObject.put("company_name", list.get(i).getCompany_name());
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
        String company_id2 = request.getParameter("company_id");
        String type = request.getParameter("type");
        IGetOrderService getOrderService = new GetOrderService();
        IGetProfileService getProfileService = new GetProfileService();
        String company_id1 = getProfileService.GetCompanyIdByUserId(user_id);
        int CMO = getOrderService.GetCountMattrOrder(company_id1, company_id2, type);
        int CP = getOrderService.GetCountPayment(company_id1,company_id2, type);
        List<Order> list = new ArrayList<>();
        List<Order_detail> listTemp = null;
        list = getOrderService.GetMatterOrderInfo(company_id1, company_id2, type);

        int len = 0;
        if (list != null) {
            len = list.size();
        }

        JSONObject tempJson = null;
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = null;
        for (int i = 0; i < len; i++) {
            listTemp = new ArrayList<>();
            listTemp = getOrderService.GetOrderDetailByMatterOrderId(list.get(i).getOrder_id());

            for (int j = 0; j < listTemp.size(); j++) {
                tempJson = new JSONObject();
                tempJson.put("product_name", listTemp.get(j).getProduct_name());
                tempJson.put("product_specification", listTemp.get(j).getProduct_specification());
                tempJson.put("quantity_delivery", listTemp.get(j).getQuantity_delivery());
                tempJson.put("quantity_receiving", listTemp.get(j).getQuantity_receiving());
                tempJson.put("order_id", list.get(i).getOrder_id());
                tempJson.put("receiving_time", list.get(i).getReceiving_time());
                tempJson.put("id", listTemp.get(j).getId());
                jsonArray1.add(tempJson);
            }
        }

        JSONObject json = new JSONObject();
        json.put("user_id", user_id);
        json.put("company_id", company_id2);
        json.put("CMO", CMO);
        json.put("CP", CP);
        json.put("list1", jsonArray1);
        byte[] jsonBytes = json.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return null;
    }

    public String GetMatterOrderDetailInfo() throws IOException {
        IGetProfileService getProfileService = new GetProfileService();
        IGetOrderService getOrderService = new GetOrderService();
        List<User_profile> listU = new ArrayList<>();
        List<Company_profile> listC = new ArrayList<>();
        List<Order> listO = new ArrayList<>();

        String user_id = request.getParameter("user_id");
        String company_id1 = getProfileService.GetCompanyIdByUserId(user_id);
        String company_id2 = request.getParameter("company_id");
        String boss_id = getProfileService.GetCompanyInfoByCompanyId(company_id2).get(0).getManager_id();
        String type = request.getParameter("type");
        String IsReconciliation = request.getParameter("IsReconciliation");
        listU = getProfileService.GetUserInfoByUserId(boss_id);
        listC = getProfileService.GetCompanyInfoByCompanyId(company_id2);

        listO = getOrderService.GetMatterOrderDetailInfo(company_id1, company_id2, type, IsReconciliation);
        JSONArray jsonArray = new JSONArray();
        JSONObject tempJson = null;
        int len = 0;
        if (listO != null) {
            len = listO.size();
        }
        for (int i = 0; i < len; i++) {
            tempJson = new JSONObject();
            tempJson.put("order_id", listO.get(i).getOrder_id());
            tempJson.put("receiving_time", listO.get(i).getReceiving_time());
            tempJson.put("type_number", listO.get(i).getType_number());
            tempJson.put("product_number", listO.get(i).getProduct_number());
            if ("1".equals(type)) {
                tempJson.put("money", listO.get(i).getTotal_price_buyer());
            } else {
                tempJson.put("money", listO.get(i).getTotal_price_seller());
            }
            jsonArray.add(tempJson);
        }

        JSONObject json = new JSONObject();
        json.put("user_name", listU.get(0).getUser_name());
        json.put("user_phone_number", listU.get(0).getUser_phone_number());
        json.put("company_name", listC.get(0).getCompany_name());
        json.put("comapny_logo", listC.get(0).getCompany_logo());
        json.put("company_address", listC.get(0).getCompany_address());
        json.put("list", jsonArray);
        byte[] jsonBytes = json.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }

    public String GetAccountPeriod() throws IOException {
        String user_id = request.getParameter("user_id");
        String type = request.getParameter("type");

        IGetOrderService getOrderService = new GetOrderService();
        List<Order> list = new ArrayList<>();
        list = getOrderService.GetAccountPeriod(user_id, type);

        JSONObject json = null;
        JSONArray jsonArray = new JSONArray();

        int len = 0;
        if (list != null) {
            len = list.size();
        }

        for (int i = 0; i < len; i++) {
            json = new JSONObject();
            if ("1".equals(type)) {
                json.put("company_id", list.get(i).getCompany_id_buyer());
            } else {
                json.put("company_id", list.get(i).getCompany_id_seller());
            }
            json.put("company_name", list.get(i).getCompany_name());
            json.put("company_logo", list.get(i).getCompany_logo());
            json.put("diff_date", list.get(i).getDiff_date());
            jsonArray.add(json);
        }

        byte[] jsonBytes = jsonArray.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }

    public String SetReceivingTime() {
        IUpdateOrderService updateOrderService = new UpdateOrderService();
        updateOrderService.SetReceivingTime(order.getOrder_id(), new GetNowTime().GetTime(2));
        System.out.println(new GetNowTime().GetTime(2));

        return null;
    }

    public String UpdateTotalPrice() {
        IUpdateOrderService updateOrderService = new UpdateOrderService();
        IGetOrderService getOrderService = new GetOrderService();

        String order_id = request.getParameter("order_id");
        String order_detail_id = request.getParameter("order_detail_id");

        if (order_id == null || order_id == "") {
            order_id = getOrderService.GetOrderIdByOrderDetailId(order_detail_id);
        }

        updateOrderService.UpdateTotalPrice(order_id);
        return null;
    }

    public String CheckOrderIsMatter() {
        String order_id = request.getParameter("order_id");

        IGetOrderService orderService = new GetOrderService();
        IUpdateOrderService updateOrderService = new UpdateOrderService();
        if (orderService.CountMatterOrder(order_id.trim())) {
           updateOrderService.UpdateReconciliation(order_id);
        }
        return null;
    }

    @Override
    public Order getModel() {
        return order;
    }
}
