package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypedNoteRepository extends JpaRepository<TypedNote, Long> {

    // Method to check if a note with the given title exists
    boolean existsByTitle(String title);
}