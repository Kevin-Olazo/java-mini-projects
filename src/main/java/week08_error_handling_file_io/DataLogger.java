package week08_error_handling_file_io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class DataLogger {

    public void saveReading(WeatherReading reading) {
        // 1. Generamos el nombre del archivo basado en la fecha de la lectura
        LocalDate date = reading.getTimestamp().toLocalDate();
        String fileName = "weather_" + date + ".log";
        Path filePath = Paths.get(fileName);

        // 2. Escribimos el reading usando try-with-resources para atrapar el error y cerrar el recurso automáticamente

        // Abrimos el writer, si no existe CREATE, si existe APPEND
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            // Escribimos el reading y usamos toString
            writer.write(reading.toString());
            // Creamos una nueva línea
            writer.newLine();
        } catch (IOException e) { // Catch para sí ocurre un error
            System.out.println("Hubo un error al grabar el reading");
        }

    }
}
