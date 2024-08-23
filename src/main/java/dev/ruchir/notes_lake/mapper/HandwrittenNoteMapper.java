package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface HandwrittenNoteMapper {

    HandwrittenNoteMapper INSTANCE = Mappers.getMapper(HandwrittenNoteMapper.class);

    @Mapping(source = "tags", target = "tagNames", qualifiedByName = "tagsToTagNames")
    HandwrittenNoteDTO toHandwrittenNoteDTO(HandwrittenNote handwrittenNote);

    @Mapping(source = "tagNames", target = "tags", qualifiedByName = "tagNamesToTags")
    HandwrittenNote toHandwrittenNoteEntity(HandwrittenNoteDTO handwrittenNoteDTO);

    @Named("tagsToTagNames")
    default Set<String> tagsToTagNames(Set<Tag> tags) {
        return tags.stream().map(Tag::getName).collect(Collectors.toSet());
    }

    @Named("tagNamesToTags")
    default Set<Tag> tagNamesToTags(Set<String> tagNames) {
        return tagNames.stream().map(name -> {
            Tag tag = new Tag();
            tag.setName(name);
            return tag;
        }).collect(Collectors.toSet());
    }
}
