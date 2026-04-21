package com.demo.graphql.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String email;
}
