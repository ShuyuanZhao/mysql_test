package com.sz.entity;

public class Employee {

    private int id;
    private String name;
    private double age;
    private String sex;
    private double salary;
    private String empdate;
    private int did;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, double age, String sex, double salary, String empdate, int did) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.empdate = empdate;
        this.did = did;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmpdate() {
        return empdate;
    }

    public void setEmpdate(String empdate) {
        this.empdate = empdate;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", empdate='" + empdate + '\'' +
                ", did=" + did +
                ", department='" + department + '\'' +
                '}';
    }


}
