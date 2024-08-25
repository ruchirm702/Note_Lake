package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    // Custom query methods can be added here if needed
}
