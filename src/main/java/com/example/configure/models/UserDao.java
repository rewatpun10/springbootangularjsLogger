package com.example.configure.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by rewat on 11/30/16.
 */
@Repository
@Transactional
public class UserDao {

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * saves the user in the database
     */

    public void create(User user) {
        entityManager.persist(user);
    }

    /**
     * delete the user from the database
     */
    public void delete(User user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }

    /**
     * returns all the user stored in the database
     */
    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    /**
     * return the user having the passed email
     */
    public User getByEmail(String email) {
        return (User) entityManager.createQuery(
                "from User where email = : email")
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * return the user having the passed id
     */
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * update the passed user in the database
     */
    public  void update(User user){
        entityManager.merge(user);
        return;
    }
}
