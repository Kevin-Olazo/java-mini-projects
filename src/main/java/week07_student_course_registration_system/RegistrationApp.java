package week07_student_course_registration_system;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegistrationApp {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        // --- 1. PREPARACIÓN DE DATOS ---
        system.addStudent(new Student("S1", "Ana"));
        system.addStudent(new Student("S2", "Carlos"));
        system.addStudent(new Student("S3", "Elena"));
        system.addStudent(new Student("S4", "David"));
        system.addStudent(new Student("S5", "SoloHan"));

        system.addCourse(new Course("CS101", "Java Básico"));
        system.addCourse(new Course("CS102", "Estructuras de Datos"));
        system.addCourse(new Course("MATH101", "Cálculo I"));

        // --- 2. INSCRIPCIONES ---

        // Grupo A: Ana y Carlos (Mismo horario: CS101 + CS102)
        system.register("S1", "CS101");
        system.register("S1", "CS102");

        system.register("S2", "CS102"); // Orden invertido,
        system.register("S2", "CS101"); // pero es el mismo Set.

        // Grupo B: Elena y David (Mismo horario: MATH101)
        system.register("S3", "MATH101");
        system.register("S4", "MATH101");

        // Estudiante Solitario: SoloHan (Solo CS101)
        system.register("S5", "CS101");

        // --- 3. REPORTE DE GRUPOS ---
        System.out.println("--- Buscando Estudiantes con Horarios Idénticos ---\n");

        // Llamamos a tu método optimizado
        Map<Set<String>, List<String>> resultados = system.findStudentsWithSameCourses();

        // Recorremos el mapa. "Entry" es cada pareja de "Llave (Horario) -> Valor (Lista de IDs)"
        for (Map.Entry<Set<String>, List<String>> entrada : resultados.entrySet()) {
            Set<String> horario = entrada.getKey();
            List<String> listaEstudiantes = entrada.getValue();

            // Solo nos interesan los grupos donde hay "gemelos" (más de 1 persona)
            if (listaEstudiantes.size() > 1) {
                System.out.println("👥 Grupo Encontrado:");
                System.out.println("   Horario compartido: " + horario);
                System.out.println("   Estudiantes: " + listaEstudiantes);
                System.out.println("-----------------------------------");
            }
        }
    }
}
