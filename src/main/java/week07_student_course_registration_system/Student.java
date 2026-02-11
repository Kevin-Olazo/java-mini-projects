package week07_student_course_registration_system;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private String id;
    private String name;
    private Set<String> enlistedCourses;


    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enlistedCourses = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEnlistedCourses() {
        return Set.copyOf(enlistedCourses);
    }

    public void enlistCourse(String id){
        if(id == null){
            throw new IllegalArgumentException("need an course id");
        }

        this.enlistedCourses.add(id);
    }

    public boolean dropCourse(String id){
        if(id == null){
            throw new IllegalArgumentException("need an course id");
        }
        return enlistedCourses.remove(id);
    }

}
