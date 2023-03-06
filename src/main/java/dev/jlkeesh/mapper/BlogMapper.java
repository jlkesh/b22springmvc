package dev.jlkeesh.mapper;

import dev.jlkeesh.domain.Blog;
import dev.jlkeesh.dto.BlogCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    Blog fromCreateDTO(BlogCreateDTO dto);
    List<Blog> fromCreateDTO(List<BlogCreateDTO> dtos);
}
