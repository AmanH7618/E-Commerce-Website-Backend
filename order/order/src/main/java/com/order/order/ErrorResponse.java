package com.order.order;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
