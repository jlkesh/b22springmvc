package dev.jlkeesh.vocabulary;

import dev.jlkeesh.config.security.SessionUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record VocabularyService(VocabularyRepository vocabularyRepository,
                                VocabularyMapper vocabularyMapper,
                                SessionUser sessionUser) {

    public String create(@NonNull VocabularyCreateDTO dto) {
        Vocabulary vocabulary = vocabularyMapper.toEntity(dto);
        vocabulary.setCreatedBy(sessionUser.getId());
        vocabularyRepository.save(vocabulary);
        return vocabulary.getId();
    }

    public List<Vocabulary> getAll(int limit) {
        Pageable pageable = PageRequest.ofSize(limit);
        return vocabularyRepository.findAllRandom(pageable);
    }

}
