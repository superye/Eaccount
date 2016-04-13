package com.eaccount.controller.action;

import com.eaccount.domain.Message_list;
import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;
import com.eaccount.service.*;
import com.eaccount.util.GetNowTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-4.
 */
public class Order_detailAction extends SuperAction{
   public String GetOrderDetailInfoByOrderId() throws IOException {
      //获取订单信息
      List<Order> list1 = new ArrayList<>();
      List<Order_detail> list2 = new ArrayList<>();
      IGetOrderService getOrderService = new GetOrderService();
      String id = request.getParameter("order_id");
      String type = request.getParameter("type");

      list1 = getOrderService.GetOrderByOrderId(id, type);
      list2 = getOrderService.GetOrderDetailByOrderId(id);

      JSONObject json = null;
      JSONArray jsonArray = new JSONArray();
      for (int i = 0; i < list2.size(); i++) {
         json = new JSONObject();
         json.put("Order_Detail_id", list2.get(i).getId());
         json.put("product_name", list2.get(i).getProduct_name());
         json.put("product_specification", list2.get(i).getProduct_specification());
         json.put("unit_price", list2.get(i).getUnit_price());
         json.put("quantity_delivery", list2.get(i).getQuantity_delivery());
         json.put("quantity_receiving", list2.get(i).getQuantity_receiving());
         if ("1".equals(type)) {
            json.put("money", list2.get(i).getMoney());
         } else {
            json.put("money", list2.get(i).getMoney2());
         }
         jsonArray.add(json);
      }

      JSONObject jsonObject = new JSONObject();
      jsonObject.put("company_logo", list1.get(0).getCompany_logo());
      jsonObject.put("company_name", list1.get(0).getCompany_name());
      jsonObject.put("company_address", list1.get(0).getCompany_address());
      jsonObject.put("user_name", list1.get(0).getUser_name());
      jsonObject.put("user_phone_number", list1.get(0).getUser_phone_number());
      jsonObject.put("place_order_time", list1.get(0).getPlace_order_time());
      jsonObject.put("receiving_time", list1.get(0).getReceiving_time());
      jsonObject.put("photo", list1.get(0).getPhoto());
      if ("type".equals(2)) {
         jsonObject.put("user_id", list1.get(0).getUser_id_buyer());
      } else {
         jsonObject.put("user_id", list1.get(0).getUser_id_seller());
      }
      jsonObject.put("List", jsonArray);

      byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
      response.setContentType("text/html;charset=utf-8");
      response.setContentLength(jsonBytes.length);
      response.getOutputStream().write(jsonBytes);
      response.getOutputStream().flush();
      response.getOutputStream().close();
      return null;
   }

   public String UpdateQuantity() {
      String id = request.getParameter("order_detail_id");
      String type = request.getParameter("type");
      String Is_Send_Message = request.getParameter("Is_Send_Message");

      IUpdateOrderService updateOrderService = new UpdateOrderService();
      updateOrderService.UpdateQuantity(id, type);

      IGetOrderService getOrderService = new GetOrderService();
      String order_id = getOrderService.GetOrderIdByOrderDetailId(id);

      List<Order> list = new ArrayList<>();

      ISendMessageService sendMessageService = new SendMessageService();
      IGetProfileService getProfileService = new GetProfileService();
      Message_list message_list = new Message_list();
      if ("1".equals(type)) {
         list = getOrderService.GetOrderByOrderId(order_id, "1");
         message_list.setMessage_sender(list.get(0).getUser_id_buyer());
         message_list.setMessage_receiver(getProfileService.GetCompanyInfoByCompanyId(list.get(0).getUser_id_seller()).get(0).getManager_id());
      } else {
         list = getOrderService.GetOrderByOrderId(order_id, "2");
         message_list.setMessage_sender(list.get(0).getUser_id_seller());
         message_list.setMessage_receiver(getProfileService.GetCompanyInfoByCompanyId(list.get(0).getUser_id_buyer()).get(0).getManager_id());
      }
      message_list.setMessage_date(new GetNowTime().GetTime(1));
      message_list.setMessage_type("6");
      message_list.setMessage_title(list.get(0).getUser_name() + "同意变更订单:" + order_id + "中 明细:" + id + "的货物数量");
      message_list.setMessage_remark(order_id);

      if ("1".equals(Is_Send_Message)) {
         sendMessageService.SendMessage(message_list);
      }

      //判断该订单明细所在订单是否已对账
      List<Order_detail> listD = new ArrayList<>();
      listD = getOrderService.GetOrderDetailByMatterOrderId(order_id);
      if (listD == null || listD.size() == 0) {
         updateOrderService.UpdateReconciliation(order_id);
      }

      updateOrderService.UpdateTotalPrice(order_id);

      return null;
   }

   public String BuyerSetQuantity() {
      String id = request.getParameter("order_detail_id");
      String quantity = request.getParameter("quantity");

      IUpdateOrderService updateOrderService = new UpdateOrderService();
      updateOrderService.BuyerSetQuantity(id, quantity);
      return null;
   }

   public void InsertOrderDetails() {
      String order_id = request.getParameter("order_id");
      String ptoduct_id = request.getParameter("product_id");
      String unit_price = request.getParameter("unit_price");
      String quantity_delivery = request.getParameter("quantity_delivery");
      Order_detail order_detail = new Order_detail();
      order_detail.setOrder_id(order_id);
      order_detail.setProduct_id(ptoduct_id);
      order_detail.setUnit_price(unit_price);
      order_detail.setQuantity_delivery(quantity_delivery);

      IUpdateOrderService updateOrderService = new UpdateOrderService();
      updateOrderService.InsertOrderDetails(order_detail);

      JSONObject jsonObject = new JSONObject();
      jsonObject.put("result", "success");
      try {
         byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
         response.setContentType("text/html;charset=utf-8");
         response.setContentLength(jsonBytes.length);
         response.getOutputStream().write(jsonBytes);
         response.getOutputStream().flush();
         response.getOutputStream().close();
      } catch (Exception e){}

   }
}
