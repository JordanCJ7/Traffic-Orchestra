package speedsensorproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    public void start(BundleContext context) throws Exception {
        ISpeedService speedService = new SpeedService();
        serviceRegistration = context.registerService(ISpeedService.class.getName(), speedService, null);
        System.out.println("Speed Sensor Service Registered.");
    }

    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
        System.out.println("Speed Sensor Service Stopped.");
    }
}
