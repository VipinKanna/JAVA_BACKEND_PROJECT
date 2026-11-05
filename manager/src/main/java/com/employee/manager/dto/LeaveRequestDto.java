package com.employee.manager.dto;

import lombok.Data;

@Data
public class LeaveRequestDto{

    public Long employeeId;
    public String leaveType;
    public String startDate;
    public String endDate;
    public String status="PENDING";

}