package com.afshin;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "JoinEmployeeMitOffice",query = "Select o from Employee o inner join fetch o.customers"),
        @NamedQuery(name = "CountGroup",query = "Select o.officeCode, count(o.employeeNumber) from Employee o " +
                "group by o.officeCode order by o.officeCode"),
        //parameterized query: named parameter
        @NamedQuery(name = "Selectedquery",query = "select o.employeeNumber,o.firstName,o.lastName " +
                "from Employee o"+" where o.employeeNumber=:empnum"
        )
})
public class Employee {

    public Employee() {
    }

    @Transient
        private Integer count;

    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "reportsTo")
    private Integer reportsTo;

    @Column(name = "jobTitle")
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "officeCode",insertable = false,updatable = false)
    private Office office;

    @OneToMany(mappedBy = "employee")
    private List<Customer> customers;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employeeList;

    @ManyToOne()
    @JoinColumn(name = "reportsTo",referencedColumnName = "employeeNumber",insertable = false,updatable = false)
    private Employee manager;

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
//                "\n, office=" + office +
//                "\n, customers=" + customers +
//               "\n, employeeList=" + employeeList +
//                "\n, manager=" + manager +
                '}';
    }
}