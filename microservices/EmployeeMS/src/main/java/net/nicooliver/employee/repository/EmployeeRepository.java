package net.nicooliver.employee.repository;

import net.nicooliver.employee.data.employee.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
