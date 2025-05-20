package com.example.Employee.request;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private Integer id;
    @NotNull(message = "Enter Employee ID")
    @Digits(integer = 4,fraction = 0,message = "Invalid")
    private Integer employeeId;
    @NotNull(message = "Enter your name")
    @Size(min = 3,max = 15,message = "employee name not be null")
    private String employeeName;

    @NotNull(message = "Enter Employee Type")
    @Size(min = 2,max = 10,message = "employee type not be null")
    private String employeeType;

    @NotNull(message = "Enter Employee Status")
    @Size(min = 3,max = 100,message = "Employee status not be null")
    private  String employeeStatus;

    @NotNull(message = "Enter Employee Address")
    @Size(min = 5,max = 40,message = "Employee Address not be null")
    private String employeeAddress;
    private Integer page;
    private  Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Enter Employee ID") @Digits(integer = 4, fraction = 0, message = "Invalid") Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(@NotNull(message = "Enter Employee ID") @Digits(integer = 4, fraction = 0, message = "Invalid") Integer employeeId) {
        this.employeeId = employeeId;
    }

    public @NotNull(message = "Enter your name") @Size(min = 3, max = 15, message = "employee name not be null") String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(@NotNull(message = "Enter your name") @Size(min = 3, max = 15, message = "employee name not be null") String employeeName) {
        this.employeeName = employeeName;
    }

    public @NotNull(message = "Enter Employee Type") @Size(min = 2, max = 10, message = "employee type not be null") String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(@NotNull(message = "Enter Employee Type") @Size(min = 2, max = 10, message = "employee type not be null") String employeeType) {
        this.employeeType = employeeType;
    }

    public @NotNull(message = "Enter Employee Status") @Size(min = 3, max = 100, message = "Employee status not be null") String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(@NotNull(message = "Enter Employee Status") @Size(min = 3, max = 100, message = "Employee status not be null") String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public @NotNull(message = "Enter Employee Address") @Size(min = 5, max = 40, message = "Employee Address not be null") String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(@NotNull(message = "Enter Employee Address") @Size(min = 5, max = 40, message = "Employee Address not be null") String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
