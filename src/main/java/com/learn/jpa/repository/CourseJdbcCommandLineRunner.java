package com.learn.jpa.repository;

import com.learn.jpa.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository courseJdbcRepository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn AWS", "Madhusudhan"));
        courseJdbcRepository.insert(new Course(2, "Learn AWS", "Madhusudhan"));
        courseJdbcRepository.insert(new Course(3, "Learn AWS", "Madhusudhan"));
        courseJdbcRepository.insert(new Course(4, "Learn AWS", "Madhusudhan"));
        courseJdbcRepository.insert(new Course(5, "Learn AWS", "Madhusudhan"));
        courseJdbcRepository.insert(new Course(6, "Learn AWS", "Madhusudhan"));

        courseJdbcRepository.deleteById(2);
        Course c = courseJdbcRepository.findById(1);
        System.out.println(c);
    }
}
