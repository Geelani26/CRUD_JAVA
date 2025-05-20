package com.example.Employee.service;
import com.example.Employee.models.EmployeeDetails;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.request.EmployeeRequest;
import com.example.Employee.response.EmployeeResponse;
import com.example.Employee.response.GetResponse;
import com.example.Employee.utils.Message;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired

    EmployeeRepository employeeRepository;

    public EmployeeResponse addDetails(EmployeeRequest employeeRequest) {
        EmployeeDetails employeeDetails;
        String message;
        if(employeeRequest.getId()==null){
            employeeDetails=new EmployeeDetails();
            message = Message.Added;
            Optional<EmployeeDetails> employee = employeeRepository.findByEmployeeId(employeeRequest.getEmployeeId());
            if(employee.isPresent()){
                throw new DuplicateKeyException("Already Exists");
            }
            employeeDetails.setEmployeeStatus("ACTIVE");
        }else{
            employeeDetails=employeeRepository.findById(employeeRequest.getId()).orElse(null);
            Optional<EmployeeDetails> employee = employeeRepository.findByEmployeeIdAndIdNot(employeeRequest.getEmployeeId(), employeeRequest.getId());
            if(employee.isPresent()){
                throw new DuplicateKeyException("Already Exists" + employee.get().getEmployeeId());
            }
            message= Message.UPDATE;
            employeeDetails.setEmployeeStatus(employeeRequest.getEmployeeStatus());
        }
        employeeDetails.setEmployeeId(employeeRequest.getEmployeeId());
        employeeDetails.setEmployeeName(employeeRequest.getEmployeeName());
        employeeDetails.setEmployeeType(employeeRequest.getEmployeeType());
        employeeDetails.setEmployeeStatus(employeeRequest.getEmployeeStatus());
        employeeDetails.setEmployeeAddress(employeeRequest.getEmployeeAddress());

        employeeRepository.save(employeeDetails);
        return new EmployeeResponse(message,200,employeeDetails);
    }

    public EmployeeResponse getDetailsById(Integer id) {
        Optional<EmployeeDetails> empById = employeeRepository.findById(id);
        return new EmployeeResponse(Message.GETBYID,200,empById);
    }
    public EmployeeResponse deleteDetailsById(Integer id) {
        Optional<EmployeeDetails> empById = employeeRepository.findById(id);
        empById.get().setEmployeeStatus("DELETED");
        employeeRepository.save(empById.get());
        return new EmployeeResponse(Message.DELETEBYID,200,"deleted");
   }

    public GetResponse getAllDetails(EmployeeRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize());
        Specification<EmployeeDetails> dsdasd = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (request.getEmployeeType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("employeeType"), request.getEmployeeType()));
            }
            if (request.getEmployeeId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("employeeID"), request.getEmployeeId()));
            }
            if (request.getEmployeeName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("employeeName"), request.getEmployeeName()));
            }
            return predicate;
        };
        Page<EmployeeDetails> employeePage = employeeRepository.findAll(dsdasd, pageable);
        return new GetResponse(Message.GET,200, employeePage.getContent(), employeePage.getTotalPages(), employeePage.getTotalElements());
    }

}
