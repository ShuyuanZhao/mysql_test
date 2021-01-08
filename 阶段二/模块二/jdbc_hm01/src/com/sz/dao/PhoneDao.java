package com.sz.dao;

import com.sz.entity.Account;
import com.sz.entity.Phone;
import com.sz.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PhoneDao {


    public List<Phone> findPhoneByPriceColor(double price ,String prodate) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from phone where price > ? and prodate < ?";

        Object[] param = {price,prodate};

        List<Phone> phones = queryRunner.query(sql, new BeanListHandler<Phone>(Phone.class), param);

        return phones;

    }

    public List<Phone> findPhoneByColor(String color) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from phone where color = ?";


        List<Phone> phones = queryRunner.query(sql, new BeanListHandler<Phone>(Phone.class), color);

        return phones;

    }
}
