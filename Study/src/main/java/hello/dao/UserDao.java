package hello.dao;

import hello.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User select(Integer id);
    void insert(User user);
    void insertBatch(List<User> list);
    void delete(User user);
    void update(User user);
    List<User> selectAll();
    List<User> selectForUpdate();
    User selectOneForUpdate(Integer id);
}
