package com.springrest.springrest.Services;

import com.springrest.springrest.Data.Domain.Course;

import com.springrest.springrest.Data.Repository.Repository;
import com.springrest.springrest.Mapping.CourseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class CourseServiceBean implements CourseService {

    @Autowired
    private Repository<Course, Integer> courseRepository;
    
    @Autowired
    private CourseMapper mapper;

	@Override
	public List<CourseDTO> getAllCourses() {
		// TODO Auto-generated method stub
		
		return courseRepository.All()
				.stream()
				.filter(Objects::nonNull)
				.map(course -> mapper.mapToDTO(course))
				.toList();
	}

	@Override
	public CourseDTO getCourse(Integer id) {
		// TODO Auto-generated method stub
		return mapper.mapToDTO(courseRepository.Get(id));
	}

	@Override
	public CourseDTO saveCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		Course saveResult = courseRepository.save(mapper.mapToEntity(course));
		
		return mapper.mapToDTO(saveResult);
	}

	@Override
	public CourseDTO updateCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		
		var courseData  = courseRepository.Get(course.getId());
		if (courseData == null)
			throw new NullPointerException("No such course found with the given id : "+course.getId());
		
		courseData = mapper.mapToEntity(course);
		var saveResult = courseRepository.save(courseData);
		return mapper.mapToDTO(saveResult);
	}

	@Override
	public CourseDTO findCourseByName(String name) {
		// TODO Auto-generated method stub
		var datas =  courseRepository.All(c -> c.getName().equals(name));
		if(datas.isEmpty())
			throw new NullPointerException("No such course found with the given name");
		
		return mapper.mapToDTO(datas.get(0));
								
								
	}

	@Override
	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		courseRepository.delete(id);
	}

    
}




