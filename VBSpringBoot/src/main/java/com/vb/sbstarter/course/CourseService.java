package com.vb.sbstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList(new
	 * Topic("spring", "SFW", "SPFWDES"), new Topic("Java", "JAVA", "JAVA DES"),
	 * new Topic("JS", "JS", "JS DES")));
	 */

	public CourseService() {
		System.out.println("CourseService Object created");
	}

	public List<Course> getAllCourse(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void updateCourse(Course topic) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic topic2 =
		 * topics.get(i); if (topic2.getId().equals(id)) { topics.set(i, topic);
		 * return; } }
		 */
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
