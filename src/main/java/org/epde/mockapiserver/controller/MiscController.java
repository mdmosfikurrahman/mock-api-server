package org.epde.mockapiserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.epde.mockapiserver.dto.response.ApiStatusResponse;
import org.epde.mockapiserver.service.MockApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Miscellaneous APIs", description = "Endpoints for miscellaneous operations")
public class MiscController {

    private final MockApiService mockApiService;

    @Operation(summary = "API Status", description = "Check the API status")
    @GetMapping("/status")
    public ApiStatusResponse getApiStatus() {
        return mockApiService.getApiStatus();
    }
}
