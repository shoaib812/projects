package com.nihongo.repository;

import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}