package com.sz.dao;

import com.sz.entity.Account;
import com.sz.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AccountDao {

    // 创建账户
    public int register(Account account) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "insert into account values(?,?,?,?)";

        Object[] param = {null,account.getUsername(),account.getCard(),account.getBalance()};

        int update = queryRunner.update(sql, param);

        return update;

    }


    // 获取账户
    public Account findAccountByCard(String card) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from account where card = ?";

//        Object[] query = queryRunner.query(sql, new ArrayHandler(), card);
//
//        System.out.println(Arrays.toString(query)); //[4, tom, 1122334455, 20000.0]

        Account account = queryRunner.query(sql, new BeanHandler<Account>(Account.class), card);

        return account;

    }

    // 修改账户余额
    public int updateAccountBalance(String card, double newBalance) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "update account set balance = ? where card = ?";

        int update = queryRunner.update(sql,newBalance,card);

        return update;
    }
}
