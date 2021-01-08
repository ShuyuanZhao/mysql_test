package com.sz.app;

import com.sz.dao.EmployeeDao;
import com.sz.entity.Employee;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestEmployee {

    EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void testEmployee() throws SQLException {

        List<Employee> allEmployee = employeeDao.getAllEmployee();

        for(Employee employee: allEmployee){
            System.out.println(employee);
        }

    }

}
