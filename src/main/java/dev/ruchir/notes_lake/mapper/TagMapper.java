package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.TagDTO;
import dev.ruchir.notes_lake.model.Core.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDTO toTagDTO(Tag tag);
    Tag toTagEntity(TagDTO tagDTO);
}