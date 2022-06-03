package com.solvd.library.services;

import com.solvd.library.bin.Users;
import com.solvd.library.bin.Workers;

import java.util.List;

public interface WorkersService {

    void delete(Long id);

    void create(Workers u);

    void update(Long id, Workers entity);

    Workers getWorker(Long id);

    List<Workers> getAllWorkers();

}
