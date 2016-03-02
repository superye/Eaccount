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
}
