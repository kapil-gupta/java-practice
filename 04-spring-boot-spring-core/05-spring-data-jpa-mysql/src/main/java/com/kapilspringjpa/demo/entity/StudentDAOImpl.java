package com.kapilspringjpa.demo.entity;

import com.kapilspringjpa.demo.interfaces.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Here Student represents the JPA entity class and not table in JPQL
        //TypedQuery<Student> createdQuery = entityManager.createQuery("From Student", Student.class);

        // Here Student represents the JPA entity class and not table in JPQL
        // Added sorting
        TypedQuery<Student> createdQuery = entityManager.createQuery("From Student ORDER BY firstName ASC", Student.class);

        return createdQuery.getResultList();
    }

    @Override
    public List<Student> findAllByFirstName(String theName) {
        // Here Student represents the JPA entity class and not table in JPQL
        TypedQuery<Student> createdQuery = entityManager.createQuery("From Student WHERE firstName=:theParam", Student.class);
        createdQuery.setParameter("theParam",theName);

        return createdQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student s) {
        entityManager.merge(s);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.remove(s);
    }
}
