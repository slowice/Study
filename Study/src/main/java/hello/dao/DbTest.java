package hello.dao;

import hello.transaction.MyTransactional;
import hello.transaction.TestModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DbTest {
    @Select("select count(*) from db_test")
    int count();

    @Insert("insert into db_test(id,date,content) values(#{id},now(),#{content})")
    @MyTransactional
    int add(TestModel testModel);

    @Insert("create table db_test(id int,date time,content varchar)")
    int createTable();
}
