package com.sz.dao;

import com.sz.entity.Transaction;
import com.sz.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class TransactionDao {
    // 写入交易记录
    public int writeTransaction(Transaction transaction) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        String sql = "insert into transaction values(?,?,?,?,?)";

        Object[] param = {null,transaction.getCardid(),transaction.getTratype(), transaction.getTramoney(),transaction.getTradate()};

        int update = qr.update(sql, param);

        return update;

    }





}
