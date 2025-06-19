package traffic_light_controller_consumer;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import trafficdensityproducer.ITrafficDensityService;
import speedsensorproducer.ISpeedService;
import weatherdataproducer.IWeatherService;

public class Activator implements BundleActivator {
    private ServiceReference densityRef;
    private ServiceReference speedRef;
    private ServiceReference weatherRef;
    
    @Override
    public void start(BundleContext context) throws Exception {
        densityRef = context.getServiceReference(ITrafficDensityService.class.getName());
        speedRef = context.getServiceReference(ISpeedService.class.getName());
        weatherRef = context.getServiceReference(IWeatherService.class.getName());
        
        if (densityRef != null && speedRef != null && weatherRef != null) {
            ITrafficDensityService densityService = (ITrafficDensityService) context.getService(densityRef);
            ISpeedService speedService = (ISpeedService) context.getService(speedRef);
            IWeatherService weatherService = (IWeatherService) context.getService(weatherRef);
            
            String roadSegment = "Main Street";
            int density = densityService.getTrafficDensity(roadSegment);
            double speed = speedService.getAverageSpeed(roadSegment);
            double temperature = weatherService.getCurrentTemperature(roadSegment);
            
            System.out.println("\n--- Traffic Light Controller Consumer ---");
            System.out.println("Road Segment: " + roadSegment);
            System.out.println("Traffic Density: " + density + "%");
            System.out.println("Average Speed: " + String.format("%.2f", speed) + " km/h");
            System.out.println("Current Temperature: " + String.format("%.2f", temperature) + " °C");
            
            adjustTrafficLights(density, speed, temperature);
        } else {
            System.out.println("Required services for Traffic Light Controller are not available.");
        }
    }
    
    private void adjustTrafficLights(int density, double speed, double temperature) {
        System.out.println("\nAdjusting Traffic Lights:");
        if (density > 70 || speed < 30) {
            System.out.println("Heavy traffic or slow speed detected. Extending green light duration.");
        } else if (density < 30 && speed > 60) {
            System.out.println("Light traffic and fast speed detected. Shortening green light duration.");
        } else {
            System.out.println("Normal conditions. Using standard signal timing.");
        }
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Traffic Light Controller Consumer stopped.");
    }
}
