package org.epde.mockapiserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.epde.mockapiserver.dto.request.*;
import org.epde.mockapiserver.dto.response.*;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User APIs", description = "Endpoints for managing users")
public class UserController {

    private final MockApiService mockApiService;

    @Operation(summary = "Get User", description = "Retrieve a default user")
    @GetMapping
    public UserResponse getUser() {
        return mockApiService.getUser();
    }

    @Operation(summary = "Get User by ID", description = "Retrieve user details by ID")
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return mockApiService.getUserById(id);
    }

    @Operation(summary = "Update User", description = "Update user details by ID")
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
        return mockApiService.updateUser(id, userRequest);
    }

    @Operation(summary = "User Details", description = "User details Request")
    @GetMapping("/details")
    public UserDetailsResponse getUserDetails(@RequestBody UserDetailsRequest request) {
        return mockApiService.getUserDetails(request);
    }

    @Operation(summary = "User Dashboard", description = "Retrieve user dashboard data")
    @PostMapping("/dashboard")
    public UserDashboardResponse getUserDashboard(@RequestBody UserDashboardRequest request) {
        return mockApiService.getUserDashboard(request);
    }

}
