package org.epde.mockapiserver.dto.request;

import java.util.List;

public record OrderRequest(List<String> items) {
}
