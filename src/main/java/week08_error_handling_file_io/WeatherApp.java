package week08_error_handling_file_io;

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
    }
}
