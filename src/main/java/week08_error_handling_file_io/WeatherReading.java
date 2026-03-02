package week08_error_handling_file_io;

import java.time.LocalDateTime;

public class WeatherReading {
    private double temperature;
    private double humidity;
    private double pressure;
    private LocalDateTime timestamp;

    public WeatherReading(double temperature, double humidity, double pressure, LocalDateTime timestamp) {
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
