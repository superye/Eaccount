package com.eaccount.domain;

/**
 * Created by yehao on 16/2/29.
 */
public class User_profile {
    private String id;
    private String user_name;
    private String user_photo;
    private String user_birthday;
    private String user_phone_number;
    private String account;
    private String user_password;
    private String permission_delivery;
    private String permission_receiving;
    private String permission_reconciliatior;
    private String permission_settlement;
    private String designate_delivery;
    private String designate_receiving;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPermission_delivery() {
        return permission_delivery;
    }

    public void setPermission_delivery(String permission_delivery) {
        this.permission_delivery = permission_delivery;
    }

    public String getPermission_receiving() {
        return permission_receiving;
    }

    public void setPermission_receiving(String permission_receiving) {
        this.permission_receiving = permission_receiving;
    }

    public String getPermission_reconciliatior() {
        return permission_reconciliatior;
    }

    public void setPermission_reconciliatior(String permission_reconciliatior) {
        this.permission_reconciliatior = permission_reconciliatior;
    }

    public String getPermission_settlement() {
        return permission_settlement;
    }

    public void setPermission_settlement(String permission_settlement) {
        this.permission_settlement = permission_settlement;
    }

    public String getDesignate_delivery() {
        return designate_delivery;
    }

    public void setDesignate_delivery(String designate_delivery) {
        this.designate_delivery = designate_delivery;
    }

    public String getDesignate_receiving() {
        return designate_receiving;
    }

    public void setDesignate_receiving(String designate_receiving) {
        this.designate_receiving = designate_receiving;
    }
}
