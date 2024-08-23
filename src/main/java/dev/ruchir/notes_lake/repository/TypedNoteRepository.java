package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate; // Add this import
import java.util.List;

@Repository
public interface TypedNoteRepository extends JpaRepository<TypedNote, Long> {

    // Method to check if a note with the given title exists
    boolean existsByTitle(String title);

    @Query("SELECT tn FROM TypedNote tn WHERE tn.title LIKE %:query%")
    List<TypedNote> searchByTitle(@Param("query") String query);

    @Query("SELECT tn FROM TypedNote tn WHERE tn.title LIKE %:title% AND tn.createdDate " +
            "BETWEEN :startDate AND :endDate")
    List<TypedNote> filterByTitleAndDate(@Param("title") String title, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
