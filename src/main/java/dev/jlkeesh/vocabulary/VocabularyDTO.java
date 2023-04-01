package dev.jlkeesh.vocabulary;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VocabularyDTO {

    private String id;
    private String word;
    private List<String> translations;
    private List<String> synonyms;
    private List<String> examples;

    private LocalDateTime createdAt;
}
