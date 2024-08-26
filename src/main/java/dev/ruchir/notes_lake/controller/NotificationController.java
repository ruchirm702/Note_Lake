package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.NotificationDTO;
import dev.ruchir.notes_lake.controller_advise.custom.InvalidNotificationException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationServiceException;
import dev.ruchir.notes_lake.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Validated
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        try {
            NotificationDTO createdNotification = notificationService.createNotification(notificationDTO);
            return ResponseEntity.status(201).body(createdNotification);
        } catch (InvalidNotificationException e) {
            return ResponseEntity.badRequest().build();
        } catch (NotificationServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        try {
            NotificationDTO notificationDTO = notificationService.getNotificationById(id);
            return ResponseEntity.ok(notificationDTO);
        } catch (NotificationNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (NotificationServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDTO>> getAllNotificationsByUserId(@PathVariable Long userId) {
        try {
            List<NotificationDTO> notifications = notificationService.getAllNotificationsByUserId(userId);
            return ResponseEntity.ok(notifications);
        } catch (NotificationServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(
            @PathVariable Long id,
            @Valid @RequestBody NotificationDTO notificationDTO) {
        try {
            NotificationDTO updatedNotification = notificationService.updateNotification(id, notificationDTO);
            return ResponseEntity.ok(updatedNotification);
        } catch (NotificationNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidNotificationException e) {
            return ResponseEntity.badRequest().build();
        } catch (NotificationServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        try {
            notificationService.deleteNotification(id);
            return ResponseEntity.noContent().build();
        } catch (NotificationNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (NotificationServiceException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
