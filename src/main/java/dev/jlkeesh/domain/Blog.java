package dev.jlkeesh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {
    private String id;
    private String title;
    private String overview;
    private String content;
}
