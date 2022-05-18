package com.solvd.library.service;

import com.solvd.library.bin.Users;

import java.util.List;

public interface UsersService {

    void delete(Long id);

    void create (Users u);

    void update(Users entity);

    Users getUsers(Long id);

    List<Users> getAllUsers ();
}
