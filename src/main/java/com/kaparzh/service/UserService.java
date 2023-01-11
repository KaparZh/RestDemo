package com.kaparzh.service;

import com.kaparzh.model.User;

public interface UserService extends GenericService<User, Integer> {

    User create(String name);

    User update(Integer id, String name);
}
