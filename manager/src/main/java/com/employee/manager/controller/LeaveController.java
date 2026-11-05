package com.employee.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manager.dto.LeaveRequestDto;
import com.employee.manager.entity.Leave;
import com.employee.manager.service.LeaveService;


@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    LeaveService leaveService;

    @GetMapping("/showleaves")
    public List<Leave> getLeaves() {
        return leaveService.getLeaves();
        
    }
    @PostMapping("/requestleave")
    public List<Leave> employeeLeaveRequest(@RequestBody LeaveRequestDto request){
        return leaveService.employeeLeaveRequest(request);
    }
    @PostMapping("/approveleave/{leaveId}")
    public String approveLeave(@PathVariable Long leaveId){
        return leaveService.approveLeave(leaveId);
    }
    @DeleteMapping("delete/{leaveId}")
    public String deleteLeave(@PathVariable Long leaveId){
        return leaveService.deleteLeave(leaveId);
    }
}