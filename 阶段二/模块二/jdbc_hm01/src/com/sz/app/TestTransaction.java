package com.sz.app;

import com.sz.dao.AccountDao;
import com.sz.dao.TransactionDao;
import com.sz.entity.Account;
import com.sz.entity.Transaction;
import com.sz.utils.DateUtils;
import org.junit.Test;

import java.sql.SQLException;

/**
 *  实现卡号：1122334455向55443332211转账5000元的操作；
 */

public class TestTransaction {

    AccountDao accountDao = new AccountDao();
    TransactionDao transactionDao = new TransactionDao();

    @Test
    public void testTransaction() throws SQLException {

        double traAmt = 5000;

        // 创建账户
//        Account newAccount = new Account("tom", "1122334455", 20000);
//        accountDao.register(newAccount);

        // 查看账户余额
        Account fromAccount = accountDao.findAccountByCard("1122334455");
        Account toAccount = accountDao.findAccountByCard("55443332211");

        System.out.println("账户 " + fromAccount.getCard() + " 的余额为：" + fromAccount.getBalance());
        System.out.println("账户 " + toAccount.getCard() + " 的余额为：" + toAccount.getBalance());

        if(fromAccount.getBalance() < traAmt) {
            System.out.println("账户余额不足，转账失败！");
            return;
        }

        // 修改账户余额并记录交易日志
        accountDao.updateAccountBalance("1122334455",fromAccount.getBalance()-traAmt);
        accountDao.updateAccountBalance("55443332211",toAccount.getBalance()+traAmt);

        transactionDao.writeTransaction(new Transaction("1122334455","转出",traAmt, DateUtils.getDateFormart()));
        transactionDao.writeTransaction(new Transaction("55443332211","转入",traAmt, DateUtils.getDateFormart()));

        System.out.println("转账成功！！");
    }
}
