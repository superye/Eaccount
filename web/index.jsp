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
    </script>
  </head>
  <body>
    <form action="order_SellerGetOrderMessage.action" id="form1">
      <input type="text" id="user_id_seller" name="user_id_seller" placeholder="id"/>
      <input type="text" id="type" name="type" placeholder="type">
      <input type="submit" value="提交"/>
    </form>
    <form action="orderDetail_SellerGetOrderDetailInfoByOrderId.action" >
      <input type="text" id="order_id" name="order_id" placeholder="order_id">
      <input type="submit" value="提交"/>
    </form>
  </body>
</html>
