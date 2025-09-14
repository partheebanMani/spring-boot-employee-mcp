package com.partheeban.component.mcp;


import com.partheeban.component.model.Employee;
import com.partheeban.component.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeMCPService {

    @Autowired
    public EmployeeService employeeService;


    @Tool(name = "get_all_employees", description = "this tool will return all the employee from Database")
    public List<Employee> getAllEmployee(){
        log.info("get all employees service invoked from MCP");
        return employeeService.getEmployee();
    }


    @Tool(name ="get_employee_based_on_id", description = "this tool will return a particular employee details based on id")
    public ResponseEntity<Optional<Employee>> getEmployee(@ToolParam Long id) {
        log.info("Employee request controller");
        return Optional.of(employeeService.getEmployee(id))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

    }

    @Tool(name = "add employee", description = "this tool will create employee record")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("Create employee request received with body {}", employee.toString());
        ResponseEntity<Employee> employeeResponseEntity = new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
        log.debug("Response for request {}", employeeResponseEntity);
        return employeeResponseEntity;
    }


}
