# Notes_Lake

![Notes_Lake](https://img.shields.io/badge/Notes_Lake-Notes%20Management-6DB33F?style=for-the-badge&logo=java&logoColor=white)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


## Welcome to Notes_Lake!

Notes_Lake is a comprehensive note management system designed to handle both handwritten and typed notes with a suite of features. This document provides an overview of the implemented services, their functionalities, and their API endpoints.

## Architecture Overview

Notes_Lake is structured using Spring Boot with a modular approach to ensure scalability and maintainability. Each module is responsible for a specific functionality, adhering to the single responsibility principle.


## Key Features

- **Versioning**: Track and manage different versions of notes.
- **Sharing**: Share notes with users and manage shared content.
- **Tagging**: Add and manage tags for organizing notes.
- **Attachments**: Handle file attachments associated with notes.
- **Search**: Perform searches and apply filters on notes.
- **Feedback**: Collect and manage feedback from users.
- **Notifications**: Manage notifications for users.

## 🛠️ Project Structure

```plaintext
notes_lake
├── controller
├── controller_advise
│   ├── custom
│   ├── standard
│   ├── GlobalExceptionHandler
│   └── ErrorResponse
├── model
│   ├── Core
│   └── enums
├── dto
├── mapper
├── repository
└── service
    ├── impl
    └── interface

```
## 🛠️ Services Overview

### 1. **VersioningService**
*Handles the creation and retrieval of note versions.*

**Endpoints:**

- **POST /versioning/handwritten/{noteId}**
  - **Description:** Creates a new version of a handwritten note.
  - **Request Body:** `HandwrittenNoteDTO`

- **POST /versioning/typed/{noteId}**
  - **Description:** Creates a new version of a typed note.
  - **Request Body:** `TypedNoteDTO`

- **GET /versioning/handwritten/{noteId}/history**
  - **Description:** Retrieves the version history of a handwritten note.

- **GET /versioning/typed/{noteId}/history**
  - **Description:** Retrieves the version history of a typed note.

### 2. **SharingService**
*Manages sharing of notes between users and retrieves shared notes.*

**Endpoints:**

- **POST /sharing/handwritten/{noteId}/user/{userId}**
  - **Description:** Shares a handwritten note with a specific user.

- **POST /sharing/typed/{noteId}/user/{userId}**
  - **Description:** Shares a typed note with a specific user.

- **GET /sharing/handwritten/{userId}**
  - **Description:** Retrieves handwritten notes shared with a specific user.

- **GET /sharing/typed/{userId}**
  - **Description:** Retrieves typed notes shared with a specific user.

### 3. **TaggingService**
*Handles tags for notes and retrieves notes by tag.*

**Endpoints:**

- **POST /tagging/handwritten/{noteId}**
  - **Description:** Adds tags to a handwritten note.
  - **Request Body:** `List<String>`

- **POST /tagging/typed/{noteId}**
  - **Description:** Adds tags to a typed note.
  - **Request Body:** `List<String>`

- **GET /tagging/handwritten/{tag}**
  - **Description:** Retrieves handwritten notes by a specific tag.

- **GET /tagging/typed/{tag}**
  - **Description:** Retrieves typed notes by a specific tag.

### 4. **AttachmentService**
*Manages attachments associated with notes.*

**Endpoints:**

- **GET /attachments/{id}**
  - **Description:** Retrieves an attachment by its ID.

- **GET /attachments**
  - **Description:** Retrieves all attachments.

- **POST /attachments**
  - **Description:** Saves a new attachment.
  - **Request Body:** `AttachmentDTO`

- **DELETE /attachments/{id}**
  - **Description:** Deletes an attachment by its ID.

### 5. **SearchService**
*Provides search and filtering capabilities for notes.*

**Endpoints:**

- **GET /search/handwritten**
  - **Description:** Searches for handwritten notes based on a query.
  - **Query Parameters:** `query`

- **GET /search/typed**
  - **Description:** Searches for typed notes based on a query.
  - **Query Parameters:** `query`

- **GET /filter/handwritten**
  - **Description:** Filters handwritten notes based on various criteria.
  - **Query Parameters:** `title`, `tag`, `startDate`, `endDate`

- **GET /filter/typed**
  - **Description:** Filters typed notes based on various criteria.
  - **Query Parameters:** `title`, `tag`, `startDate`, `endDate`

### 6. **NoteService**
*Manages creation, retrieval, and deletion of notes.*

**Endpoints:**

- **POST /notes/handwritten**
  - **Description:** Creates a new handwritten note.
  - **Request Body:** `HandwrittenNoteDTO`

- **GET /notes/handwritten/{id}**
  - **Description:** Retrieves a handwritten note by its ID.

- **DELETE /notes/handwritten/{id}**
  - **Description:** Deletes a handwritten note by its ID.

- **POST /notes/typed**
  - **Description:** Creates a new typed note.
  - **Request Body:** `TypedNoteDTO`

- **GET /notes/typed/{id}**
  - **Description:** Retrieves a typed note by its ID.

- **DELETE /notes/typed/{id}**
  - **Description:** Deletes a typed note by its ID.

### 7. **FeedbackService**
*Handles feedback related to notes.*

**Endpoints:**

- **POST /feedback**
  - **Description:** Creates new feedback for a note.
  - **Request Body:** `FeedbackDTO`

- **PUT /feedback/{id}**
  - **Description:** Updates existing feedback.
  - **Request Body:** `FeedbackDTO`

- **DELETE /feedback/{id}**
  - **Description:** Deletes feedback by its ID.

- **GET /feedback/{id}**
  - **Description:** Retrieves feedback by its ID.

- **GET /feedback**
  - **Description:** Retrieves all feedback entries.

- **GET /feedback/user/{userId}**
  - **Description:** Retrieves feedback by user ID.

- **GET /feedback/handwritten/{handwrittenNoteId}**
  - **Description:** Retrieves feedback for a specific handwritten note.

- **GET /feedback/typed/{typedNoteId}**
  - **Description:** Retrieves feedback for a specific typed note.

### 8. **NotificationService**
*Manages notifications for users.*

**Endpoints:**

- **POST /notifications**
  - **Description:** Creates a new notification.
  - **Request Body:** `NotificationDTO`

- **GET /notifications/{id}**
  - **Description:** Retrieves a notification by its ID.

- **GET /notifications/user/{userId}**
  - **Description:** Retrieves all notifications for a specific user.

- **PUT /notifications/{id}**
  - **Description:** Updates an existing notification.
  - **Request Body:** `NotificationDTO`

- **DELETE /notifications/{id}**
  - **Description:** Deletes a notification by its ID.


## Package Descriptions

- **controller**: Contains all REST API controllers that handle incoming HTTP requests and return responses. This includes controllers for managing notes, attachments, notifications, feedback, and more.

- **controller_advise**: Manages exception handling and provides customized error responses:
  - **custom**: Includes custom exception classes for specific error scenarios.
  - **standard**: Contains standard exception classes for common error situations.
  - **GlobalExceptionHandler**: Provides global exception handling logic for the application.
  - **ErrorResponse**: Defines the structure of error responses returned to clients.

- **model**: Contains the core domain models and enumerations used throughout the application:
  - **Core**: Includes core entities like Note, User, Tag, etc.
  - **enums**: Contains various enumerations used for defining constant values, such as NoteType, UserRole, etc.

- **dto**: Data Transfer Objects used for transferring data between the client and server. This includes DTOs for notes, attachments, feedback, and more.

- **mapper**: Contains mapper classes for converting between entities and DTOs. Each mapper is responsible for mapping data between different layers of the application.

- **repository**: Contains interfaces for data access and persistence. These repositories interact with the database to perform CRUD operations on entities.

- **service**: Contains service interfaces and their implementations:
  - **impl**: Provides concrete implementations of the service interfaces, containing the business logic.
  - **interface**: Defines service interfaces that outline the business operations available.

## Contributing Guidelines

We welcome contributions to the Notes_Lake project! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with clear messages.
4. Push your changes to your fork.
5. Submit a pull request to the main repository.
