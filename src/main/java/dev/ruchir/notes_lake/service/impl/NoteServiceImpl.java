package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.controller_advise.custom.InvalidNoteException;
import dev.ruchir.notes_lake.controller_advise.custom.NoteAlreadyExistsException;
import dev.ruchir.notes_lake.controller_advise.standard.ResourceNotFoundException;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.mapper.NoteMapper;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.repository.HandwrittenNoteRepository;
import dev.ruchir.notes_lake.repository.TypedNoteRepository;
import dev.ruchir.notes_lake.service.interfaces.NoteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final HandwrittenNoteRepository handwrittenNoteRepository;
    private final TypedNoteRepository typedNoteRepository;
    private final NoteMapper noteMapper;

    @Autowired
    public NoteServiceImpl(HandwrittenNoteRepository handwrittenNoteRepository,
                           TypedNoteRepository typedNoteRepository,
                           NoteMapper noteMapper) {
        this.handwrittenNoteRepository = handwrittenNoteRepository;
        this.typedNoteRepository = typedNoteRepository;
        this.noteMapper = noteMapper;
    }

    @Transactional
    @Override
    public HandwrittenNoteDTO createHandwrittenNote(HandwrittenNoteDTO dto) {
        if (handwrittenNoteRepository.existsByTitle(dto.getTitle())) {
            throw new NoteAlreadyExistsException("HandwrittenNote with title '" + dto.getTitle() + "' already exists.");
        }

        HandwrittenNote handwrittenNote = noteMapper.toHandwrittenNoteEntity(dto);
        if (handwrittenNote == null) {
            throw new InvalidNoteException("Invalid data for HandwrittenNote.");
        }

        HandwrittenNote savedNote = handwrittenNoteRepository.save(handwrittenNote);
        return noteMapper.toHandwrittenNoteDTO(savedNote);
    }

    @Override
    public HandwrittenNoteDTO getHandwrittenNoteById(Long id) {
        HandwrittenNote handwrittenNote = handwrittenNoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HandwrittenNote not found with id " + id));
        return noteMapper.toHandwrittenNoteDTO(handwrittenNote);
    }

    @Transactional
    @Override
    public void deleteHandwrittenNoteById(Long id) {
        if (!handwrittenNoteRepository.existsById(id)) {
            throw new ResourceNotFoundException("HandwrittenNote not found with id " + id);
        }
        handwrittenNoteRepository.deleteById(id);
    }

    @Transactional
    @Override
    public TypedNoteDTO createTypedNote(TypedNoteDTO dto) {
        if (typedNoteRepository.existsByTitle(dto.getTitle())) {
            throw new NoteAlreadyExistsException("TypedNote with title '" + dto.getTitle() + "' already exists.");
        }

        TypedNote typedNote = noteMapper.toTypedNoteEntity(dto);
        if (typedNote == null) {
            throw new InvalidNoteException("Invalid data for TypedNote.");
        }

        TypedNote savedNote = typedNoteRepository.save(typedNote);
        return noteMapper.toTypedNoteDTO(savedNote);
    }

    @Override
    public TypedNoteDTO getTypedNoteById(Long id) {
        TypedNote typedNote = typedNoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TypedNote not found with id " + id));
        return noteMapper.toTypedNoteDTO(typedNote);
    }

    @Transactional
    @Override
    public void deleteTypedNoteById(Long id) {
        if (!typedNoteRepository.existsById(id)) {
            throw new ResourceNotFoundException("TypedNote not found with id " + id);
        }
        typedNoteRepository.deleteById(id);
    }
}
