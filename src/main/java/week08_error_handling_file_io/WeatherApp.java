package week08_error_handling_file_io;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class WeatherApp {
    public static void main(String[] args) {
        DataLogger dataLogger = new DataLogger();
        WeatherStation weatherStation = new WeatherStation(dataLogger);

        for (int i = 0; i < 10; i++) {

            try {
                weatherStation.takeAndSaveReading();
            } catch (SensorOfflineException e) {
                System.out.println(e.getMessage());
            }

        }


        try  {
            List<WeatherReading> listReadings = dataLogger.loadReadings(LocalDate.now());
            for (WeatherReading r : listReadings){
                System.out.println(r.toString());
            }

        } catch (CorruptDataException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
