package net.nicooliver.service.manager;

import net.nicooliver.service.data.service.Service;
import net.nicooliver.service.data.service.ServiceEntity;
import net.nicooliver.service.data.service.ServiceResource;
import net.nicooliver.service.exception.ServiceEntityNotFoundException;
import net.nicooliver.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceManager {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        List<Service> result = new ArrayList<>();
        for (ServiceEntity serviceEntity : serviceRepository.findAll()) {
            result.add(convertServiceEntityToService(serviceEntity));
        }
        return result;
    }

    public Service addService(Service service) {
        return saveService(service);
    }

    public Service getServiceById(Integer serviceId) {
        return convertServiceEntityToService(getServiceEntityById(serviceId));
    }

    public Service editService(Integer serviceId, Service newService) {
        Service service = getServiceById(serviceId);

        service.setDate(newService.getDate());
        service.setLongitude(newService.getLongitude());
        service.setEmployeeId(newService.getEmployeeId());
        service.setName(newService.getName());
        service.setLatitude(newService.getLatitude());

        return saveService(service);
    }

    public Service deleteService(Integer serviceId) {
        ServiceEntity foundEntity = getServiceEntityById(serviceId);
        serviceRepository.delete(foundEntity);
        return convertServiceEntityToService(foundEntity);
    }

    private Service convertServiceEntityToService(ServiceEntity serviceEntity) {
        Service result = new Service();

        result.setId(serviceEntity.getId());
        result.setName(serviceEntity.getName());
        result.setDate(serviceEntity.getDate());
        result.setLatitude(serviceEntity.getLatitude());
        result.setLongitude(serviceEntity.getLongitude());
        result.setEmployeeId(serviceEntity.getEmployeeId());

        return result;
    }

    private ServiceEntity convertServiceToServiceEntity(Service service) {
        ServiceEntity result = new ServiceEntity();

        if(service.getId() != -1) {
            result.setId(service.getId());
        }

        result.setDate(service.getDate());
        result.setEmployeeId(service.getEmployeeId());
        result.setLatitude(service.getLatitude());
        result.setLongitude(service.getLongitude());
        result.setName(service.getName());

        return result;
    }

    private Service saveService(Service service) {
        ServiceEntity storedEntity = serviceRepository.save(convertServiceToServiceEntity(service));
        return convertServiceEntityToService(storedEntity);
    }

    private ServiceEntity getServiceEntityById(Integer serviceId) {
        Optional<ServiceEntity> foundEntity = serviceRepository.findById(serviceId);

        if(!foundEntity.isPresent())
            throw new ServiceEntityNotFoundException(String.format("Service with id %d does not exist!", serviceId));

        return foundEntity.get();
    }
}
