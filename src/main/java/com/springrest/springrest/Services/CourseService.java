package com.springrest.springrest.Services;


import java.util.List;


public interface CourseService {

    List<CourseDTO> getAllCourses();
    CourseDTO getCourse(Integer id);
    CourseDTO saveCourse(CourseDTO course);
    CourseDTO updateCourse(CourseDTO course);
    CourseDTO findCourseByName(String name);
    void deleteCourse(Integer id);
}
