package xb.pagehelperdemo.service;

import xb.pagehelperdemo.bean.Test;

import java.util.List;

public interface TestService {
    Test selectOne(String id);
    List<Test> selectAll();
}
