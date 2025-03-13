package com.metrodata.advance_class.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Schema(
        name = "Error Response",
        description = "Schema to hold error response"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    @Schema(
        description = "API Path invoked by client", example = "/api/v1/..."
    )
    private String apiPath;

    @Schema(
        description = "Error Code representing the type of error", example = "4xx/5xx"
    )
    private int errorCode;

    @Schema(
        description = "Error message representing the type of error", example = "ERROR"
    )
    private String errorMessage;

    @Schema(
        description = "Time representing when the error occurred", example = "2025-01-01T00:00:00.000Z"
    )
    private Instant errorTime;
}
