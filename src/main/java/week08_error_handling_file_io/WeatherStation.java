package week08_error_handling_file_io;

import java.time.LocalDateTime;

public class WeatherStation {
    private DataLogger dataLogger;

    public WeatherStation(DataLogger dataLogger){
        this.dataLogger = dataLogger;
    }

    public void takeAndSaveReading() throws SensorOfflineException, InvalidReadingException  {

      double chances = Math.random();
      System.out.println(chances);

      if (chances <= 0.10){
          throw new SensorOfflineException("Error: el sensor esta desconectado");
      }

      try {
          double temp = Math.random();
          double humidity = Math.random();
          double pressure = Math.random();

          WeatherReading newReading = new WeatherReading(temp, humidity, pressure, LocalDateTime.now());

          dataLogger.saveReading(newReading);
      } catch (InvalidReadingException e) {
          System.out.println("Error al grabar reading");
      }


    }

}
