package com.dbbyte.learn.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbbyte.learn.entities.Passport;
import com.dbbyte.learn.entities.Student;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	};

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    };

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    };
    
    public void saveStudentWithPassport() {
    	Passport passport = new Passport("Z123456");
    	em.persist(passport);
    	
    	Student student = new Student("Adrian");
    	student.setPassport(passport);
    	em.persist(student);
    	
    }

}
