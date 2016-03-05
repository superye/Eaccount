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
    <script type="text/javascript">
      function test1() {
          $.ajax({
            url: "http://localhost:8080/order_GetOrderMessage.action",
            data: {"user_id_seller" : $("#user_id_seller").val(),
                  "type" : $("#type").val()},
            type: "GET",
            success: function (data) {
              $("#test2").append(data);
            }
          });
      }
      function test2() {
        $.ajax({
          url: "http://localhost:8080/order_GetOrderMessage.action",
          data: {"id" : $("#id").val(),
          type: "GET",
          success: function (data) {
            $("#test2").append(data);
          }
        });
      }
    </script>
  </head>
  <body>
    通过用户id获取订单信息测试
    <form action="order_SellerGetOrderMessage.action" id="form1">
      <input type="text" id="user_id_seller" name="user_id_seller" placeholder="id"/>
      <input type="text" id="type" name="type" placeholder="type">
      <input type="submit" value="提交"/>
    </form>
    通过订单id获取订单详细信息测试
    <form action="orderDetail_SellerGetOrderDetailInfoByOrderId.action" >
      <input type="text" id="order_id" name="order_id" placeholder="order_id">
      <input type="submit" value="提交"/>
    </form>
    通过接收方id查询信息测试
    <form action="messageList_GetMessageById.action" >
      <input type="text" id="id" name="id" placeholder="id">
      <input type="submit" value="提交"/>
    </form>
    通过用户id查询同公司的用户的id
    <form action="UserProfile_GetUserInfoByUserId.action">
      <input type="text" id="user_id" name="user_id" placeholder="id">
      <input type="submit" value="提交">
    </form>
  </body>
</html>
