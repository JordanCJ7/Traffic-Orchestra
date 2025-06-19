package speedsensorproducer;

import java.util.Random;

public class SpeedService implements ISpeedService {
    private Random random = new Random();

    @Override
    public double getAverageSpeed(String roadSegment) {
        return 20 + (random.nextDouble() * 80); // Generates speed between 20-100 km/h
    }
}
