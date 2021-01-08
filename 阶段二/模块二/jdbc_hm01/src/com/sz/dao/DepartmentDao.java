package com.sz.dao;

import com.sz.entity.Department;
import com.sz.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class DepartmentDao {

    public Department findDepartment(int dptId) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from dept where id = ?";

        Department department = queryRunner.query(sql, new BeanHandler<Department>(Department.class),dptId);

        return department;

    }
}
