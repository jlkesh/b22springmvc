package dev.jlkeesh;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Employee {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
}
