package com.rasoolghafari.walletapplication.service;

import com.rasoolghafari.walletapplication.dto.UserDTO;
import com.rasoolghafari.walletapplication.exception.ApplicationException;
import com.rasoolghafari.walletapplication.mapper.UserMapper;
import com.rasoolghafari.walletapplication.model.User;
import com.rasoolghafari.walletapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Value("#{messages['userNotFound']}")
    private String userNotFound;
    public UserDTO createUser(UserDTO userDTO) {
        User user = repository.save(mapper.toEntity(userDTO));

        return mapper.toDto(user);
    }

    public UserDTO find(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            User entity = user.get();
            return mapper.toDto(entity);
        }
        throw new ApplicationException(userNotFound);
    }

    public List<UserDTO> list() {
        return mapper.toDtos(repository.findAll());
    }
}