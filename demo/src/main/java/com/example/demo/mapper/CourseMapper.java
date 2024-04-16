package com.example.demo.mapper;


import com.example.demo.entity.Comment;
import com.example.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<Course> all();

    void updateByComment(Course course);

    Course getByCourseName(Comment comment);

    //Integer getCourseId(String courseNumber);
}
