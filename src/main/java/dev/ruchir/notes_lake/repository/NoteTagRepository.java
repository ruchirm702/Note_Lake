package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteTagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT hn FROM HandwrittenNote hn JOIN hn.tags t WHERE t.name = :tagName")
    List<HandwrittenNote> findHandwrittenNotesByTagName(@Param("tagName") String tagName);

    @Query("SELECT tn FROM TypedNote tn JOIN tn.tags t WHERE t.name = :tagName")
    List<TypedNote> findTypedNotesByTagName(@Param("tagName") String tagName);
}
