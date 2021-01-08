package com.sz.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String deptname;

    List<Employee> employeeList = new ArrayList<>();

    public Department() {
    }

    public Department(int id, String deptname) {
        this.id = id;
        this.deptname = deptname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
