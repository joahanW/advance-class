package com.metrodata.advance_class.controller;

import com.metrodata.advance_class.constants.ProductConstant;
import com.metrodata.advance_class.dto.request.ProductRequest;
import com.metrodata.advance_class.dto.response.APIResponse;
import com.metrodata.advance_class.dto.response.ErrorResponse;
import com.metrodata.advance_class.dto.response.ProductResponse;
import com.metrodata.advance_class.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for product in JMarket",
        description = "CRUD REST APIs for product in JMarket to CREATE, UPDATE, DELETE and Fetch product detail"
)
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Fetch all Product detail",
            description = "REST APIs to Fetch all Product detail"
    )
    @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = ProductConstant.MESSAGE_200
            ),
            @ApiResponse(
                responseCode = "500",
                description = ProductConstant.MESSAGE_500,
                content = @Content(
                        schema = @Schema(implementation = ErrorResponse.class)
                )
            )
    })
    @GetMapping
    public ResponseEntity<APIResponse<List<ProductResponse>>> findAllProduct(){
        return ResponseEntity
                .status(HttpStatus.valueOf(ProductConstant.STATUS_200))
                .body(productService.findAllProduct());
    }

    @Operation(
            summary = "Fetch detail Product based on id",
            description = "REST APIs to Fetch Product detail"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = ProductConstant.MESSAGE_200
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = ProductConstant.MESSAGE_500,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> findProductById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.valueOf(ProductConstant.STATUS_200))
                .body(productService.findProductById(id))sdasd;
    }

    @Operation(
            summary = "Create Product",
            description = "REST APIs to Create Product detail"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = ProductConstant.MESSAGE_201
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = ProductConstant.MESSAGE_500,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<APIResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.valueOf(ProductConstant.STATUS_201))
                .body(productService.createProduct(productRequest));
    }

    @Operation(
            summary = "Update Product base on Id",
            description = "REST APIs to update Product detail"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = ProductConstant.MESSAGE_200
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = ProductConstant.MESSAGE_500,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.valueOf(ProductConstant.STATUS_200))
                .body(productService.updateProduct(id, productRequest));
    }

    @Operation(
            summary = "Delete Product based on id",
            description = "REST APIs to delete Product detail"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = ProductConstant.MESSAGE_200
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = ProductConstant.MESSAGE_500,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> deleteById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.valueOf(ProductConstant.STATUS_200))
                .body(productService.deleteProduct(id));
    }

}
