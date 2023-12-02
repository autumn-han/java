package com.coding_dojo.beltExam.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.beltExam.models.Course;
import com.coding_dojo.beltExam.models.User;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
	List<Course> findAll();
	List<Course> findByUser(User user);
}
