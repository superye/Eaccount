package com.eaccount.domain;

/**
 * Created by yehao on 16/3/1.
 */
public class Order_detail {
    private String id;
    private String order_id;
    private String product_id;
    private String unit_price;
    private String quantity_delivery;
    private String quantity_receiving;

    /**
     * 商品名称
     * 商品类别
     * 总金额
     */
    private String product_name;
    private String product_specification;
    private int money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getQuantity_delivery() {
        return quantity_delivery;
    }

    public void setQuantity_delivery(String quantity_delivery) {
        this.quantity_delivery = quantity_delivery;
    }

    public String getQuantity_receiving() {
        return quantity_receiving;
    }

    public void setQuantity_receiving(String quantity_receiving) {
        this.quantity_receiving = quantity_receiving;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_specification() {
        return product_specification;
    }

    public void setProduct_specification(String product_specification) {
        this.product_specification = product_specification;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
