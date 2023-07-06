package com.springrest.springrest.Controller;

import com.springrest.springrest.Data.Domain.Course;
import com.springrest.springrest.Services.CourseDTO;
import com.springrest.springrest.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.Entity;

import java.util.List;

@RestController
@RequestMapping("/api/Course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping("/home")
	public String Home() {
		return "Hello World";
	}

	@GetMapping("/courses")
	public ResponseEntity getAllCourses(){
		try{
			return new  ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/course/{id}")
	public ResponseEntity getCourse(@PathVariable Integer id){
		try{
			return new ResponseEntity<>(courseService.getCourse(id),HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{name}")
	public ResponseEntity getCourseByName(@PathVariable String name){
		try{
			return new ResponseEntity<>(courseService.findCourseByName(name),HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/course")
	public ResponseEntity addCourse(@RequestBody CourseDTO course){
		try{
			return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/course")
	public ResponseEntity updateCourse(@RequestBody CourseDTO course){
		try{
			return new ResponseEntity<>(courseService.updateCourse(course), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity deleteCourse(@PathVariable Integer id){
		try{
			courseService.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e){
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
