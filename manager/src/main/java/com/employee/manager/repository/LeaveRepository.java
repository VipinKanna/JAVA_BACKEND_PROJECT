package com.employee.manager.repository;


import com.employee.manager.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

    List<Leave> findByEmployee_Id(Long employeeId);

}