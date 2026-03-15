package week09_multi_notification_system;

import week09_multi_notification_system.util.Priority;

public class NotificationApp {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // 1. Instanciar cola especifica
        NotificationQueue<EmailMessage> emailQueue = new NotificationQueue<>();

        // 2. Registrar en el servicio
        service.registerQueue("EMAIL", emailQueue);

        // 3. Crear mensajes y notificaciones
        EmailMessage emsg1 = new EmailMessage("Mensaje Urgente", Priority.HIGH);
        EmailMessage emsg2 = new EmailMessage("Saludo", Priority.LOW);
        EmailMessage emsg3 = new EmailMessage("Bug fix", Priority.MEDIUM);
        EmailMessage emsg4 = new EmailMessage("Reunion normal", Priority.MEDIUM);
        EmailMessage emsg5 = new EmailMessage("cierre", Priority.LOW);
        EmailMessage emsg6 = new EmailMessage("EMERGENCIA", Priority.HIGH);

        Notification<EmailMessage> en1 = new Notification<>(emsg1, "001");
        Notification<EmailMessage> en2 = new Notification<>(emsg2, "002");
        Notification<EmailMessage> en3 = new Notification<>(emsg3, "003");
        Notification<EmailMessage> en4 = new Notification<>(emsg4, "004");
        Notification<EmailMessage> en5 = new Notification<>(emsg5, "005");
        Notification<EmailMessage> en6 = new Notification<>(emsg6, "006");

        // 4. Agregarlos a la cola...
        emailQueue.add(en1);
        emailQueue.add(en2);
        emailQueue.add(en3);
        emailQueue.add(en4);
        emailQueue.add(en5);
        emailQueue.add(en6);

        // 5. Probar buscar uno que exista y otro que no exista...

        System.out.println(service.findNotificationById("001"));

        // --- DEMOSTRACIÓN DE TYPE SAFETY ---
        // TODO: Escribe código que el compilador rechace, coméntalo y explica por qué falló.


    }
}
