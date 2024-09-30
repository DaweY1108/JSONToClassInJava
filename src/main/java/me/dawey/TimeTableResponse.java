package me.dawey;

import java.util.List;

public class TimeTableResponse {
    private String status;
    private String message;
    private List<Course> courses;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TimetableResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", courses=" + courses +
                '}';
    }
}
