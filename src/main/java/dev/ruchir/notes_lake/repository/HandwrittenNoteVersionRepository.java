package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.HandwrittenNoteVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HandwrittenNoteVersionRepository extends JpaRepository<HandwrittenNoteVersion, Long> {

    List<HandwrittenNoteVersion> findByNoteIdOrderByVersionNumberAsc(Long noteId);
    Optional<HandwrittenNoteVersion> findTopByNoteIdOrderByVersionNumberDesc(Long noteId);
    boolean existsByNoteId(Long noteId);
}
