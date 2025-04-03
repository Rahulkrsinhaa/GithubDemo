package com.rest.restApi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
@ToString
@Builder
public class Employee {
    @Id
    String id;

    String name;

    String gender;

    int age;
}
