package com.metrodata.advance_class.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    name = "Product Request",
    description = "Schema to hold Product Request information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @Schema(
            description = "Product name",
            example = "Macbook Pro M4 Pro 2024"
    )
    @NotBlank(message = "Product name cannot be null or empty")
    private String name;

    @Schema(
        description = "Product price",
        example = "3000.00"
    )
    @Positive(message = "Product price cannot be negative")
    private double price;

    @Schema(
        description = "Product quantity",
        example = "10"
    )
    @PositiveOrZero(message = "Product quantity cannot be negative")
    private int quantity;

}
