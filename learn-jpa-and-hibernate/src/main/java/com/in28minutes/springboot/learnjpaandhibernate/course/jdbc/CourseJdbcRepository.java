package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private static final String INSERT_QUERY =
            """
                        INSERT INTO COURSE (ID, NAME, AUTHOR) 
                        values(?, ?, ?);  
                    """;

    private static final String DELETE_QUERY =
            """
                      DELETE FROM COURSE WHERE ID = ?;
                    """;

    private static final String SELECT_QUERY =
            """
                      SELECT * FROM COURSE
                       WHERE ID = ?;
                    """;
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public int deleteById(long id) {
        return springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        //Result Set => Bean => Row Mapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
