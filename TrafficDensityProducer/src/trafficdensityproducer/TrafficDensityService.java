package trafficdensityproducer;


import java.util.Random;

public class TrafficDensityService implements ITrafficDensityService {
    private Random random = new Random();

    @Override
    public int getTrafficDensity(String roadSegment) {
        return random.nextInt(101); // Returns a density value between 0-100%
    }
}
