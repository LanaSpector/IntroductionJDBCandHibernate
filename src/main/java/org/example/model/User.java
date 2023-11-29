package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private long id;
    private String name;
    private String lastName;
    private byte age;

}
