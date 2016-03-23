/**
 * Created by yehao on 16/3/17.
 */
var i = 0;
var m = 0;
function AddProduct() {
    var tmp = $("#productName").val();
    var str = "#productName option[value="+tmp+"]";
    $("#priceError").html("商品单价");
    $("#priceError").css({color:"black"});
    $("#numError").html("商品数量");
    $("#numError").css({color:"black"});
    if ($("#price").val()=="") {
        $("#priceError").html("商品单价 (单价不能为空)");
        $("#priceError").css({color:"red"});
        return;
    }
    if (isNaN($("#price").val())) {
        $("#priceError").html("商品单价 (单价不合法)");
        $("#priceError").css({color:"red"});
        return;
    }

    if ($("#num").val()=="") {
        $("#numError").html("商品数量 (数量不能为空)");
        $("#numError").css({color:"red"});
        return;
    }
    if (isNaN($("#num").val())) {
        $("#numError").html("商品数量 (数量不合法)");
        $("#numError").css({color:"red"});
        return;
    }

    var j = 1;
    for (;j<=i;j++) {
        if ($("#tdName" + j.toString()).html() == $(str).html()) {
            if ($("#tdPrice" + j.toString()).html() != $("#price").val()) {
                alert("与之前添加的同类商品价格不符!");
                return;
            }
            var price = $("#tdPrice" + j.toString()).html();
            var num = $("#num").val();
            m = m + price * num;
            var tmp = $("#tdNum" + j.toString()).html();
            num = num * 1 + tmp * 1;
            $("#total_price_seller").val(m);
            $("#tdNum" + j.toString()).html(num)
            return;
        }
    }
    i = i + 1;
    var s = i.toString();
    $("#productDetail").append("<tr id='trId"+s+"' class='even gradeC'><td id='tdId"+s+"'>"+$("#productName").val()
        +"</td><td id='tdName"+s+"'>"+$(str).html()
        +"</td> <td id='tdPrice"+s+"'>"+$("#price").val()
        +"</td> <td id='tdNum"+s+"' class='center'>"+$("#num").val()
        +"</td> <td class='center'><a href='javascript:void(0)' onclick='DeleteProduct("+s+")' ;>删除</a></td> </tr>");

    var price = ($("#tdPrice" + s).html());
    var num = ($("#tdNum" + s).html());
    m = m + price * num;
    $("#total_price_seller").val(m);
}

function DeleteProduct(id) {
    var s = id.toString();
    var price = ($("#tdPrice" + s).html());
    var num = ($("#tdNum" + s).html());
    m = m - price * num;
    $("#total_price_seller").val(m);
    $("#trId" + s).remove();
}

function AddOrder() {
    alert("a");
    var url = "http://www.spzn.party/updateorder_InsertOrder.action";
    var data = "order_id="+$("#order_id").val()+
        "&company_id_buyer="+$("#company_id_buyer").val()+
        "&user_id_seller="+$("#user_id_seller").val()+
        "&total_price_seller="+$("#total_price_seller").val()+
        "&payment_day="+$("#payment_day").val();
    $.ajax({
        type:"GET",
        url:url,
        data: data,
        success: function(Msg) {
            alert("下单成功");
        }
    });
    var j = 1;
    for (;j <= i; j++) {
        if ($("#trId" + j.toString()).length > 0) {
            AddOrderDetails($("#order_id").val(), $("#tdId"+ j.toString()).html(), $("#tdPrice" + j.toString()).html(), $("#tdNum"+ j.toString()).html());
        }
    }

}

function AddOrderDetails(order_id, pruduct_id, unit_price, quantity_delivery) {
    var url = "http://www.spzn.party/orderDetail_InsertOrderDetails.action";
    var data = "order_id="+order_id+
        "&product_id="+pruduct_id+
        "&unit_price="+unit_price+
        "&quantity_delivery="+quantity_delivery;

    $.ajax({
        type:"GET",
        url:url,
        data: data,
        success: function(Msg) {
        }
    });
}
