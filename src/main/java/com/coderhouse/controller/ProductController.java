package com.coderhouse.controller;

import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class ProductController {

    private final ProductService service;

    @PostMapping("/user")
    public UserResponse createProduct(
            @Validated @RequestBody UserRequest user) {
        return service.create(user);
    }

    @PutMapping("/user/{id}")
    public UserResponse updateProduct(@PathVariable String id,
            @Validated @RequestBody UserRequest user) {
        return service.update(id, user);
    }

    @GetMapping("/user/all")
    public List<UserResponse> searchProduct() {
        return service.searchAll();
    }
}
