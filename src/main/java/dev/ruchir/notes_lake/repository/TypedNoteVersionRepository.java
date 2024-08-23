package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.TypedNoteVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypedNoteVersionRepository extends JpaRepository<TypedNoteVersion, Long> {

    List<TypedNoteVersion> findByNoteIdOrderByVersionNumberAsc(Long noteId);
    Optional<TypedNoteVersion> findTopByNoteIdOrderByVersionNumberDesc(Long noteId);
    boolean existsByNoteId(Long noteId);
}
