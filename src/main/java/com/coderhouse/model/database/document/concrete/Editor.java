package com.coderhouse.model.database.document.concrete;


import com.coderhouse.model.database.document.User;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@JsonTypeName("editor")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Editor extends User {
    private String apellido;
}
