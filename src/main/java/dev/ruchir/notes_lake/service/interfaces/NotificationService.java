package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.NotificationDTO;
import dev.ruchir.notes_lake.controller_advise.custom.InvalidNotificationException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.NotificationServiceException;

import java.util.List;

public interface NotificationService {

    NotificationDTO createNotification(NotificationDTO notificationDTO) throws InvalidNotificationException, NotificationServiceException;

    NotificationDTO getNotificationById(Long id) throws NotificationNotFoundException, NotificationServiceException;

    List<NotificationDTO> getAllNotificationsByUserId(Long userId) throws NotificationServiceException;

    NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) throws NotificationNotFoundException, InvalidNotificationException, NotificationServiceException;

    void deleteNotification(Long id) throws NotificationNotFoundException, NotificationServiceException;
}
