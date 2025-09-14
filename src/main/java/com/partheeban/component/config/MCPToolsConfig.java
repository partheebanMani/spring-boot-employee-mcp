package com.partheeban.component.config;

import com.partheeban.component.mcp.EmployeeMCPService;
import com.partheeban.component.mcp.StudentMCPService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MCPToolsConfig {


    @Bean
    public ToolCallbackProvider findTools(EmployeeMCPService employeeMCPService, StudentMCPService studentMCPService){
        return MethodToolCallbackProvider.builder()
                .toolObjects(employeeMCPService, studentMCPService)
                .build();
    }

//    @Bean
//    public ToolCallbackProvider findTools(EmployeeMCPService employeeMCPService) {
//        log.info("find tools bean invoked");
//        return MethodToolCallbackProvider.builder()
//                .toolObjects(employeeMCPService)
//                .build();
//    }

}
