package com.sz.entity;

import java.io.Serializable;

/**
 *  Account(账户表)
 *   id int(11)  PRIMARY KEY AUTO_INCREMENT,
 *   username varchar(100) ,	-- 用户姓名
 *   card varchar(100) ,		-- 卡号
 *   balance double	-- 当前余额
 */

public class Account implements Serializable {
    private int id;

    private String username;

    private String card;

    private double balance;

    public Account() {
    }

    public Account(int id, String username, String card, double balance) {
        this.id = id;
        this.username = username;
        this.card = card;
        this.balance = balance;
    }

    public Account(String username, String card, double balance) {
        this.username = username;
        this.card = card;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", card='" + card + '\'' +
                ", balance=" + balance +
                '}';
    }
}
