package com.petshop.habernate.dao;

// import thu vien can thien
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.petshop.habernate.dao.User;

import java.util.ArrayList;

public class HandleHibernate {
    public static void main(String[] args) {
//        HandleHibernate handleHibernate = new HandleHibernate();
////        handleHibernate.insert();
////        handleHibernate.update();
////        handleHibernate.delete();
//        handleHibernate.select();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, 1);
        if (user == null) {
            System.out.println("Khong tim thay user");
        } else {
            System.out.println(user.getName());
        }

    }
    // CRUD Hibernate
    public void insert(User user) {
        // Insert
        // create an user
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public void update(User user) {
     // handle hibernate update
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, user.getId
        ());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public void delete(int id) {
        // delete by ID
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public ArrayList<User> select() {

        try {
            // select
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            ArrayList<User> users = (ArrayList<User>) entityManager.createQuery("from User").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return users;
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<User> orderById() {
        try {
            // select
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            ArrayList<User> users = (ArrayList<User>) entityManager.createQuery("from User order by id").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return users;
        } catch (Exception e) {
            return null;
        }
    }
}
