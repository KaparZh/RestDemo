package com.kaparzh.service.impl;

import com.kaparzh.model.User;
import com.kaparzh.repository.impl.UserRepositoryImpl;
import com.kaparzh.service.UserService;

import java.util.List;

public final class UserServiceImpl implements UserService {

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();

    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User create(String name) {
        return userRepository.save(new User(name));
    }

    @Override
    public User update(Integer id, String name) {
        return userRepository.update(new User(id, name));
    }
}
