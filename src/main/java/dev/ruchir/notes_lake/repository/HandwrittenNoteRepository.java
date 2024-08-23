package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface HandwrittenNoteRepository extends JpaRepository<HandwrittenNote, Long> {

    boolean existsByTitle(String title);

    @Query("SELECT hn FROM HandwrittenNote hn WHERE hn.title LIKE %:query%")
    List<HandwrittenNote> searchByTitle(@Param("query") String query);

    @Query("SELECT hn FROM HandwrittenNote hn WHERE hn.title LIKE %:title% AND " +
            "hn.createdDate BETWEEN :startDate AND :endDate")
    List<HandwrittenNote> filterByTitleAndDate(@Param("title") String title,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);

    @Query("SELECT hn FROM HandwrittenNote hn JOIN hn.tags t WHERE t = :tag")
    List<HandwrittenNote> findByTagsContains(@Param("tag") Tag tag);
}
