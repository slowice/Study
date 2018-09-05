package hello.service;

import hello.dao.InsureLogDao;
import hello.logshandler.entity.InsureLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsureLogServiceImpl implements InsureLogService {
    @Autowired
    private InsureLogDao dao;
    @Override
    public void insert(InsureLog insureLog) {
        dao.insert(insureLog);
    }
}
