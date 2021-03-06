package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Hibernate - HQL
 */
import com.afshin.Entity.Employee;
import com.afshin.General.Mysession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

//HQL method
public class EmployeeDao {
    Session neshast = Mysession.getsession();
    //ExecuteQuery
    public EmployeeDao() {}
    public List<Employee> findall(){
        try(Session localneshast=Mysession.getsession();) { //try with Resources
            return neshast.createQuery("from Employee").list();
        }
    }
    public Employee findbyid(Integer empnum){
        return neshast.find(Employee.class, empnum);
        //return neshast.get(Employee.class, empnum);
        //return neshast.load(Employee.class, empnum);
    }
    public List<Employee> joinedQuey(){
        return neshast.createNamedQuery("JoinEmployeeMitOffice").list();
    }
    public List<?> aggregation(){
        return neshast.createNamedQuery("CountGroup").list();
    }
    public List<Employee> parameterized(Integer inputnumber){
        return neshast.createNamedQuery("Selectedquery").setParameter("empnum",inputnumber).setMaxResults(10).list();
    }

    //ExecuteUpdate
    public void insert(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
             neshast.persist(employee);
            tx.commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void update(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.merge(employee);
            tx.commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void delete(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.delete(employee);
            tx.commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
}