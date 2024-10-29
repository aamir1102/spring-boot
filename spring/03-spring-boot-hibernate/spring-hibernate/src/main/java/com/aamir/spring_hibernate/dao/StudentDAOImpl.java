package com.aamir.spring_hibernate.dao;

import com.aamir.spring_hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    EntityManager theEntityManager;

    @Autowired
    public void setTheEntityManager(EntityManager entityManager){
        theEntityManager=entityManager;
    }


    @Override
    @Transactional
    public void save(Student student) {
        theEntityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return theEntityManager.find(Student.class,id);
    }

    public List<Student> findAll(){
        TypedQuery<Student> query = theEntityManager
                .createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public Student findByLastName() {
        TypedQuery<Student> query = theEntityManager
                .createQuery("FROM Student WHERE lastName = 'Jobs'",Student.class);
        return query.getResultList().get(0);
    }

    @Override
    public List<Student> findByParameters(String firstName, String lastName) {
        TypedQuery<Student> query=theEntityManager
                .createQuery("FROM Student WHERE firstName =:firstName OR lastName =:lastName",Student.class);
        query.setParameter("firstName",firstName);
        query.setParameter("lastName",lastName);

        return query.getResultList();
    }

    @Override
    public List<Student> strictJPQL() {
        TypedQuery<Student> query = theEntityManager
                .createQuery("SELECT s FROM Student s",Student.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        theEntityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(int id) {
        theEntityManager.remove(findById(id));
    }

//    Notes
//
//    -->Delete All Students
//    int numRowsDeleted = entityManager
//            .createQuery("DELETE FROM Student")
//            .executeUpdate();
//
//
//    -->Delete based on a condition
//    int numRowsDeleted = entityManager.createQuery(
//                    "DELETE FROM Student WHERE lastName=‘Smith’")
//            .executeUpdate();
//
//    -->Update last name for all students
//    int numRowsUpdated = entityManager.createQuery(
//            "UPDATE Student SET lastName=‘Tester’”)
//                    .executeUpdate();


}
