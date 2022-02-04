package com.coderhouse.model.database.document.concrete;


import com.coderhouse.model.database.document.User;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonTypeName("admin")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

    private String area;
}
