package week07_student_course_registration_system;

import java.util.*;

public class RegistrationSystem {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    public void addStudent(Student s) {
        students.put(s.getId(), s);
    }

    public void addCourse(Course c) {
        courses.put(c.getCode(), c);
    }

    public boolean register(String studentId, String courseId) {
        // 1. Recuperar Student y Course de los Maps usando los IDs
        Student u = students.get(studentId);
        Course c = courses.get(courseId);
        // 2. Validar que ambos existan (si no, retornar false)
        if (u == null || c == null) {
            return false;
        }
        // 3. Validar si ya está inscrito (evitar duplicados - aunque el Set lo maneja, es bueno saberlo)
        if (u.getEnlistedCourses().contains(courseId)) {
            return false;
        }
        // 4. Actualizar AMBOS Sets (Bidireccional)
        u.enlistCourse(courseId);
        c.enlistStudent(studentId);

        return true;

    }

    public boolean dropCourse(String studentId, String courseId){
        // 1. Recuperar Student y Course de los Maps usando los IDs
        Student u = students.get(studentId);
        Course c = courses.get(courseId);
        // 2. Validar que ambos existan (si no, retornar false)
        if (u == null || c == null) {
            return false;
        }
        // 3. Validar si ya está inscrito (evitar duplicados - aunque el Set lo maneja, es bueno saberlo)
        if (u.dropCourse(courseId)){
            return c.dropStudent(studentId);
        }
        return false;
    }

    public Set<String> findStudentsWithSameCourses(){
        List<Student> lista = new ArrayList<>(students.values());
        Set<String> parejas = new HashSet<>();

        Map<Set<Course>, Set<Student>>  grupos = new HashMap<>();


        for(int i = 0; i < lista.size(); i++){
            for (int j = i + 1; j < lista.size(); j++){
                Student s1 = lista.get(i);
                Student s2 = lista.get(j);

                if (s1.getEnlistedCourses().equals(s2.getEnlistedCourses())){
                    parejas.add(s1.getId());
                    parejas.add(s2.getId());
                    System.out.println("Encontramos una pareja");
                    System.out.println(s1.getName() + " " + s2.getName());
                }
            }
        }

        return parejas;
    }

    public Set<String> findCommonCourses(String studentId1, String studentId2){
        if (studentId1 == null || studentId2 == null){
            throw new IllegalArgumentException("Cannot be null");
        }

        Student s1 = students.get(studentId1);
        Student s2 = students.get(studentId2);

        if (s1 == null || s2 == null){
            return new HashSet<>();
        }

        Set<String> common = new HashSet<>(s1.getEnlistedCourses());
        common.retainAll(s2.getEnlistedCourses());

        return common;
    }

    public void printReport() {
        System.out.println("--- Reporte de Inscripciones ---");
        // Tip Pro: Aquí puedes iterar usando entrySet() para ver todo
        for(Map.Entry<String, Course> entry : courses.entrySet()){
            System.out.println("Curso: " + entry.getValue().getCode() + " \nEstudiantes: " );
            for(String u : entry.getValue().getEnlistedStudents()){
                System.out.println(students.get(u).getName());
            }
        }
    }
}
