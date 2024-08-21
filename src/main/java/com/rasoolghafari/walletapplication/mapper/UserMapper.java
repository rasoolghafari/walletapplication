package com.rasoolghafari.walletapplication.mapper;

import com.rasoolghafari.walletapplication.dto.UserDTO;
import com.rasoolghafari.walletapplication.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);
    User toEntity(UserDTO dto);
    List<UserDTO> toDtos(List<User> entity);
    List<User> toEntities(List<UserDTO> dto);
}