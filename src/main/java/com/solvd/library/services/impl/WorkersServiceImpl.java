package com.solvd.library.services.impl;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.dao.impl.WorkersDAO;
import com.solvd.library.services.WorkersService;

import java.sql.Connection;
import java.util.List;

public class WorkersServiceImpl implements WorkersService {

    private Connection conn;

    private IWorkersDAO workersService = new WorkersDAO(conn);


    public WorkersServiceImpl(Connection conn){
        this.conn=conn;
    }

    @Override
    public void delete(Long id) {
        workersService.delete(id);
    }

    @Override
    public void create(Workers u) {
        workersService.saveEntity(u);
    }

    @Override
    public void update(Workers entity) {
        workersService.update(entity);
    }

    @Override
    public Workers getWorker(Long id) {

        Workers worker = workersService.getEntity(id);

        return worker;
    }

    @Override
    public List<Workers> getAllWorkers() {
        List<Workers> workersList = workersService.getAll();
        return workersList;
    }
}
