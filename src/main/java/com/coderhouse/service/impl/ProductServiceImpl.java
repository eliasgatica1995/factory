package com.coderhouse.service.impl;

import com.coderhouse.builder.ProductBuilder;
import com.coderhouse.model.ProductFactory;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.repository.ProductRepository;
import com.coderhouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductFactory productFactory = new ProductFactory();

    @Override
    public UserResponse create(UserRequest request) {
        var entity =
                productFactory.createProduct(request);
        var entitySaved = repository.save(entity);
        return ProductBuilder.entityToResponseCreate(entitySaved);
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        var entity =
                productFactory.createProduct(request);
        entity.setId(id);
        var entitySaved = repository.save(entity);
        return ProductBuilder.entityToResponseCreate(entitySaved);
    }

    @Override
    public List<UserResponse> searchAll() {
        return ProductBuilder.listEntityToResponse(repository.findAll());
    }
}
