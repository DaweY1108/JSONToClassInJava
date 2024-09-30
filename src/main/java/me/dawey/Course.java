package me.dawey;

import com.google.gson.annotations.SerializedName;

class Course {
    @SerializedName("course_code") // Ez azért kell mert a course_code a json-ban a neve
    private String courseCode;

    @SerializedName("course_label")
    private String courseLabel;

    private String weekday;

    @SerializedName("course_type")
    private String courseType;

    private String beginning;
    private String end;
    private String teacher;
    private int credit;

    @SerializedName("day_code")
    private int dayCode;

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseLabel() {
        return courseLabel;
    }

    public void setCourseLabel(String courseLabel) {
        this.courseLabel = courseLabel;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDayCode() {
        return dayCode;
    }

    public void setDayCode(int dayCode) {
        this.dayCode = dayCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseLabel='" + courseLabel + '\'' +
                ", weekday='" + weekday + '\'' +
                ", courseType='" + courseType + '\'' +
                ", beginning='" + beginning + '\'' +
                ", end='" + end + '\'' +
                ", teacher='" + teacher + '\'' +
                ", credit=" + credit +
                ", dayCode=" + dayCode +
                '}';
    }
}