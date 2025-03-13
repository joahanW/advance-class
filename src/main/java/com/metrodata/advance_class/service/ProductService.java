package com.metrodata.advance_class.service;

import com.metrodata.advance_class.dto.request.ProductRequest;
import com.metrodata.advance_class.dto.response.APIResponse;
import com.metrodata.advance_class.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    /**
     *
     * @return find all product detail
     */
    APIResponse<List<ProductResponse>> findAllProduct();

    /**
     *
     * @param id product id
     * @return product detail by id
     */
    APIResponse<ProductResponse> findProductById(Long id);

    /**
     *
     * @param productRequest
     * @return product detail
     */
    APIResponse<ProductResponse> createProduct(ProductRequest productRequest);

    /**
     *
     * @param id
     * @param productRequest
     * @return product detail
     */
    APIResponse<ProductResponse> updateProduct(Long id, ProductRequest productRequest);

    /**
     *
     * @param id
     * @return product detail
     */
    APIResponse<ProductResponse> deleteProduct(Long id);
}
