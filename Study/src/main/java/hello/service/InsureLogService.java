package hello.service;

import hello.logshandler.entity.InsureLog;
import org.springframework.stereotype.Service;

public interface InsureLogService {
    void insert(InsureLog insureLog);
}
