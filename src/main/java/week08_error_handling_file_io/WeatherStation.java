package week08_error_handling_file_io;

import java.time.LocalDateTime;

public class WeatherStation {
    private DataLogger dataLogger;

    public WeatherStation(DataLogger dataLogger){
        this.dataLogger = dataLogger;
    }

    public void takeAndSaveReading() throws SensorOfflineException  {

      double chances = Math.random();
      System.out.println(chances);

      if (chances <= 0.10){
          throw new SensorOfflineException("Error: el sensor esta desconectado");
      }

      try {
          double temp = (Math.random() * (50 - -50 + 1)) + -50;
          double humidity = (Math.random() * (100 - 0 + 1)) + 0;
          double pressure = (Math.random() * (1100 - 900 + 1)) + 900;

          WeatherReading newReading = new WeatherReading(temp, humidity, pressure, LocalDateTime.now());

          dataLogger.saveReading(newReading);
      } catch (InvalidReadingException e) {
          System.out.println("Error al grabar reading");
      }

    }

}
