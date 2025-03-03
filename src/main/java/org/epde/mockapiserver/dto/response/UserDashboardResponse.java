package org.epde.mockapiserver.dto.response;

import java.util.List;

public record UserDashboardResponse(
        UserResponse userInfo,
        List<ActivityLogResponse> recentActivities,
        List<NotificationResponse> notifications
) {
}
