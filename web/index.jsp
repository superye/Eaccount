<%--
  Created by IntelliJ IDEA.
  User: yehao
  Date: 16/2/29
  Time: 下午9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>
  </head>
  <body>
    通过用户id获取订单信息测试
    <form action="order_SellerGetOrderMessage.action" id="form1">
      <input type="text" name="user_id_seller" placeholder="id"/>
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交" />
    </form>
    通过订单id获取订单详细信息测试
    <form action="orderDetail_SellerGetOrderDetailInfoByOrderId.action" >
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="提交"/>
    </form>
    通过接收方id查询信息测试
    <form action="messageList_GetMessageById.action" >
      <input type="text" name="id" placeholder="id">
      <input type="submit" value="提交"/>
    </form>
    通过用户id查询同公司的用户的id
    <form action="UserProfile_GetUserInfoByUserId.action">
      <input type="text" name="user_id" placeholder="id">
      <input type="submit" value="提交">
    </form>
    通过订单Id和用户Id将该订单的user_seller_id修改为该用户Id
    <form action="order_UpdateOrderSellerId.action">
      <input type="text" name="user_seller_id" placeholder="user_seller_id">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="submit">
    </form>
    通过订单Id删除订单及订单明细信息
    <form action="order_DeleteOrderInfoByOrderId.action">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="submit">
    </form>
    通过买方id获取订单信息测试
    <form action="order_BuyerGetOrderMessage.action">
      <input type="text" name="user_id_buyer" placeholder="id"/>
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交" />
    </form>
  </body>
</html>
