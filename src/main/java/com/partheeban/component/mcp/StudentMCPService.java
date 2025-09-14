package com.partheeban.component.mcp;


import com.partheeban.component.model.Student;
import com.partheeban.component.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentMCPService {

    @Autowired
    private StudentService studentService;

    @Tool(name = "get_students")
    public ResponseEntity<List<Student>> getStudents(){
        log.info("GET student request is received");
        ResponseEntity<List<Student>> listResponseEntity = new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        log.debug("Response for GET students request, status code {}, response body {}", listResponseEntity.getStatusCode(), listResponseEntity.getBody());
        return listResponseEntity;
    }

    @Tool(name = "get_student_based_on_id")
    public ResponseEntity<Optional<Student>> getStudent(@ToolParam Integer id)  {
        log.info("GET employee request received for ID {}", id);
        return Optional.of(studentService.getStudent(id))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }
}
