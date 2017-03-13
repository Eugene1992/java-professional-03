package com.cbu.edu.JDBC.Model;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public class Employee extends IdEntity {
    private String fullName;
    private int age;
    private String address;

    public Employee(int id, String fullName, int age, String address) {
        super(id);
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (fullName != null ? !fullName.equals(employee.fullName) : employee.fullName != null) return false;
        return address != null ? address.equals(employee.address) : employee.address == null;
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
