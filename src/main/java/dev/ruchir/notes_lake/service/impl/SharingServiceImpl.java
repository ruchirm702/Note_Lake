package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.controller_advise.custom.NoteNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.ResourceNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.UnauthorizedAccessException;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.mapper.HandwrittenNoteMapper;
import dev.ruchir.notes_lake.mapper.TypedNoteMapper;
import dev.ruchir.notes_lake.model.Core.NoteSharing;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.model.Core.User;
import dev.ruchir.notes_lake.repository.NoteSharingRepository;
import dev.ruchir.notes_lake.repository.HandwrittenNoteRepository;
import dev.ruchir.notes_lake.repository.TypedNoteRepository;
import dev.ruchir.notes_lake.repository.UserRepository;
import dev.ruchir.notes_lake.service.interfaces.SharingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class SharingServiceImpl implements SharingService {

    private final NoteSharingRepository noteSharingRepository;
    private final HandwrittenNoteRepository handwrittenNoteRepository;
    private final TypedNoteRepository typedNoteRepository;
    private final UserRepository userRepository;
    private final HandwrittenNoteMapper handwrittenNoteMapper;
    private final TypedNoteMapper typedNoteMapper;


    public SharingServiceImpl(NoteSharingRepository noteSharingRepository,
                              HandwrittenNoteRepository handwrittenNoteRepository,
                              TypedNoteRepository typedNoteRepository,
                              UserRepository userRepository,
                              HandwrittenNoteMapper handwrittenNoteMapper,
                              TypedNoteMapper typedNoteMapper) {
        this.noteSharingRepository = noteSharingRepository;
        this.handwrittenNoteRepository = handwrittenNoteRepository;
        this.typedNoteRepository = typedNoteRepository;
        this.userRepository = userRepository;
        this.handwrittenNoteMapper = handwrittenNoteMapper;
        this.typedNoteMapper = typedNoteMapper;
    }

    @Override
    @Transactional
    public void shareHandwrittenNoteWithUser(Long noteId, Long userId) throws UnauthorizedAccessException, NoteNotFoundException {
        HandwrittenNote handwrittenNote = handwrittenNoteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Handwritten note not found with ID: " + noteId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        NoteSharing noteSharing = new NoteSharing();
        noteSharing.setHandwrittenNote(handwrittenNote);
        noteSharing.setUser(user);
        noteSharing.setSharedAt(LocalDateTime.now());

        noteSharingRepository.save(noteSharing);
    }

    @Override
    @Transactional
    public void shareTypedNoteWithUser(Long noteId, Long userId) throws UnauthorizedAccessException, NoteNotFoundException {
        TypedNote typedNote = typedNoteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Typed note not found with ID: " + noteId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        NoteSharing noteSharing = new NoteSharing();
        noteSharing.setTypedNote(typedNote);
        noteSharing.setUser(user);
        noteSharing.setSharedAt(LocalDateTime.now());

        noteSharingRepository.save(noteSharing);
    }

    @Override
    public List<HandwrittenNoteDTO> getSharedHandwrittenNotes(Long userId) throws ResourceNotFoundException {
        List<NoteSharing> sharedNotes = noteSharingRepository.findByUserId(userId);
        if (sharedNotes.isEmpty()) {
            throw new ResourceNotFoundException("No handwritten notes shared with user ID: " + userId);
        }
        return sharedNotes.stream()
                .map(noteSharing -> handwrittenNoteMapper.toHandwrittenNoteDTO(noteSharing.getHandwrittenNote()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TypedNoteDTO> getSharedTypedNotes(Long userId) throws ResourceNotFoundException {
        List<NoteSharing> sharedNotes = noteSharingRepository.findByUserId(userId);
        if (sharedNotes.isEmpty()) {
            throw new ResourceNotFoundException("No typed notes shared with user ID: " + userId);
        }
        return sharedNotes.stream()
                .map(noteSharing -> typedNoteMapper.toTypedNoteDTO(noteSharing.getTypedNote()))
                .collect(Collectors.toList());
    }
}
