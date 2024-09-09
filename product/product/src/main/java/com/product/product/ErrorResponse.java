package com.product.product;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
