package com.learn.jpa.repository;

import com.learn.jpa.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    public CourseJpaCommandLineRunner(CourseSpringJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    private final CourseSpringJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.save(new Course(11, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(12, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(13, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(14, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(15, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(16, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(17, "Learn AWS", "Madhusudhan"));
        courseJpaRepository.save(new Course(18, "Learn AWS", "Madhusudhan"));

        Optional<Course> c = courseJpaRepository.findById(12L);
        System.out.println(c);

        courseJpaRepository.deleteById(11L);

        System.out.println(courseJpaRepository.findByAuthor("Madhusudhan"));
    }
}
