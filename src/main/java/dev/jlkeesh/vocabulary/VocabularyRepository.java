package dev.jlkeesh.vocabulary;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, String> {

    @Query("select t from Vocabulary t order by random()")
    List<Vocabulary> findAllRandom(Pageable pageable);
}