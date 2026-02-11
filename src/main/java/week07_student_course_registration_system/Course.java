package week07_student_course_registration_system;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private String code;
    private String name;
    private Set<String> enlistedStudents;

    public Course() {
    }

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.enlistedStudents =  new HashSet<>();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEnlistedStudents() {
        return Set.copyOf(enlistedStudents);
    }

    public void enlistStudent(String id){
        if (id == null){
            throw new IllegalArgumentException("student id cannot be null");
        }
        this.enlistedStudents.add(id);
    }

    public boolean dropStudent(String id){
        if (id == null){
            throw new IllegalArgumentException("student id cannot be null");
        }
        return this.enlistedStudents.remove(id);
    }
}
