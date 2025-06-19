package weatherdataproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        IWeatherService weatherService = new WeatherService();
        registration = context.registerService(IWeatherService.class.getName(), weatherService, null);
        System.out.println("Weather Data Producer started and registered.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Weather Data Producer stopped.");
    }
}

