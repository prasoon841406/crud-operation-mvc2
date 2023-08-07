package in.prasoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prasoon.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}
