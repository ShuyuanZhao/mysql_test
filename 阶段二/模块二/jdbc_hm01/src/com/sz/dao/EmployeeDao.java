package com.sz.dao;

import com.sz.entity.Department;
import com.sz.entity.Employee;
import com.sz.entity.Phone;
import com.sz.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllEmployee() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from employee where did is not null";

        List<Employee> employees = queryRunner.query(sql, new BeanListHandler<Employee>(Employee.class));

        DepartmentDao departmentDao = new DepartmentDao();

        for(Employee employee: employees){
            Department department = departmentDao.findDepartment(employee.getDid());
            employee.setDepartment(department.getDeptname());
        }

        return employees;

    }
}
