package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.HandwrittenNoteVersionDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteVersionDTO;
import dev.ruchir.notes_lake.mapper.HandwrittenNoteVersionMapper;
import dev.ruchir.notes_lake.mapper.TagMapper;
import dev.ruchir.notes_lake.mapper.TypedNoteVersionMapper;
import dev.ruchir.notes_lake.model.Core.HandwrittenNoteVersion;
import dev.ruchir.notes_lake.model.Core.TypedNoteVersion;
import dev.ruchir.notes_lake.repository.HandwrittenNoteVersionRepository;
import dev.ruchir.notes_lake.repository.TypedNoteVersionRepository;
import dev.ruchir.notes_lake.service.interfaces.VersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VersioningServiceImpl implements VersioningService {

    private final HandwrittenNoteVersionRepository handwrittenNoteVersionRepository;
    private final TypedNoteVersionRepository typedNoteVersionRepository;
    private final HandwrittenNoteVersionMapper handwrittenNoteVersionMapper;
    private final TypedNoteVersionMapper typedNoteVersionMapper;
    private final TagMapper tagMapper;

    @Autowired
    public VersioningServiceImpl(
            HandwrittenNoteVersionRepository handwrittenNoteVersionRepository,
            TypedNoteVersionRepository typedNoteVersionRepository,
            HandwrittenNoteVersionMapper handwrittenNoteVersionMapper,
            TypedNoteVersionMapper typedNoteVersionMapper,
            TagMapper tagMapper) {
        this.handwrittenNoteVersionRepository = handwrittenNoteVersionRepository;
        this.typedNoteVersionRepository = typedNoteVersionRepository;
        this.handwrittenNoteVersionMapper = handwrittenNoteVersionMapper;
        this.typedNoteVersionMapper = typedNoteVersionMapper;
        this.tagMapper = tagMapper;
    }

    @Override
    public HandwrittenNoteVersionDTO createHandwrittenNoteVersion(Long noteId, HandwrittenNoteDTO updatedNoteDTO) {
        int versionNumber = getNextVersionNumberForHandwrittenNote(noteId);
        HandwrittenNoteVersion handwrittenNoteVersion = new HandwrittenNoteVersion();
        handwrittenNoteVersion.setNoteId(noteId);
        handwrittenNoteVersion.setVersionNumber(versionNumber);
        handwrittenNoteVersion.setTimestamp(LocalDateTime.now());
        handwrittenNoteVersion.setContent(updatedNoteDTO.getPdfFileUrl() + " | " + updatedNoteDTO.getImageFileUrl());
        handwrittenNoteVersion.setTags(tagMapper.toTags(updatedNoteDTO.getTags())); // Convert DTO tags to entities
        handwrittenNoteVersion.setVersionDate(LocalDateTime.now());

        handwrittenNoteVersion = handwrittenNoteVersionRepository.save(handwrittenNoteVersion);
        return handwrittenNoteVersionMapper.toHandwrittenNoteVersionDTO(handwrittenNoteVersion);
    }

    @Override
    public TypedNoteVersionDTO createTypedNoteVersion(Long noteId, TypedNoteDTO updatedNoteDTO) {
        int versionNumber = getNextVersionNumberForTypedNote(noteId);
        TypedNoteVersion typedNoteVersion = new TypedNoteVersion();
        typedNoteVersion.setNoteId(noteId);
        typedNoteVersion.setVersionNumber(versionNumber);
        typedNoteVersion.setTimestamp(LocalDateTime.now());
        typedNoteVersion.setContent(updatedNoteDTO.getTextContent());
        typedNoteVersion.setTags(tagMapper.toTags(updatedNoteDTO.getTags())); // Convert DTO tags to entities
        typedNoteVersion.setVersionDate(LocalDateTime.now());

        typedNoteVersion = typedNoteVersionRepository.save(typedNoteVersion);
        return typedNoteVersionMapper.toTypedNoteVersionDTO(typedNoteVersion);
    }

    @Override
    public List<HandwrittenNoteVersionDTO> getHandwrittenNoteHistory(Long noteId) {
        List<HandwrittenNoteVersion> versions = handwrittenNoteVersionRepository.findByNoteIdOrderByVersionNumberAsc(noteId);
        return handwrittenNoteVersionMapper.toHandwrittenNoteVersionDTOs(versions);
    }

    @Override
    public List<TypedNoteVersionDTO> getTypedNoteHistory(Long noteId) {
        List<TypedNoteVersion> versions = typedNoteVersionRepository.findByNoteIdOrderByVersionNumberAsc(noteId);
        return typedNoteVersionMapper.toTypedNoteVersionDTOs(versions);
    }

    private int getNextVersionNumberForHandwrittenNote(Long noteId) {
        Optional<HandwrittenNoteVersion> latestVersionOpt = handwrittenNoteVersionRepository.findTopByNoteIdOrderByVersionNumberDesc(noteId);
        return latestVersionOpt.map(version -> version.getVersionNumber() + 1).orElse(1);
    }

    private int getNextVersionNumberForTypedNote(Long noteId) {
        Optional<TypedNoteVersion> latestVersionOpt = typedNoteVersionRepository.findTopByNoteIdOrderByVersionNumberDesc(noteId);
        return latestVersionOpt.map(version -> version.getVersionNumber() + 1).orElse(1);
    }
}
