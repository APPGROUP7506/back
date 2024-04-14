package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.entity.Course;
import com.example.demo.entity.Result;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseService courseService;

    @RequestMapping("/all")
    public Result all()
    {
        List<Course> allCourse=courseService.all();
        return Result.success(allCourse);
    }

    @RequestMapping("/detail/{courseNumber}")
    public Result getCommentsByCourseNumber(@PathVariable String courseNumber)
    {
        //Integer id=courseService.getCourseId(courseNumber);
        List<Comment> comments=courseService.getCommentsByCourseNumber(courseNumber);
        if(comments!=null) return Result.success(comments);
        else return Result.error("no this course");
    }

    @RequestMapping("/comment")
    public Result commentByCourseNumber(@RequestBody Comment comment)
    {
        courseService.commentByCourseNumber(comment);
        return Result.success();
    }
    /*
    {
    "courseNumber":"COMP7606",
    "userName":"ffoo",
    "score":92.65,
    "userComment":"what do you think of"
     }
    * */
}
