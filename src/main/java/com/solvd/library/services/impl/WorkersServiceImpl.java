package com.solvd.library.services.impl;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.dao.impl.WorkersDAO;
import com.solvd.library.services.WorkersService;

import java.sql.Connection;
import java.util.List;

public class WorkersServiceImpl implements WorkersService {

    private Connection conn;


    public WorkersServiceImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void delete(Long id) {
        IWorkersDAO workersService = new WorkersDAO(conn);
        workersService.delete(id);
    }

    @Override
    public void create(Workers u) {
        IWorkersDAO workersService = new WorkersDAO(conn);
        workersService.saveEntity(u);
    }

    @Override
    public void update(Workers entity) {
        IWorkersDAO workersService = new WorkersDAO(conn);
        workersService.update(entity);
    }

    @Override
    public Workers getWorker(Long id) {
        IWorkersDAO workersService = new WorkersDAO(conn);
        Workers worker = workersService.getEntity(id);
        return worker;
    }

    @Override
    public List<Workers> getAllWorkers() {
        IWorkersDAO workersService = new WorkersDAO(conn);
        List<Workers> workersList = workersService.getAll();
        return workersList;
    }
}
