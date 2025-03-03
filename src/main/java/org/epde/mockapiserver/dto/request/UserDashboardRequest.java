package org.epde.mockapiserver.dto.request;

public record UserDashboardRequest(int userId, String name, String email) {
}