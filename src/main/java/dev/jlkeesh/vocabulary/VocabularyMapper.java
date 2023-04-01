package dev.jlkeesh.vocabulary;

import org.mapstruct.*;

@Mapper( componentModel = "spring")
public interface VocabularyMapper {
    Vocabulary toEntity(VocabularyCreateDTO dto);

    VocabularyDTO toDto(Vocabulary vocabulary);

}