package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Course;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> all();

    //List<Comment> getCommentsByCourseNumber(String courseNumber);

    List<Comment> getCommentsByCourseNumber(String courseNumber);

    void commentByCourseNumber(Comment comment);

    //Integer getCourseId(String courseNumber);
}
