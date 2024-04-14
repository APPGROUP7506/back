package com.example.demo.service.impl;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Course> all() {
        return courseMapper.all();
    }

    @Override
    public List<Comment> getCommentsByCourseNumber(String courseNumber) {
        return commentMapper.getByCourseNumber(courseNumber);
    }

    @Override
    public void commentByCourseNumber(Comment comment) {
        commentMapper.insert(comment);
        Course course=courseMapper.getByCourseName(comment);

        int people=course.getCommentPeople();
        double score=(course.getCourseScore()*people+comment.getScore())/(people+1);

        course.setCourseScore(score);
        course.setCommentPeople(people+1);

        courseMapper.updateByComment(course);
    }




    /*
    @Override
    public Course getByCourseNumber(String courseNumber) {
        Course course=courseMapper.getByCourseNumber(courseNumber);

        return null;
    }
     */
}
