package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Entity.Customer;
import com.afshin.Entity.Order;
import com.afshin.General.Myentitymanager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public OrderDao(){}
    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    //ExecuteQuery
    public List<com.afshin.Entity.Order> findAll(){
        CriteriaQuery<com.afshin.Entity.Order> criteriaQuery = criteriaBuilder.createQuery(com.afshin.Entity.Order.class);
        Root<com.afshin.Entity.Order> o = criteriaQuery.from(com.afshin.Entity.Order.class);
        criteriaQuery.select(o);
        criteriaQuery.orderBy(criteriaBuilder.asc(o.get("orderNumber")));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public com.afshin.Entity.Order findById(Integer ordNum){
        return entityManager.find(com.afshin.Entity.Order.class, ordNum);
    }
    public List<?> someColumn(){
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> o = criteriaQuery.from(com.afshin.Entity.Order.class);
        criteriaQuery.multiselect(o.get("orderNumber"), o.get("orderDate"), o.get("status"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<com.afshin.Entity.Order> whereClause(String stat){
        CriteriaQuery<com.afshin.Entity.Order> criteriaQuery = criteriaBuilder.createQuery(com.afshin.Entity.Order.class);
        Root<com.afshin.Entity.Order> o = criteriaQuery.from(com.afshin.Entity.Order.class);
        criteriaQuery.select(o);
        //WhereClause with list of Predicates : مبتنی بر
        List<Predicate> predicates=new ArrayList<>();
        predicates.add(criteriaBuilder.equal(o.get("status"), stat));
        predicates.add(criteriaBuilder.isNull(o.get("shippedDate")));
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        Query q = entityManager.createQuery(criteriaQuery);// select o from Order o where o.status=:stat
        return q.getResultList();
    }
    public List<?> aggregation(){
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> o = criteriaQuery.from(com.afshin.Entity.Order.class);
        criteriaQuery.multiselect(o.get("status"), criteriaBuilder.max(o.<Number>get("orderDate")),
                criteriaBuilder.min(o.<Number>get("shippedDate"))).groupBy(o.get("status"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<?> joinedQuery(){
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<com.afshin.Entity.Order> o = criteriaQuery.from(com.afshin.Entity.Order.class);
        Join<com.afshin.Entity.Order, Customer> c = o.join("customer");// from Order o inner join Customer c on
        criteriaQuery.multiselect(o.get("orderNumber"), c.get("customerName"), o.get("status"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    //ExecuteUpdate
    public void insert(com.afshin.Entity.Order order){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void update(com.afshin.Entity.Order order){
        try{
            entityManager.getTransaction().begin();
            order.setOrderDate(order.getOrderDate());
            order.setRequiredDate(order.getRequiredDate());
            order.setShippedDate(order.getShippedDate());
            order.setStatus(order.getStatus());
            order.setComments(order.getComments());
            order.setCustomerNumber(order.getCustomerNumber());
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void delete(Order order){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(order);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
}
