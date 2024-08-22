package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandwrittenNoteRepository extends JpaRepository<HandwrittenNote, Long> {

    // Method to check if a note with the given title exists
    boolean existsByTitle(String title);
}