package com.coderhouse.model.request;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "El campo type no puede vacio")
    @Pattern(regexp = "^(client|editor|admin)$", message = "Solo acepta: client,admin,editor")
    private String type;
    private String description;
    @Max(100)
    @Min(1)
    private int edad;
    private String area;
    private String apellido;
    @NotNull(message = "El campo category es obligatorio")
    private CurriculumRequest curriculum;
}
