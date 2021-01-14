package tr.edu.mu.ceng.mad.myapplicationme;

import java.io.Serializable;

public class Course implements Serializable {
    private String course_name, teacher_name;
    private String filePath;

    public Course() {
    }

    public Course(String course_name, String teacher_name, String filePath) {
        this.course_name = course_name;
        this.teacher_name = teacher_name;
        this.filePath = filePath;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
