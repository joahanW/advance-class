package com.metrodata.advance_class.service.impl;

import com.metrodata.advance_class.constants.ProductConstant;
import com.metrodata.advance_class.dto.mapper.ProductMapper;
import com.metrodata.advance_class.dto.request.ProductRequest;
import com.metrodata.advance_class.dto.response.APIResponse;
import com.metrodata.advance_class.dto.response.ProductResponse;
import com.metrodata.advance_class.entity.Product;
import com.metrodata.advance_class.exception.CustomException;
import com.metrodata.advance_class.repository.ProductRepository;
import com.metrodata.advance_class.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public APIResponse<List<ProductResponse>> findAllProduct() {
        return productMapper.mapToApiResponseListDto(
                productRepository.findAll()
        );
    }

    @Override
    public APIResponse<ProductResponse> findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException(ProductConstant.MESSAGE_404, ProductConstant.STATUS_404));
        return productMapper.mapToAPiResponseDto(product);
    }

    @Override
    public APIResponse<ProductResponse> createProduct(ProductRequest productRequest) {
        Product product = productMapper.requestDtoToModel(productRequest);
        return productMapper.mapToAPiResponseDto(
                productRepository.saveAndFlush(product)
        );
    }

    @Override
    public APIResponse<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {
        findProductById(id);
        Product product = productMapper.requestDtoToModel(productRequest);
        product.setId(id);
        return productMapper.mapToAPiResponseDto(
                productRepository.saveAndFlush(product)
        );
    }

    @Override
    public APIResponse<ProductResponse> deleteProduct(Long id) {
        APIResponse<ProductResponse> product = findProductById(id);
        productRepository.deleteById(id);
        return product;
    }
}
