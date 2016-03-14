package com.eaccount.controller.action;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;
import com.eaccount.domain.User_profile;
import com.eaccount.service.*;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import java.io.*;
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
            }else
                jsonObject.put("company_id_buyer", list.get(i).getCompany_id_buyer());
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
        List<Order> list = new ArrayList<>();
        List<Order_detail> listTemp = null;
        list = getOrderService.GetMatterOrderInfo(user_id, company_id, type);

        int len = 0;
        if (list != null) {
            len = list.size();
        }

        JSONObject tempJson = null;
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = null;
        for (int i = 0; i < len; i++) {
            jsonArray2 = new JSONArray();
            listTemp = new ArrayList<>();
            listTemp = getOrderService.GetOrderDetailByMatterOrderId(list.get(i).getOrder_id());

            for (int j = 0; j < listTemp.size(); j++) {
                tempJson = new JSONObject();
                tempJson.put("product_name", listTemp.get(j).getProduct_name());
                tempJson.put("product_specification", listTemp.get(j).getProduct_specification());
                tempJson.put("quantity_delivery", listTemp.get(j).getQuantity_delivery());
                tempJson.put("quantity_receiving", listTemp.get(j).getQuantity_receiving());
                jsonArray2.add(tempJson);
            }

            tempJson = new JSONObject();
            tempJson.put("order_id", list.get(i).getOrder_id());
            tempJson.put("receiving_time", list.get(i).getReceiving_time());
            tempJson.put("id", list.get(i).getId());
            tempJson.put("list2", jsonArray2);
            jsonArray1.add(tempJson);
        }

        JSONObject json = new JSONObject();
        json.put("user_id", user_id);
        json.put("company_id", company_id);
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
        String company_id = request.getParameter("company_id");
        String type = request.getParameter("type");
        listU = getProfileService.GetUserInfoByUserId(user_id);
        listC = getProfileService.GetCompanyInfoByCompanyId(company_id);
        listO = getOrderService.GetMatterOrderInfo(user_id, company_id, type);



        JSONObject json = new JSONObject();
        json.put("user_name", listU.get(0).getUser_name());
        json.put("user_phone_number", listU.get(0).getUser_phone_number());
        json.put("company_name", listC.get(0).getCompany_name());
        json.put("comapny_logo", listC.get(0).getCompany_logo());
        json.put("company_address", listC.get(0).getCompany_address());
        byte[] jsonBytes = json.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }

    // username属性用来封装用户名
    private String username;

    // myFile属性用来封装上传的文件
    private File myFile;

    // myFileContentType属性用来封装上传文件的类型
    private String myFileContentType;

    // myFileFileName属性用来封装上传文件的文件名
    private String myFileFileName;


    //获得username值
    public String getUsername() {
        return username;
    }

    //设置username值
    public void setUsername(String username) {
        this.username = username;
    }

    //获得myFile值
    public File getMyFile() {
        return myFile;
    }

    //设置myFile值
    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    //获得myFileContentType值
    public String getMyFileContentType() {
        return myFileContentType;
    }

    //设置myFileContentType值
    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    //获得myFileFileName值
    public String getMyFileFileName() {
        return myFileFileName;
    }

    //设置myFileFileName值
    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String imageTest() throws IOException {
        //基于myFile创建一个文件输入流
        InputStream is = new FileInputStream(myFile);

        // 设置上传文件目录
        String uploadPath = ServletActionContext.getServletContext()
                .getRealPath("/upload");

        // 设置目标文件
        File toFile = new File(uploadPath, this.getMyFileFileName());

        // 创建一个输出流
        OutputStream os = new FileOutputStream(toFile);

        //设置缓存
        byte[] buffer = new byte[1024];

        int length = 0;

        //读取myFile文件输出到toFile文件中
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        System.out.println("上传用户" + username);
        System.out.println("上传文件名"+myFileFileName);
        System.out.println("上传文件类型"+myFileContentType);
        //关闭输入流
        is.close();

        //关闭输出流
        os.close();
        return null;
    }

    @Override
    public Order getModel() {
        return order;
    }
}
