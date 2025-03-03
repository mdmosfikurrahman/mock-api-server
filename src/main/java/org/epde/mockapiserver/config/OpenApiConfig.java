package org.epde.mockapiserver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Mock API Server",
                description = "This API provides mocked endpoints for testing and simulating real-world API responses. It includes user, product, and order-related endpoints to facilitate development and testing scenarios.",
                summary = "A mock API server for testing and simulation of various API responses.",
                contact = @Contact(
                        name = "Md. Mosfikur Rahman",
                        email = "mdmosfikurrahman.cse@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                ),
                version = "v1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:1234/api/v1"
                ),
                @Server(
                        description = "Deployed Server",
                        url = "https://epde-mock-server.onrender.com/api/v1"
                )
        }
)
public class OpenApiConfig {
}
