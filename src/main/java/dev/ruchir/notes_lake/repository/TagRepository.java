package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t FROM Tag t WHERE t.name LIKE %:query%")
    List<Tag> searchByName(@Param("query") String query);

    // Add more queries if needed
}