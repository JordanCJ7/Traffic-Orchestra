# Traffic-Orchestra
OSGi Based Smart Traffic Management System

## Overview
Traffic-Orchestra is a modular, service-oriented architecture for smart traffic management systems. It demonstrates how OSGi framework can be used to build a flexible and extensible traffic monitoring and control system where different components can work together while remaining loosely coupled.

The system simulates various traffic data producers (sensors, weather stations, transit trackers) and consumers (dashboards, traffic light controllers, navigation apps) that interact through well-defined service interfaces.

## What is OSGi?

OSGi (Open Service Gateway initiative) is a Java framework for developing and deploying modular software programs and libraries. It provides a component system that allows applications to be built from small, reusable components that can be composed together.

Key features of OSGi:
- **Dynamic Component Model**: Components (bundles) can be installed, started, stopped, updated, and uninstalled without requiring a system restart
- **Service Registry**: Allows bundles to register services that other bundles can discover and use
- **Lifecycle Management**: Each bundle has its own lifecycle (install, start, stop, update, uninstall)
- **Versioning**: Supports multiple versions of the same component running simultaneously
- **Modularity**: Provides strong module boundaries with explicit dependencies

## Tech Stack
- Java SE 23
- OSGi Framework
- Eclipse IDE (recommended for OSGi development)

## Project Features
- Real-time traffic density monitoring
- Vehicle speed monitoring
- Weather condition tracking
- Public transit status updates
- Traffic dashboard visualization
- Intelligent traffic light control
- Emergency vehicle routing
- Smart navigation suggestions

## Project Structure
```
Traffic-Orchestra/
├── Emergency_Routing_Consumer/        # Emergency vehicle routing optimization
├── Navigation_App_Consumer/           # Navigation app service consumer
├── PublicTransitTrackerProducer/      # Public transit data service provider
├── SpeedSensorProducer/               # Vehicle speed data service provider
├── Traffic_Dashboard_Consumer/        # Traffic monitoring dashboard
├── Traffic_Light_Controller_Consumer/ # Traffic light timing controller
├── TrafficDensityProducer/            # Traffic congestion data service provider
└── WeatherDataProducer/               # Weather data service provider
```

Each bundle contains:
```
BundleName/
├── META-INF/
│   └── MANIFEST.MF                    # OSGi bundle manifest
├── build.properties                   # Build configuration
├── bin/                               # Compiled classes
└── src/                               # Source code
    └── package/
        ├── Activator.java             # Bundle activator
        ├── IService.java              # Service interface (for producers)
        └── ServiceImpl.java           # Service implementation (for producers)
```

## Service Architecture

### Producer Bundles (Service Providers)
- **SpeedSensorProducer**: Provides vehicle speed data through `ISpeedService`
- **TrafficDensityProducer**: Provides traffic congestion data through `ITrafficDensityService`
- **WeatherDataProducer**: Provides weather condition data through `IWeatherService`
- **PublicTransitTrackerProducer**: Provides public transport status through `IPublicTransitService`

### Consumer Bundles (Service Consumers)
- **Traffic_Dashboard_Consumer**: Displays a unified view of all traffic metrics
- **Traffic_Light_Controller_Consumer**: Adjusts traffic signals based on current conditions
- **Emergency_Routing_Consumer**: Optimizes routes for emergency vehicles
- **Navigation_App_Consumer**: Provides route recommendations based on traffic conditions

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK) 23 or later
- Eclipse IDE with PDE (Plugin Development Environment)
- OSGi framework (Apache Felix or Eclipse Equinox)

### Setup in Eclipse
1. **Install Eclipse IDE for Java Developers**
2. **Install PDE (Plugin Development Environment)**:
   - Help → Install New Software
   - Work with: [Your Eclipse version repository]
   - Select "Eclipse Plugin Development Tools"
   - Complete the installation

3. **Import the project**:
   - File → Import → Existing Projects into Workspace
   - Select the Traffic-Orchestra root directory
   - Import all projects

4. **Create an OSGi Run Configuration**:
   - Run → Run Configurations
   - Create a new OSGi Framework configuration
   - Select all Traffic-Orchestra bundles
   - Click "Run"

### Manual Setup (Command Line)
1. **Download Apache Felix**:
   ```
   https://felix.apache.org/downloads.cgi
   ```

2. **Compile all bundles**:
   ```
   javac -d bin src/**/*.java
   ```

3. **Create JAR files for each bundle**:
   ```
   jar cfm BundleName.jar META-INF/MANIFEST.MF -C bin .
   ```

4. **Run Felix and install bundles**:
   ```
   java -jar bin/felix.jar
   felix:install file:/path/to/BundleName.jar
   felix:start [bundle-id]
   ```

## How It Works
1. **Producers** register their services with the OSGi service registry when started
2. **Consumers** look up required services from the registry when started
3. Consumers use the producer services to obtain data and perform their functions
4. The OSGi framework manages dependencies and service lifecycle

## Sample Output
When running the Traffic Dashboard Consumer, you'll see output similar to:
```
--- Traffic Dashboard Consumer ---
===== Traffic Dashboard =====
Road Segment: Main Street
Traffic Density: 65%
Average Speed: 45.23 km/h
Temperature: 22.50 °C
Transit Status: On Time
=============================
```

## Resources
- [OSGi Alliance](https://www.osgi.org/)
- [Eclipse Equinox](https://www.eclipse.org/equinox/)
- [Apache Felix](https://felix.apache.org/)
- [OSGi in Action (Book)](https://www.manning.com/books/osgi-in-action)

## License
[Specify your license here]

## Contributors
[Janitha Gamage] (https://github.com/JordanCJ7)
