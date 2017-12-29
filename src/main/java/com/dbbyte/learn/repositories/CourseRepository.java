package com.dbbyte.learn.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbbyte.learn.entities.Course;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	};

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    };

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    };
    
    public void playWithEntityManager() {
    	Course course = new Course("My new one!");
    	em.persist(course);
    	
    	course.setName("my new name"); // this is saved to db but i din not required this - course is keept in track by entity manager
    }

}
