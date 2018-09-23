package com.lanhu.work.mapper;

import java.util.List;

import com.lanhu.work.pojo.Locations;

public interface LocationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Locations record);

    int insertSelective(Locations record);

    List<Locations> findAllByParentId(Integer parentId);

    int updateByPrimaryKeySelective(Locations record);

    int updateByPrimaryKey(Locations record);
}