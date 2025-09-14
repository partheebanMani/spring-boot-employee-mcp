package com.partheeban.component;

import com.partheeban.component.mcp.EmployeeMCPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentApplication.class, args);
    }



}
