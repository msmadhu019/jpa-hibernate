package com.learn.jpa.repository;

import com.learn.jpa.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String course);
}
