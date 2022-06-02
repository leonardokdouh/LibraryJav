package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Workers;
import com.solvd.library.dao.IWorkersDAO;
import com.solvd.library.services.WorkersService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkersServiceImplementation extends AbsSqlSession implements WorkersService {
    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSession()) {
            IWorkersDAO workersDAO = session.getMapper(IWorkersDAO.class);
            workersDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public void create(Workers u) {
        try (SqlSession session = sqlSession()) {
            IWorkersDAO workersDAO = session.getMapper(IWorkersDAO.class);
            workersDAO.saveEntity(u);
            session.commit();
        }
    }

    @Override
    public void update(Workers entity) {
        try (SqlSession session = sqlSession()) {
            IWorkersDAO workersDAO = session.getMapper(IWorkersDAO.class);
            workersDAO.update(entity);
            session.commit();
        }
    }

    @Override
    public Workers getWorker(Long id) {
        try (SqlSession session = sqlSession()) {
            IWorkersDAO workersDAO = session.getMapper(IWorkersDAO.class);
            Workers worker = workersDAO.getEntity(id);
            return worker;
        }
    }

    @Override
    public List<Workers> getAllWorkers() {
        try (SqlSession session = sqlSession()) {
            IWorkersDAO workersDAO = session.getMapper(IWorkersDAO.class);

            List<Workers> workers = workersDAO.getAll();
            return workers;
        }
    }
}
