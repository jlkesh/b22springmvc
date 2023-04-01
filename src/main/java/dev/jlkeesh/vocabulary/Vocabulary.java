package dev.jlkeesh.vocabulary;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Vocabulary {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
    private String word;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "varchar[]", name = "translations")
    private List<String> translations;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "varchar[]", name = "synonyms")
    private List<String> synonyms;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "varchar[]", name = "examples")
    private List<String> examples;

    @Column
    private String createdBy;
}
