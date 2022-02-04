package com.coderhouse.model.database.document;

import com.coderhouse.model.database.document.concrete.Admin;
import com.coderhouse.model.database.document.concrete.Client;
import com.coderhouse.model.database.document.concrete.Editor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "admin"),
        @JsonSubTypes.Type(value = Client.class, name = "client"),
        @JsonSubTypes.Type(value = Editor.class, name = "editor"),

})
@Document("user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class User{

    @Id
    private String id;
    private String type;
    private String description;

    private Curriculum curriculum;
    private boolean status;
    private LocalDateTime createDate;

}
