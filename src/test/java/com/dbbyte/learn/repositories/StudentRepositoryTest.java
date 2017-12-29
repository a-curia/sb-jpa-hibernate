package com.dbbyte.learn.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbbyte.learn.SbJpaHibernateApplication;
import com.dbbyte.learn.entities.Course;
import com.dbbyte.learn.entities.Passport;
import com.dbbyte.learn.entities.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbJpaHibernateApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    EntityManager em;

    @Test
    public void findById() throws Exception {
        logger.info("Test is running");

        Student student = studentRepository.findById(2L);
        assertEquals("Adrian",student.getName());
    }

  
    @Test
    @Transactional //needed because of lazy fetching
    public void retreiveStudentAndPassportDetails() throws Exception {

//        Student student = studentRepository.findById(2L);
//        Passport passport = student.getPassport();
//        assertEquals("Adrian",student.getName());
//        assertEquals("Z123456",student.getPassport().getNumber());
    	
		Student student = em.find(Student.class, 2L);
    	logger.info("student -> {}", student);
    	logger.info("passport is -> {}", student.getPassport());
    }

}