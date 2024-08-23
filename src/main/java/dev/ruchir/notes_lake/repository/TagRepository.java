package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t FROM Tag t WHERE t.name LIKE %:query%")
    List<Tag> searchByName(@Param("query") String query);
    Optional<Tag> findByName(String name);

    // Add more queries if needed
}