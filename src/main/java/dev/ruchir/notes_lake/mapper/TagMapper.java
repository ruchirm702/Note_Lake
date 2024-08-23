package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.TagDTO;
import dev.ruchir.notes_lake.model.Core.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagDTO toTagDTO(Tag tag);

    Tag toTag(TagDTO tagDTO);

    Set<TagDTO> toTagDTOs(Set<Tag> tags);

    Set<Tag> toTags(Set<TagDTO> tagDTOs);

    List<TagDTO> toTagDTOs(List<Tag> tags);

    List<Tag> toTags(List<TagDTO> tagDTOs);
}
