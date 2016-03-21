package com.eaccount.domain;

/**
 * Created by yehao on 16/3/1.
 */
public class Product {
    private String id;
    private String product_name;
    private String product_specification;

    /**
     * 额外补充属性
     *商品单价,发货数量(用于发货商品详情)
     */
    private int unit_price;
    private int quantity_delivery;

    /**
     * 实收数量,金额(加上上面的,用于收货商品详情)
     */
    private int quantity_receiving;
    private int money;

    /**
     * 所属商品
     * @return
     */

    private String company_id;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_specification() {
        return this.product_specification;
    }

    public void setProduct_specification(String product_specification) {
        this.product_specification = product_specification;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity_delivery() {
        return quantity_delivery;
    }

    public void setQuantity_delivery(int quantity_delivery) {
        this.quantity_delivery = quantity_delivery;
    }

    public int getQuantity_receiving() {
        return quantity_receiving;
    }

    public void setQuantity_receiving(int quantity_receiving) {
        this.quantity_receiving = quantity_receiving;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
