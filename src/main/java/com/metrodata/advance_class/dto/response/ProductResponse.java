package com.metrodata.advance_class.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Product Response",
        description = "Schema to hold Product Response"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    @Schema(
        description = "Product id",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Product name",
        example = "Macbook Pro M4 Pro 2024"
    )
    private String name;

    @Schema(
        description = "Product price",
        example = "3000.00"
    )
    private double price;

    @Schema(
        description = "Product quantity",
        example = "10"
    )
    private int quantity;

}
