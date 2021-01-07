package nl.cge.jakartaee8.jaxrs20.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InputDto {

    private String username;
    private String password;
}
