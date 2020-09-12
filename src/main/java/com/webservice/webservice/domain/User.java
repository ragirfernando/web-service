package com.webservice.webservice.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"name", "email", "phone", "password"})
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
