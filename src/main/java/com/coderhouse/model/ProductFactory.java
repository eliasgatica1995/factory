package com.coderhouse.model;

import com.coderhouse.builder.ProductBuilder;
import com.coderhouse.model.database.document.User;
import com.coderhouse.model.request.UserRequest;
import lombok.Data;

@Data
public class ProductFactory {

        public User createProduct(UserRequest request) {
        switch (request.getType()) {
            case "client":
                return ProductBuilder.requestToEntityClient(request);
            case "admin":
                return ProductBuilder.requestToEntityAdmin(request);
            case "editor":
                return ProductBuilder.requestToEntityEditor(request);

            default:
                return null;
        }
    }

}
