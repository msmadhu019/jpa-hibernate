package com.learn.jpa.repository;

import com.learn.jpa.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Course course) {
        String INSERT_QUERY = """
                        INSERT INTO COURSE(ID,NAME,AUTHOR)
                        VALUES(?,?, ?)
                """;
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(int id) {
        String DELETE_QUERY = """
                DELETE FROM COURSE WHERE ID=?""";
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        String SELECT_QUERY = """
                SELECT * FROM COURSE WHERE ID=?""";
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
