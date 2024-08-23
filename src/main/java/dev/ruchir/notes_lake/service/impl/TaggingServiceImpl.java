package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.controller_advise.custom.NoteNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.TagNotFoundException;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.mapper.HandwrittenNoteMapper;
import dev.ruchir.notes_lake.mapper.TypedNoteMapper;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.repository.HandwrittenNoteRepository;
import dev.ruchir.notes_lake.repository.TagRepository;
import dev.ruchir.notes_lake.repository.TypedNoteRepository;
import dev.ruchir.notes_lake.service.interfaces.TaggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaggingServiceImpl implements TaggingService {

    private final HandwrittenNoteRepository handwrittenNoteRepository;
    private final TypedNoteRepository typedNoteRepository;
    private final TagRepository tagRepository;
    private final HandwrittenNoteMapper handwrittenNoteMapper;
    private final TypedNoteMapper typedNoteMapper;

    @Override
    public HandwrittenNoteDTO addTagsToHandwrittenNote(Long noteId, List<String> tags) {
        HandwrittenNote handwrittenNote = findHandwrittenNoteById(noteId);
        Set<Tag> existingTags = getOrCreateTags(handwrittenNote.getTags(), tags);
        handwrittenNote.setTags(existingTags);
        HandwrittenNote updatedNote = handwrittenNoteRepository.save(handwrittenNote);
        return handwrittenNoteMapper.toHandwrittenNoteDTO(updatedNote);
    }

    @Override
    public TypedNoteDTO addTagsToTypedNote(Long noteId, List<String> tags) {
        TypedNote typedNote = findTypedNoteById(noteId);
        Set<Tag> existingTags = getOrCreateTags(typedNote.getTags(), tags);
        typedNote.setTags(existingTags);
        TypedNote updatedNote = typedNoteRepository.save(typedNote);
        return typedNoteMapper.toTypedNoteDTO(updatedNote);
    }

    @Override
    public List<HandwrittenNoteDTO> getHandwrittenNotesByTag(String tagName) {
        Tag tag = findTagByName(tagName);
        List<HandwrittenNote> notes = handwrittenNoteRepository.findByTagsContains(tag);
        return notes.stream()
                .map(handwrittenNoteMapper::toHandwrittenNoteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TypedNoteDTO> getTypedNotesByTag(String tagName) {
        Tag tag = findTagByName(tagName);
        List<TypedNote> notes = typedNoteRepository.findByTagsContains(tag);
        return notes.stream()
                .map(typedNoteMapper::toTypedNoteDTO)
                .collect(Collectors.toList());
    }

    // Helper methods to reduce code duplication
    private HandwrittenNote findHandwrittenNoteById(Long noteId) {
        return handwrittenNoteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Handwritten note with ID " + noteId + " not found"));
    }

    private TypedNote findTypedNoteById(Long noteId) {
        return typedNoteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Typed note with ID " + noteId + " not found"));
    }

    private Set<Tag> getOrCreateTags(Set<Tag> existingTags, List<String> tagNames) {
        Set<Tag> tags = existingTags != null ? existingTags : new HashSet<>();
        for (String tagName : tagNames) {
            Tag tag = tagRepository.findByName(tagName)
                    .orElseThrow(() -> new TagNotFoundException("Tag with name " + tagName + " not found"));
            tags.add(tag);
        }
        return tags;
    }

    private Tag findTagByName(String tagName) {
        return tagRepository.findByName(tagName)
                .orElseThrow(() -> new TagNotFoundException("Tag with name " + tagName + " not found"));
    }
}
