package controllers;

import daos.CourseDAO;
import models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * CourseServlet handles HTTP requests related to course management.
 * 
 * It supports creating, editing, retrieving, and deleting courses.
 * 
 * @author han
 */
@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCourse(request, response);
                break;
            default:
                listCourses(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createCourse(request, response);
                break;
            case "edit":
                editCourse(request, response);
                break;
            default:
                response.sendRedirect("courses");
                break;
        }
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> courses = courseDAO.getAllCourses();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("courses.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("course-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        Course existingCourse = courseDAO.getCourseById(courseId);
        request.setAttribute("course", existingCourse);
        request.getRequestDispatcher("course-form.jsp").forward(request, response);
    }

    private void createCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String term = request.getParameter("term");
        String schedule = request.getParameter("schedule");
        String deliveryMethod = request.getParameter("deliveryMethod");
        String qualifications = request.getParameter("qualifications");
        String compensation = request.getParameter("compensation");
        int institutionId = Integer.parseInt(request.getParameter("institutionId"));

        Course newCourse = new Course(title, code, term, schedule, deliveryMethod, qualifications, compensation, institutionId);
        courseDAO.createCourse(newCourse);
        response.sendRedirect("courses");
    }

    private void editCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String term = request.getParameter("term");
        String schedule = request.getParameter("schedule");
        String deliveryMethod = request.getParameter("deliveryMethod");
        String qualifications = request.getParameter("qualifications");
        String compensation = request.getParameter("compensation");
        int institutionId = Integer.parseInt(request.getParameter("institutionId"));

        Course course = new Course(courseId, title, code, term, schedule, deliveryMethod, qualifications, compensation, institutionId);
        courseDAO.updateCourse(course);
        response.sendRedirect("courses");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        courseDAO.deleteCourse(courseId);
        response.sendRedirect("courses");
    }

    @Override
    public void destroy() {
        courseDAO.close();
    }
}