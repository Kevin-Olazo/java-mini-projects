package week08_error_handling_file_io;

import java.time.LocalDateTime;

public class WeatherStation {
    private DataLogger dataLogger;

    public WeatherStation(DataLogger dataLogger){
        this.dataLogger = dataLogger;
    }

    public void takeAndSaveReading() throws SensorOfflineException  {
      double chances = Math.random();

      if (chances <= 0.10){
          throw new SensorOfflineException("Error: el sensor esta desconectado");
      }

      try {
          double temp = -50 + Math.random() * (50 - (-50));
          double humidity = Math.random() * (100);
          double pressure = 900 + Math.random() * (1100 - 900);


          temp = Math.round(temp * 10) / 10.0;
          humidity = Math.round(humidity * 10) / 10.0;
          pressure = Math.round(pressure * 10) / 10.0;

          WeatherReading newReading = new WeatherReading(temp, humidity, pressure, LocalDateTime.now());

          dataLogger.saveReading(newReading);
      } catch (InvalidReadingException e) {
          System.out.println("Error al grabar reading");
      }

    }

}
