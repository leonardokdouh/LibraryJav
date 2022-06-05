package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.dao.impl.WorkersDAO;
import com.solvd.library.services.WorkersService;

import java.util.List;

public class WorkersServiceImpl implements WorkersService {

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
        return workersService.getEntity(id);
    }

    @Override
    public List<Workers> getAllWorkers() {
        IWorkersDAO workersService = new WorkersDAO();
        return workersService.getAll();
    }
}
