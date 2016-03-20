package com.eaccount.domain;

/**
 * Created by yehao on 16/3/1.
 */
public class Pay {
    private String id;
    private String message_receiver;
    private String message_sender;
    private String amount_of_money;
    private String pay_state;
    private String pay_time;
    private String pay_picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage_receiver() {
        return message_receiver;
    }

    public void setMessage_receiver(String message_receiver) {
        this.message_receiver = message_receiver;
    }

    public String getMessage_sender() {
        return message_sender;
    }

    public void setMessage_sender(String message_sender) {
        this.message_sender = message_sender;
    }

    public String getAmount_of_money() {
        return amount_of_money;
    }

    public void setAmount_of_money(String amount_of_money) {
        this.amount_of_money = amount_of_money;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_picture() {
        return pay_picture;
    }

    public void setPay_picture(String pay_picture) {
        this.pay_picture = pay_picture;
    }
}
