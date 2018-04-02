package hello.dao;

import hello.logshandler.entity.InsureLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsureLogDao {
    InsureLog selectByOrderId(String orderId);
    void insert(InsureLog insureLog);
    void insertBatch(List<InsureLog> list);
}
