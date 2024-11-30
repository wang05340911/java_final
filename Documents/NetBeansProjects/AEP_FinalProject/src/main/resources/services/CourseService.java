package services;

import daos.CourseDAO;
import models.Course;
import utils.Validator;

import java.util.List;

/**
 * CourseService handles business logic related to courses.
 * It acts as an intermediary between the servlet/controller layer and the DAO layer.
 * 
 * @author han
 */
public class CourseService {

    private CourseDAO courseDAO;

    // Default Constructor
    public CourseService() throws ClassNotFoundException {
        this.courseDAO = new CourseDAO();
    }

    // Constructor with Dependency Injection
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    /**
     * Retrieve all courses.
     * 
     * @return A list of all courses.
     */
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    /**
     * Retrieve a course by its ID.
     * 
     * @param courseId The ID of the course.
     * @return The course with the specified ID.
     */
    public Course getCourseById(int courseId) {
        return courseDAO.getCourseById(courseId);
    }

    /**
     * Create a new course.
     * 
     * @param course The course to be created.
     * @return true if the course was created successfully; false otherwise.
     */
    public boolean createCourse(Course course) {
        if (validateCourse(course)) {
            return courseDAO.createCourse(course);
        }
        return false;
    }

    /**
     * Update an existing course.
     * 
     * @param course The course to be updated.
     * @return true if the course was updated successfully; false otherwise.
     */
    public boolean updateCourse(Course course) {
        if (validateCourse(course)) {
            return courseDAO.updateCourse(course);
        }
        return false;
    }

    /**
     * Delete a course by its ID.
     * 
     * @param courseId The ID of the course to be deleted.
     * @return true if the course was deleted successfully; false otherwise.
     */
    public boolean deleteCourse(int courseId) {
        return courseDAO.deleteCourse(courseId);
    }

    /**
     * Validate a course object.
     * 
     * @param course The course to validate.
     * @return true if the course is valid; false otherwise.
     */
    private boolean validateCourse(Course course) {
        if (course == null) {
            return false;
        }
        if (!Validator.validateNotEmpty(course.getTitle()) || !Validator.validateNotEmpty(course.getCode())) {
            return false;
        }
        if (!Validator.validateNotEmpty(course.getTerm()) || !Validator.validateNotEmpty(course.getSchedule())) {
            return false;
        }
        return true;
    }

    /**
     * Close resources used by the DAO.
     */
    public void close() {
        courseDAO.close();
    }
}