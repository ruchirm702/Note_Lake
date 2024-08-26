package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Custom query methods (if any) can be added here
}
