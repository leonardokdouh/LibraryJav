package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.dao.impl.WorkersDAO;
import com.solvd.library.services.WorkersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class WorkersServiceImpl implements WorkersService {

    private static final Logger LOG = LogManager.getLogger(WorkersServiceImpl.class);


    @Override
    public void delete(Long id) {
        IWorkersDAO workersService = new WorkersDAO();
        workersService.delete(id);
    }

    @Override
    public void create(Workers u) {
        IWorkersDAO workersService = new WorkersDAO();
        workersService.saveEntity(u);
    }

    @Override
    public void update(Long id, Workers entity) {
        IWorkersDAO workersService = new WorkersDAO();
        workersService.update(id, entity);
    }

    @Override
    public Workers getWorker(Long id) {
        IWorkersDAO workersService = new WorkersDAO();
        Workers worker = workersService.getEntity(id);
        return worker;
    }

    @Override
    public List<Workers> getAllWorkers() {
        IWorkersDAO workersService = new WorkersDAO();
        List<Workers> workersList = workersService.getAll();
        return workersList;
    }
}
