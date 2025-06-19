package weatherdataproducer;

import java.util.Random;

public class WeatherService implements IWeatherService {
    private Random random = new Random();

    @Override
    public double getCurrentTemperature(String location) {
       
        double temperature = 10 + random.nextDouble() * 25;
        System.out.println("WeatherService: Location '" + location + "' temperature = " 
                + String.format("%.2f", temperature) + " °C");
        return temperature;
    }
}
