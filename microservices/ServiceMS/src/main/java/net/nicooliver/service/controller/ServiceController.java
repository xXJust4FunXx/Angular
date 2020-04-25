package net.nicooliver.service.controller;

import net.nicooliver.service.data.service.ServiceDto;
import net.nicooliver.service.data.service.ServiceResource;
import net.nicooliver.service.dataService.ServiceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("services")
public class ServiceController {
    @Autowired
    private ServiceDataService serviceDataService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<ServiceResource>> getAllServices() {
        return new HttpEntity<>(serviceDataService.getAllServices());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ServiceResource addService(@RequestBody ServiceDto serviceDto) {
        return serviceDataService.addService(serviceDto);
    }

    @RequestMapping(value = "{serviceId}", method = RequestMethod.DELETE)
    public ServiceResource deleteService(@PathVariable Integer serviceId) {
        return serviceDataService.deleteService(serviceId);
    }

    @RequestMapping(value = "{serviceId}", method = RequestMethod.GET)
    public ServiceResource getService(@PathVariable Integer serviceId) {
        return serviceDataService.getService(serviceId);
    }

    @RequestMapping(value = "{serviceId}", method = RequestMethod.PUT)
    public ServiceResource editService(@PathVariable Integer serviceId, @RequestBody ServiceDto serviceDto) {
        return serviceDataService.editService(serviceId, serviceDto);
    }
}
