package com.coding_dojo.beltExam.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding_dojo.beltExam.models.Course;
import com.coding_dojo.beltExam.repositories.CourseRepo;

@Service
public class CourseService {

//	inject CourseRepo
	@Autowired
	private CourseRepo courseRepo;
	
//	create course
	public Course create(Course newCourse) {
		return courseRepo.save(newCourse);
	}
	
//	retrieve one course
	public Course getOne(Long id) {
		Optional<Course> course = courseRepo.findById(id);
		if (course.isPresent()) {
			return course.get();
		}
		else {
			return null;
		}
	}
	
//	update course
	public Course update(Course courseEdit) {
		return courseRepo.save(courseEdit);
	}
	
//	delete one course
	public void delete(Long id) {
		courseRepo.deleteById(id);
	}
	
//	retrieve all courses
	public List<Course> allCourses() {
		return courseRepo.findAll();
	}
}
