package com.example.Employee.controller;
import com.example.Employee.request.EmployeeRequest;
import com.example.Employee.response.EmployeeResponse;
import com.example.Employee.response.GetResponse;
import com.example.Employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeResponse addDetails(@RequestBody@Valid EmployeeRequest employeeRequest) {
        return employeeService.addDetails(employeeRequest);
    }
    @GetMapping("/getAll")
    public GetResponse getAllDetails(EmployeeRequest employeeRequest) {
        return employeeService.getAllDetails(employeeRequest);
    }
    @GetMapping("/{id}")
    public EmployeeResponse getDetailsById(@PathVariable Integer id) {
        return employeeService.getDetailsById(id);
    }

    @DeleteMapping("/{id}")
    public EmployeeResponse deleteDetailsById(@PathVariable Integer id) {
        return employeeService.deleteDetailsById(id);
    }
}











