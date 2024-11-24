/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author han
 */

public class Request {
    private int id;
    private int userId;
    private int courseId;
    private String status;

    public Request(int id, int userId, int courseId, String status) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }
}