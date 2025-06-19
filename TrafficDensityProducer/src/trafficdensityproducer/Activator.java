package trafficdensityproducer;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    public void start(BundleContext context) throws Exception {
        ITrafficDensityService densityService = new TrafficDensityService();
        serviceRegistration = context.registerService(ITrafficDensityService.class.getName(), densityService, null);
        System.out.println("Traffic Density Service Registered.");
    }

    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
        System.out.println("Traffic Density Service Stopped.");
    }
}
