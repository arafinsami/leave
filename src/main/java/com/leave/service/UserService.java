package com.leave.service;

import com.leave.dto.UserDto;
import com.leave.entity.User;
import com.leave.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public User save(UserDto dto) {
        User mappedUser = modelMapper.map(dto, User.class);
        User user = userRepository.save(mappedUser);
        return user;
    }

    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
