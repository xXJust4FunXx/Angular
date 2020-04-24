package net.nicooliver.service.repository;

import net.nicooliver.service.data.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Integer> {
}
