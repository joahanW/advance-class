package com.metrodata.advance_class.dto.mapper;

import com.metrodata.advance_class.dto.request.ProductRequest;
import com.metrodata.advance_class.dto.response.APIResponse;
import com.metrodata.advance_class.dto.response.ProductResponse;
import com.metrodata.advance_class.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper extends APIResponseMapper<Product, ProductRequest, ProductResponse> {

}
