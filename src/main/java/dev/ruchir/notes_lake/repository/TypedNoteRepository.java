package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Tag;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TypedNoteRepository extends JpaRepository<TypedNote, Long> {

    boolean existsByTitle(String title);

    @Query("SELECT tn FROM TypedNote tn WHERE tn.title LIKE %:query%")
    List<TypedNote> searchByTitle(@Param("query") String query);

    @Query("SELECT tn FROM TypedNote tn WHERE tn.title LIKE %:title% AND tn.createdDate BETWEEN :startDate AND :endDate")
    List<TypedNote> filterByTitleAndDate(@Param("title") String title, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT tn FROM TypedNote tn JOIN tn.tags t WHERE t = :tag")
    List<TypedNote> findByTagsContains(@Param("tag") Tag tag);
}
