package com.dbbyte.learn.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbJpaHibernateApplication.class) // lunch entire context
// Unit test is run between the Context Launch and Destroy!
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById() throws Exception {
        logger.info("Test is running");

        Course course = courseRepository.findById(10002L);
        assertEquals("Java in 10 steps",course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() throws Exception {
        // this test is changeing the data so we must put Dirty.. is it set by default?
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }
    
    @Test
    @DirtiesContext
    public void saveTest() throws Exception {
        //get a course
    	Course course = courseRepository.findById(10002L);
    	assertEquals("Java in 10 steps",course.getName());
    	// update details
    	course.setName("another name");
    	courseRepository.save(course);
    	// check value by using the db
    	Course course1 = courseRepository.findById(10002L);
    	assertEquals("another name", course1.getName());
    	
    	
    }
    
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}
    


}