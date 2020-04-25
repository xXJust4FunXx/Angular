package net.nicooliver.service;

import net.nicooliver.service.dataService.LocationIQDataService;
import net.nicooliver.service.dataService.ServiceDataService;
import net.nicooliver.service.manager.ServiceManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ServiceDataService createServiceDataService() {
        return new ServiceDataService();
    }

    @Bean
    public ServiceManager createServiceManager() {
        return new ServiceManager();
    }

    @Bean
    public LocationIQDataService createLocationIQDataService() {
        return new LocationIQDataService();
    }
}
