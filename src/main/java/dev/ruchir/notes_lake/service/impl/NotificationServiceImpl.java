package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.dto.NotificationDTO;
import dev.ruchir.notes_lake.mapper.NotificationMapper;
import dev.ruchir.notes_lake.model.Core.Notification;
import dev.ruchir.notes_lake.repository.NotificationRepository;
import dev.ruchir.notes_lake.controller_advise.custom.InvalidNotificationException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationServiceException;
import dev.ruchir.notes_lake.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper = NotificationMapper.INSTANCE;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) throws InvalidNotificationException, NotificationServiceException {
        try {
            Notification notification = notificationMapper.toNotificationEntity(notificationDTO);
            Notification savedNotification = notificationRepository.save(notification);
            return notificationMapper.toNotificationDTO(savedNotification);
        } catch (Exception e) {
            throw new NotificationServiceException("Error creating notification", e);
        }
    }

    @Override
    public NotificationDTO getNotificationById(Long id) throws NotificationNotFoundException, NotificationServiceException {
        return notificationRepository.findById(id)
                .map(notificationMapper::toNotificationDTO)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
    }

    @Override
    public List<NotificationDTO> getAllNotificationsByUserId(Long userId) throws NotificationServiceException {
        try {
            // Filter notifications by userId if necessary
            List<Notification> notifications = notificationRepository.findAll(); // Adjust if needed
            return notifications.stream()
                    .map(notificationMapper::toNotificationDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotificationServiceException("Error retrieving notifications", e);
        }
    }

    @Override
    public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) throws NotificationNotFoundException, InvalidNotificationException, NotificationServiceException {
        if (!notificationRepository.existsById(id)) {
            throw new NotificationNotFoundException("Notification not found with id: " + id);
        }
        try {
            Notification notification = notificationMapper.toNotificationEntity(notificationDTO);
            notification.setId(id); // Ensure the ID is set for the update
            Notification updatedNotification = notificationRepository.save(notification);
            return notificationMapper.toNotificationDTO(updatedNotification);
        } catch (Exception e) {
            throw new NotificationServiceException("Error updating notification", e);
        }
    }

    @Override
    public void deleteNotification(Long id) throws NotificationNotFoundException, NotificationServiceException {
        if (!notificationRepository.existsById(id)) {
            throw new NotificationNotFoundException("Notification not found with id: " + id);
        }
        try {
            notificationRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotificationServiceException("Error deleting notification", e);
        }
    }
}
