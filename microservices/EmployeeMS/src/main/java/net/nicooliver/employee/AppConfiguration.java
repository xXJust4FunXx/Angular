package net.nicooliver.employee;

import net.nicooliver.employee.dataService.EmployeeDataService;
import net.nicooliver.employee.dataService.LocationIQDataService;
import net.nicooliver.employee.manager.EmployeeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public EmployeeDataService createEmployeeDataService() {
        return new EmployeeDataService();
    }

    @Bean
    public EmployeeManager createEmployeeManager() {
        return new EmployeeManager();
    }

    @Bean
    public LocationIQDataService createLocationIQDataService() {
        return new LocationIQDataService();
    }
}
