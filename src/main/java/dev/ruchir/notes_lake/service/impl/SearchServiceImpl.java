package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.controller_advise.custom.TagNotFoundException;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.mapper.NoteMapper;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.repository.HandwrittenNoteRepository;
import dev.ruchir.notes_lake.repository.TagRepository;
import dev.ruchir.notes_lake.repository.TypedNoteRepository;
import dev.ruchir.notes_lake.service.interfaces.SearchService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private final HandwrittenNoteRepository handwrittenNoteRepository;
    private final TypedNoteRepository typedNoteRepository;
    private final TagRepository tagRepository;
    private final NoteMapper noteMapper;

    public SearchServiceImpl(HandwrittenNoteRepository handwrittenNoteRepository,
                             TypedNoteRepository typedNoteRepository,
                             TagRepository tagRepository,
                             NoteMapper noteMapper) {
        this.handwrittenNoteRepository = handwrittenNoteRepository;
        this.typedNoteRepository = typedNoteRepository;
        this.tagRepository = tagRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<HandwrittenNoteDTO> searchHandwrittenNotes(String query) {
        List<HandwrittenNote> notes = handwrittenNoteRepository.searchByTitle(query);
        return notes.stream()
                .map(noteMapper::toHandwrittenNoteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TypedNoteDTO> searchTypedNotes(String query) {
        List<TypedNote> notes = typedNoteRepository.searchByTitle(query);
        return notes.stream()
                .map(noteMapper::toTypedNoteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<HandwrittenNoteDTO> filterHandwrittenNotes(String title, String tag, LocalDate startDate,
                                                           LocalDate endDate) {
        Set<Tag> tags = getTagsByName(tag); // Retrieve tags based on the tag name
        List<HandwrittenNote> notes = handwrittenNoteRepository.filterByTitleAndDate(title, startDate, endDate);
        return notes.stream()
                .filter(note -> note.getTags().containsAll(tags))
                .map(noteMapper::toHandwrittenNoteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TypedNoteDTO> filterTypedNotes(String title, String tag, LocalDate startDate, LocalDate endDate) {
        Set<Tag> tags = getTagsByName(tag); // Retrieve tags based on the tag name
        List<TypedNote> notes = typedNoteRepository.filterByTitleAndDate(title, startDate, endDate);
        return notes.stream()
                .filter(note -> note.getTags().containsAll(tags))
                .map(noteMapper::toTypedNoteDTO)
                .collect(Collectors.toList());
    }

    private Set<Tag> getTagsByName(String tagName) {
        List<Tag> tags = tagRepository.searchByName(tagName);
        if (tags.isEmpty()) {
            throw new TagNotFoundException("Tag with name '" + tagName + "' not found.");
        }
        return new HashSet<>(tags); // Convert list to set
    }
}
