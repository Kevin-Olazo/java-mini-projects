package week07_student_course_registration_system;

import java.util.Set;

public class RegistrationApp {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        // --- PREPARACIÓN DE DATOS ---
        // Estudiantes
        system.addStudent(new Student("S1", "Ana"));      // Grupo A
        system.addStudent(new Student("S2", "Carlos"));   // Grupo A
        system.addStudent(new Student("S3", "Elena"));    // Grupo B
        system.addStudent(new Student("S4", "David"));    // Grupo B
        system.addStudent(new Student("S5", "SoloHan"));  // Sin pareja

        // Cursos
        system.addCourse(new Course("CS101", "Java Básico"));
        system.addCourse(new Course("CS102", "Estructuras de Datos"));
        system.addCourse(new Course("MATH101", "Cálculo I"));

        // --- ESCENARIOS DE INSCRIPCIÓN ---

        // 1. Pareja "Grupo A" (Ana y Carlos): Tienen EXACTAMENTE lo mismo (CS101 + CS102)
        system.register("S1", "CS101");
        system.register("S1", "CS102");

        system.register("S2", "CS102"); // Orden diferente al registrar,
        system.register("S2", "CS101"); // pero el Set debe ignorar eso.

        // 2. Pareja "Grupo B" (Elena y David): Tienen EXACTAMENTE lo mismo (Solo MATH101)
        system.register("S3", "MATH101");
        system.register("S4", "MATH101");

        // 3. Estudiante Solitario (SoloHan): Tiene una combinación única
        system.register("S5", "CS101");
        // (Nadie más tiene SOLO CS101, así que no debería salir)

        // --- EJECUCIÓN ---
        system.printReport();

        System.out.println("\n--- Buscando estudiantes con el mismo horario ---");
        Set<String> gemelos = system.findStudentsWithSameCourses();

        System.out.println("IDs encontrados: " + gemelos);
    }
}
