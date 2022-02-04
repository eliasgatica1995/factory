package com.coderhouse.builder;

import com.coderhouse.model.database.document.Curriculum;
import com.coderhouse.model.database.document.User;
import com.coderhouse.model.database.document.concrete.Admin;
import com.coderhouse.model.database.document.concrete.Client;
import com.coderhouse.model.database.document.concrete.Editor;
import com.coderhouse.model.request.CurriculumRequest;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.CategoryResponse;
import com.coderhouse.model.response.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    public static Admin requestToEntityAdmin(UserRequest request) {
        return Admin.builder()
                .type(request.getType())
                .createDate(LocalDateTime.now())
                .status(Boolean.TRUE)
                .area(request.getArea())
                .description(request.getDescription())
                .curriculum(requestToEntityCategory(request.getCurriculum()))
                .build();
    }


    public static Client requestToEntityClient(UserRequest request) {
        return Client.builder()
                .type(request.getType())
                .edad(request.getEdad())
                .status(Boolean.TRUE)
                .createDate(LocalDateTime.now())
                .description(request.getDescription())
                .curriculum(requestToEntityCategory(request.getCurriculum()))
                .build();
    }
    public static Editor requestToEntityEditor(UserRequest request) {
        return Editor.builder()
                .type(request.getType())
                .createDate(LocalDateTime.now())
                .status(Boolean.TRUE)
                .apellido(request.getApellido())
                .description(request.getDescription())
                .curriculum(requestToEntityCategory(request.getCurriculum()))
                .build();
    }

    private static Curriculum requestToEntityCategory(CurriculumRequest category) {
        return Curriculum.builder().description(category.getDescription()).build();
    }
    public static UserResponse entityToResponseCreate(User entity) {
        return UserResponse.builder()
                .code(entity.getId())
                .createDate(entity.getCreateDate().toString())
                .status(entity.isStatus())
                .build();
    }


    public static <T extends User> UserResponse entityToResponse(T entity) {
        if (entity instanceof Admin) {
            var entityCast = (Admin) entity;
            return UserResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .description(entity.getDescription())
                    .type(entity.getType())
                    .build();
        } else {
            return UserResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .description(entity.getDescription())
                    .type(entity.getType())
                    .build();
        }
    }

    private static CategoryResponse buildCategory(User category) {
        return CategoryResponse.builder().description(category.getDescription()).build();
    }

    public static List<UserResponse>
    listEntityToResponse(List<User> products) {

        var listResponse = new ArrayList<UserResponse>();
        products.forEach(item -> listResponse.add(entityToResponse(item)));
        return listResponse;
    }

}
