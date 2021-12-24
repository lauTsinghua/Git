package com.tedu.pojo;
/**用于封装员工信息的实体类**/
public class Emp {
    private Integer id;
    private String name;
    private String job;
    private Double salary;
    /**
     * Student
     *
     * private double score;//基本数据类型,默认值是 0
     * private Double score;//包装类型,默认值是null
     *
     * **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
