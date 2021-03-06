package com.afshin.Entity;

import javax.persistence.*;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:26 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@Entity
@Table(name = "users")
public class User {
    public User() {}

    @Id
    @Column(name = "idusers")
    private Integer idusers;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "employeeid")
    private Integer employeeid;
    @ManyToOne
    @JoinColumn(name = "employeeid",referencedColumnName = "employeeNumber",insertable = false,updatable = false)
    private Employee employee;

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "User{" +
                "idusers=" + idusers +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeid=" + employeeid +
                ", employee=" + employee +
                '}';
    }
}
