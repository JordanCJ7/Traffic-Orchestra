package traffic_dashboard_consumer;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import trafficdensityproducer.ITrafficDensityService;
import speedsensorproducer.ISpeedService;
import weatherdataproducer.IWeatherService;
import publictransittrackerproducer.IPublicTransitService;


public class Activator implements BundleActivator {
    private ServiceReference densityRef;
    private ServiceReference speedRef;
    private ServiceReference weatherRef;
    private ServiceReference transitRef;
    
    @Override
    public void start(BundleContext context) throws Exception {
        densityRef = context.getServiceReference(ITrafficDensityService.class.getName());
        speedRef = context.getServiceReference(ISpeedService.class.getName());
        weatherRef = context.getServiceReference(IWeatherService.class.getName());
        transitRef = context.getServiceReference(IPublicTransitService.class.getName());
        
        if (densityRef != null && speedRef != null && weatherRef != null && transitRef != null) {
            ITrafficDensityService densityService = (ITrafficDensityService) context.getService(densityRef);
            ISpeedService speedService = (ISpeedService) context.getService(speedRef);
            IWeatherService weatherService = (IWeatherService) context.getService(weatherRef);
            IPublicTransitService transitService = (IPublicTransitService) context.getService(transitRef);
            
            String roadSegment = "Main Street";
            int density = densityService.getTrafficDensity(roadSegment);
            double speed = speedService.getAverageSpeed(roadSegment);
            double temperature = weatherService.getCurrentTemperature(roadSegment);
            String transitStatus = transitService.getTransitStatus("Bus-101");
            
            System.out.println("\n--- Traffic Dashboard Consumer ---");
            System.out.println("===== Traffic Dashboard =====");
            System.out.println("Road Segment: " + roadSegment);
            System.out.println("Traffic Density: " + density + "%");
            System.out.println("Average Speed: " + String.format("%.2f", speed) + " km/h");
            System.out.println("Temperature: " + String.format("%.2f", temperature) + " °C");
            System.out.println("Transit Status: " + transitStatus);
            System.out.println("=============================");
        } else {
            System.out.println("Required services for Traffic Dashboard are not available.");
        }
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Traffic Dashboard Consumer stopped.");
    }
}
