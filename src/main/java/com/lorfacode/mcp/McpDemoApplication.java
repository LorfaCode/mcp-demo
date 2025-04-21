package com.lorfacode.mcp;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lorfacode.mcp.service.CryptoService;

@SpringBootApplication
public class McpDemoApplication {

    @Autowired
    private CryptoService cryptoService;

    public static void main(String[] args) {
        SpringApplication.run(McpDemoApplication.class, args);
    }

/*     @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Running as a CLI application...");
            final var data = cryptoService.getOHLCForPair("ETHUSD", 5);
            System.out.println("Data: " + data);
        };
    } */

    @Bean
    public ToolCallbackProvider toolCallBackProvider() {
        return MethodToolCallbackProvider.builder().toolObjects(cryptoService).build();
    }
}
