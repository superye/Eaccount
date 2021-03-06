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
      <input type="text" name="user_id_seller" placeholder="id"/>
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交" />
    </form>
    通过订单id获取订单详细信息测试 1卖 2买
    <form action="orderDetail_GetOrderDetailInfoByOrderId.action" >
      <input type="text" name="order_id" placeholder="order_id">
      <input type="text" name="type" placeholder="type">
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
    通过订单Id和用户Id将该订单的user_id及用户类型修改为该用户Id
    <form action="order_UpdateOrderUserId.action">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="text" name="type" placeholder="type 1卖 2 买">
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
    登录测试
    <form action="login_Login.action">
      <input type="text" id="user_phone_number" name="user_phone_number" placeholder="phone">
      <input type="text" id="user_password" name="user_password" placeholder="password">
      <input type="submit" value="提交">
    </form>

    获取登录信息
    <form action="login_GetLoginInfo.action">
      <input type="text" name="user_phone_number" placeholder="phone">
      <input type="submit" value="提交">
    </form>

    信息测试
    <form action="messageList_SendMessage.action">
      <input type="text" id="message_receiver" name="message_receiver" placeholder="message_receiver">
      <input type="text" id="message_sender" name="message_sender" placeholder="message_sender">
      <input type="text" id="message_title" name="message_title" placeholder="message_title">
      <input type="text" id="message_type" name="message_type" placeholder="message_type">
      <input type="text" id="message_state" name="message_state" placeholder="message_state">
      <input type="text" id="message_remark" name="message_remark" placeholder="message_remark">
      <input type="submit" value="提交">
    </form>
    未付账单测试
    <form action="order_GetNoPaidOrderByUserId.action">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交">
    </form>
    已对账,未付账单测试
    <form action="order_GetRecButNoPaidOrderByUserId.action">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交">
    </form>
    查看对账信息
    <form action="order_GetReconciliationInfo.action">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="company_id" placeholder="company_id">
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="提交">
    </form>
    查看对账详情
     <form action="order_GetMatterOrderDetailInfo.action">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="company_id" placeholder="company_id">
      <input type="text" name="type" placeholder="type">
       <input type="text" name="IsReconciliation" placeholder="IsReconciliation">
      <input type="submit" value="提交">
    </form>
    图片测试
    <form action="upload_UploadImage.action" method="post" enctype="multipart/form-data">
      <input type="text" name="myFile">
      <input type="text" name="username">
      <input type="submit" value="submit">
    </form>
    账期提醒,负数代表还款日期在X天之后，正数代表已超过X天
    <form action="order_GetAccountPeriod.action" method="post">
      <input type="text" name="user_id" placeholder="user_id">
      <input type="text" name="type" placeholder="type 1 收款 2 付款">
      <input type="submit" value="submit">
    </form>

    自动生成id
    <form action="order_GetNewestOrderId.action">
      <input type="submit" value="submit">
    </form>

    添加付款信息
    <form action="pay_AddPayInfo.action">
      <input type="text" name="message_receiver" placeholder="Company_message_receiver">
      <input type="text" name="message_sender" placeholder="User_message_sender">
      <input type="text" name="amount_of_money" placeholder="amount_of_money">
      <input type="submit" value="submit">
    </form>

    修改订单明细表中货物数量 1 卖方将收货数量改为送货数量 2 买方将送货数量改为收货数量 1发送消息 2不发送消息
    <form action="orderDetail_UpdateQuantity.action">
      <input type="text" name="order_detail_id" placeholder="order_detail_id">
      <input type="text" name="type" placeholder="type">
      <input type="text" name="Is_Send_Message" placeholder="Is_Send_Message">
      <input type="submit" value="submit">
    </form>

    买方修改收货数量
    <form action="orderDetail_BuyerSetQuantity.action">
      <input type="text" name="order_detail_id" placeholder="order_detail_id">
      <input type="text" name="quantity" placeholder="quantity">
      <input type="submit" value="submit">
    </form>

    读消息1 或　取消消息2
    <form action="messageList_ReadMessage.action">
      <input type="text" name="message_id" placeholder="message_id">
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="submit">
    </form>

    设置收货时间
    <form action="order_SetReceivingTime.action">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="submit">
    </form>

    查看账单
    <form action="pay_GetPayInfoByCompanyId.action">
      <input type="text" name="company_id" placeholder="company_id">
      <input type="submit" value="submit">
    </form>

  　确认收款
    <form action="pay_ConfirmPay.action">
      <input type="text" name="pay_id" placeholder="pay_id">
      <input type="submit" value="submit">
    </form>

    更正订单总价
    <form action="order_UpdateTotalPrice.action">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="text" name="order_detail_id" placeholder="order_detail_id">
      <input type="submit" value="submit">
    </form>

    发送请求变更数量信息 1卖方发送　　２买方发送
    <form action="messageList_SendChangeQuantity.action">
      <input type="text" name="order_detail_id" placeholder="order_detail_id">
      <input type="text" name="type" placeholder="type">
      <input type="submit" value="submit">
    </form>

    发送催款信息
    <form action="messageList_SendNeedMoney.action">
      <input type="text" name="company_id_sender" placeholder="company_id_sender">
      <input type="text" name="company_id_receiver" placeholder="company_id_receiver">
      <input type="submit" value="submit">
    </form>

    发送确认收货信息
    <form action="messageList_SendConfirmReceiving.action">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="submit">
    </form>

    确认是否无需对账
    <form action="order_CheckOrderIsMatter.action">
      <input type="text" name="order_id" placeholder="order_id">
      <input type="submit" value="submit">
    </form>

  </body>
</html>
