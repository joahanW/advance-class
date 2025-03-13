package com.metrodata.advance_class.dto.mapper;

import com.metrodata.advance_class.dto.response.APIResponse;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @param <M> Model
 * @param <R> Request
 * @param <S> Response
 */
public interface APIResponseMapper<M, R, S> {

    M requestDtoToModel (R r);
    M responseDtoToModel (S s);
    S modelToResponseDto (M m);
    List<S> listModelToResponseDtoList (List<M> m);

    default APIResponse<List<S>> mapToApiResponseListDto(List<M> m){
        List<S> target = listModelToResponseDtoList(m);
        return new APIResponse<>(target);
    }

    default APIResponse<S> mapToAPiResponseDto(M m){
        S target = modelToResponseDto(m);
        return new APIResponse<>(target);
    }

    default APIResponse<S> mapToErrorApiResponseDto(List<HashMap<String,String>> message){
        return new APIResponse<>(message);
    }

}
