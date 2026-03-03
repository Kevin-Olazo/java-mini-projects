package week08_error_handling_file_io;

import java.time.LocalDateTime;

public class WeatherReading {
    private double temperature;
    private double humidity;
    private double pressure;
    private LocalDateTime timestamp;

    public WeatherReading(double temperature, double humidity, double pressure, LocalDateTime timestamp) {
        if (temperature < -50 || temperature > 50){
            throw new InvalidReadingException("Error: La temperatura debe estar en un rango de -50 y 50");
        }

        if (humidity < 0 || humidity > 100){
            throw new InvalidReadingException("Error: La humedad debe estar en un rango de 0 y 100");
        }

        if (pressure < 900 || pressure > 1100){
            throw new InvalidReadingException("Error: La presión debe estar en un rango de 900 y 1100");
        }

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return temperature + "," + humidity + "," + pressure + "," + timestamp;
    }
}
