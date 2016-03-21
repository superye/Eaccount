/**
 * Created by yehao on 16/3/21.
 */

function AddGood(company_id) {
    var goods = $("#goods").val();
    var specification = $("#specification").val();
    var url = "http://localhost:8080/updateproduct_AddProduct.action";
    var data = "product_name="+goods+"&product_specification="+specification+"&company_id=" + company_id;
    $.ajax({
        type:"GET",
        url:url,
        data: data,
        success: function(Msg) {
            location.reload();
        }
    });
}

function DeleteGood(id) {
    $("#goods"+id).remove();
    var url = "http://localhost:8080/updateproduct_DeleteProduct.action";
    var data = "id="+id;
    $.ajax({
        type:"GET",
        url:url,
        data: data,
        success: function(Msg) {
        }
    });
}
