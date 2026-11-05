package com.employee.manager.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.manager.dto.LeaveRequestDto;
import com.employee.manager.entity.Employee;
import com.employee.manager.entity.Leave;
import com.employee.manager.repository.EmployeeRepository;
import com.employee.manager.repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepo;
    @Autowired
    EmployeeRepository employeeRepo;

    public List<Leave> employeeLeaveRequest(LeaveRequestDto request) {

    Long employeeId = request.getEmployeeId();
    
    Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

    Leave leaveRequest = new Leave();

    leaveRequest.setEmployee(employee);
    leaveRequest.setLeaveType(request.getLeaveType());
    LocalDate startDate = LocalDate.parse(request.getStartDate());
    LocalDate endDate = LocalDate.parse(request.getEndDate());
    leaveRequest.setStartDate(startDate);
    leaveRequest.setEndDate(endDate);
    leaveRepo.save(leaveRequest);
    return leaveRepo.findAll();
    }
    public List<Leave> getLeaves(){
        return leaveRepo.findAll();
    }
    public String approveLeave(Long leaveId){

        Leave leave = leaveRepo.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
        int days=(int) ChronoUnit.DAYS.between(leave.getStartDate(), leave.getEndDate());
        Employee employee = leave.getEmployee();
        employee.setLeaveBalance(employee.getLeaveBalance() - (days+1));
        leave.setStatus("Approved");
        
        leaveRepo.save(leave);
        employeeRepo.save(employee);
        return "Leave approved successfully";
    }
    public String deleteLeave(Long leaveId){
        Leave leave = leaveRepo.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
        leaveRepo.delete(leave);
        return "deleted Successfully";
    }
    
}
