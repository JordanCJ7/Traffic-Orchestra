package publictransittrackerproducer;

import java.util.Random;

public class PublicTransitService implements IPublicTransitService {
    private Random random = new Random();

    @Override
    public String getTransitStatus(String vehicleId) {
       
        String[] statuses = {"On Time", "Delayed", "En Route", "At Terminal", "Out of Service"};
        String status = statuses[random.nextInt(statuses.length)];
        System.out.println("PublicTransitService: Vehicle '" + vehicleId + "' status = " + status);
        return status;
    }
}

