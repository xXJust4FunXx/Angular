package net.nicooliver.service.dataService;

import net.nicooliver.service.data.employee.EmployeeResource;
import net.nicooliver.service.data.location.LongitudeLatitude;
import net.nicooliver.service.data.service.Service;
import net.nicooliver.service.data.service.ServiceDto;
import net.nicooliver.service.data.service.ServiceResource;
import net.nicooliver.service.exception.ServiceBadRequestException;
import net.nicooliver.service.exception.ServiceNotFoundException;
import net.nicooliver.service.manager.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ServiceDataService {
    @Autowired
    private ServiceManager serviceManager;
    @Autowired
    private LocationIQDataService locationIQDataService;
    @Autowired
    private EmployeeDataService employeeDataService;

    public List<ServiceResource> getAllServices() {
        List<ServiceResource> result = new ArrayList<>();
        for (Service service : serviceManager.getAllServices()) {
            result.add(convertServiceToServiceRessource(service));
        }
        return result;
    }

    private ServiceResource convertServiceToServiceRessource(Service service) {
        ServiceResource result = new ServiceResource();
        result.setId(service.getId());
        result.setName(service.getName());
        result.setAddress(locationIQDataService.getAddress(service.getLongitude(), service.getLatitude()));
        result.setDate(service.getDate());
        result.setEmployee(employeeDataService.getEmployeeById(service.getEmployeeId()));
        return result;
    }

    public ServiceResource addService(ServiceDto serviceDto) {
        checkServiceDto(serviceDto);
        return convertServiceToServiceRessource(serviceManager.addService(convertServiceDtoToService(serviceDto)));
    }

    private Service convertServiceDtoToService(ServiceDto serviceDto) {
        Service result = new Service();

        result.setName(serviceDto.getName());
        result.setEmployeeId(serviceDto.getEmployeeId());
        result.setDate(serviceDto.getDate());

        LongitudeLatitude lonlat = locationIQDataService.getLongitudeLatitudeByAddress(serviceDto.getAddress());
        result.setLatitude(lonlat.getLatitude());
        result.setLongitude(lonlat.getLongitude());

        return result;
    }

    private void checkServiceDto(ServiceDto serviceDto) {
        if(serviceDto.getName().length() <= 4) {
            throw new ServiceBadRequestException("The name of the service must be longer than 4");
        }
        if(isNullOrEmpty(serviceDto.getName())) {
            throw new ServiceBadRequestException("The name of the service must be set");
        }
        if(isNullOrEmpty(serviceDto.getDate())) {
            throw new ServiceBadRequestException("The date of the service must be set");
        }
        if(isNullOrEmpty(serviceDto.getAddress())) {
            throw new ServiceBadRequestException("The address of the service must be set");
        }
        if(!validateStringDate(serviceDto.getDate())) {
            throw new ServiceNotFoundException("The date of the service must be in the right format");
        }
        if(serviceDto.getAddress().length() <= 5) {
            throw new ServiceBadRequestException("The address of the service must be longer than 5");
        }
    }

    private boolean validateStringDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        try {
            Date javaDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean isNullOrEmpty(String string) {
        return string == null || string.equals("");
    }

    public ServiceResource deleteService(Integer serviceId) {
        return convertServiceToServiceRessource(serviceManager.deleteService(serviceId));
    }

    public ServiceResource getService(Integer serviceId) {
        return convertServiceToServiceRessource(serviceManager.getServiceById(serviceId));
    }

    public ServiceResource editService(Integer serviceId, ServiceDto serviceDto) {
        checkServiceDto(serviceDto);

        Service editedService = serviceManager.editService(serviceId, convertServiceDtoToService(serviceDto));
        return convertServiceToServiceRessource(editedService);
    }
}
