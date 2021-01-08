package com.sz.app;

import com.sz.dao.PhoneDao;
import com.sz.entity.Phone;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestPhone {

    PhoneDao phoneDao = new PhoneDao();

    @Test
    public void testPhone() throws SQLException {
        List<Phone> phones;

        // 需求1:  查询价格高于2000元，生产日期是2019年之前的所有手机
        phones = phoneDao.findPhoneByPriceColor(2000, "2019-01-01");

        System.out.println("价格高于2000元，生产日期是2019年的手机有: ");

        for(Phone phone: phones){
            System.out.println(phone);
        }

        System.out.println("---------------------------------------------------------------");

        // 需求2:  查询所有颜色是白色的手机信息
        phones = phoneDao.findPhoneByColor("白色");

        System.out.println("颜色是白色的手机有: ");

        for(Phone phone: phones){
            System.out.println(phone);
        }




    }
}
