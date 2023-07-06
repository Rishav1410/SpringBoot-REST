package com.springrest.springrest.Mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Data.Domain.Course;
import com.springrest.springrest.Services.CourseDTO;

@Mapper(componentModel="spring")
public interface CourseMapper {
	@Mapping(source = "name", target = "courseName")
	@Mapping(source = "description", target = "courseDescription")
	CourseDTO mapToDTO(Course course);
	
	@Mapping(source = "courseName", target = "name")
	@Mapping(source = "courseDescription", target = "description")
	Course mapToEntity(CourseDTO courseDTO);
	

}
