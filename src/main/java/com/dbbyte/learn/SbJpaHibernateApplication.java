package com.dbbyte.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbbyte.learn.entities.Course;
import com.dbbyte.learn.repositories.CourseRepository;

@SpringBootApplication
public class SbJpaHibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SbJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course = courseRepository.findById(10001L);
		
		logger.info("Course 10001 -> {}",course);
		logger.info("Try deleting the course");

		courseRepository.deleteById(10001L);

		courseRepository.save(new Course("Microservices in 100 steps!"));
	}
}
