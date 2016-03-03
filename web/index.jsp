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
  </head>
  <body>
    <form action="order_GetOrderMessage.action" enctype="multipart/form-data">
      <input type="text" id="user_id_seller" name="user_id_seller" placeholder="id"/>
      <input type="text" id="type" name="type" placeholder="type">
      <input type="submit" value="提交"/>
    </form>
  </body>
</html>
