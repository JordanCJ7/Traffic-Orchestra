package publictransittrackerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        IPublicTransitService transitService = new PublicTransitService();
        registration = context.registerService(IPublicTransitService.class.getName(), transitService, null);
        System.out.println("Public Transit Tracker Producer started and registered.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Public Transit Tracker Producer stopped.");
    }
}
